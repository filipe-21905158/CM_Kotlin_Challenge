package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Motor(val cavalos: Int, val cilindrada: Int, var ligado: Boolean) : Ligavel {

    public constructor(cavalos: Int, cilindrada: Int) : this(cavalos, cilindrada, false)

    override fun ligar() {
        if(ligado == false) {
            ligado = true
        } else {
            throw VeiculoLigadoException()
        }
    }

    override fun desligar() {

        if (ligado == true) {
            ligado = false
        } else {
            throw VeiculoDesligadoException()
        }

    }

    override fun estaLigado(): Boolean {
        return ligado
    }

    override fun toString(): String {
        return "Motor | $cavalos | $cilindrada"
    }
}