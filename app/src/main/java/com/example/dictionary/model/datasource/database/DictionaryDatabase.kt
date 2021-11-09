package com.example.dictionary.model.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.dictionary.model.data.DataModel

@Database(entities = [DataModel::class], version = 2, exportSchema = true)
@TypeConverters(DictionaryConverter::class)
abstract class DictionaryDatabase: RoomDatabase() {
    abstract fun dictionaryDao(): DictionaryDao
}