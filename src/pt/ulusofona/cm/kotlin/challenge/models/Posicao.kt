package pt.ulusofona.cm.kotlin.challenge.models

class Posicao(
    private var x: Int,
    private var y: Int
) {

    fun alterarPosicaoPara(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

    override fun toString(): String {
        return "Posicao | x:$x | y:$y"
    }
}