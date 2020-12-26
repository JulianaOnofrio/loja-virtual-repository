package br.com.alura.jdbc.modelo;

public class Produto {

    private Integer id;
    private String nome;
    private String descricacao;

    public Produto(String nome, String descricacao) {
        super();
        this.nome = nome;
        this.descricacao = descricacao;

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricacao() {
        return descricacao;


    }

    @Override
    public String toString() {
        return String.format("O produto criado foi: %d, %s, %s",
                this.id, this.nome, this.descricacao);
    }
}
