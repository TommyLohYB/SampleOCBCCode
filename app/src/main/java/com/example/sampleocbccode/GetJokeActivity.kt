package com.example.sampleocbccode

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleocbccode.api.JokesAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetJokeActivity : AppCompatActivity() {

    var listOfJokes: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getjoke)

        val BASE_URL = "https://v2.jokeapi.dev/joke/"
        val api =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
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
            GlobalScope.launch(Dispatchers.Main) {
                val getJokeResponse = api.getJokes()
                if (getJokeResponse.isSuccessful) {
                    val jokeResponse = getJokeResponse.body()!!
                    val jokes = jokeResponse.jokes
                    listOfJokes.clear()
                    for(joke in jokes){
                        Log.d("Tommy",joke.joke)
                        listOfJokes.add(joke.joke)
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