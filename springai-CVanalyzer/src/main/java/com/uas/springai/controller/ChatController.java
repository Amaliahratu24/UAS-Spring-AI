package com.uas.springai.controller;

import com.uas.springai.service.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/chat";
    }

    @GetMapping("/chat")
    public String chatPage(HttpSession session, Model model) {
        String sessionId = session.getId();
        
        @SuppressWarnings("unchecked")
        List<Map<String, String>> messages = 
            (List<Map<String, String>>) session.getAttribute("messages");
        
        if (messages == null) {
            messages = new ArrayList<>();
            session.setAttribute("messages", messages);
        }
        
        model.addAttribute("messages", messages);
        model.addAttribute("sessionId", sessionId);
        return "chat";
    }

    @PostMapping("/chat/send")
    public String sendMessage(@RequestParam String message, 
                            HttpSession session, 
                            Model model) {
        
        if (message == null || message.trim().isEmpty()) {
            return "redirect:/chat";
        }
        
        String sessionId = session.getId();
        
        @SuppressWarnings("unchecked")
        List<Map<String, String>> messages = 
            (List<Map<String, String>>) session.getAttribute("messages");
        
        if (messages == null) {
            messages = new ArrayList<>();
        }

        // Tambah pesan user
        Map<String, String> userMsg = new HashMap<>();
        userMsg.put("type", "user");
        userMsg.put("content", message.trim());
        messages.add(userMsg);

        try {
            // Get AI response
            String aiResponse = chatService.chat(sessionId, message.trim());
            
            // Tambah response AI
            Map<String, String> aiMsg = new HashMap<>();
            aiMsg.put("type", "assistant");
            aiMsg.put("content", aiResponse);
            messages.add(aiMsg);
            
        } catch (Exception e) {
            // Error message
            Map<String, String> errorMsg = new HashMap<>();
            errorMsg.put("type", "error");
            errorMsg.put("content", "Maaf, terjadi kesalahan: " + e.getMessage());
            messages.add(errorMsg);
        }

        session.setAttribute("messages", messages);
        model.addAttribute("messages", messages);
        
        return "chat";
    }

    @PostMapping("/chat/clear")
    public String clearChat(HttpSession session) {
        String sessionId = session.getId();
        chatService.clearHistory(sessionId);
        session.removeAttribute("messages");
        return "redirect:/chat";
    }
    
    @GetMapping("/chat/stats")
    @ResponseBody
    public Map<String, Object> getChatStats(HttpSession session) {
        String sessionId = session.getId();
        
        @SuppressWarnings("unchecked")
        List<Map<String, String>> messages = 
            (List<Map<String, String>>) session.getAttribute("messages");
        
        Map<String, Object> stats = new HashMap<>();
        stats.put("sessionId", sessionId);
        stats.put("messageCount", messages != null ? messages.size() : 0);
        stats.put("historySize", chatService.getHistorySize(sessionId));
        
        return stats;
    }
}