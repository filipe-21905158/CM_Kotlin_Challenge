package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Motor(val cavalos: Int, val cilindrada: Int, var ligado: Boolean = false) : Ligavel {

    override fun ligar() {
        if(!estaLigado()) {
            ligado = true
            return
        }
        throw VeiculoLigadoException()
    }

    override fun desligar() {

        if (estaLigado()) {
            ligado = false
            return
        }
        throw VeiculoDesligadoException()

    }

    override fun estaLigado(): Boolean {
        return ligado
    }

    override fun toString(): String {
        return "Motor | $cavalos | $cilindrada"
    }
}