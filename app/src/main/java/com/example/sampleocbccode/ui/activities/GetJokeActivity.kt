package com.example.sampleocbccode.ui.activities

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleocbccode.ui.adapters.JokeAdapter
import com.example.sampleocbccode.R
import com.example.sampleocbccode.domain.feature.joke.model.Joke
import com.example.sampleocbccode.domain.feature.joke.repository.JokeRepository
import com.example.sampleocbccode.domain.network.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class GetJokeActivity : AppCompatActivity() {

    private var listOfJokes: List<Joke> = listOf()
    private val jokeRepository = JokeRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getjoke)

        //Init UI elements
        val getJokeButton = findViewById<Button>(R.id.getJokeButton)
        val recyclerView  = findViewById<RecyclerView>(R.id.recyclerView)

        //Initialize RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = JokeAdapter(listOfJokes)
        recyclerView.adapter = adapter

        //OnClickListener
        getJokeButton.setOnClickListener {
            val jokes = jokeRepository.getJoke()
            if(jokes.isNotEmpty()){
                listOfJokes = jokes
                adapter.notifyDataSetChanged()
            }else{
                val toastMessage  = "Unable to get jokes"
                Toast.makeText(applicationContext,toastMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}