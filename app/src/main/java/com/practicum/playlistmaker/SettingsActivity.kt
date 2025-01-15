package com.practicum.playlistmaker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_settings)

        val btnBack    = findViewById<ImageButton>(R.id.btn_arrow_back)
        val btnSupport = findViewById<ImageButton>(R.id.btn_support)
        val btnShare   = findViewById<ImageButton>(R.id.btn_share)
        val btnAgree   = findViewById<ImageButton>(R.id.btn_agreement)

        btnBack.setOnClickListener {
            val backIntent = Intent(this, MainActivity::class.java)
            startActivity(backIntent)
        }

        btnSupport.setOnClickListener {

            val intent = Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"))
            intent.setType("multipart/mixed")

            intent.putExtra(Intent.EXTRA_EMAIL,     "sviridov.sergey.0@yandex.ru")
            intent.putExtra(Intent.EXTRA_SUBJECT,   "Сообщение разработчикам и разработчицам приложения Playlist Maker")
            intent.putExtra(Intent.EXTRA_TEXT,      "Спасибо разработчикам и разработчицам за крутое приложение!");

            if(intent.resolveActivity(packageManager) != null)
                startActivity(intent)
        }

        btnShare.setOnClickListener {

            val intent = Intent(Intent.ACTION_SEND)
            intent.setType("text/plain")
            intent.putExtra(Intent.EXTRA_TEXT,      "https://practicum.yandex.ru/profile/android-developer-plus/");

            startActivity(Intent.createChooser(intent, ""))

        }

        btnAgree.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://yandex.ru/legal/practicum_offer/"));
            startActivity(intent)

        }
    }
}