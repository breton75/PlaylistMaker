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
            startActivity(Intent(this, MainActivity::class.java))
        }

        btnSupport.setOnClickListener {

            val intent = Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"))
            intent.setType("multipart/mixed")

            intent.putExtra(Intent.EXTRA_EMAIL,     getString(R.string.str_email))
            intent.putExtra(Intent.EXTRA_SUBJECT,   getString(R.string.str_subject))
            intent.putExtra(Intent.EXTRA_TEXT,      getString(R.string.str_message));

            if(intent.resolveActivity(packageManager) != null)
                startActivity(intent)
        }

        btnShare.setOnClickListener {

            val intent = Intent(Intent.ACTION_SEND)
            intent.setType("text/plain")
            intent.putExtra(Intent.EXTRA_TEXT,      getString(R.string.str_share_link));

            startActivity(Intent.createChooser(intent, ""))

        }

        btnAgree.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.str_agree_link)))
            startActivity(intent)

        }
    }
}