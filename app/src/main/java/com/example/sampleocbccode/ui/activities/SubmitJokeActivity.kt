package com.example.sampleocbccode.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sampleocbccode.R
import com.example.sampleocbccode.databinding.ActivitySubmitjokeBinding
import com.example.sampleocbccode.domain.feature.joke.model.Joke
import com.example.sampleocbccode.domain.feature.joke.model.JokeFlag
import com.example.sampleocbccode.domain.feature.joke.model.SubmitJokeRequest
import com.example.sampleocbccode.domain.feature.joke.repository.JokeRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

@AndroidEntryPoint
class SubmitJokeActivity : AppCompatActivity() {

    private lateinit var databinding: ActivitySubmitjokeBinding

    @Inject
    lateinit var jokeRepo: JokeRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_submitjoke)
        var toastMessage = ""

        databinding.submitJokeButton.setOnClickListener {
            if (databinding.submitJokeEditText.text.isNullOrBlank()) {
                toastMessage = "Please do not leave it blank"
                Toast.makeText(applicationContext, toastMessage, Toast.LENGTH_SHORT).show()
            } else {
                CoroutineScope(Dispatchers.IO).launch {
                    val submitJokeRequest = SubmitJokeRequest(
                        3,
                        "Misc",
                        "single",
                        databinding.submitJokeEditText.text.toString(),
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

                    toastMessage = jokeRepo.submitJoke(submitJokeRequest)
                    withContext(Dispatchers.Main) {
                        Toast.makeText(applicationContext, toastMessage, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}