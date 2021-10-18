package com.example.sampleocbccode.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.sampleocbccode.R
import com.example.sampleocbccode.domain.EnglishPerson
import com.example.sampleocbccode.domain.Person
import com.example.sampleocbccode.domain.SpanishPerson
import com.example.sampleocbccode.domain.di.module.SpanishQualifier
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @SpanishQualifier
    @Inject
    lateinit var spanishPerson: Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getJokeButton = findViewById<Button>(R.id.getJokeButton)
        val submitJokeButton = findViewById<Button>(R.id.submitJokeButton)
        var intent : Intent

        spanishPerson.speakLanguage()

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