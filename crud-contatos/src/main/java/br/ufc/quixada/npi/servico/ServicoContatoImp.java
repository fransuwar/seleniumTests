package br.ufc.quixada.npi.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.quixada.npi.modelo.Contato;
import br.ufc.quixada.npi.repositorio.Contatos;

@Service
public class ServicoContatoImp implements ServicoContato {

	@Autowired
	private Contatos contatos;
	
	@Override
	public Iterable<Contato> buscarTodos() {
		return contatos.findAll();
	}

	@Override
	public Contato buscarPorID(Long id) {
		return contatos.findOne(id);
	}

	@Override
	public void salvar(Contato contato) {
		contatos.save(contato);
	}

	@Override
	public void remover(Contato contato) {
		contatos.delete(contato);
	}
	
	@Override
	public void remover(Long id) {
		contatos.delete(id);
	}

	/**
	 * Para remoção de duvidas...
	 * 
	 * O método save de CrudRepository, salva um objeto caso ele não exista na base de dados.
	 * Caso o objeto exista, ele então chama o método merge do EntityManager e atualiza.
	 * 
	 * @param contato
	 * @return o contato atualizado caso ele exista, null caso contrário.
	 */
	@Override
	public void atualizar(Contato contato) {
		if (contatos.exists(contato.getId())) {
			contatos.save(contato);
		}
	}

}
