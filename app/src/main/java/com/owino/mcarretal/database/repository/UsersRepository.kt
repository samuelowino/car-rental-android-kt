package com.owino.mcarretal.database.repository

import androidx.lifecycle.LiveData
import com.owino.mcarretal.database.User
import com.owino.mcarretal.database.dao.UsersDao
import com.owino.mcarretal.database.repository.base.CrudeRepository

class UsersRepository(private val dao: UsersDao) : CrudeRepository<Long, User> {

    override fun findById(id: Long) : LiveData<User> {
        return dao.getUserById(id);
    }

    override fun findAll(): LiveData<List<User>> {
        return dao.getAllUsers();
    }

    override suspend fun insert(e: User) {
        dao.insert(e);
    }

    override suspend fun update(e: User) {
        dao.update(e);
    }

    override suspend fun deleteById(id: Long) {
        dao.deleteUser(id);
    }

    override suspend fun deleteAll() {
        dao.deleteAllUsers();
    }

}