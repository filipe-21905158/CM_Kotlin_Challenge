package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import java.time.LocalDate
import java.time.Period

class Pessoa(
    val nome: String,
    val dataDeNascimento: Data
) {

    var veiculos: List<Veiculo> = mutableListOf()
    var carta: Carta? = null
    val posicao: Posicao = Posicao(0,0)


    fun comprarVeiculo(veiculo: Veiculo) {
        try {
            pesquisarVeiculo(veiculo.identificador)
        } catch (e: VeiculoNaoEncontradoException){
            veiculos = veiculos + veiculo
            println("Veiculos actuais: $veiculos")
        }
    }

    fun pesquisarVeiculo(identificador: String): Veiculo {
        return veiculos.find { v -> v.identificador == identificador } ?: throw VeiculoNaoEncontradoException()
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {

        if (this == comprador) return

        try {
            val veiculo = pesquisarVeiculo(identificador)
            comprador.comprarVeiculo(veiculo)
            veiculos = veiculos - veiculo
        } catch (_: VeiculoNaoEncontradoException) {}
        println("Veiculos actuais: $veiculos")
    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        try {
            val veiculo = pesquisarVeiculo(identificador)
            veiculo.moverPara(x, y)
        } catch (_: VeiculoNaoEncontradoException) {}
    }

    fun temCarta(): Boolean {
        return carta != null
    }

    fun tirarCarta() {
//        val dataAtual =  LocalDate.now()
//        val dataNascimento = LocalDate.of(dataDeNascimento._ano, dataDeNascimento._mes, dataDeNascimento._dia)
//
//        try {
//            if (Period.between(dataNascimento, dataAtual).years >= 18) {
//                carta =  Carta()
//            }
//        }catch (e: MenorDeIdadeException) {
//            throw MenorDeIdadeException()
//        }


    }

    override fun toString(): String {
        return "Pessoa | $nome | $dataDeNascimento | $posicao"
    }

}