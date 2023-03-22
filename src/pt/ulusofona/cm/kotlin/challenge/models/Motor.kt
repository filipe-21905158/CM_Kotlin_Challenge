package pt.ulusofona.cm.kotlin.challenge.models

class Motor(val cavalos: Int, val cilindrada: Int, var ligado: Boolean) {

    public constructor(cavalos: Int, cilindrada: Int) : this(cavalos, cilindrada, false)

    override fun toString(): String {
        return "Carro | $cavalos | $cilindrada | $ligado"
    }
}