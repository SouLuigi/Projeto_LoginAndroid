package com.ex.projectlogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val bntLogin = findViewById<Button>(R.id.bntLogin)

        bntLogin.setOnClickListener{
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username == "Luigi" && password == "1234"){
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("USERNAME", username)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show()
                etUsername.text.clear()
                etPassword.text.clear()
            }
        }
    }
}