package com.practicum.playlistmaker

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchActivity : AppCompatActivity() {

    var searchText: String? = ""

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
                clearButton.visibility = if (s.isNullOrEmpty()) View.GONE else View.VISIBLE

            }

            override fun afterTextChanged(s: Editable?) {
                searchText = inputEditText.toString()
            }
        }

        clearButton.setOnClickListener {
            inputEditText.setText("")

            val imm: InputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(inputEditText.windowToken, 0);
        }

        inputEditText.addTextChangedListener(textWatcher)
        clearButton.callOnClick()

//        val trackList = MockData.getData()

        val recyclerView = findViewById<RecyclerView>(R.id.rvTracks)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = TrackAdapter(MockData.getData())

    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)

        outState.putString(SEARCH_EDIT_TEXT, searchText)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)

        val inputEditText = findViewById<EditText>(R.id.search_edit_text)

        if(savedInstanceState != null) {

            searchText = savedInstanceState.getString(SEARCH_EDIT_TEXT)
            inputEditText.setText(searchText)

        }
    }

    companion object {
        const val SEARCH_EDIT_TEXT = "SEARCH_EDIT_TEXT"
    }

}