package com.example.lenden.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lenden.model.Person

@Database(entities = [Person::class], version = 1, exportSchema = false)
abstract class PersonDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao

    companion object {
        private var Instance: PersonDatabase? = null
        fun getDatabase(context: Context): PersonDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    PersonDatabase::class.java,
                    "person_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
