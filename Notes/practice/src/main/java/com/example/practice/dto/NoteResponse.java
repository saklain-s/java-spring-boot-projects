package com.example.practice.dto;

public class NoteResponse {

    private String id;
    private String title;
    private String content;
    private boolean archived;

    public NoteResponse(String id, String title, String content, boolean archived){
        this.archived=archived;
        this.id=id;
        this.content=content;
        this.title=title;
    }
    public String getTitle(){return title;}
    public String getId(){return id;}
    private String getContent(){return content;}
    private boolean isArchived(){return archived;}
}
