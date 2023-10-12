package com.korea.basic1;

import java.util.ArrayList;

public class ArticleView {


    public void printArticles(ArrayList<Article> articles) {
        for (Article article : articles) {
            System.out.printf("번호 : %d \n", article.getId());
            System.out.printf("제목 : %s \n", article.getTitle());
            System.out.printf("내용 : %s \n", article.getContent());
            System.out.printf("등록 날짜 : %s \n", article.getRegDate());
            System.out.printf("조회수 : %d\n",article.getHit());


        }


    }
    public void printArticle(Article article){
        System.out.printf("번호 : %d \n", article.getId());
        System.out.printf("제목 : %s \n", article.getTitle());
        System.out.printf("내용 : %s \n", article.getContent());
        System.out.printf("등록 날짜 : %s \n", article.getRegDate());
        System.out.printf("조회수 : %d\n",article.getHit());
    }
}
