package com.example.dictionary.model.datasource.database

import androidx.room.*
import com.example.dictionary.model.data.DataModel

@Dao
interface DictionaryDao {

    @Query("SELECT * FROM words")
    fun getWordListFromDB(): List<DataModel>

    @Query("SELECT * FROM words WHERE isFavorite = 'true'")
    fun getFavoritesListFromDB(): List<DataModel>

    @Query("SELECT * FROM words WHERE text LIKE :text")
    fun getWordFromDB(text: String): DataModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateList(wordList: List<DataModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateWord (word: DataModel)

    @Query("UPDATE words SET isFavorite = :status WHERE text = :text")
    fun changeWordStatus (text: String, status: String)

}