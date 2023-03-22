package pt.ulusofona.cm.kotlin.challenge.models
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel

abstract class Veiculo(
    val _identificador: String,
    var _posicao: Posicao,
    val dataDeAquisicao: Data
) : Movimentavel {

    public constructor(identificador: String) : this(identificador, Posicao(0,0), Data(1,1, 2023))

    val identificador get() = _identificador
    val posicao get() = _posicao

    abstract fun requerCarta(): Boolean

    override fun toString(): String {
        return "$identificador | $posicao | $dataDeAquisicao"
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicaoPara(x, y)
    }
}