package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Period
import java.time.ZoneId
import java.time.temporal.ChronoUnit
import java.util.Date
import kotlin.reflect.typeOf

class Pessoa(
    val nome: String,
    val dataDeNascimento: Date
) : Movimentavel {

    var veiculos: List<Veiculo> = mutableListOf()
    var carta: Carta? = null
    val posicao: Posicao = Posicao(0,0)


    fun comprarVeiculo(veiculo: Veiculo) {
        try {
            pesquisarVeiculo(veiculo.identificador)
        } catch (e: VeiculoNaoEncontradoException){
            veiculos = veiculos + veiculo
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
    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        try {
            val veiculo = pesquisarVeiculo(identificador)

            if (veiculo.requerCarta() && !temCarta()) {
                throw PessoaSemCartaException("$nome não tem carta para conduzir o veículo indicado")
            }
            moverPara(x, y)
            veiculo.moverPara(x, y)

        } catch (_: VeiculoNaoEncontradoException) { }

    }

    fun temCarta(): Boolean {
        return carta != null
    }

    fun tirarCarta() {
        val dataNascimento = dataDeNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()

        if (ChronoUnit.YEARS.between(dataNascimento, LocalDate.now()).toInt() >= 18) {
            carta =  Carta()
            return
        }

        throw MenorDeIdadeException()
    }

    override fun moverPara(x: Int, y: Int) {
        if (x != posicao.x || y != posicao.y ) {
            posicao.alterarPosicaoPara(x, y)
        } else {
            throw AlterarPosicaoException()
        }
    }

    override fun toString(): String {
        return "Pessoa | $nome | ${SimpleDateFormat("dd-MM-yyyy").format(dataDeNascimento)} | $posicao"
    }

}