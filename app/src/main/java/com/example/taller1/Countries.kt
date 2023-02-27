package com.example.taller1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class Countries : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)
        val spin=FillSpinnerActivity()
        selectCountryActivity(spin)
    }
    fun loadJSONFromAssetActivity(): String?{
        var json: String? = null
        try{
            val istream: InputStream = assets.open("paises.json")
            val size: Int = istream.available()
            val buffer = ByteArray(size)
            istream.read(buffer)
            istream.close()
            json = String(buffer, Charsets.UTF_8)
        }
        catch (ex: IOException){
            ex.printStackTrace()
            return null
        }
        return json
    }
    fun FillSpinnerActivity():Spinner{
        val json= JSONObject(loadJSONFromAssetActivity())
        val lista= ArrayList<String>()
        val paises=json.getJSONArray("paises")
        for (i in 0 until paises.length()){
            val jsonobj=paises.getJSONObject(i)
            val Nombre=jsonobj.getString("nombre_pais")
            lista.add(Nombre)
        }
        val spin= findViewById<Spinner>(R.id.Paises)
        spin.adapter= ArrayAdapter(this,android.R.layout.simple_spinner_item,lista)
        return spin
    }
    fun selectCountryActivity(spin: Spinner){
        val json= JSONObject(loadJSONFromAssetActivity())
        val paises=json.getJSONArray("paises")
        val Bandera=findViewById<ImageView>(R.id.Bandera)
        spin.onItemSelectedListener=object:
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val Greeting=p2
                val jsonobj=paises.getJSONObject(p2)
                val NameSP=jsonobj.getString("nombre_pais")
                val CapitalC=jsonobj.getString("capital")
                val NameENG=jsonobj.getString("nombre_pais_int")
                val Acro=jsonobj.getString("sigla")
                val image_url=jsonobj.getString("URL")
                val CapitalT=findViewById<TextView>(R.id.Capital)
                CapitalT.setText(getString(R.string.Capital)+CapitalC)
                val NameSPT=findViewById<TextView>(R.id.NameSp)
                NameSPT.setText(getString(R.string.NombreSP)+NameSP)
                val NameENGT=findViewById<TextView>(R.id.NameEng)
                NameENGT.setText(getString(R.string.NameENG)+NameENG)
                val AcroT=findViewById<TextView>(R.id.acronym)
                AcroT.setText(getString(R.string.Acronym)+Acro)
                Picasso.get().load(image_url).into(Bandera)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}