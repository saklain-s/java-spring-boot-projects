package com.example.practice.controller;


import com.example.practice.dto.NoteCreateRequest;
import com.example.practice.dto.NoteResponse;
import com.example.practice.dto.NoteUpdateRequest;
import com.example.practice.model.Note;
import com.example.practice.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService service;

    public NoteController(NoteService service){
        this.service = service;
    }

    @GetMapping
    public List<Note> getNotes(){
        return service.getNotes();
    }

    @PostMapping
    public NoteResponse add(@RequestBody NoteCreateRequest request){
        return service.addNote(request);
    }

    @PutMapping("/{id}")
    public NoteResponse update(
            @PathVariable String id,
            @RequestBody NoteUpdateRequest request
    ) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        service.deleteNote(id);
    }
}

