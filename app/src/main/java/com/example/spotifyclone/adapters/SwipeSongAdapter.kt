package com.example.spotifyclone.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.spotifyclone.R
import com.example.spotifyclone.data.entities.Song
import com.example.spotifyclone.databinding.ListItemBinding
import javax.inject.Inject

class SwipeSongAdapter : BaseSongAdapter(R.layout.swipe_item) {

    override val differ = AsyncListDiffer(this, differCallback)

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songs[position]

        holder.itemView.apply {

            val text = "${song.title} - ${song.subtitle}"
            findViewById<TextView>(R.id.tvPrimary).text = text

            setOnClickListener {
                onItemClickListener?.let {
                    it(song)
                }
            }
        }
    }
}