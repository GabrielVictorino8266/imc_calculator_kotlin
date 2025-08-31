package com.example.imc_atividade.domain.usecase

import com.example.imc_atividade.domain.model.Pessoa
import com.example.imc_atividade.domain.model.ResultadoIMC
/**
 *  Classe Use Case para calcular o IMC de uma pessoa.
 *
*/
class calcularIMCUseCase {
/*TODO
create function - ok
create variables imc and faixa - ok
define which fixa uses, but try to optimize later. - review
return an data class ResultadoIMC - ok
*/
    /**
     * Calcula o IMC de uma pessoa.
     * @param pessoa [Pessoa] com peso e altura
     * @return [ResultadoIMC] com imc e faixa
     */
    fun execute(pessoa : Pessoa) : ResultadoIMC{
        val imc = pessoa.peso / (pessoa.altura * pessoa.altura)
        val faixa = when {
            imc < 18.5 -> "Abaixo do Peso"
            imc <= 24.9 -> "Peso Normal"
            imc <= 29.9 -> "Sobrepeso"
            imc <= 34.9 -> "Obsedidade Grau I"
            imc <= 39.9 -> "Obesidade Grau II"
            else -> "Obsesidade Grau III"
        }
        return ResultadoIMC(imc, faixa)
    }
}