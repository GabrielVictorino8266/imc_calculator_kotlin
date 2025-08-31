package com.example.imc_atividade.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imc_atividade.domain.model.Pessoa
import com.example.imc_atividade.domain.model.ResultadoIMC
import com.example.imc_atividade.domain.usecase.calcularIMCUseCase
import com.example.imc_atividade.util.UtilImc

class IMCViewModel() : ViewModel() {
    private val calcularIMCUseCase = calcularIMCUseCase()

    private val _resultadoIMC = MutableLiveData<ResultadoIMC>()
    val resultadoIMC: LiveData<ResultadoIMC> = _resultadoIMC

    private val _erroIMC = MutableLiveData<String>()
    val erroIMC: LiveData<String> = _erroIMC

    fun calcularIMC(peso: Double, altura: Double){
        if(!UtilImc.isPositiveNumber(peso)
            && !UtilImc.isPositiveNumber(altura)){
            _erroIMC.value = "Existem valores em branco ou zerados, preencha eles e continue."
            return
        }

        val pessoa =  Pessoa(peso, altura)
        val resultado = calcularIMCUseCase.execute(pessoa)
        _resultadoIMC.value = resultado
    }
}