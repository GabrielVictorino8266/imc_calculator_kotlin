package com.example.imc_atividade.util

object UtilImc {
    fun isPositiveNumber(value: Double):Boolean {
        return value != null && value > 0.0
    }
}