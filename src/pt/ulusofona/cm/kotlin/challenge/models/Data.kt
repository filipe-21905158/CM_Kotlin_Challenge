package pt.ulusofona.cm.kotlin.challenge.models

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.*

class Data {
    companion object {
        private fun converterLocalDate(data : Date) : LocalDate {
            val c1 = Calendar.getInstance()
            c1.time = data

            return LocalDate.of(c1.get(Calendar.YEAR), c1.get(Calendar.MONTH)+1, c1.get(Calendar.DAY_OF_MONTH))
        }

        fun diferencaParaAtualidade(data : Date) : Int {
            val d1 = converterLocalDate(data)
            val d2 = LocalDate.now()

            return Period.between(d1, d2).years
        }

        fun formatar(data : Date): String {
            val d1 = converterLocalDate(data)

            return d1.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        }
    }
}