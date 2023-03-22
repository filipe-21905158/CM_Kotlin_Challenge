package pt.ulusofona.cm.kotlin.challenge.models
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.Date

abstract class Veiculo(
    val _identificador: String,

) : Movimentavel {

    var _posicao: Posicao = Posicao(0,0)
    val dataDeAquisicao: Date = Date()

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