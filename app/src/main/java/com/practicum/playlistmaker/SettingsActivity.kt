package com.practicum.playlistmaker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_settings)

        val btnBack    = findViewById<ImageButton>(R.id.btn_arrow_back)
        val btnSupport = findViewById<ImageButton>(R.id.btn_support)

        btnBack.setOnClickListener {
            val backIntent = Intent(this, MainActivity::class.java)
            startActivity(backIntent)
        }

        btnSupport.setOnClickListener {

            val intent = Intent(Intent.ACTION_SEND)
            intent.setData(Uri.parse("mailto:"))
            intent.setType("message/rfc822")

            intent.putExtra(Intent.EXTRA_EMAIL,     "sviridov.sergey.0@yandex.ru")
            intent.putExtra(Intent.EXTRA_SUBJECT,   "Сообщение разработчикам и разработчицам приложения Playlist Maker")
            intent.putExtra(Intent.EXTRA_TEXT,      "Спасибо разработчикам и разработчицам за крутое приложение!");

            if(intent.resolveActivity(packageManager) != null)
                startActivity(intent)
        }
    }
}