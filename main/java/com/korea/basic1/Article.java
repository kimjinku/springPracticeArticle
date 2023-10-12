package com.korea.basic1;

public class Article {



    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private int id;
    private String title;
    private String content;

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    private int hit;

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    private String regDate;

    public String getRegDate() {
        return regDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Article(int id,String title,String content,String regDate){
        this.id=id;
        this.title=title;
        this.content=content;
        this.regDate=regDate;
    }
}
