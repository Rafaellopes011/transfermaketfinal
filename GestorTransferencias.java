import java.util.ArrayList;

public class GestorTransferencias implements Gerenciavel {
    private final ArrayList<Transferencia> transferencias = new ArrayList<>();

    @Override
    public void adicionarTransferencia(Object obj) {
        if (obj instanceof Transferencia) {
            transferencias.add((Transferencia) obj);
            System.out.println("Transferência adicionada com sucesso!");
        } else {
            System.out.println("Objeto inválido. Apenas transferências podem ser adicionadas.");
        }
    }

    @Override
    public void listarTransferencias() {
        System.out.println("\n--- Lista de Transferências ---");
        for (int i = 0; i < transferencias.size(); i++) {
            Transferencia t = transferencias.get(i);
            System.out.println(i + ". Jogador: " + t.getJogador().getNome() +
                    ", Clube de Origem: " + t.getClubeOrigem().getNome() +
                    ", Clube de Destino: " + t.getClubeDestino().getNome() +
                    ", Valor: " + t.getValor() +
                    ", Data: " + t.getData() +
                    ", Status: " + t.getStatus());
        }
    }
    public ArrayList<Transferencia> getTransferencias() {
        return transferencias;
    }

}
