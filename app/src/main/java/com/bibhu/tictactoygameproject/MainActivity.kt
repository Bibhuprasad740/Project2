package com.bibhu.tictactoygameproject

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonclick(view:View){
        var cellId = 0
        var buclick = view as Button
        when(buclick.id){
            R.id.bu1-> cellId = 1
            R.id.bu2-> cellId = 2
            R.id.bu3-> cellId = 3
            R.id.bu4-> cellId = 4
            R.id.bu5-> cellId = 5
            R.id.bu6-> cellId = 6
            R.id.bu7-> cellId = 7
            R.id.bu8-> cellId = 8
            R.id.bu9-> cellId = 9

        }
        //Toast.makeText(this,"Clicked:"+cellId,Toast.LENGTH_LONG).show()
        playgame(cellId,buclick)
    }
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var currentplayer = 1
    var winner = -1
    
    fun playgame(cellId:Int,buclick:Button){
        buclick.isEnabled = false
        if(currentplayer == 1){
            buclick.text = "X"
            buclick.setBackgroundColor(Color.RED)
            player1.add(cellId)
            checkwinner()
            currentplayer = 2
        }else{
            buclick.text = "O"
            buclick.setBackgroundColor(Color.GREEN)
            player2.add(cellId)
            checkwinner()
            currentplayer = 1
        }
    }
    fun checkwinner(){
        if (winner == -1){
            if (player1.contains(1) && player1.contains(2) &&player1.contains(3)){
                winner = 1
            }else if (player1.contains(4) && player1.contains(5) &&player1.contains(6)){
                winner = 1
            }else if (player1.contains(7) && player1.contains(8) &&player1.contains(9)){
                winner = 1
            }else if (player1.contains(1) && player1.contains(5) &&player1.contains(9)){
                winner = 1
            }else if (player1.contains(3) && player1.contains(5) &&player1.contains(7)){
                winner = 1
            }else if (player1.contains(1) && player1.contains(4) &&player1.contains(7)){
                winner = 1
            }else if (player1.contains(2) && player1.contains(5) &&player1.contains(8)){
                winner = 1
            }else if (player1.contains(3) && player1.contains(6) &&player1.contains(9)){
                winner = 1
            }

            if (player2.contains(1) && player2.contains(2) &&player2.contains(3)){
                winner = 2
            }else if (player2.contains(4) && player2.contains(5) &&player2.contains(6)){
                winner = 2
            }else if (player2.contains(7) && player2.contains(8) &&player2.contains(9)){
                winner = 2
            }else if (player2.contains(1) && player2.contains(5) &&player2.contains(9)){
                winner = 2
            }else if (player2.contains(3) && player2.contains(5) &&player2.contains(7)){
                winner = 2
            }else if (player2.contains(1) && player2.contains(4) &&player2.contains(7)){
                winner = 2
            }else if (player2.contains(2) && player2.contains(5) &&player2.contains(8)){
                winner = 2
            }else if (player2.contains(3) && player2.contains(6) &&player2.contains(9)){
                winner = 2
            }
        }
        if (winner != -1)
            Toast.makeText(this,"Player $winner Wins.",Toast.LENGTH_SHORT).show()
        else if (player1.size + player2.size == 9)
            Toast.makeText(this,"No Winners.",Toast.LENGTH_SHORT).show()
        
    }
}