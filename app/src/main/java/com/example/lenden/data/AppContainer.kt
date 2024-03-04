package com.example.lenden.data

import android.content.Context

interface AppContainer {
    val personRepository: PersonRepository
}

class AppDataContainer(private val context:Context): AppContainer {
    override val personRepository: PersonRepository by lazy {
        OfflinePersonRepository(PersonDatabase.getDatabase(context).personDao())
    }
}