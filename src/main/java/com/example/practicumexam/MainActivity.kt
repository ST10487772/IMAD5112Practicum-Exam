package com.example.practicumexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // Adding parallel arrays
    private val songTitles = mutableListOf<String>()
    private val artistNames = mutableListOf<String>()
    private val ratings = mutableListOf<Int>()
    private val comments = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val songTitleText = findViewById<EditText>(R.id.songtitleText)
        val artistNameText = findViewById<EditText>(R.id.ArtistnameText)
        val ratingText = findViewById<EditText>(R.id.ratingText)
        val commentText = findViewById<EditText>(R.id.commentText)

        val atpBtn = findViewById<Button>(R.id.atpBtn)
        val nextBtn = findViewById<Button>(R.id.nextBtn)
        val exitBtn = findViewById<Button>(R.id.exitBtn)

        atpBtn.setOnClickListener {
            val song = songTitleText.text.toString().trim()
            val artist = artistNameText.text.toString().trim()
            val ratingStr = ratingText.text.toString().trim()
            val comment = commentText.text.toString().trim()

            if (song.isBlank() || artist.isBlank() || ratingStr.isBlank()) {
                Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val rating = ratingStr.toInt()

                // Add to parallel arrays
                songTitles.add(song)
                artistNames.add(artist)
                ratings.add(rating)
                comments.add(comment)

                Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT).show()

                // Clear fields
                songTitleText.text.clear()
                artistNameText.text.clear()
                ratingText.text.clear()
                commentText.text.clear()

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Rating must be a number", Toast.LENGTH_SHORT).show()
            }
        }

        nextBtn.setOnClickListener {
            val intent = Intent(this, DetailedActivity2::class.java)
            intent.putStringArrayListExtra("Songtitle", ArrayList(songTitles))
            intent.putStringArrayListExtra("ArtistName", ArrayList(artistNames))
            intent.putIntegerArrayListExtra("Rating", ArrayList(ratings))
            intent.putStringArrayListExtra("comments", ArrayList(comments))
            startActivity(intent)
        }

        exitBtn.setOnClickListener {
            finish()
        }
    }
}
