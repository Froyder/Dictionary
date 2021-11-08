package com.example.dictionary

import com.example.dictionary.model.data.Meanings

fun toStringConverter(meanings: List<Meanings>?): String {
    val translations = mutableListOf<String>()
    meanings?.forEach {
        it.translation?.translation?.let { it1 -> translations.add(it1) }
    }
    return translations.joinToString (", ")
}