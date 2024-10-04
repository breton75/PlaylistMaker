package com.practicum.playlistmaker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // батон поиск. анонимный класс
        val btnSearch = findViewById<Button>(R.id.btn_search)
        btnSearch.setOnClickListener {
            val searchIntent = Intent(this, SearchActivity::class.java)
            startActivity(searchIntent)
        }
//        val btnSearchClickListener: View.OnClickListener = object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                Toast.makeText(this@MainActivity, "Нажали на ${btnSearch.text}!", Toast.LENGTH_SHORT).show()
//            }
//        }
//        btnSearch.setOnClickListener(btnSearchClickListener)

        // батон медиатека. лямбда
        val btnLib = findViewById<Button>(R.id.btn_library)
        btnLib.setOnClickListener {
            val libIntent = Intent(this, MediaLibActivity::class.java)
            startActivity(libIntent)
        }
//        btnLib.setOnClickListener {
//            Toast.makeText(this@MainActivity, "Нажали на ${btnLib.text}!", Toast.LENGTH_SHORT).show()
//        }

        // батон настройки. лямбда
        val btnSettings = findViewById<Button>(R.id.btn_settings)
        btnSettings.setOnClickListener {
            val settingsIntent = Intent(this, SettingsActivity::class.java)
            startActivity(settingsIntent)
        }
//        btnSettings.setOnClickListener {
//            Toast.makeText(this@MainActivity, "Нажали на ${btnSettings.text}!", Toast.LENGTH_SHORT).show()
//        }

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}