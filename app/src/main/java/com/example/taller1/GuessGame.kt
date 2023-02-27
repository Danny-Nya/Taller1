package com.example.taller1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random
import java.util.*
import kotlin.random.nextInt

class GuessGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess_game)
        val num=intent.getStringExtra("number").toString()
        val print=findViewById<TextView>(R.id.GuessGameTitle)
        print.setText(getString(R.string.Titulo1)+num)
        val max= num.toInt()+1
        val NumAdi= Random.nextInt(max)
        var cont=0
        val check=findViewById<Button>(R.id.Check)
        check.setOnClickListener(){
            cont += 1
            CompareActivity(NumAdi)
            val coun=findViewById<TextView>(R.id.Counterr)
            coun.setText(getString(R.string.Try)+cont.toString())
        }
    }
    fun CompareActivity(NumAdi: Int){
        val Guess=findViewById<EditText>(R.id.UserNumber).text.toString().toInt()
        if (Guess==NumAdi){
            val result=findViewById<TextView>(R.id.Result)
            result.setText(getString(R.string.Win))
        }
        else if (Guess>NumAdi){
            val result=findViewById<TextView>(R.id.Result)
            result.setText(getString(R.string.Low)+Guess.toString())
        }
        else if (Guess<NumAdi){
            val result=findViewById<TextView>(R.id.Result)
            result.setText(getString(R.string.High)+Guess.toString())
        }
    }
}