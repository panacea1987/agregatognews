package com.example.testtask.tools;

import com.example.testtask.entity.RulesItem;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RulesParserImplTest {
    @Test
    public void generateRulesByInputString1() throws Exception {
        RulesParserImpl rulesParser = new RulesParserImpl();
        assertEquals(rulesParser.generateRulesByInputString(
                "contentType=b\r\n" +
                        "feedTag=d\r\n" +
                        "feedClass=f\r\n" +
                        "linkAttr=h\r\n" +
                        "linkClass=j\r\n" +
                        "imgAttr=l\r\n" +
                        "imgClass=n\r\n" +
                        "timeClass=p\r\n" +
                        "headerClass=r\r"
        ), new RulesItem(
                "b",
                "d",
                "f",
                "h",
                "j",
                "l",
                "n",
                "p",
                "r\r"

        ));
    }

    @Test
    public void generateRulesByInputString() throws Exception {
        RulesParserImpl rulesParser = new RulesParserImpl();
        assertNotNull(rulesParser.generateRulesByInputString(
                "contentType=b\r\n" +
                        "feedTag=d\r\n" +
                        "feedClass=f\r\n" +
                        "linkAttr=h\r\n" +
                        "linkClass=j\r\n" +
                        "imgAttr=l\r\n" +
                        "imgClass=n\r\n" +
                        "timeClass=p\r\n" +
                        "headerClass=r\r"
        ));

    }

}