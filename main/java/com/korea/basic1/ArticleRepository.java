package com.korea.basic1;




import java.util.ArrayList;

public class ArticleRepository {
    ArrayList<Article> articles = new ArrayList<>();
    int lastid = 4;

    public ArticleRepository() {
        Article a1 = new Article(1, "안녕하세요, 반갑습니다. 자바공부중이에요", "", Util.getCurrent());
        Article a2 = new Article(2, "자바 질문 좀 할게요 ~", "", Util.getCurrent());
        Article a3 = new Article(3, "정처기 꼭 따야하나요?", "", Util.getCurrent());
        articles.add(a1);
        articles.add(a2);
        articles.add(a3);

    }

    public void insert(String title,String content) {
        Article article = new Article(lastid, title, content, Util.getCurrent());
        articles.add(article);
        lastid++;

    }

    public void eliminate(Article article) {
        articles.remove(article);


    }

    public Article findById(int id) {
        Article target = null;
        for (Article article : articles) {
            if (id == article.getId()) {
                target = article;
            }
        }
        return target;
    }

    public ArrayList<Article> findAllArticles() {
        return articles;
    }

    public ArrayList<Article> findByTitle(String keyword) {
        ArrayList<Article> searchedArticles = new ArrayList<>();
        for (Article article : articles) {
            if (article.getTitle().contains(keyword)) {
                searchedArticles.add(article);
            }

        }return searchedArticles;
    }
}
