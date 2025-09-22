package com.medkissi.notes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Upsert
    suspend fun  insertOrUpdate(note:Note)
    @Delete
    suspend fun  deleteNote(note:Note)
    @Query("SELECT * FROM notes ORDER BY dateAdded DESC")
    fun getNotesOrderByDateAdded():Flow<List<Note>>
    @Query("SELECT * FROM notes ORDER BY title ASC ")
    fun getNotesOrderedByTitle(): Flow<List<Note>>
}