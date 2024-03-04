package com.example.lenden.data

import com.example.lenden.model.Person
import java.util.UUID

object DefaultDataSource {
    val personsList = listOf(
        Person(id = UUID.randomUUID().toString(), name = "Rambo", amount = 34.0),
        Person(id = UUID.randomUUID().toString(), name = "Rambo", amount = 34.0),
        Person(id = UUID.randomUUID().toString(), name = "Rambo", amount = 34.0),
        Person(id = UUID.randomUUID().toString(), name = "Rambo", amount = 34.0),
        Person(id = UUID.randomUUID().toString(), name = "Rambo", amount = 34.0),
        Person(id = UUID.randomUUID().toString(), name = "Rambo", amount = 34.0),
    )
}