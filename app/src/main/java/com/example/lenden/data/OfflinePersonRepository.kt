package com.example.lenden.data

import com.example.lenden.model.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class OfflinePersonRepository(private val personDao: PersonDao) : PersonRepository {
    override fun getAllPersonsStream(): Flow<List<Person>> = personDao.getAllPersons()

    override suspend fun insertPerson(person: Person) = personDao.insert(person)

    override suspend fun deletePerson(person: Person) = personDao.delete(person)

    override fun getPersonById(id: String): Flow<Person> = personDao.getPersonById(id)
}