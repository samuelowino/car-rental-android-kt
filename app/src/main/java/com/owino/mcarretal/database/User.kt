package com.owino.mcarretal.database;

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey @ColumnInfo(name = "id") val id: Long,
    val phoneNumber: String,
    val username: String
)
