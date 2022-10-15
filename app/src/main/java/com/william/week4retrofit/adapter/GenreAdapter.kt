package com.william.week4retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.william.week4retrofit.R
import com.william.week4retrofit.databinding.ListGenreBinding
import com.william.week4retrofit.model.Genre

class GenreAdapter(private val dataGenre: List<Genre>):
    RecyclerView.Adapter<GenreAdapter.ViewHolder> () {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
            val binding = ListGenreBinding.bind(itemView)
            val tvGenre= binding.tvGenre


        }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_genre, viewGroup, false)

        return ViewHolder(view)
    }
    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.tvGenre.text = dataGenre[position].name
    }
    override fun getItemCount() = dataGenre.size

}