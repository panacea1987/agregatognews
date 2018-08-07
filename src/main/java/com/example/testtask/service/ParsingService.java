package com.example.testtask.service;

import com.example.testtask.entity.NewsItem;
import com.example.testtask.entity.RulesItem;

import java.util.List;

public interface ParsingService {

    RulesItem getParsingRulesByInputString(String unparsedRules);

    List<NewsItem> getFreshNews(String url, RulesItem parsingRules);

}
