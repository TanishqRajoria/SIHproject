package com.example.database

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignInActivity : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference
    companion object{
        const val key1="com.example.database.SignActivity.mail"
        const val key2="com.example.database.SignActivity.name"
        const val key3="com.example.database.SignActivity.id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val signInButton=findViewById<Button>(R.id.btnSignIn)
        val userName=findViewById<TextInputEditText>(R.id.eTUniqueID)

        signInButton.setOnClickListener{
            // Take ref till node "Users"
            val uniqueId=userName.text.toString()// Convert to String
            if(uniqueId.isNotEmpty()){
                readData(uniqueId)
            }
            else{
                Toast.makeText(this,"Please enter User Name",Toast.LENGTH_SHORT).show()
            }
        }
    } //onCreate method over

    private fun readData(uniqueId: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")

        databaseReference.child(uniqueId).get().addOnSuccessListener { //get() is used to just let know the information without making any change
            //if user exist or not
            if (it.exists()){
                //Welcome user in your app with intent and also pass
                val email=it.child("email").value
                val name=it.child("name").value
                val userid=it.child("uniqueId").value

                val intentWelcome=Intent(this,HomeActivity::class.java)
                intentWelcome.putExtra(key1,email.toString())
                intentWelcome.putExtra(key2,name.toString())
                intentWelcome.putExtra(key3,userid.toString())
                startActivity(intentWelcome)
            }
            else{
                Toast.makeText(this,"User does not exist",Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener{
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
        }
    }
}