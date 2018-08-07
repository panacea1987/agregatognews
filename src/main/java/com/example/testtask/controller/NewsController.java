package com.example.testtask.controller;

import com.example.testtask.entity.RulesItem;
import com.example.testtask.repository.NewsRepository;
import com.example.testtask.service.ParsingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Controller
public class NewsController {
    private ParsingService parsingService;
    private NewsRepository newsRepository;

    public NewsController(ParsingService parsingService, NewsRepository newsRepository) {
        this.parsingService = parsingService;
        this.newsRepository = newsRepository;
    }

    /*стартовая страница*/
    @RequestMapping(value = "/")
    public String Home() {
        return "index";
    }

    /*Обрабатываем запрос, формируем правила парсинга из строки, перед вставкой
    * каждой новости в базу происходит select по ссылке, дабы удостовериться
    * что новости там нет, исключаем дубли и трибли*/
    @RequestMapping("newslink")
    String findAllNewsByInputLink(@RequestParam("url") String url, @RequestParam("rules") String unparsedRules, Model model) {
        RulesItem parsedRules = parsingService.getParsingRulesByInputString(unparsedRules);
        parsingService.getFreshNews(url, parsedRules)
                .stream()
                .filter(s -> newsRepository.findByLinkNews(s.getLinkNews()) == null)
                .forEach(s -> newsRepository.save(s));
        model.addAttribute("newslist", newsRepository.findAllByOrderByIdAsc());
        return "allnews";
    }

    /*Поиск новости по like ключевое слово в заголовке новости в базе*/
    @RequestMapping("singlenews")
    String findSingleNewsByKeyWord(@RequestParam("keyword") String keyWord, Model model, HttpServletResponse response) {
        model.addAttribute("singlenews", newsRepository.findByHeaderNewsContaining(keyWord));
        return "singlenews";
    }
}
