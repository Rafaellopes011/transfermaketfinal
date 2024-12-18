class Transferencia {
    private Jogador jogador;
    private Clube clubeOrigem;
    private Clube clubeDestino;
    private double valor;
    private String data;
    private String status;

    public Transferencia(Jogador jogador, Clube clubeOrigem, Clube clubeDestino, double valor, String data) {
        this.jogador = jogador; // Vincule o jogador diretamente
        this.clubeOrigem = clubeOrigem;
        this.clubeDestino = clubeDestino;
        this.valor = valor;
        this.data = data;
        this.status = "Pendente";
    }

    public Jogador getJogador() {
        return jogador;
    }

    public Clube getClubeOrigem() {
        return clubeOrigem;
    }

    public Clube getClubeDestino() {
        return clubeDestino;
    }

    public double getValor() {
        return valor;
    }

    public String getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public void completarTransferencia() {
        this.status = "Completada";
    }

    public void cancelarTransferencia() {
        this.status = "Cancelada";
    }
}
