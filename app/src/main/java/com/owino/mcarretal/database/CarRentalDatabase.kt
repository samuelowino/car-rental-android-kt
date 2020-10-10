package com.owino.mcarretal.database;

import android.content.Context
import androidx.room.Database;
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.owino.mcarretal.R
import com.owino.mcarretal.database.dao.UsersDao
import com.owino.mcarretal.database.dao.VehiclesDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

import kotlin.jvm.Volatile;

@Database(entities = arrayOf(User::class, Vehicle::class), version = 1, exportSchema = false)
public abstract class CarRentalDatabase : RoomDatabase() {

    abstract fun usersDao(): UsersDao

    abstract fun vehicleDao(): VehiclesDao

    companion object {
        @Volatile
        private var INSTANCE: CarRentalDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): CarRentalDatabase {
            val carDatabaseInstance = INSTANCE
            if (carDatabaseInstance != null) {
                return carDatabaseInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CarRentalDatabase::class.java,
                    "car_rent_db"
                )
                    .addCallback(DatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class DatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.vehicleDao())
                }
            }
        }

        suspend fun populateDatabase(vehicleDao: VehiclesDao) {
            vehicleDao.deleteAllVehicles()

            val car1 = Vehicle(1, "Benze CLA", 2.0, "available", R.drawable.benze_b);
            val car2 = Vehicle(1, "Benze CM", 2.0, "available", R.drawable.benze_b);
            val car3 = Vehicle(1, "Jeep", 2.0, "available", R.drawable.benze_b);

            vehicleDao.insert(car1)
            vehicleDao.insert(car2)
            vehicleDao.insert(car3)
        }
    }

}


