package com.example.heartguardlayout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvRegister = findViewById<TextView>(R.id.tvRegister)

        // Tombol Login
        btnLogin.setOnClickListener {
            val username = findViewById<EditText>(R.id.etUsername).text.toString().trim()
            val password = findViewById<EditText>(R.id.etPassword).text.toString().trim()

            // Validasi input tidak kosong
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username dan password tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Simulasi autentikasi (dummy)
            if (username == "admin" && password == "admin") {
                val isRmeRegistered = checkRmeRegistration(username) // Cek status registrasi RME
                if (isRmeRegistered) {
                    // Jika sudah registrasi RME, masuk ke halaman utama
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    // Jika belum registrasi RME, masuk ke halaman ProfileActivity
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                }
                finish() // Tutup LoginActivity agar tidak bisa kembali
            } else {
                Toast.makeText(this, "Username atau password salah!", Toast.LENGTH_SHORT).show()
            }
        }

        // Tombol Register
        tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    // Fungsi untuk mengecek status registrasi RME
    private fun checkRmeRegistration(username: String): Boolean {
        // Simulasi data: hanya username "admin" yang dianggap sudah registrasi RME
        return username == "admin" // Ganti logika ini jika menggunakan database nanti
    }
}
