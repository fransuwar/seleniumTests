package br.ufc.quixada.npi.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.ufc.quixada.npi.modelo.Contato;

@Repository
public interface Contatos extends CrudRepository<Contato, Long>{

	public Contato findByNome(String nome);
}
