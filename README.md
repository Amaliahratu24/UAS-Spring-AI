# 🎓 Ujian Akhir Semester - Spring AI
**Mata Kuliah Peminatan Software Engineer 2025**

## 👨‍🏫 Dosen Pengampu
Rizal Broer Bahaweres, M.Kom.

## 👥 Tim Penyusun
- Ratu Amaliah (11230910000026)
- Syifa Auliyah Kusumawardani (11230910000114)
- Diniah Nurrohmah (1121091000098)

---

## 🌟 Overview

Repository ini berisi **2 project Spring AI** yang dikembangkan sebagai bagian dari tugas akhir semester:
1. **springai-helloworld** - REST API sederhana untuk belajar Spring Boot
2. **springai-CVanalyzer** - AI-powered recruitment assistant dengan Groq LLaMA

---

# 🚀 Project 1: springai-helloworld

Simple Spring AI Hello World REST API Application - project dasar untuk memahami struktur Spring Boot dan REST API. Perfect untuk pemula! 👋

## ✨ Fitur
- ✅ 3 endpoint REST API sederhana
- ✅ Kode clean & mudah dipahami
- ✅ Hot reload dengan DevTools
- ✅ Logging yang jelas
- ✅ Best practice Java modern

## 🧰 Tech Stack
- ☕ Java 17
- 🌱 Spring Boot 3.4.12
- 📦 Maven
- 🌐 Spring Web
- 🚀 Tomcat (embedded)

## 🛠️ Prerequisites
- Java JDK 17+
- Maven 3.9+ (atau gunakan Maven Wrapper)
- IDE favorit (VS Code, IntelliJ, Eclipse)

## ▶️ Cara Menjalankan

**Menggunakan Maven Wrapper (Recommended):**
```bash
.\mvnw.cmd spring-boot:run
```

**Menggunakan Maven:**
```bash
mvn spring-boot:run
```

**Build & Run JAR:**
```bash
.\mvnw.cmd clean package
java -jar target/springai-helloworld-0.0.1-SNAPSHOT.jar
```

**Akses aplikasi di:** 👉 http://localhost:8080

## 🌐 API Endpoints

**1. Hello World**
```http
GET /api/hello
Response: Hello World from Spring AI!
```

**2. Welcome**
```http
GET /api/welcome
Response: Welcome to Spring AI Application - Simple Demo
```

**3. Info**
```http
GET /api/info
Response: This is a simple Spring Boot REST API for learning Spring AI
```

---

# 🎯 Project 2: HR CV Analyzer

**HR Recruitment Assistant** - Sistem Pendukung Keputusan (Decision Support System) cerdas untuk analisis CV kandidat menggunakan AI.

## ✨ Fitur
- 🧠 Analisis CV menggunakan AI (Groq LLaMA 3.3 70B)
- 📊 Scoring otomatis (0-100%)
- ⚠️ Deteksi Red Flags
- 💪 Identifikasi Kelebihan Kandidat
- ❓ Rekomendasi Pertanyaan Interview

## 🧰 Tech Stack
- ☕ Java 21
- 🌱 Spring Boot 3.4.12
- 🤖 Spring AI
- 🦙 Groq API (llama-3.3-70b-versatile)
- 🌐 Spring Web + Thymeleaf
- 💾 HttpSession (Session Management)

## 🔑 AI/API Keys yang Digunakan

Project ini menggunakan **Groq API** dengan model **LLaMA 3.3 70B Versatile**

**Cara mendapatkan API Key:**
1. Daftar di [https://console.groq.com](https://console.groq.com)
2. Login dan buat API Key baru
3. Copy API Key yang didapat

## 🛠️ Prerequisites
- Java JDK 17+
- Maven 3.9+
- **Groq API Key** (wajib untuk menjalankan aplikasi)
- Browser modern (Chrome, Firefox, Edge)

## ⚙️ Konfigurasi

**1. Set Environment Variable untuk API Key:**

**Windows (CMD):**
```bash
set GROQ_API_KEY=your_api_key_here
```

**2. File application.properties sudah dikonfigurasi:**
```properties
server.port=8080
spring.ai.groq.api-key=${GROQ_API_KEY}
spring.ai.groq.chat.options.model=llama-3.3-70b-versatile
spring.ai.groq.chat.options.temperature=0.7
```

## ▶️ Cara Menjalankan

**1. Clone/Extract project**
```bash
cd springai-CVanalyzer
```

**2. Set API Key**
```bash
# Windows CMD
set GROQ_API_KEY=gsk_xxxxxxxxxxxxxxxxxxxxx

**3. Jalankan aplikasi**
```bash
.\mvnw.cmd spring-boot:run
```

**4. Buka browser**
```
http://localhost:8080
```

## 🎮 Cara Menggunakan

1. **Input CV** - Paste atau ketik teks CV kandidat
2. **Klik Analyze** - AI akan menganalisis CV
3. **Lihat Hasil** - Sistem menampilkan:
   - 💪 Kelebihan kandidat
   - 🚩 Red Flags/Risiko
   - 📈 Skor Kecocokan (0-100%)
   - ❓ Pertanyaan Interview yang disarankan


---

**⭐ UAS Spring AI 2025 ⭐**
