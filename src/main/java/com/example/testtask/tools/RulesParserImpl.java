package com.example.testtask.tools;

import com.example.testtask.entity.RulesItem;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.regex.Pattern;

/*Так как условием работы нашего сервиса являются регламентированые правила, парсим строку отталкиваясь
* от обозначенного формата входной строки*/
@Component
public class RulesParserImpl implements RulesParser {
    public RulesItem generateRulesByInputString(String aWord) {
        HashMap<String, String> attributeMap = new HashMap<>();
        if (aWord != null) {
            String inputArray[] = aWord.split(Pattern.quote("\r\n"));
            for (String s : inputArray) {
                if (s.contains("=")) {
                    attributeMap.put(s.split(Pattern.quote("="))[0], s.split(Pattern.quote("="))[1]);
                }
            }

        }
        return new RulesItem(
                attributeMap.get("contentType"),
                attributeMap.get("feedTag"),
                attributeMap.get("feedClass"),
                attributeMap.get("linkAttr"),
                attributeMap.get("linkClass"),
                attributeMap.get("imgAttr"),
                attributeMap.get("imgClass"),
                attributeMap.get("timeClass"),
                attributeMap.get("headerClass")
        );

    }

}
