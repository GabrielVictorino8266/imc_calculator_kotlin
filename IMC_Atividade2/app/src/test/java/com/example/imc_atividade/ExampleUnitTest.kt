package com.example.imc_atividade

import com.example.imc_atividade.domain.model.Pessoa
import com.example.imc_atividade.domain.usecase.calcularIMCUseCase
import junit.framework.TestCase.assertEquals
import org.junit.Test

class IMCUnitTest {
    private val useCase = calcularIMCUseCase()

    @Test
    fun `calcula IMC corretamente para peso normal`() {
        val pessoa = Pessoa(peso = 70.0, altura = 1.75)
        val resultado = useCase.execute(pessoa)

        assertEquals(22.86, resultado.imc, 0.01)
        assertEquals("Peso Normal", resultado.faixa)
    }

    @Test
    fun `calcula IMC corretamente para sobrepeso`() {
        val pessoa = Pessoa(peso = 85.0, altura = 1.70)
        val resultado = useCase.execute(pessoa)

        assertEquals(29.41, resultado.imc, 0.01)
        assertEquals("Sobrepeso", resultado.faixa)
    }
}