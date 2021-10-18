package com.example.sampleocbccode.ui.activities

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleocbccode.ui.adapters.JokeAdapter
import com.example.sampleocbccode.R
import com.example.sampleocbccode.databinding.ActivityGetjokeBinding
import com.example.sampleocbccode.domain.di.module.ApplicationModule
import com.example.sampleocbccode.domain.feature.joke.model.Joke
import com.example.sampleocbccode.domain.feature.joke.repository.JokeRepository
import com.example.sampleocbccode.domain.feature.joke.service.JokesAPI
import com.example.sampleocbccode.domain.network.RetrofitService
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class GetJokeActivity : AppCompatActivity() {

    private var listOfJokes: MutableList<Joke> = mutableListOf()
    private lateinit var databinding: ActivityGetjokeBinding

    @Inject
    lateinit var jokeRepo: JokeRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_getjoke)

        //Initialize RecyclerView
        databinding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = JokeAdapter(listOfJokes)
        databinding.recyclerView.adapter = adapter

        //OnClickListener
        databinding.getJokeButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val jokes = jokeRepo.getJoke()
                withContext(Dispatchers.Main) {
                    if (jokes.isNotEmpty()) {
                        listOfJokes.clear()
                        listOfJokes.addAll(jokes)
                        adapter.notifyDataSetChanged()
                    } else {
                        val toastMessage = "Unable to get jokes"
                        Toast.makeText(applicationContext, toastMessage, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}