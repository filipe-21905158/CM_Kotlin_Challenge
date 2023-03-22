package pt.ulusofona.cm.kotlin.challenge.models

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
        return "Carro | ${super.toString()}"
    }
}