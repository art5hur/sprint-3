package com.github.art5hur.sprint_3.service;

import com.github.art5hur.sprint_3.model.Treinamento;
import com.github.art5hur.sprint_3.repository.TreinamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinamentoService {

    @Autowired
    private final TreinamentoRepository treinamentoRepository;

    public TreinamentoService(TreinamentoRepository treinamentoRepository) {
        this.treinamentoRepository = treinamentoRepository;
    }

    /**
     * Cadastra um novo treinamento no banco de dados.
     *
     * @param treinamento O objeto de treinamento a ser salvo.
     */
    public void cadastrar(Treinamento treinamento) {
        treinamentoRepository.save(treinamento);
    }

    /**
     * Retorna todos os treinamentos cadastrados no sistema.
     *
     * @return Lista de treinamentos.
     */
    public List<Treinamento> listarTodos() {
        return treinamentoRepository.findAll();
    }

    /**
     * Busca um treinamento por seu ID.
     *
     * @param id O ID do treinamento.
     * @return Um Optional contendo o treinamento, se encontrado.
     */
    public Optional<Treinamento> buscarPorId(Long id) {
        return treinamentoRepository.findById(id);
    }

    /**
     * Remove um treinamento por seu ID.
     *
     * @param id O ID do treinamento a ser removido.
     */
    public void remover(Long id) {
        treinamentoRepository.deleteById(id);
    }
}
