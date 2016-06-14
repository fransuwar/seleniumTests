package br.ufc.quixada.npi.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tarefas")
public class ControladorTarefas {

	@RequestMapping
	public String tarefas(){
		return "tarefas";
	}
}
