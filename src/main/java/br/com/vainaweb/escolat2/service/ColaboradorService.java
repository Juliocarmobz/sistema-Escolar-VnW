package br.com.vainaweb.escolat2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vainaweb.escolat2.dto.DadosColaborador;
import br.com.vainaweb.escolat2.model.ColaboradorModel;
import br.com.vainaweb.escolat2.repository.ColaboradorRepository;

@Service //Classe de servico gerenciada pelo Spring
public class ColaboradorService {
	
	@Autowired
	private ColaboradorRepository repository;

	public List<ColaboradorModel> encontrarTodosOsColaboradores() {
		// TODO Auto-generated method stub
		return repository.findAll(); //SELECT * FROM tb_colaboradores;
	}

	public void cadastrar(DadosColaborador dados) {
		var colaborador = new ColaboradorModel(dados.nome(), dados.cpf(), dados.email(), dados.cargo());
		repository.save(colaborador);
		
	}
	
	
	
}
