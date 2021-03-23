package com.ciro.calculadora_imc_bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var resultadoTXT = findViewById<TextView>(R.id.resultadoTXT)
        val tituloTXT = findViewById<TextView>(R.id.tituloAppTXT)
        val pesoEDT = findViewById<EditText>(R.id.pesoEDT)
        val alturaEDT = findViewById<EditText>(R.id.alturaEDT)
        val calculaBNT = findViewById<Button>(R.id.calcularBTN)


        calculaBNT.setOnClickListener {
            var imc = calculaIMC(pesoEDT.text.toString().toFloat(), alturaEDT.text.toString().toFloat())

            if (imc < 17.0)
                resultadoTXT.setText("Muito abaixo do peso!\nIMC: "+imc.toString()+"")
            else if (imc >= 17.0 && imc < 18.5 )
                resultadoTXT.setText("Abaixo do peso!\nIMC: "+imc.toString()+"")
            else if (imc >= 18.5 && imc < 25.0 )
                resultadoTXT.setText("Peso normal!\nIMC: "+imc.toString()+"")
            else if (imc >= 25.0 && imc < 30.0 )
                resultadoTXT.setText("Acima do peso!\nIMC: "+imc.toString()+"")
            else if (imc >= 30.0 && imc < 35.0 )
                resultadoTXT.setText("Obesidade grau I!\nIMC: "+imc.toString()+"")
            else if (imc >= 35.0 && imc <= 40.0 )
                resultadoTXT.setText("Obesidade grau II!\nIMC: "+imc.toString()+"")
            else if (imc > 40.0 )
                resultadoTXT.setText("Obesidade grau III!\nIMC: "+imc.toString()+"")
        }

    }
    //calcula o IMC
    private fun calculaIMC(peso: Float, altura: Float):Float     {
        return (peso / (altura * altura))
    }

}