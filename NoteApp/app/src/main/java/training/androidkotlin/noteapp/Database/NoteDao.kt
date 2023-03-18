package training.androidkotlin.noteapp.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import training.androidkotlin.noteapp.Models.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note:Note)

    //permet de selectionner tous les champs de la note par l'odre ascendant des id
    @Query("Select * from notes_table order by id ASC")
    fun getAllNotes():LiveData<List<Note>>

    //permet de faire une mise a jour des champs de la table note
    @Query("UPDATE notes_table Set title = :title, note = :note  WHERE id = :id")
    suspend fun update(id:Int?,title:String?,note:String?)
}