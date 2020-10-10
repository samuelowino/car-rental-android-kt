package com.owino.mcarretal.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.owino.mcarretal.database.User

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(user:User);

    @Query("SELECT * FROM users WHERE id = :id")
    fun getUserById(id:Long) : LiveData<User>

    @Query("SELECT * FROM users")
    fun getAllUsers() : LiveData<List<User>>

    @Update
    suspend fun update(user: User);

    @Query("DELETE FROM users WHERE id = :id")
    suspend fun deleteUser(id:Long)

    @Query("DELETE FROM users")
    suspend fun deleteAllUsers()
}