package com.example.demo;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

interface Parser {
	void parse(String str);
}

class JsonParser implements Parser {
	@Override
	public void parse(String str) {
		System.out.println("JsonParser.parse :: " + str);
	}
}

class XMLParser implements Parser {
	@Override
	public void parse(String str) {
		System.out.println("XMLParser.parse :: " + str);
	}
}

enum ParserType {
	JSON("jsonParser"),
	XML("xmlParser");

	private final String value;

	ParserType(String input) {
		this.value = input;
	}

	public String getValue() {
		return this.value;
	}
}

@Component
interface ParserFactory {
	Parser getParser(ParserType parserType);
}

@Service
class ParserService {

	@Autowired
	private ParserFactory parserFactory;

	public void doParse(String parseString, ParserType parseType) {
		Parser parser = parserFactory.getParser(parseType);
		System.out.println("ParserService.doParse... " + parser);
		parser.parse(parseString);
	}
}

@Configuration
@ComponentScan(basePackages = {"com.example.demo"})
class AppConfig {
	@Bean
	public FactoryBean serviceLocatorFactoryBean() {
		ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
		factoryBean.setServiceLocatorInterface(ParserFactory.class);
		return factoryBean;
	}

	@Bean(name = "jsonParser")
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public JsonParser jsonParser() {
		return new JsonParser();
	}

	@Bean(name = "xmlParser")
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public XMLParser xmlParser() {
		return new XMLParser();
	}
}

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		ParserService parserService = new ParserService();
		parserService.doParse("json to be parsed", ParserType.JSON);
	}

}
