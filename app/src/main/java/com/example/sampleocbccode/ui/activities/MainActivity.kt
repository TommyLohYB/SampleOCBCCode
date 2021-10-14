package com.example.sampleocbccode.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.sampleocbccode.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getJokeButton = findViewById<Button>(R.id.getJokeButton)
        val submitJokeButton = findViewById<Button>(R.id.submitJokeButton)
        var intent : Intent

        getJokeButton.setOnClickListener {
            intent = Intent(this, GetJokeActivity::class.java)
            startActivity(intent)
        }

        submitJokeButton.setOnClickListener {
            intent = Intent(this, SubmitJokeActivity::class.java)
            startActivity(intent)
        }

    }
}