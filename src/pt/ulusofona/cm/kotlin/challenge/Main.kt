package pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.models.Carro
import pt.ulusofona.cm.kotlin.challenge.models.Carta
import pt.ulusofona.cm.kotlin.challenge.models.Motor
import pt.ulusofona.cm.kotlin.challenge.models.Pessoa
import java.time.Instant
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalAccessor
import java.util.*


fun main() {
    // aqui escreves o código do programa

    var newCar1 = Carro("12345", Motor(230, 2000))
    var newCar2 = Carro("56789", Motor(230, 2000))
    var newCar3 = Carro("asdfg", Motor(230, 2000))
    var newCar4 = Carro("zxcvb", Motor(230, 2000))
    var pessoa1 = Pessoa("Pessoa #1", Date.from(Instant.parse("2000-02-15T00:00:00Z")))
    var pessoa2 = Pessoa("Pessoa #2", Date.from(Instant.parse("2000-02-15T00:00:00Z")))

    pessoa1.comprarVeiculo(newCar1)
    pessoa1.comprarVeiculo(newCar2)
    pessoa2.comprarVeiculo(newCar3)
    pessoa2.comprarVeiculo(newCar4)

    pessoa1.tirarCarta()
    pessoa1.venderVeiculo("12345", pessoa2)

    println(pessoa1.veiculos)
    println(pessoa2.veiculos)

    for (v in pessoa1.veiculos) {
        pessoa1.moverVeiculoPara(v.identificador, 3, 3)
    }

    println(pessoa1.veiculos)

    val agora = LocalDate.now()
    val dataAtual =  LocalDate.of(agora.year, agora.month, agora.dayOfMonth, )
}

