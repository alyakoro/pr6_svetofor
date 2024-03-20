package com.korobeynikova.pr6_svetofor

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var red: ImageView
    private lateinit var yellow: ImageView
    private lateinit var green: ImageView
    private lateinit var switch: Button

    private var currentColorIndex = 0

    companion object {
        private const val CURRENT_COLOR_INDEX_KEY = "currentColorIndex"
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        red = findViewById(R.id.red)
        yellow = findViewById(R.id.yellow)
        green = findViewById(R.id.green)
        switch = findViewById(R.id.button)

        updateColorViews()

        switch.setOnClickListener {
            switchColor()
        }

        savedInstanceState?.let {
            currentColorIndex = it.getInt(CURRENT_COLOR_INDEX_KEY, 0)
            updateColorViews()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(CURRENT_COLOR_INDEX_KEY, currentColorIndex)
        super.onSaveInstanceState(outState)
    }

    private fun switchColor() {
        currentColorIndex = (currentColorIndex + 1) % 3
        updateColorViews()
    }

    @SuppressLint("ResourceType")
    private fun updateColorViews() {
        when (currentColorIndex) {
            0 -> {
                red.setImageResource(R.drawable.circle_red)
                yellow.setImageResource(R.drawable.circle_gray)
                green.setImageResource(R.drawable.circle_gray)
            }
            1 -> {
                red.setImageResource(R.drawable.circle_gray)
                yellow.setImageResource(R.drawable.circle_yellow)
                green.setImageResource(R.drawable.circle_gray)
            }
            2 -> {
                red.setImageResource(R.drawable.circle_gray)
                yellow.setImageResource(R.drawable.circle_gray)
                green.setImageResource(R.drawable.circle_green)
            }
        }
    }
}