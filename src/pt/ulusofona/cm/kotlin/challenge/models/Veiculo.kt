package models
import interfaces.Ligavel
import interfaces.Movimentavel
import java.util.Date

abstract class Veiculo(
    private val _identificador: String,
    private var _posicao: Posicao,
    private val dataDeAquisicao: Data
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