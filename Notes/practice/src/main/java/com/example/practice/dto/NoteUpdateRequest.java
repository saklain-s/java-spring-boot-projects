package com.example.practice.dto;

public class NoteUpdateRequest {

    public String title;
    public String content;
    public Boolean archived;

    public String getContent(){return content;}
    public String getTitle(){return title;}
    public Boolean getArchived(){return archived;}
}
