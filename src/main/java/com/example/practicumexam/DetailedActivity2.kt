package com.example.practicumexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailedActivity2 : AppCompatActivity() {


    private lateinit var songTitles:ArrayList<String>
    private lateinit var artistNames:ArrayList<String>
    private lateinit var ratings:ArrayList<Int>
    private lateinit var comments:ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed2)


        val detailsView=findViewById<TextView>(R.id.detailsView)
        val displayBtn=findViewById<Button>(R.id.displayBtn)
        val averageBtn=findViewById<Button>(R.id.averageBtn)
        val returnBtn=findViewById<Button>(R.id.returnBtn)


        songTitles=intent.getStringArrayListExtra("songTitles")?: arrayListOf()
        artistNames=intent.getStringArrayListExtra("artistNames")?: arrayListOf()
        ratings=intent.getIntegerArrayListExtra("ratings")?: arrayListOf()
        comments=intent.getStringArrayListExtra("comments")?: arrayListOf()

        // Display of the playlists
        displayBtn.setOnClickListener {
            val result=StringBuilder("Full Playlist:\n\n")
            for(i in songTitles.indices){
                result.append("Song:${songTitles[i]}\n")
                result.append("Artist:${artistNames[i]}\n")
                result.append("Rate:${ratings[i]}\n")
                result.append("Comment:${comments[i]}\n\n")
            }
            detailsView.text=result.toString()
        }
        // Display Songs with Rating >=3
        averageBtn.setOnClickListener {
            val result=StringBuilder("Songs with Rating >=3:\n\n")
            for (i in songTitles.indices){
                if (ratings[i]>=3){
                    result.append("Song:${songTitles[i]}\n")
                    result.append("Artist:${artistNames[i]}\n")
                    result.append("Rate:${ratings[i]}\n")
                    result.append("Comment:${comments}\n\n")
                }
            }
            detailsView.text=result.toString()
        }
        // Return to main activity
        returnBtn.setOnClickListener {
            finish()
        }
    }
}