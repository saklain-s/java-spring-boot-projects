package com.example.practice.model;

public class Note {

    private String id;
    private String title;
    private String content;
    private boolean archived;

    public Note(String id, String title, String content, boolean archived){
        this.id = id;
        this.title = title;
        this.content = content;
        this.archived = archived;
    }

    public  String getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setArchived(boolean archived){
        this.archived = archived;
    }
    public boolean getArchived(){
        return archived;
    }

    public void setTitle(String title){
        this.title = title;
    }
}
