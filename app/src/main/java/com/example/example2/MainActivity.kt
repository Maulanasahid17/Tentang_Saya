package com.example.example2

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.klik1)

        val buttonLogout = findViewById<Button>(R.id.buttonkeluar)
        buttonLogout?.setOnClickListener {  // Safe call operator
            startActivity(Intent(this, login::class.java))
            finish()
        }

        val icon1 = findViewById<ImageView>(R.id.icon1)
        icon1?.setOnClickListener { openCalculator() }

        val icon11 = findViewById<ImageView>(R.id.icon2)
        icon11?.setOnClickListener { openCalculator() } // Only once!

        val buttons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
            R.id.btnPlus, R.id.btnMinus, R.id.btnMultiply, R.id.btnDivide,
            R.id.btnEqual, R.id.btnClear
        )

        for (buttonId in buttons) {
            val button = findViewById<Button>(buttonId)  // Get the button
            button?.setOnClickListener { // Safe call on the button
                playClickSound()
            }
        }
    }

    private fun openCalculator() {
        startActivity(Intent(this, CalculatorActivity::class.java))
    }

    private fun playClickSound() {
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.start()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}