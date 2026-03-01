package com.example.practice.repository;


import com.example.practice.model.Note;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NoteRepository {

    List<Note> notes = new ArrayList<>();

    public List<Note> findAll(){
        return notes;
    }

    public void saveNote(Note note){
        notes.add(note);
    }

    public void deleteNote(Note note){
        notes.remove(note);
    }

    public void updateNote(Note note){
        note.setArchived(true);
    }

    public Note findById(String id){
        for (Note note: notes){
            if (note.getId().equals(id)){
                return note;
            }
        }
        return null;
    }
}
