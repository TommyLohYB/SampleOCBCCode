package com.example.sampleocbccode.ui.activities

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleocbccode.JokeAdapter
import com.example.sampleocbccode.R
import com.example.sampleocbccode.domain.feature.joke.service.JokesAPI
import com.example.sampleocbccode.domain.feature.joke.model.Joke
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetJokeActivity : AppCompatActivity() {

    var listOfJokes: ArrayList<Joke> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getjoke)

        //OkHttp
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val BASE_URL = "https://v2.jokeapi.dev/joke/"
        val api =
            Retrofit.Builder().baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(JokesAPI::class.java)

        //Init UI elements
        val getJokeButton = findViewById<Button>(R.id.getJokeButton)
        val recyclerView  = findViewById<RecyclerView>(R.id.recyclerView)

        //Initialize RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = JokeAdapter(listOfJokes)
        recyclerView.adapter = adapter

        //OnClickListener
        getJokeButton.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                val getJokeResponse = api.getJokes()
                if (getJokeResponse.isSuccessful) {
                    val jokeResponse = getJokeResponse.body()!!
                    val jokes = jokeResponse.jokes
                    listOfJokes.clear()
                    for(joke in jokes){
                        listOfJokes.add(joke)
                    }
                    withContext(Dispatchers.Main){
                        adapter.notifyDataSetChanged()
                    }
                }else{
                    val toastMessage  = "Unable to get jokes"
                    Toast.makeText(applicationContext,toastMessage, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}