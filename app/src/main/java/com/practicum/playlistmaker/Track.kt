package com.practicum.playlistmaker

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

data class Track (
    val trackName:      String,   // Название композиции
    val artistName:     String,   // Имя исполнителя
    val trackDuration:  String,   // Продолжительность трека
    val artworkUrl100:  String    // Ссылка на изображение обложки
)

class TrackViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val trackImage:     ImageView = itemView.findViewById(R.id.track_image)
    private val trackName:      TextView  = itemView.findViewById(R.id.track_name)
    private val trackSinger:    TextView  = itemView.findViewById(R.id.track_singer)
    private val trackDuration:  TextView  = itemView.findViewById(R.id.track_duration)

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

class TrackAdapter(private val tracks: List<Track>) : RecyclerView.Adapter<TrackViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.track, parent, false)
        return TrackViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.bind(tracks[position])
    }

    override fun getItemCount(): Int {
        return tracks.size
    }

}