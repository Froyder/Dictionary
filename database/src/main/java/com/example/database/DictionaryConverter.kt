package com.example.database

import androidx.room.TypeConverter
import com.example.model.Meanings
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class DictionaryConverter {

    @TypeConverter
    fun storedStringToMyObjects(data: String?): List<Meanings?>? {
        val gson = Gson()
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object : TypeToken<List<Meanings?>?>() {}.type
        return gson.fromJson<List<Meanings?>>(data, listType)
    }

    @TypeConverter
    fun myObjectsToStoredString(myObjects: List<Meanings?>?): String? {
        val gson = Gson()
        return gson.toJson(myObjects)
    }

}