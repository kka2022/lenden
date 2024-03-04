package com.example.lenden.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "persons")
data class Person(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val amount: Double,
//    val history: List<String>,
)