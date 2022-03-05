package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.execptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.execptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.execptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel

class Pessoa(var nome: String, var veiculos: MutableList<Veiculo>, var dataDeNascimento: Data, var carta: Carta?, var posicao: Posicao) : Movimentavel {

    constructor(nome: String, dataDeNascimento: Data): this(nome, mutableListOf(), dataDeNascimento, null, Posicao(0,0) )

    fun comprarVeiculo(veiculo: Veiculo){
        veiculos.add(veiculo)
    }

    fun pesquisaVeiculo(identificador: String): Veiculo {
        for (veiculo in veiculos){
            if (veiculo.identificador == identificador){
                return veiculo
            }
        }
        throw VeiculoNaoEncontradoException("O veiculo com o identificador $identificador nao foi encontrado!")
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa){
        val veiculo = pesquisaVeiculo(identificador)
        comprador.comprarVeiculo(veiculo)
        veiculos.remove(veiculo)
    }

    fun moverVeiculoPara(identificador: String, x: Int, y:Int)  {
        val veiculo = pesquisaVeiculo(identificador)

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
        val idade = dataDeNascimento.diferencaParaAtualidade()

        if (idade > 18) {
            carta = Carta()
        }
        else {
            throw MenorDeIdadeException("Com a idade $idade ainda nao consegue tirar a carta, tera de ter um minimo de 18 anos.")
        }
    }

    override fun toString(): String {
        return "Pessoa | $nome | Posicao | $dataDeNascimento | x:${posicao.x} | y:${posicao.y}"
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicao(x, y)
    }
}