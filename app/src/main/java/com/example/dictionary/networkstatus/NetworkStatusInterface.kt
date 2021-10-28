package com.example.dictionary.networkstatus

import io.reactivex.Observable
import io.reactivex.Single

interface NetworkStatusInterface {
    fun isOnline(): Observable<Boolean>
    fun isOnlineSingle(): Single<Boolean>
}