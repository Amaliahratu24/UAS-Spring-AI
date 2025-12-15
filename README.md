# springai-helloworld
Simple Spring AI Hello World REST API Application
springai-helloworld 👋

Project Spring Boot + Spring AI super sederhana buat kenalan sama dunia REST API.
Outputnya cuma “Hello World”, tapi pas banget buat start belajar Spring 🔥

🤔 Ini Project Apa Sih?

Ini adalah project latihan Spring Boot REST API yang menampilkan beberapa endpoint sederhana.
Dibikin buat kamu yang baru mulai dan pengen ngerti:

Gimana struktur project Spring Boot

Cara bikin REST API

Sedikit perkenalan sama Spring AI

Best practice dasar di Java modern

🧰 Tech Stack

☕ Java 17

🌱 Spring Boot 3.4.12

📦 Maven

🌐 Spring Web

🚀 Tomcat (embedded)

✨ Fitur Singkat

✅ 3 endpoint REST API

✅ Kode simpel & gampang dibaca

✅ Cocok buat pemula

✅ Bisa hot reload (DevTools)

✅ Logging jelas

🛠️ Sebelum Jalanin

Pastikan sudah ada:

Java JDK 17+

Maven 3.9+ (atau pakai Maven Wrapper)

IDE favorit kamu (VS Code, IntelliJ, dll)

▶️ Cara Jalanin
Cara paling gampang (disarankan)
.\mvnw.cmd spring-boot:run


Atau kalau mau pakai Maven langsung:

mvn spring-boot:run


Kalau mau versi JAR:

.\mvnw.cmd clean package
java -jar target/springai-helloworld-0.0.1-SNAPSHOT.jar


Akses di browser:
👉 http://localhost:8080

🌐 Endpoint yang Tersedia
👋 Hello World

GET /api/hello

Hello World from Spring AI!

curl http://localhost:8080/api/hello

🎉 Welcome

GET /api/welcome

Welcome to Spring AI Application - Simple Demo

curl http://localhost:8080/api/welcome

ℹ️ Info

GET /api/info

This is a simple Spring Boot REST API for learning Spring AI

curl http://localhost:8080/api/info

🎯 Catatan

Project ini cocok banget buat:

Belajar Spring Boot dari nol

Latihan bikin REST API

Ngoding santai tapi tetap rapi

Kalau sudah paham, tinggal lanjut:
➡️ tambah service
➡️ tambah AI feature
➡️ sambung ke database
