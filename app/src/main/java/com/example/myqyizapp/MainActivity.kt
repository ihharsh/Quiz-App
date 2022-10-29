package com.example.myqyizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnStart: Button = findViewById(R.id.btnStart)
        var et_name: EditText = findViewById(R.id.et_name)

        btnStart.setOnClickListener(){
            if(et_name.text.isEmpty()){
                Toast.makeText(this, "Enter your name", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this,QuizQuestionsActivity:: class.java)
                intent.putExtra(Constants.USER_NAME,et_name.text.toString())
                startActivity(intent)
                finish()
            }

        }
    }
}