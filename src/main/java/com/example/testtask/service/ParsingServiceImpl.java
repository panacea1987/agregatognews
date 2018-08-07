package com.example.testtask.service;

import com.example.testtask.entity.NewsItem;
import com.example.testtask.entity.RulesItem;
import com.example.testtask.tools.HtmlParser;
import com.example.testtask.tools.RulesParserImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Service
public class ParsingServiceImpl implements ParsingService {

    private RulesParserImpl generator;
    private ExecutorService executorService;
    private Logger logger = LoggerFactory.getLogger(ParsingService.class);

    @Autowired
    public ParsingServiceImpl(@Value("${threadCount}") int threadCount, RulesParserImpl generator) {
        this.generator = generator;
        this.executorService = Executors.newFixedThreadPool(threadCount);
    }

    @Override
    public RulesItem getParsingRulesByInputString(String unparsedRules) {
        return generator.generateRulesByInputString(unparsedRules);
    }

    /*Парсинг страницы может занимать продолжительное время, предполагая что
    * в какой то момент ожидания может произойти другой запрос делаем
    * процедуру парсинга HTML многопоточной, количество потоков в пуле задается
    * в файле property*/

    @Override
    public List<NewsItem> getFreshNews(String url, RulesItem parsingRules) {
        if (parsingRules.getContentType().equals("html")) {
            try {
                return executorService.submit(new HtmlParser(url, parsingRules)).get();
            } catch (Exception e) {
                logger.error("Error call new thread");
                e.printStackTrace();
            }

        }/*else какой то другой тип входных данных, например RSS отадим другой имплементации парсера*/
        return null;
    }
}
