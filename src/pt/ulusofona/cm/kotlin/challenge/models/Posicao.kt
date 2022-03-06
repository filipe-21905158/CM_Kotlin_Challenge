package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException

data class Posicao(var x: Int = 0, var y: Int = 0) {

    fun alterarPosicao(x: Int, y: Int) {
        if (this.x != x || this.y != y ){
            this.x = x
            this.y = y
        }
        else {
            throw AlterarPosicaoException("Já se encontra nesta posição")
        }
    }

    override fun toString(): String {
        return "Posicao | x:$x | y:$y"
    }
}
