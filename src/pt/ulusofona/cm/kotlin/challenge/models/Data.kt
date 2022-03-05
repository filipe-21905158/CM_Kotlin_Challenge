package pt.ulusofona.cm.kotlin.challenge.models

import java.time.LocalDate
import java.time.Period

class Data(val dia : Int, val mes : Int, val ano : Int) {

    fun diferencaParaAtualidade() : Int {
        val d1 : LocalDate = LocalDate.of(ano, mes, dia)
        val d2 : LocalDate = LocalDate.now()

        return Period.between(d1, d2).years
    }

    override fun toString(): String {
        return "%02d-%02d-%04d".format(dia, mes, ano)
    }
}