package com.example.sampleocbccode.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleocbccode.R
import com.example.sampleocbccode.databinding.ItemJokeBinding
import com.example.sampleocbccode.domain.feature.joke.model.Joke

class JokeAdapter(private var jokes: MutableList<Joke>) :
    RecyclerView.Adapter<JokeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemJokeBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_joke, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(jokes[position])
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    class ViewHolder(private val binding: ItemJokeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Joke) {
            with(binding) {
                jokeSetup = item.setup
                jokeDelivery = item.delivery
                executePendingBindings()
            }
        }
    }
}