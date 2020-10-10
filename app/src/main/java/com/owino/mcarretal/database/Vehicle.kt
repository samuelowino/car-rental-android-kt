package com.owino.mcarretal.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehicles")
data class Vehicle(
    @PrimaryKey @ColumnInfo(name = "id") val id: Long,
    val name: String,
    val price: Double,
    val availability: String,
    val image: String
)
