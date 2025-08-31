package com.example.imc_atividade.presentation.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imc_atividade.R
import com.example.imc_atividade.presentation.viewmodel.IMCViewModel
import com.example.imc_atividade.util.UtilImc


class MainActivity : AppCompatActivity() {
    private val viewModel : IMCViewModel by viewModels()
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val pesoInput = findViewById<EditText>(R.id.pesoInputDecimal)
        val alturaInput = findViewById<EditText>(R.id.alturaInputDecimal)
        val btnCalcular = findViewById<Button>(R.id.btnCalcularIMC)
        val labelResultado = findViewById<TextView>(R.id.txtResposta)
        val limparBtn = findViewById<Button>(R.id.limparBtn)
            limparBtn.visibility = View.INVISIBLE

        btnCalcular.setOnClickListener{
            val peso = pesoInput.text.toString().toDoubleOrNull() ?: 0.0
            val altura = alturaInput.text.toString().toDoubleOrNull() ?: 0.0

            viewModel.calcularIMC(peso, altura)
            limparBtn.visibility = View.VISIBLE
        }

        limparBtn.setOnClickListener{
            pesoInput.text.clear()
            alturaInput.text.clear()
            labelResultado.text = UtilImc.EMPTY_VALUE
            limparBtn.visibility = View.INVISIBLE
        }

        viewModel.resultadoIMC.observe(this) { resultado ->
            labelResultado.text = "IMC: %.2f\n Faixa %s".format(resultado.imc, resultado.faixa)
        }

        viewModel.erroIMC.observe(this) { mensagem ->
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
        }
    }
}