package com.ciro.calculadora_imc_bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var resultadoTXT = findViewById<TextView>(R.id.resultadoTXT)
        val pesoEDT = findViewById<EditText>(R.id.pesoEDT)
        val alturaEDT = findViewById<EditText>(R.id.alturaEDT)
        val calculaBNT = findViewById<Button>(R.id.calcularBTN)

        //calcula o IMC quando clica no botão Calcular
        calculaBNT.setOnClickListener {
            calcula(pesoEDT, alturaEDT, resultadoTXT)
        }

        //Quando digita no pesoEDT
        pesoEDT.doAfterTextChanged {
            if(pesoEDT.text.isNotEmpty() && alturaEDT.text.isNotEmpty()) //Só calcula se ambos os campos estiverem preenchidos
                calcula(pesoEDT, alturaEDT, resultadoTXT)
        }

        //Quando digita no alturaEDT
        alturaEDT.doAfterTextChanged {
            if(pesoEDT.text.isNotEmpty() && alturaEDT.text.isNotEmpty()) //Só calcula se ambos os campos estiverem preenchidos
                calcula(pesoEDT, alturaEDT, resultadoTXT)
        }

    }

    //calcula o IMC e classifica de acordo com o valor obtido
    private fun calcula(pesoEDT: EditText, alturaEDT: EditText, resultadoTXT: TextView){
        var imc = calculaIMC(pesoEDT.text.toString().toFloat(), alturaEDT.text.toString().toFloat())

        if (imc < 17.0) {
            resultadoTXT.setTextColor(getResources().getColor(R.color.red))
            resultadoTXT.setText("Muito abaixo do peso!\nIMC: " + imc.toString() + "")
        }
        else if (imc >= 17.0 && imc < 18.5 ) {
            resultadoTXT.setTextColor(getResources().getColor(R.color.orange))
            resultadoTXT.setText("Abaixo do peso!\nIMC: " + imc.toString() + "")
        }
        else if (imc >= 18.5 && imc < 25.0 ) {
            resultadoTXT.setTextColor(getResources().getColor(R.color.green))
            resultadoTXT.setText("Peso normal!\nIMC: " + imc.toString() + "")
        }
        else if (imc >= 25.0 && imc < 30.0 ) {
            resultadoTXT.setTextColor(getResources().getColor(R.color.orange))
            resultadoTXT.setText("Acima do peso!\nIMC: " + imc.toString() + "")
        }
        else if (imc >= 30.0 && imc < 35.0 ) {
            resultadoTXT.setTextColor(getResources().getColor(R.color.orange))
            resultadoTXT.setText("Obesidade Grau 1!\nIMC: " + imc.toString() + "")
        }
        else if (imc >= 35.0 && imc <= 40.0 ) {
            resultadoTXT.setTextColor(getResources().getColor(R.color.red))
            resultadoTXT.setText("Obesidade Grau 2!\nIMC: " + imc.toString() + "")
        }
        else if (imc > 40.0 ) {
            resultadoTXT.setTextColor( getResources().getColor(R.color.red))
            resultadoTXT.setText("Obesidade Grau 3!\nIMC: " + imc.toString() + "")
        }
    }

    //calcula o IMC
    private fun calculaIMC(peso: Float, altura: Float):Float     {
        return (peso / (altura * altura))
    }

}