package com.JuanPablo.tallerpromedionotas


import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnSend:Button = findViewById(R.id.IdSend)
        btnSend.setOnClickListener { calculate() }
    }

    private fun calculate() {
        val inputNombre: EditText = findViewById(R.id.Nombre_estudiante)


        val inputMateria: EditText = findViewById(R.id.Materia)


        val inputNota1: EditText = findViewById(R.id.nota_1)


        val inputNota2: EditText = findViewById(R.id.nota_2)


        val inputNota3: EditText = findViewById(R.id.nota_3)


        val intent = Intent(this,PromedioNotas::class.java)
        val miBundle:Bundle=Bundle()
        miBundle.putString("Nombre_estudiante",inputNombre!!.text.toString())
        miBundle.putString("Materia",inputMateria.text.toString())
        miBundle.putDouble("Nota1", inputNota1.text.toString().toDouble())
        miBundle.putDouble("Nota2", inputNota2.text.toString().toDouble())
        miBundle.putDouble("Nota3", inputNota3.text.toString().toDouble())
        intent.putExtras(miBundle)
        startActivity(intent)
    }


}