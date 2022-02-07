package com.example.demo.parsers;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "xmlParser")
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class XMLParser implements IParser {
    @Override
    public void parse(String str) {
        System.out.println("Calling XMLParser.parse and str = " + str);
    }
}
