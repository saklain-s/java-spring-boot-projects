package com.example.practice.service;
import com.example.practice.model.Note;
import com.example.practice.repository.NoteRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository repository;

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public Note save(Note note) {
        return repository.save(note);
    }

    public List<Note> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}