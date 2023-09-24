package com.example.database

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    //variable to link firebase to the code
    //lateinit var a:String  lateinit variable type is used to only declare and not initialize a variable in Kotlin.


    lateinit var database :DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signButton=findViewById<Button>(R.id.btnSignUp)


        val eTName=findViewById<EditText>(R.id.eTName)
        val eTPassword=findViewById<EditText>(R.id.eTPassword)
        val eTUniqueID=findViewById<EditText>(R.id.eTUniqueID)
        val eTMail=findViewById<EditText>(R.id.eTMail)

        signButton.setOnClickListener{
            val name=eTName.text.toString()
            val mail=eTMail.text.toString()
            val id=eTUniqueID.text.toString()
            val password=eTPassword.text.toString()
            //Create a object of data class User
            val user=User(name,mail,password,id)
            database=FirebaseDatabase.getInstance().getReference("Users")
            //Create a dataclass in java -> database
            database.child(id).setValue(user).addOnSuccessListener {
                if(id.isNotEmpty()){
                    eTName.text.clear()
                    eTMail.text.clear()
                    eTPassword.text.clear()
                    eTUniqueID.text.clear()
                    Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"Please enter User Name",Toast.LENGTH_SHORT).show()
                }
            }.addOnFailureListener{
                Toast.makeText(this,"User Registration Failed",Toast.LENGTH_SHORT).show()
            }
        }

        val signInText = findViewById<TextView>(R.id.tvSignIn)
        signInText.setOnClickListener{
            val openSignInActivity = Intent(this,SignInActivity::class.java)
            startActivity(openSignInActivity)
        }
    }
}