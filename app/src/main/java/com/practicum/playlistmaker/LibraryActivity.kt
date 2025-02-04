package com.practicum.playlistmaker

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class LibraryActivity : AppCompatActivity() {

    private val imageUrl = "https://img.freepik.com/free-vector/open-blue-book-white_1308-69339.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_library)

        val image = findViewById<ImageView>(R.id.image)

        Glide.with(applicationContext).load(MockData.getData()[1].artworkUrl100).centerInside().transform(RoundedCorners(10)).into(image)
    }
}