import java.util.ArrayList;

class Clube {
    private String nome;
    private ArrayList<Jogador> jogadores = new ArrayList<>();
    private ArrayList<Transferencia> historicoTransferencias = new ArrayList<>();

    public Clube(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }
    public ArrayList<Transferencia> getHistoricoTransferencias() {
        return historicoTransferencias;
    }
}
