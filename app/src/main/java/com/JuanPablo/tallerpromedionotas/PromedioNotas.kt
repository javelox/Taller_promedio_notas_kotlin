package com.JuanPablo.tallerpromedionotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PromedioNotas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promedio_notas)

        val Nombre = findViewById<TextView>(R.id.Resultado_Nombre)
        val Materia = findViewById<TextView>(R.id.Resultado_Materia)
        val Nota_1 = findViewById<TextView>(R.id.Resultado_Nota1)
        val Nota_2 = findViewById<TextView>(R.id.Resultado_Nota2)
        val Nota_3 = findViewById<TextView>(R.id.Resultado_Nota3)
        val Promedio = findViewById<TextView>(R.id.Resultado_Promedio)

        var miBundle:Bundle? = this.intent.extras

        if(miBundle != null){
            Nombre.text="${miBundle.getString("Nombre_estudiante")}"
            Materia.text="${miBundle.getString("Materia")}"
            val Nota1:Double = miBundle.getDouble("Nota1")
            val Nota2:Double = miBundle.getDouble("Nota2")
            val Nota3:Double = miBundle.getDouble("Nota3")
            val Nombre_estudiante:String? = miBundle.getString("Nombre_estudiante")
            Nota_1.text="${miBundle.getDouble("Nota1")}"
            Nota_2.text="${miBundle.getDouble("Nota2")}"
            Nota_3.text="${miBundle.getDouble("Nota3")}"

            var resultadoPromedio:Double = (Nota1 + Nota2 + Nota3)/3;

            val resultado = if (resultadoPromedio>=3.5){
                Promedio.setTextColor(resources.getColor(R.color.green))
                "El estudiante ${Nombre_estudiante} Aprobó"
            }  else {
                Promedio.setTextColor(resources.getColor(R.color.red))
                "El estudiante ${Nombre_estudiante} Reaprobó"
            }

            Promedio.text="El resultado es: ${resultadoPromedio} y ${resultado}"
        }

        val btnSalir:Button = findViewById(R.id.Exit)
        btnSalir.setOnClickListener { onClick() }
    }

    private fun onClick() {
        finish()
    }
}