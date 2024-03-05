package com.example.lenden.data

import com.example.lenden.model.Person
import kotlinx.coroutines.flow.Flow

interface PersonRepository {
    fun getAllPersonsStream(): Flow<List<Person>>
    suspend fun insertPerson(person: Person)
    suspend fun deletePerson(person: Person)
    fun getPersonById(id: String): Flow<Person>
}