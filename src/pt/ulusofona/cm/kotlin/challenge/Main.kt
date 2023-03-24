package pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.models.Carro
import pt.ulusofona.cm.kotlin.challenge.models.Carta
import pt.ulusofona.cm.kotlin.challenge.models.Motor
import pt.ulusofona.cm.kotlin.challenge.models.Pessoa
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period
import java.time.temporal.ChronoUnit
import java.util.Date


fun main() {
    // aqui escreves o código do programa

    /*var newCar = Carro("12345", Motor(230, 2000))
    println(newCar.motor.estaLigado())
    println(newCar.motor.ligar())
    println(newCar.motor.ligar())
    println(newCar.motor.estaLigado())*/

    val agora = LocalDate.now()

    val dataAtual =  LocalDate.of(agora.year, agora.month, agora.dayOfMonth, )
    //val dataNascimento = LocalDate.of(dataDeNascimento._ano, dataDeNascimento._mes, dataDeNascimento._dia)
    val dataNascimento = LocalDate.of(2003, 3, 23)
    //println(Period.between(dataNascimento, dataAtual).years)
    println(ChronoUnit.YEARS.between(dataNascimento, LocalDate.now()).toInt())
}

