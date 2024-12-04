import java.util.Scanner;

class Jogador {
    private String nome;
    private int idade;
    private String nacionalidade;
    private String posicao;
    private String clubeAtual;
    private double valorDeMercado;

    public Jogador(String nome, int idade, String nacionalidade, String posicao, String clubeAtual, double valorDeMercado) {
        this.nome = nome;
        this.idade = idade;
        this.nacionalidade = nacionalidade;
        this.posicao = posicao;
        this.clubeAtual = clubeAtual;
        this.valorDeMercado = valorDeMercado;
    }

    public String getNome() {
        return nome;
    }

}

