package com.owino.mcarretal.database.repository.base

import androidx.lifecycle.LiveData

interface CrudeRepository<T,E> {

    fun findById(id:T) : LiveData<E>

    fun findAll() : LiveData<List<E>>

    suspend fun insert(e:E);

    suspend fun update(e:E);

    suspend fun deleteById(id:Long);

    suspend fun deleteAll();
}