package br.ufc.quixada.npi;

import static org.assertj.core.api.Assertions.assertThat;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.ufc.quixada.npi.modelo.Contato;
import br.ufc.quixada.npi.repositorio.Contatos;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CrudContatosApplication.class)
@WebAppConfiguration
public class ControladorContatosTest extends FluentTest {
	
	private String urlPaginaContatos = "http://localhost:8080/contatos";
	String tituloPaginaContatos = "Contatos";
	String nome = "Bruno Barreto";
	String email = "bruno@bruno.com";
	String telefone = "123456";
	
	@Autowired
	private Contatos contatos;
	
	private WebDriver driver = new FirefoxDriver();
	
	@Override
	public WebDriver getDefaultDriver() {
		return driver;
	}
	
	@Test
	public void consegueAdicionarNovoContato(){
				
		goTo(urlPaginaContatos);
		
		find("#link-novo-contato").click();
		fill("input").with(nome, email, telefone);
		submit("form");
		
		assertThat(title()).contains(tituloPaginaContatos);
		assertThat(find(".linha").size() == 1);
	}
	@Test
	public void consegueAdicionarEDeletarOcontatoAdicionado() {
		consegueAdicionarNovoContato();
		
		Contato contato = contatos.findByNome(nome);
		
		find("#deletar"+contato.getId()).click();
		
		assertThat(find(".linha").size() == 0);
	}
	
	@Test
	public void consegueAdicionarEEditarOcontatoAdicionado() {
		consegueAdicionarNovoContato();
		String nome2 = "Bruno";
		
		Contato contato = contatos.findByNome(nome);
		
		find("#editar"+contato.getId()).click();
		fill("input").with(nome2, email, telefone);
		submit("form");
		
		assertThat(find(".linha").getText().contains(nome2));
	}
	
	@Test
	public void naoAceitaFormularioVazio() {
		goTo(urlPaginaContatos);
		find("#link-novo-contato").click();
		submit("form");
		assertThat(find(".help-block").size() == 3);
	}
	
	@Test
	public void naoAceitaFormularioComDadosInvalidos() {
		goTo(urlPaginaContatos);
		find("#link-novo-contato").click();
		submit("form");
		assertThat(find(".help-block").size() > 0);
	}
}
