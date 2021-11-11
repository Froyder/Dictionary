package com.example.dictionary

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.dictionary.model.data.Meanings

fun toStringConverter(meanings: List<Meanings>?): String {
    val translations = mutableListOf<String>()
    meanings?.forEach {
        it.translation?.translation?.let { it1 -> translations.add(it1) }
    }
    return translations.joinToString (", ")
}

val MIGRATION_2_3 = object : Migration(2, 3){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE words ADD COLUMN isFavorite text")
    }

}