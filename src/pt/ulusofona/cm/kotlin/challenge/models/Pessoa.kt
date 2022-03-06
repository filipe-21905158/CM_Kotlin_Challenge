package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.*

class Pessoa(var nome: String, var veiculos: MutableList<Veiculo>, var dataDeNascimento: Date, var carta: Carta?, var posicao: Posicao) : Movimentavel {

    constructor(nome: String, dataDeNascimento: Date): this(nome, mutableListOf(), dataDeNascimento, null, Posicao(0,0) )

    fun comprarVeiculo(veiculo: Veiculo){
        veiculos.add(veiculo)
    }

    fun pesquisarVeiculo(identificador: String): Veiculo {
        for (veiculo in veiculos){
            if (veiculo.identificador == identificador){
                return veiculo
            }
        }
        throw VeiculoNaoEncontradoException("O veiculo com o identificador $identificador nao foi encontrado!")
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa){
        val veiculo = pesquisarVeiculo(identificador)
        comprador.comprarVeiculo(veiculo)
        veiculos.remove(veiculo)
        veiculo.dataDeAquisicao = Date()
    }

    fun moverVeiculoPara(identificador: String, x: Int, y:Int)  {
        val veiculo = pesquisarVeiculo(identificador)

        if (veiculo.requerCarta() && !temCarta()) {
            throw PessoaSemCartaException("$nome não tem carta para conduzir o veículo indicado")
        }
        else {
            veiculo.moverPara(x, y)
        }
    }

    fun temCarta(): Boolean{
        return carta!=null
    }

    fun tirarCarta(){
        val idade = Data.diferencaParaAtualidade(dataDeNascimento)

        if (idade > 18) {
            carta = Carta()
        }
        else {
            throw MenorDeIdadeException("Com a idade $idade ainda nao consegue tirar a carta, tera de ter um minimo de 18 anos.")
        }
    }

    override fun toString(): String {
        return "Pessoa | $nome | ${Data.formatar(dataDeNascimento)} | $posicao"
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicao(x, y)
    }
}