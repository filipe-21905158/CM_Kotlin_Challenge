package pt.ulusofona.cm.kotlin.challenge.models
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.SimpleDateFormat
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
        return "$identificador | ${SimpleDateFormat("dd-MM-yyyy").format(dataDeAquisicao)} | $posicao"
    }

    override fun moverPara(newX: Int, newY: Int) {
        if (newX != posicao.x || newY != posicao.y ){
            posicao.alterarPosicaoPara(newX, newX)
        }

    }
}