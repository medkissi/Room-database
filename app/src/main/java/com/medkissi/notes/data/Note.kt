package com.medkissi.notes.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    val title:String,
    val description : String,
    val dateAdded : Long,
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0
)
