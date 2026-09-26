package br.com.locadora.locadora_web_barbara.service;

import br.com.locadora.locadora_web_barbara.model.Filme;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Contém as regras de negócio da Locadora
@Service  //indica que a classe é um serviço do Spring (que passa a gerenciar a mesma)
public class LocadoraService{
    private final List<Filme>filmes; //declara a lista de filmes
    private int proximoCodigoFilme; //guarda o próximo código auto.

    public LocadoraService(){
        filmes = new ArrayList<>(); //cria lista vazia,
        proximoCodigoFilme = 1;
    }
    public  void cadastrarFilme(Filme filme){
        filme.setCodigo(proximoCodigoFilme);
        proximoCodigoFilme++;
        filmes.add(filme);
    }
    public List<Filme>listarFilmes(){
        //cria uma cópia da lista para proteger a lista interna
        return  new ArrayList<>(filmes);
    }
    public Filme buscarFilmePorCodigo(int codigo){
        for (Filme filme: filmes){
            if (filme.getCodigo()==codigo){
                return filme;
            }
        }
        return null;
    }

}
