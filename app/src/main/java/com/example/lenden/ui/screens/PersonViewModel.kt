package com.example.lenden.ui.screens

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.lenden.LenDenApplication
import com.example.lenden.data.PersonRepository
import com.example.lenden.model.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class PersonViewModel(
    private val personRepository: PersonRepository
) : ViewModel() {
    private val _personsList = MutableStateFlow<List<Person>>(emptyList())
    val personsList = _personsList.asStateFlow()

    val addDialogName = mutableStateOf("")
    val addDialogAmount = mutableStateOf("")

    fun changeAddDialogName(name: String) {
        addDialogName.value = name
    }

    fun changeAddDialogAmount(amount: String) {
        addDialogAmount.value = amount
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as LenDenApplication)
                val personRepository = application.container.personRepository
                PersonViewModel(personRepository = personRepository)
            }
        }
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            personRepository.getAllPersonsStream().distinctUntilChanged().collect { listOfPersons ->
                if (listOfPersons.isEmpty()) {
                    Log.d("PERSONS_LIST", "Empty list")
                } else {
                    _personsList.value = listOfPersons
                }
            }
        }
    }

    fun insertPerson(person: Person) {
        viewModelScope.launch { personRepository.insertPerson(person) }
        addDialogName.value = ""
        addDialogAmount.value = ""
    }

    fun deletePerson(person: Person) =
        viewModelScope.launch { personRepository.deletePerson(person) }
}

