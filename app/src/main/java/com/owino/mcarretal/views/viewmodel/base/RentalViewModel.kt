package com.owino.mcarretal.views.viewmodel.base

interface RentalViewModel<T,E> {

    suspend fun insert(e:E);

    fun getById(id:T) : E;

    fun getAll() : List<E>

    fun deleteById(id:T);

    fun deleteAll();
}