package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.*

abstract class Veiculo(var identificador: String, var posicao: Posicao, var dataDeAquisicao: Date) : Movimentavel {

    constructor(identificador: String): this(identificador, Posicao(0,0), Date())

    abstract fun requerCarta(): Boolean
}
