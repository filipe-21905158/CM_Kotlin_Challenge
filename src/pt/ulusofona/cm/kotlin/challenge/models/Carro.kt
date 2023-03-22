package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Carro(identificador: String, var motor: Motor) : Veiculo(identificador), Ligavel {
    override fun requerCarta(): Boolean {
        return true
    }

    override fun ligar() {
        motor.ligado = true
    }

    override fun desligar() {
        motor.ligado = false
    }

    override fun estaLigado(): Boolean {
        return motor.ligado
    }

    override fun moverPara(x: Int, y: Int) {
        if(estaLigado()){
            super.moverPara(x, y)
        }
    }


    override fun toString(): String {
        return "Carro | ${super.toString()}"
    }
}