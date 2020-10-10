package com.owino.mcarretal.database.repository

import androidx.lifecycle.LiveData
import com.owino.mcarretal.database.Vehicle
import com.owino.mcarretal.database.dao.VehiclesDao
import com.owino.mcarretal.database.repository.base.CrudeRepository

class VehiclesRepository(private val dao: VehiclesDao) : CrudeRepository<Long, Vehicle> {

    override fun findById(id: Long): LiveData<Vehicle> {
        return dao.getVehicleById(id);
    }

    override fun findAll(): LiveData<List<Vehicle>> {
        return dao.getAllVehicles();
    }

    override suspend fun insert(e: Vehicle) {
        dao.insert(e);
    }

    override suspend fun update(e: Vehicle) {
        dao.updateVehicle(e);
    }

    override suspend fun deleteById(id: Long) {
        dao.deleteVehicle(id);
    }

    override suspend fun deleteAll() {
        dao.deleteAllVehicles();
    }

}