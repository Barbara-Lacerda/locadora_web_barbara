package br.com.locadora.locadora_web_barbara.controller;

import br.com.locadora.locadora_web_barbara.model.Filme;
import br.com.locadora.locadora_web_barbara.service.LocadoraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/filmes") //define "/filmes" como início de todas as rotas da classe
public class FilmeController {
    private final LocadoraService service;  //guarda a referência do service usado pelo controller

    public FilmeController(LocadoraService service){
        this.service = service; //guarda o objeto recebido no atributo
        }
    @GetMapping("/novo")
    public String abrirFormulario(Model model){ //objeto usado para enviar dados do java para o html
        model.addAttribute("filme", new Filme());  //envia um objeto vazio "filme" para o formulário
        return "filme/formulario";
    }
    @PostMapping("/salvar") //cria a rota post que recebe o nome do formulário (no caso "salvar")
    public String salvarFilmes(@ModelAttribute Filme filme, Model model){ //pede ao string p/ preencher um objeto Filme para os dados enviados
        try{ //inicia um bloco que pode gerar erro de regra
            service.cadastrarFilme(filme); //entrega o objeto ao service
            return "redirect:/filmes?sucesso=true"; // manda o navegador abrir a listagem dos filmes e acrescenta um parâmetro de sucesso
        }catch (IllegalArgumentException erro){//captura uma regra inválida lançada pelo service ou model
            model.addAttribute("mensagemErro",erro.getMessage()); //obter a mensagem de erro
            return "filme/formulario";
        }
    }
    @GetMapping
    public String listarFilmes(Model model){
        model.addAttribute("filmes",service.listarFilmes()); //envia a lista de filmes para página
        return "filmes/lista";
    }
}
