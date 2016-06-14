package br.ufc.quixada.npi;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CrudContatosApplication.class)
@WebAppConfiguration
public class HelloWorldTest extends FluentTest{

	private String urlContatos = "http://localhost:8080/contatos";
	
	private WebDriver webDriver = new FirefoxDriver();
	
	@Override
	public WebDriver getDefaultDriver() {
		return webDriver;
	}
	
	
	@Test
	public void contextLoads() {
		webDriver.get(urlContatos);
	}

}
