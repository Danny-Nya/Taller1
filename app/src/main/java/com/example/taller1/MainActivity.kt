package com.example.taller1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spin=FillSpinnerActivity()
        ButtonGuessActivity()
        DefineGreetActivity(spin)
        GoToCountriesActivity()
    }
    fun FillSpinnerActivity() :Spinner{
        val spin= findViewById<Spinner>(R.id.Lenguajes)
        val lista=resources.getStringArray(R.array.opciones)
        spin.adapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,lista)
        return spin
    }
    fun ButtonGuessActivity(){
        val buttonClick = findViewById<Button>(R.id.buttonGuess)
        buttonClick.setOnClickListener {
            val limit = findViewById<EditText>(R.id.Numbers).text.toString()
            if(limit.toInt()<0 || limit.toInt()>1000){
                Toast.makeText(applicationContext,getString(R.string.outbounds),Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(this, GuessGame::class.java)
                intent.putExtra("number", limit)
                startActivity(intent)
            }
        }
    }
    fun DefineGreetActivity(spin: Spinner){
        var Greeting=0
        spin.onItemSelectedListener=object:
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Greeting=p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        val buttonGreet = findViewById<Button>(R.id.Greet)
        buttonGreet.setOnClickListener {
            val intent = Intent(this, Greetings::class.java)
            intent.putExtra("greet", Greeting.toString())
            startActivity(intent)
        }
    }
    fun GoToCountriesActivity(){
        val buttonCountries = findViewById<Button>(R.id.Countries)
        buttonCountries.setOnClickListener {
            val intent = Intent(this, Countries::class.java)
            startActivity(intent)
        }
    }
}