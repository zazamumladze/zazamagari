package com.example.nodari

import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var zaza1: ImageButton
    private lateinit var zaza2: ImageButton
    private lateinit var zaza3: ImageButton
    private lateinit var zaza4: ImageButton
    private lateinit var zaza5: ImageButton
    private lateinit var zaza6: ImageButton
    private lateinit var zaza7: ImageButton
    private lateinit var zaza8: ImageButton
    private lateinit var zaza9: ImageButton

    private lateinit var resetButton: Button

    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    private var activePlayer = 1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        reset()
    }

    private fun init() {
        zaza1 = findViewById(R.id.zaza1)
        zaza2 = findViewById(R.id.zaza2)
        zaza3 = findViewById(R.id.zaza3)
        zaza4 = findViewById(R.id.zaza4)
        zaza5 = findViewById(R.id.zaza5)
        zaza6 = findViewById(R.id.zaza6)
        zaza7 = findViewById(R.id.zaza7)
        zaza8 = findViewById(R.id.zaza8)
        zaza9 = findViewById(R.id.zaza9)

        resetButton = findViewById(R.id.zazamagari)

        zaza1.setOnClickListener(this)
        zaza2.setOnClickListener(this)
        zaza3.setOnClickListener(this)
        zaza4.setOnClickListener(this)
        zaza5.setOnClickListener(this)
        zaza6.setOnClickListener(this)
        zaza7.setOnClickListener(this)
        zaza8.setOnClickListener(this)
        zaza9.setOnClickListener(this)





    }

    override fun onClick(clickedView: View?) {

        if (clickedView is ImageButton) {
            var buttonNumber = 0

            when (clickedView.id) {
                R.id.zaza1 -> buttonNumber = 1
                R.id.zaza2 -> buttonNumber = 2
                R.id.zaza3 -> buttonNumber = 3
                R.id.zaza4 -> buttonNumber = 4
                R.id.zaza5 -> buttonNumber = 5
                R.id.zaza6 -> buttonNumber = 6
                R.id.zaza7 -> buttonNumber = 7
                R.id.zaza8 -> buttonNumber = 8
                R.id.zaza9 -> buttonNumber = 9


            }
            if (buttonNumber != 0){
                playGame(buttonNumber, clickedView )
            }
        }

    }

    private fun playGame(buttonNumber: Int, clickedView: ImageButton){
        if (activePlayer == 1)  {
            //clickedView.text = "X"
            clickedView.setImageResource(R.drawable.lilu)
            firstPlayer.add(buttonNumber)
            activePlayer = 2
        } else {
            //clickedView.text = "O"
            clickedView.setImageResource(R.drawable.stich)
            secondPlayer.add(buttonNumber)
            activePlayer = 1
        }
        clickedView.isEnabled = false
        check()
    }
    private fun check(){
        var winnerPlayer = 0

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3) ){
            winnerPlayer = 1
        }
           if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)){
               winnerPlayer = 2
           }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6) ){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9) ){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9) ){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7) ){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(3) && firstPlayer.contains(7) ){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(3) && secondPlayer.contains(7)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8) ){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)){
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9) ){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if (winnerPlayer != 0) {
            if (winnerPlayer == 1) {
                Toast.makeText(this, "Tom Wins!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Jerry Wins!", Toast.LENGTH_LONG).show()
            }
            disableButtons()


        }

    }

    private fun disableButtons() {
        zaza1.isEnabled = false
        zaza2.isEnabled = false
        zaza3.isEnabled = false
        zaza4.isEnabled = false
        zaza5.isEnabled = false
        zaza6.isEnabled = false
        zaza7.isEnabled = false
        zaza8.isEnabled = false
        zaza9.isEnabled = false

    }

    private fun reset() {
        resetButton.setOnClickListener {


            zaza1.isEnabled = true
            zaza2.isEnabled = true
            zaza3.isEnabled = true
            zaza4.isEnabled = true
            zaza5.isEnabled = true
            zaza6.isEnabled = true
            zaza7.isEnabled = true
            zaza8.isEnabled = true
            zaza9.isEnabled = true

            firstPlayer.clear()
            secondPlayer.clear()
            activePlayer = 1

            zaza1.setImageResource(android.R.color.transparent)
            zaza2.setImageResource(android.R.color.transparent)
            zaza3.setImageResource(android.R.color.transparent)
            zaza4.setImageResource(android.R.color.transparent)
            zaza5.setImageResource(android.R.color.transparent)
            zaza6.setImageResource(android.R.color.transparent)
            zaza7.setImageResource(android.R.color.transparent)
            zaza8.setImageResource(android.R.color.transparent)
            zaza9.setImageResource(android.R.color.transparent)




        }

    }
}




