package com.practicum.playlistmaker

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_search)

        val btnBack       = findViewById<ImageButton>(R.id.btn_arrow_back)
        val inputEditText = findViewById<EditText>(R.id.search_edit_text)
        val clearButton   = findViewById<ImageView>(R.id.btn_clear)

        btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        // логика по работе с введённым значением
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // empty
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                clearButton.visibility = if (s.isNullOrEmpty()) View.GONE else View.VISIBLE //clearButtonVisibility(s)
            }

            override fun afterTextChanged(s: Editable?) {
                // empty
            }
        }

        clearButton.setOnClickListener {
            inputEditText.setText("")
        }

        clearButton.callOnClick()

        inputEditText.addTextChangedListener(textWatcher)
        inputEditText.requestFocus()

    }

}