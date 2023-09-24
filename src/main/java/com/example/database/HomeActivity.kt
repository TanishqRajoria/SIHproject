package com.example.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val name =intent.getStringExtra(SignInActivity.key2)
        val mail =intent.getStringExtra(SignInActivity.key1)
        val userid =intent.getStringExtra(SignInActivity.key3)

        val welcomeText = findViewById<TextView>(R.id.tVWelcome)
        val mailText= findViewById<TextView>(R.id.tVMail)
        val idText=findViewById<TextView>(R.id.tVUnique)

        welcomeText.text="Welcome $name"
        mailText.text="Mail : $mail"
        idText.text="User ID : $userid"
    }
}