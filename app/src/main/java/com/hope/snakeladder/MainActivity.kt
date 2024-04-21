package com.hope.snakeladder

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var text1 : TextView? = null
    var text2 : TextView? = null
    var image1 : ImageView? = null
    var image2 : ImageView? = null
    var dice : Int = 0
    var player1 : Boolean = true
    var player2 : Boolean = false
    var diceClick : Boolean = true
    var ps1 : TextView? = null
    var ps2 : TextView? = null
    var score1 : Int = 0
    var score2 : Int = 0
    var coin1 : ImageView? = null
    var coin2 : ImageView? = null
    var gridview : GridLayout? = null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        text1 = findViewById(R.id.text1)
        text2 = findViewById(R.id.text2)
        image1 = findViewById(R.id.image1)
        image2 = findViewById(R.id.image2)
        coin1 = findViewById(R.id.coin1)
        coin2 = findViewById(R.id.coin2)
        ps1 = findViewById(R.id.score1)
        ps2 = findViewById(R.id.score2)

        image1?.setImageResource(R.drawable.sankeladder)
        image2?.setImageResource(R.drawable.sankeladder)
        coin1?.setImageResource(R.drawable.redcoin)
        coin2?.setImageResource(R.drawable.bluecoin)


        var diceList = mapOf(
            1 to R.drawable.one,
            2 to R.drawable.two,
            3 to R.drawable.three,
            4 to R.drawable.four,
            5 to R.drawable.five,
            6 to R.drawable.six,
        )
        var snake = mapOf(
//          SANKE
            27 to 5,
            40 to 3,
            43 to 18,
            54 to 31,
            66 to 45,
            89 to 53,
            95 to 77,
            99 to 41,

//          LADDER
            4 to 25,
            13 to 46,
            33 to 49,
            42 to 63,
            50 to 69,
            62 to 81,
            74 to 92
        )

        text1?.setBackgroundColor(Color.GREEN)
        text2?.setBackgroundColor(Color.GRAY)

        dice = Random.nextInt(1, 7)
        diceList[dice]?.let { image2?.setImageResource(it) }

        image2?.setOnClickListener {
            dice = Random.nextInt(1, 7)
            diceList[dice]?.let { it1 -> image2?.setImageResource(it1) }
            if (player1) {
                score1 += dice
                if(score1 in snake) {
                    score1 = snake[score1]!!
                }
                ps1?.text = score1.toString()
                player1 = false
                text1?.setBackgroundColor(Color.GRAY)
                text2?.setBackgroundColor(Color.GREEN)
            }
            else {
                score2 += dice
                if(score2 in snake) {
                    score2 = snake[score2]!!
                }
                ps2?.text = score2.toString()
                player1 = true
                text1?.setBackgroundColor(Color.GREEN)
                text2?.setBackgroundColor(Color.GRAY)
            }
            if (score1 >= 100 ) {
                ps1?.text = "100"
                player1 = false
                player2 = false
                diceClick = false
            }
            if (score2 >= 100) {
                ps2?.text = "100"
                player1 = false
                player2 = false
                diceClick = false
            }
        }
    }
}