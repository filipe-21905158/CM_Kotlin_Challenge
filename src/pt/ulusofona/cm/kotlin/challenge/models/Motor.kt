package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Motor(val cavalos: Int, val cilindrada: Int, var ligado: Boolean) : Ligavel {

    public constructor(cavalos: Int, cilindrada: Int) : this(cavalos, cilindrada, false)

    override fun ligar() {
        ligado = true
    }

    override fun desligar() {
        ligado = false
    }

    override fun estaLigado(): Boolean {
        return ligado
    }

    override fun toString(): String {
        return "Carro | $cavalos | $cilindrada | $ligado"
    }
}