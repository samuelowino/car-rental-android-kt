package com.owino.mcarretal.views.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.owino.mcarretal.database.CarRentalDatabase
import com.owino.mcarretal.database.User
import com.owino.mcarretal.database.dao.UsersDao
import com.owino.mcarretal.database.repository.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersViewModel(application: Application) : AndroidViewModel(application) {

    private val database: CarRentalDatabase =
        CarRentalDatabase.getDatabase(application, viewModelScope);
    private val repository: UsersRepository;
    private val dao: UsersDao;

    init {
        dao = database.usersDao();
        repository = UsersRepository(dao);
    }

    suspend fun insert(e: User) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(e);
    }

    fun getById(id: Long): LiveData<User> {
        return repository.findById(id);
    }

    fun getAll(): LiveData<List<User>> {
        return repository.findAll();
    }

    fun deleteById(id: Long) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteById(id);
    }

    fun deleteAll() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAll()
    }


}