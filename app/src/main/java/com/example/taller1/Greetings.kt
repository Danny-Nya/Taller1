package com.example.taller1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class Greetings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greetings)
        val Greeting=intent.getStringExtra("greet").toString().toInt()
        when (Greeting) {
            0 -> {
                Toast.makeText(applicationContext, "Hallo Guten Morgen", Toast.LENGTH_SHORT).show()
            }
            1 -> {
                Toast.makeText(applicationContext, "Hello Good Morning", Toast.LENGTH_SHORT).show()
            }
            2 -> {
                Toast.makeText(applicationContext, "Hola Buenos Dias", Toast.LENGTH_SHORT).show()
            }
            3 -> {
                Toast.makeText(applicationContext, "おはようございます", Toast.LENGTH_SHORT).show()
            }
        }
    }
}