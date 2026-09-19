package br.com.locadora.locadora_web_barbara.model;
//Representa um filme cadastrado na locadora
public class Filme {
    private int codigo;
    private String nome;
    private String genero;
    private boolean alugado;

    //construtor vazio, padrão do filme quando cadastrado é estar disponível
    public Filme(){
        this.alugado =false;
    }

    //construtor com argumentos
    public Filme(String nome, int codigo, String genero) {
        this.nome = nome;
        this.codigo = codigo;
        this.genero = genero;
        this.alugado = false;
    }

    public int getCodigo(){
        return codigo;
    }
    //define o código automático no service
    public void setCodigo(int codigo){
        this.codigo=codigo;
    }

    //permite ler o nome
    public String getNome(){
        return nome;
    }

    //permite alterar nome
    public void setNome(String nome){
        this.nome=nome;
    }
    //permite ler o gênero
    public String getGenero(){
        return genero;
    }
    //permite alterar o gênero
    public void setGenero(String genero){
        this.genero=genero;
    }
    //
    public boolean isAlugado(){
        return alugado;
    }
    //altera o estado do filme, verificando se está alugado ou não
    public void alugar(){
        if(alugado){
            throw new IllegalAccessException("Filme está alugado");
        }
        alugado=true;
    }
    //devolução de filme
    public void devolver(){
        alugado=false;
    }
    //editar a saída que eu quero
    @Override
    public String toString(){  //toString pega um objeto e transforma em "texto"
        String status = alugado ? "Alugado":"Disponível";
        return "Código: " +codigo
                +"|Nome: " +nome
                +"|Gênero: "+genero
                +"|Status: "+status;
    }
}


