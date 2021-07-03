package br.edu.usj.ads.usj.jogos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface JogoRepository extends CrudRepository <Jogo, Long>{
    List<Jogo> findAll();
}
