package com.example.lenden.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lenden.model.Person

@Preview(showBackground = true)
@Composable
fun AddDialog(
    addDialogNameText: String = "",
    addDialogAmountText: String = "",
    onAddDialogNameChange: (String) -> Unit = {},
    onAddDialogAmountChange: (String) -> Unit = {},
    onAddButtonClick: (Person) -> Unit = {}
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .padding(16.dp)
    ) {
        Text(text = "Add New Person")
        Spacer(modifier = Modifier.size(16.dp))
        OutlinedTextField(
            value = addDialogNameText,
            onValueChange = { onAddDialogNameChange(it) },
            label = { Text(text = "Name") })
        Spacer(modifier = Modifier.size(8.dp))
        OutlinedTextField(
            value = addDialogAmountText,
            onValueChange = { onAddDialogAmountChange(it) },
            label = { Text(text = "Amount") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = {
            if (addDialogNameText.isNotEmpty() && addDialogAmountText.isNotEmpty()) {
                val amount = addDialogAmountText.toDoubleOrNull()
                if (amount != null) {
                    onAddButtonClick(Person(name = addDialogNameText, amount = amount))
                }
            }
        }) {
            Text(text = "Add")
        }
    }
}