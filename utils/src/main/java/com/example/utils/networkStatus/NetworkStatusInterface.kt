package com.example.utils.networkStatus

import io.reactivex.Observable
import io.reactivex.Single

interface NetworkStatusInterface {
    fun isOnline(): Observable<Boolean>
    fun isOnlineSingle(): Single<Boolean>
}