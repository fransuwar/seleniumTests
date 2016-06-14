package br.ufc.quixada.npi.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.ufc.quixada.npi.modelo.Contato;
import br.ufc.quixada.npi.servico.ServicoContato;

@Controller
@RequestMapping("/contatos")
public class ControladorContato {

	private static final String PAGINA_CADASTRO_CONTATOS = "cadastroContatos";
	
	@Autowired
	ServicoContato servicoContato;
	
	@RequestMapping
	public String contatos(Model model){
		model.addAttribute("contatos", servicoContato.buscarTodos());
		return "contatos";
	}
	
	@RequestMapping("/cadastro")
	public String cadastro(Model model){
		model.addAttribute("contato", new Contato());
		return PAGINA_CADASTRO_CONTATOS;
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(@Valid Contato contato, BindingResult result){
		if (result.hasErrors()) {
			return PAGINA_CADASTRO_CONTATOS;
		}
		servicoContato.salvar(contato);
		return "redirect:/contatos";
	}
	
	@RequestMapping(value = "/deletar{id}", method = RequestMethod.GET)
	public String deletar(@RequestParam(value = "id", required = true) Long id) {
		//TODO pagina de erro
		servicoContato.remover(id);
		return "redirect:/contatos";
	}
	
	@RequestMapping(value = "/editar{id}", method = RequestMethod.GET)
	public String editar(@RequestParam(value = "id", required = true) Long id, Model model) {
		Contato contato = servicoContato.buscarPorID(id);
		model.addAttribute("contato", contato);
		return "cadastroContatos";
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String badRequest(){
		return "401";
	}
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public String serverError(){
		return "500";
	}
}
