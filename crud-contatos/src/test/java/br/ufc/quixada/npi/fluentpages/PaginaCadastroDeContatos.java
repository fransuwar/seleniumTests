package br.ufc.quixada.npi.fluentpages;

import org.fluentlenium.core.FluentPage;
import static org.assertj.core.api.Assertions.*;

public class PaginaCadastroDeContatos extends FluentPage {

	private String titulo = "Cadastro de Contatos";
	@Override
	public String getUrl() {
		return "http://localhost:8080/contatos/cadastro";
	}
	
	@Override
	public void isAt() {
		assertThat(title()).isEqualTo(titulo);
	}
	
	public void preencherFormulario(String... campos){
		fill("input").with(campos);
	}
	
	public void submeterFormulario() {
		submit("form");
	}
	public void preencherESubmeterFormulario(String... campos) {
		preencherFormulario(campos);
		submeterFormulario();
	}
}
