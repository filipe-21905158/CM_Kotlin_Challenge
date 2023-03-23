package pt.ulusofona.cm.kotlin.challenge.models
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import java.text.SimpleDateFormat

class Carro(identificador: String, var motor: Motor) : Veiculo(identificador) {
    override fun requerCarta(): Boolean {
        return true
    }

    override fun moverPara(x: Int, y: Int) {
        if(motor.estaLigado()){
            super.moverPara(x, y)
        }
    }


    override fun toString(): String {
        return "Carro | $identificador | $${SimpleDateFormat("dd-MM-yyyy").format(dataDeAquisicao)} | Posicao | x:${posicao.x} | y:${posicao.y}"
    }
}