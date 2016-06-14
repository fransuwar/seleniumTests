package br.ufc.quixada.npi.servico;

import br.ufc.quixada.npi.modelo.Contato;

public interface ServicoContato {

	public abstract Iterable<Contato> buscarTodos();
	
	public abstract Contato buscarPorID(Long id);
	
	public abstract void salvar(Contato contato);
	
	public abstract void remover(Contato contato);
	
	public abstract void remover(Long id);
	
	public abstract void atualizar(Contato contato);
	
}
