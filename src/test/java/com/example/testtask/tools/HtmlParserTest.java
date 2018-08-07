package com.example.testtask.tools;

import com.example.testtask.entity.RulesItem;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HtmlParserTest {

    @Test
    public void call2() throws Exception {
        String url = "https://www.e1.ru/news/";
        RulesItem item1 = new RulesItem(
                "html",
                "",
                "e1-article e1-article_news",
                "href",
                "e1-article__link e1-article__link_inline",
                "src",
                "e1-article__img",
                "e1-article__date-text",
                "e1-article__tit"

        );
        HtmlParser parser1 = new HtmlParser(url, item1);
        assertEquals(parser1.call(), null);
        assertEquals(parser1.makeImgLink("/test"),"https:/test");
        assertEquals(parser1.makeImgLink("test"),"test");
    }

    @Test
    public void call1() throws Exception {
        String url = "https://www.e1.ru/news/";
        RulesItem item2 = new RulesItem(
                "html",
                "article",
                "",
                "href",
                "e1-article__link e1-article__link_inline",
                "src",
                "e1-article__img",
                "e1-article__date-text",
                "e1-article__tit"

        );
        HtmlParser parser2 = new HtmlParser(url, item2);
        assertEquals(parser2.call(), null);
        assertEquals(parser2.makeNewsLink("/test"),"https://www.vesti.ru/test");
        assertEquals(parser2.makeNewsLink("test"),"test");
    }

    @Test
    public void call() throws Exception {
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
        HtmlParser parser = new HtmlParser(url, item);
        assertNotNull(parser.call());

    }

}