package pt.ulusofona.cm.kotlin.challenge.models

class Bicicleta(identificador: String): Veiculo(identificador){
    override fun requerCarta(): Boolean {
        return false
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicao(x, y)
    }

    override fun toString(): String {
        return "Bicicleta | $identificador | ${Data.formatar(dataDeAquisicao)} | $posicao"
    }

}
