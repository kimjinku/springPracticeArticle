package com.korea.basic1;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Scanner;

@Controller
public class ArticleController {

    ArticleView articleView = new ArticleView();
    ArticleRepository articleRepository = new ArticleRepository();


    Scanner scan = new Scanner(System.in);


    public void exit() {
        System.out.print("명령어 : ");
        String command = scan.nextLine();
        if (command.equals("exit")) {
            System.out.println("프로그램을 종료합니다");

        }
    }

    @RequestMapping("add")
    @ResponseBody
    public String add(String title, String content) {

        articleRepository.insert(title, content);
        return "게시물이 등록되었습니다";


    }

    @RequestMapping("list")

    public String list(Model model) {
        ArrayList<Article> articles = articleRepository.findAllArticles();
        //템플릿 필요 --> 나 html에서 자바하고싶어요
        model.addAttribute("articleList",articles);
        return "article_list";

    }

    @RequestMapping("update")
    @ResponseBody
    public String update(int targetId, String newTitle, String newContent) {
        Article article = articleRepository.findById(targetId);
        if (article == null) {
            return "해당 게시물을 찾을 수 없습니다";
        } else {

            article.setTitle(newTitle);
            article.setContent(newContent);


            return "게시물 수정이 완료되었습니다";
        }
    }

    @RequestMapping("delete")
    @ResponseBody

    public String delete(int targetId) {
        System.out.print("삭제할 게시물의 번호를 입력하세요 : ");

        Article article = articleRepository.findById(targetId);
        if (article == null) {
            return "해당 게시물을 찾을 수 없습니다";
        } else {
            articleRepository.eliminate(article);
            return "게시물 삭제가 완료되었습니다";
        }
    }

    @RequestMapping("detail")
    @ResponseBody
    public String detail(int targetId) {


        Article article = articleRepository.findById(targetId);
        if (article == null) {
            return "해당 게시물을 찾을 수 없습니다";
        } else {
            article.setHit(article.getHit() + 1);

            ObjectMapper objectMapper = new ObjectMapper();

            String json = "";
            try {
                // Java 객체를 JSON 문자열로 변환
                json = objectMapper.writeValueAsString(article);
                return json;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return json;


        }

    }
    @RequestMapping("search")
    @ResponseBody
    public ArrayList<Article> search(@RequestParam (defaultValue = " ") String keyword) {

        ArrayList<Article> searchedArticles = articleRepository.findByTitle(keyword);
        return searchedArticles;
    }

    public int getParamInt(String input, int defaultVaule) {
        try {
            int num = Integer.parseInt(input);
            return num;
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요");
        }

        return defaultVaule - 1;
    }


}










