package training.androidkotlin.noteapp.Database

import androidx.lifecycle.LiveData
import training.androidkotlin.noteapp.Models.Note

class NotesRepository(private val noteDao: NoteDao) {

    val allNotes:LiveData<List<Note>> = noteDao.getAllNotes()

    //elle permet d'implementer la fonction insert qui se trouve dans noteDao
    suspend fun insert(note:Note){
        noteDao.insert(note)
    }

    //elle permet d'implementer la fonction delete qui se trouve dans noteDao
    suspend fun delete(note:Note){
        noteDao.delete(note)
    }

    //elle permet d'implementer la fonction update qui se trouve dans noteDao
    suspend fun update(note:Note){
        noteDao.update(note.id,note.title,note.note)
    }
}