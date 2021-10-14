package com.example.sampleocbccode.ui.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sampleocbccode.R
import com.example.sampleocbccode.domain.feature.joke.service.JokesAPI
import com.example.sampleocbccode.domain.feature.joke.model.JokeFlag
import com.example.sampleocbccode.domain.feature.joke.model.SubmitJokeRequest
import com.example.sampleocbccode.domain.network.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SubmitJokeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submitjoke)

        val submitJokeEditText = findViewById<EditText>(R.id.submitJokeEditText)
        val submitJokeButton = findViewById<Button>(R.id.submitJokeButton)
        var toastMessage: String = ""
        var failedSubmissionMessage = "Failed to submit joke. Please try again!"

        submitJokeButton.setOnClickListener {
            if (submitJokeEditText.text.isNullOrBlank()) {
                toastMessage = "Please do not leave it blank"
                Toast.makeText(applicationContext, toastMessage, Toast.LENGTH_SHORT).show()
            } else {
                GlobalScope.launch(Dispatchers.IO) {
                    val submitJokeRequest = SubmitJokeRequest(
                        3,
                        "Misc",
                        "single",
                        submitJokeEditText.text.toString(),
                        JokeFlag(
                            nsfw = false,
                            religious = false,
                            political = false,
                            racist = false,
                            sexist = false,
                            explicit = false
                        ),
                        "en"
                    )

                    val submitJokeResponse = RetrofitService.jokeApi.submitJoke(submitJokeRequest)
                    if (submitJokeResponse.isSuccessful) {
                        val jokeResponse = submitJokeResponse.body()!!

                        //Display Toast
                        if (jokeResponse.error) toastMessage = failedSubmissionMessage
                        else toastMessage = jokeResponse.message
                        withContext(Dispatchers.Main){
                            Toast.makeText(applicationContext, toastMessage, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}