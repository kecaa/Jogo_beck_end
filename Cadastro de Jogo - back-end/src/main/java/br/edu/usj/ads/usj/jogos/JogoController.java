package br.edu.usj.ads.usj.jogos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@ResponseBody
@CrossOrigin
public class JogoController {

  @Autowired
  JogoRepository jogoRepository;

  @GetMapping(value = "/")
  public List<Jogo> getListarTodos() {
    List<Jogo> lista = jogoRepository.findAll();
    return lista;
  }

  @GetMapping(value = "/detalhes/{id}")
  public Jogo getDetalhes(@PathVariable Long id) {
    Jogo jogo = new Jogo();
    jogo = jogoRepository.findById(id).get();
    return jogo;
  }

  @PostMapping(value = "/adicionar")
  public Jogo postAdicionar(@RequestBody Jogo jogo) {
    Jogo jogoNovo = jogoRepository.save(jogo);
    return jogoNovo;
  }

  @GetMapping(value = "/deletar/{id}")
  public String getDeletar(@PathVariable Long id) {
    jogoRepository.deleteById(id);
    return "Cadastro excluído!";
  }
}
