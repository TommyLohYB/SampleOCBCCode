package com.example.sampleocbccode.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleocbccode.R
import com.example.sampleocbccode.domain.feature.joke.model.Joke

class JokeAdapter(private var jokes: MutableList<Joke>) : RecyclerView.Adapter<JokeAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_joke, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val joke = jokes[position]
        holder.jokeSetupTextView.text = joke.setup
        holder.jokeDeliveryTextView.text = joke.delivery
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val jokeSetupTextView: TextView = itemView.findViewById(R.id.jokeSetupTextView)
        val jokeDeliveryTextView: TextView = itemView.findViewById(R.id.jokeDeliveryTextView)
    }
}