package com.example.testtask.service;

import com.example.testtask.entity.NewsItem;
import com.example.testtask.entity.RulesItem;
import com.example.testtask.tools.RulesParserImpl;
import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParsingServiceImplTest {


    @Mock
    RulesParserImpl parser;
    @Mock
    ExecutorService executorService;
    @Autowired
    ParsingServiceImpl parsingService;

    @Test
    public void getFreshNews() throws Exception {
        String url = "https://www.e1.ru/news/";
        RulesItem item = new RulesItem(
                "html",
                "article",
                "e1-article e1-article_news",
                "href",
                "e1-article__link e1-article__link_inline",
                "src",
                "e1-article__img",
                "e1-article__date-text",
                "e1-article__tit"

        );
        assertNotNull(parsingService.getFreshNews(url,item));
    }

    @Test
    public void getParsingRulesByInputString() throws Exception {
        assertNotNull(parsingService.getParsingRulesByInputString("feedTag=article\n" +
                "feedClass=e1-article e1-article_news\n" +
                "linkAttr=href\n" +
                "linkClass=e1-article__link e1-article__link_inline\n" +
                "imgAttr=src\n" +
                "imgClass=e1-article__img\n" +
                "timeClass=e1-article__date-text\n" +
                "headerClass=e1-article__tit"));
    }


}