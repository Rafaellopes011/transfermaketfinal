import java.util.Scanner;

class Jogador extends Pessoa implements Transacionavel {
    private String posicao;
    private String clubeAtual;
    private double valorDeMercado;

    public Jogador(String nome, int idade, String nacionalidade, String posicao, String clubeAtual, double valorDeMercado) {
        super(nome, idade, nacionalidade);
        this.posicao = posicao;
        this.clubeAtual = clubeAtual;
        this.valorDeMercado = valorDeMercado;

    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getClubeAtual() {
        return clubeAtual;
    }

    public void setClubeAtual(String clubeAtual) {
        this.clubeAtual = clubeAtual;
    }

    public double getValorDeMercado() {
        return valorDeMercado;
    }

    public void setValorDeMercado(double valorDeMercado) {
        this.valorDeMercado = valorDeMercado;
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Transferência realizada para o jogador " + getNome());
    }

    @Override
    public void cancelarTransferencia() {
        System.out.println("Transferência cancelada para o jogador " + getNome());
    }

    // Novo método para permitir edição de informações do jogador
    public void editarInformacoes() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Alterando informações do jogador: " + getNome());

        System.out.print("Nova idade: ");
        try {
            this.setIdade(Integer.parseInt(scanner.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("Idade inválida! Mantendo a idade antiga.");
        }

        System.out.print("Nova posição: ");
        this.posicao = scanner.nextLine();

        System.out.print("Novo clube atual: ");
        this.clubeAtual = scanner.nextLine();

        System.out.print("Novo valor de mercado: ");
        try {
            this.valorDeMercado = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido! Mantendo o valor antigo.");
        }

        System.out.println("Informações atualizadas com sucesso!");
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Posição: " + this.posicao);
        System.out.println("Clube Atual: " + this.clubeAtual);
        System.out.println("Valor de Mercado: " + this.valorDeMercado);

    }
}
