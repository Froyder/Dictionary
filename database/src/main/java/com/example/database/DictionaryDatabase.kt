package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.model.DataModel

@Database(entities = [DataModel::class], version = 3, exportSchema = true)
@TypeConverters(DictionaryConverter::class)
abstract class DictionaryDatabase: RoomDatabase() {
    abstract fun dictionaryDao(): DictionaryDao
}