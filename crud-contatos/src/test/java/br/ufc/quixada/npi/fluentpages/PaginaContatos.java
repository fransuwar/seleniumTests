package br.ufc.quixada.npi.fluentpages;

import org.fluentlenium.core.FluentPage;
import static org.assertj.core.api.Assertions.*;

public class PaginaContatos extends FluentPage {

	private String titulo = "Contatos";
	@Override
	public String getUrl() {
		return "http://localhost:8080/contatos";
	}
	
	@Override
	public void isAt() {
		assertThat(title()).isEqualTo(titulo);
	}
	
	public void vaParaCadastroDeContatos(){
		find("#link-novo-contato").click();
	}
}
