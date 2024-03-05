package com.example.lenden.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lenden.data.DefaultDataSource
import com.example.lenden.model.Person
import com.example.lenden.ui.components.PersonCard

@Composable
fun HomeScreen(
    goToDetails: (String) -> Unit,
    personsList: List<Person> = DefaultDataSource.personsList,
    deleteAccount: (Person) -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 4.dp)
    ) {
        items(personsList) { person ->
            PersonCard(
                person = person,
                goToDetails = goToDetails,
                modifier = Modifier.padding(vertical = 2.dp),
                deleteAccount = deleteAccount
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(goToDetails = { /*TODO*/ })
}