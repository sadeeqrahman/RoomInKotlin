package com.encoders.roominkotlin

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val phobe: String

        )