package com.example.practice.service;

import com.example.practice.dto.NoteCreateRequest;
import com.example.practice.dto.NoteResponse;
import com.example.practice.dto.NoteUpdateRequest;
import com.example.practice.model.Note;
import com.example.practice.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class NoteService {

    private final NoteRepository repo;
    private final Supplier<String> idGenerator;

    public NoteService(NoteRepository repo, Supplier<String> idGenerator){
        this.idGenerator=idGenerator;
        this.repo=repo;
    }
    public NoteResponse addNote(NoteCreateRequest request) {
        String id = idGenerator.get();
        Note note = new Note(id, request.getTitle(), request.getContent(), false);
        repo.saveNote(note);
        return toResponse(note);
    }

    private NoteResponse toResponse(Note note) {
        return new NoteResponse(
                note.getId(),
                note.getTitle(),
                note.getContent(),
                note.getArchived()
        );
    }

    public List<Note> getNotes(){
        return repo.findAll();
    }



    public NoteResponse update(String id, NoteUpdateRequest request) {
        Note note = repo.findById(id);
        if (note == null) {
            throw new RuntimeException("Not Found");
        }

        // PUT = full replacement
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note.setArchived(request.getArchived());

        return toResponse(note);
    }



    public void deleteNote(String id){
        Note note = repo.findById(id);
        if (note == null){
            throw new RuntimeException("Not Fond!");
        }
        repo.deleteNote(note);
    }

    public NoteResponse patch(String id, NoteUpdateRequest request) {
        Note note = repo.findById(id);
        if (note == null) {
            throw new RuntimeException("Not Found");
        }

        if (request.getTitle() != null) {
            note.setTitle(request.getTitle());
        }
        if (request.getContent() != null) {
            note.setContent(request.getContent());
        }
        if (request.getArchived() != null) {
            note.setArchived(request.getArchived());
        }

        return toResponse(note);
    }


}
