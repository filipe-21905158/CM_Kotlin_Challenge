package pt.ulusofona.cm.kotlin.challenge.models

class Data(var _dia: Int, var _mes: Int, var _ano: Int) {

    private val dia get() = _dia
    private val mes get() = _mes
    private val ano get() = _ano

    override fun toString(): String {
        return "$dia-$mes-$ano"
    }
}