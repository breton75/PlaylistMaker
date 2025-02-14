package com.practicum.playlistmaker

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners


class TrackViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val trackImage: ImageView = itemView.findViewById(R.id.track_image)
    private val trackName: TextView = itemView.findViewById(R.id.track_name)
    private val trackSinger: TextView = itemView.findViewById(R.id.track_singer)
    private val trackDuration: TextView = itemView.findViewById(R.id.track_duration)

    fun bind(data: Track) {

        trackName.text      = data.trackName
        trackSinger.text    = data.artistName
        trackDuration.text  = data.trackDuration

        Glide.with(itemView).load(data.artworkUrl100)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
            .centerInside()
            .transform(RoundedCorners(2))
            .into(trackImage)
    }

}