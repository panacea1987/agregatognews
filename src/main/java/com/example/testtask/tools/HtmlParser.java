package com.example.testtask.tools;

import com.example.testtask.entity.NewsItem;
import com.example.testtask.entity.RulesItem;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class HtmlParser implements Callable<List<NewsItem>> {
    private String url;
    private RulesItem rulesItem;

    public HtmlParser(String url, RulesItem rulesItem) {
        this.url = url;
        this.rulesItem = rulesItem;
    }

    /*Распознавание нужного блока с новостями, для фигурирующих в проекте сайтов новостей,
     * можно произвести по двум параметрам, проверяем что этим параметам присвоилось значение,
     *оличное от дефолтного получаем нужные нам атрибюты, формируя лист с объектами типа Новость*/
    @Override
    public List<NewsItem> call() throws Exception {
        Document doc = null;
        if (!rulesItem.getFeedClass().isEmpty() && !rulesItem.getFeedTag().isEmpty()) {
            doc = Jsoup.connect(url).get();
            return doc.getAllElements().stream()
                    .filter(s -> s.className().equals(rulesItem.getFeedClass()))
                    .filter(s -> s.tag().toString().equals(rulesItem.getFeedTag()))
                    .map(s ->
                            new NewsItem(
                                    url,
                                    s.getElementsByClass(rulesItem.getHeaderClass()).text(),
                                    makeNewsLink(s.getElementsByClass(rulesItem.getLinkClass()).attr(rulesItem.getLinkAttr())),
                                    makeImgLink(s.getElementsByClass(rulesItem.getImgClass()).attr(rulesItem.getImgAttr())),
                                    s.getElementsByClass(rulesItem.getTimeClass()).text()
                            )
                    )
                    .collect(Collectors.toList());
        }
        return null;
    }

    /*На рассматриваемых в программе сайтах переиодически встречаются "обрезанные ссылки" ссылки,
    приходится использовать некие шаблоны*/
    String makeNewsLink(String inputNewsLink) {
        if (inputNewsLink.startsWith("/")) {
            return "https://www.vesti.ru" + inputNewsLink;
        }
        return inputNewsLink;
    }

    String makeImgLink(String inputImgLink) {
        if (inputImgLink.startsWith("/")) {
            return "https:" + inputImgLink;
        }
        return inputImgLink;
    }
}
