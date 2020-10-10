package com.owino.mcarretal.database;

import android.content.Context
import androidx.room.Database;
import androidx.room.Room
import androidx.room.RoomDatabase
import com.owino.mcarretal.database.dao.UsersDao

import kotlin.jvm.Volatile;

@Database(entities = arrayOf(User::class, Vehicle::class), version = 1, exportSchema = false)
public abstract class CarRentalDatabase : RoomDatabase() {

    abstract fun usersDao(): UsersDao

    companion object {
        @Volatile
        private var INSTANCE: CarRentalDatabase? = null

        fun getDatabase(context: Context): CarRentalDatabase {
            val carDatabaseInstance = INSTANCE
            if (carDatabaseInstance != null) {
                return carDatabaseInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CarRentalDatabase::class.java,
                    "car_rent_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
