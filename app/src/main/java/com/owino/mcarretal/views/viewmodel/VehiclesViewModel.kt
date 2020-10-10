package com.owino.mcarretal.views.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.owino.mcarretal.database.CarRentalDatabase
import com.owino.mcarretal.database.Vehicle
import com.owino.mcarretal.database.dao.VehiclesDao
import com.owino.mcarretal.database.repository.VehiclesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VehiclesViewModel(application: Application) : AndroidViewModel(application) {

    private val database: CarRentalDatabase =
        CarRentalDatabase.getDatabase(application, viewModelScope)
    private val repository: VehiclesRepository;
    private val dao: VehiclesDao;

    init {
        dao = database.vehicleDao()
        repository = VehiclesRepository(dao);
    }

    suspend fun insert(e: Vehicle) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(e);
    }

    fun getById(id: Long): LiveData<Vehicle> {
        return repository.findById(id);
    }

    fun getAll(): LiveData<List<Vehicle>> {
        return repository.findAll();
    }

    fun deleteById(id: Long) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteById(id);
    }

    fun deleteAll() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAll()
    }
}