package com.example.dictionary.model.datasource.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dictionary.model.data.DataModel

@Dao
interface DictionaryDao {

    @Query("SELECT * FROM words")
    fun getWordListFromDB(): List<DataModel>

    @Query("SELECT * FROM words WHERE text LIKE :text")
    fun getWordFromDB(text: String): DataModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateList(wordList: List<DataModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateWord (word: DataModel)

}