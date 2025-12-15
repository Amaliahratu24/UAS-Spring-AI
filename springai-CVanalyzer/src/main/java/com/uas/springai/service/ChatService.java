package com.uas.springai.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatService {

    private final ChatModel chatModel;
    private final Map<String, List<Map<String, String>>> conversationHistory;

    public ChatService(ChatModel chatModel) {
        this.chatModel = chatModel;
        this.conversationHistory = new HashMap<>();
    }

    public String chat(String sessionId, String userMessage) {
        conversationHistory.putIfAbsent(sessionId, new ArrayList<>());
        List<Map<String, String>> history = conversationHistory.get(sessionId);

        // Tambah pesan user
        Map<String, String> userMsg = new HashMap<>();
        userMsg.put("role", "user");
        userMsg.put("content", userMessage);
        history.add(userMsg);

        // Limit history agar hemat token
        if (history.size() > 10) {
            history = new ArrayList<>(history.subList(history.size() - 10, history.size()));
            conversationHistory.put(sessionId, history);
        }

        try {
            // === BAGIAN INI YANG DIUBAH (SYSTEM PROMPT HRD) ===
            StringBuilder contextBuilder = new StringBuilder();
            contextBuilder.append("PERAN: Anda adalah HR Manager Senior yang teliti dan profesional.\n");
            contextBuilder.append("TUGAS: Analisis teks CV atau profil kandidat yang diberikan user.\n");
            contextBuilder.append("FORMAT OUTPUT (Gunakan HTML): \n");
            contextBuilder.append("<ul>");
            contextBuilder.append("<li><b>Kelebihan:</b> [Sebutkan skill utama]</li>");
            contextBuilder.append("<li><b>Kekurangan/Resiko:</b> [Sebutkan yang kurang/perlu diperbaiki]</li>");
            contextBuilder.append("<li><b>Skor Kecocokan:</b> [0-100]%</li>");
            contextBuilder.append("<li><b>Saran Pertanyaan Interview:</b><br/>1. ...<br/>2. ...</li>");
            contextBuilder.append("</ul>");
            contextBuilder.append("Gunakan Bahasa Indonesia yang formal namun jelas.\n\n");
            
            contextBuilder.append("Riwayat Percakapan:\n");
            
            for (Map<String, String> msg : history) {
                if ("user".equals(msg.get("role"))) {
                    contextBuilder.append("Kandidat/User: ").append(msg.get("content")).append("\n");
                } else if ("assistant".equals(msg.get("role"))) {
                    contextBuilder.append("HRD: ").append(msg.get("content")).append("\n");
                }
            }
            
            contextBuilder.append("\nBerikan analisis Anda terhadap pesan terakhir:");

            // Generate response
            Prompt prompt = new Prompt(contextBuilder.toString());
            ChatResponse response = chatModel.call(prompt);
            String aiResponse = response.getResult().getOutput().getContent();

            // Simpan response AI
            Map<String, String> aiMsg = new HashMap<>();
            aiMsg.put("role", "assistant");
            aiMsg.put("content", aiResponse);
            history.add(aiMsg);

            return aiResponse;
            
        } catch (Exception e) {
            return "Maaf, sistem sedang sibuk. Error: " + e.getMessage();
        }
    }

    public void clearHistory(String sessionId) {
        conversationHistory.remove(sessionId);
    }
    
    public int getHistorySize(String sessionId) {
        List<Map<String, String>> history = conversationHistory.get(sessionId);
        return history != null ? history.size() : 0;
    }
}