package com.example.myqyizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class finish_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val score: TextView = findViewById(R.id.score)
        val username: TextView = findViewById(R.id.username)
        val finish: Button = findViewById(R.id.btn_finish)

        val correctans = intent.getIntExtra(Constants.CORRECT_ANS,0)
        val totalquestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)

        score.text = "Your Score is $correctans Out of $totalquestions"
        username.text = intent.getStringExtra(Constants.USER_NAME)

        finish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}


