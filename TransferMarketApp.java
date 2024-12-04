import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TransferMarketApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Caminho fixo para salvar as informações
        String caminhoPasta = "C:\\Users\\liama\\Downloads\\Transfermarket";


        JFrame frame = new JFrame("Transfer Market - Login");
        String usuario = JOptionPane.showInputDialog(frame, "Digite seu nome de usuário:");
        String senha = JOptionPane.showInputDialog(frame, "Digite sua senha:");

        String usuarioCorreto = "Lopes";
        String senhaCorreta = "123456";

        while (usuario != null && senha != null && (!usuario.equals(usuarioCorreto) || !senha.equals(senhaCorreta))) {
            JOptionPane.showMessageDialog(frame, "Login falhou! Verifique seu nome de usuário e senha.");
            usuario = JOptionPane.showInputDialog(frame, "Digite seu nome de usuário:");
            senha = JOptionPane.showInputDialog(frame, "Digite sua senha:");
        }

        JOptionPane.showMessageDialog(frame, "Login bem-sucedido! Bem-vindo ao Transfer Market!");

        // Inicializar objetos
        GestorTransferencias gestor = new GestorTransferencias();
        Treinador treinador = new Treinador("Pep Guardiola", 52, "Manchester City");

        treinador.exibirDetalhes();

        Jogador jogador = new Jogador("Cristiano Ronaldo", 39, "Português", "Atacante", "Juventus", 100_000_000);
        Clube clubeOrigem = new Clube("Juventus");
        Clube clubeDestino = new Clube("Manchester United");
        Transferencia transferencia = new Transferencia(jogador, clubeOrigem, clubeDestino, 100_000_000, "27/08/2024");

        gestor.adicionarTransferencia(transferencia);

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Listar transferências");
            System.out.println("2. Completar transferência");
            System.out.println("3. Cancelar transferência");
            System.out.println("4. Editar informações de clube");
            System.out.println("5. Listar informações do treinador");
            System.out.println("6. Alterar informações do treinador");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            switch (opcao) {
                case 1:
                    listarTransferencias(gestor);
                    break;
                case 2:
                    completarTransferencia(scanner, gestor);
                    break;
                case 3:
                    cancelarTransferencia(scanner, gestor);
                    break;
                case 4:
                    editarClube(scanner, clubeOrigem);
                    break;
                case 5:
                    listarInformacoesTreinador(treinador);
                    break;
                case 6:
                    alterarInformacoesTreinador(scanner, treinador);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    salvarInformacoesEmTxt(caminhoPasta, gestor, treinador);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    public static void listarTransferencias(GestorTransferencias gestor) {
        System.out.println("\n--- Transferências ---");
        for (int i = 0; i < gestor.getTransferencias().size(); i++) {
            Transferencia t = gestor.getTransferencias().get(i);
            Jogador jogador = t.getJogador();
            int index = 0;
            System.out.println(index + ". Jogador: " + jogador.getNome());
            System.out.println("   Clube Origem: " + t.getClubeOrigem().getNome());
            System.out.println("   Clube Destino: " + t.getClubeDestino().getNome());
            System.out.println("   Valor: " + t.getValor());
            System.out.println("   Data: " + t.getData());
            System.out.println("   Status: " + t.getStatus());
            index++;
        }
    }
        public static void completarTransferencia (Scanner scanner, GestorTransferencias gestor){
            System.out.print("Digite o índice da transferência para completar: ");
            int indice = Integer.parseInt(scanner.nextLine());
            if (indice >= 0 && indice < gestor.getTransferencias().size()) {
                gestor.getTransferencias().get(indice).completarTransferencia();
                System.out.println("Transferência completada com sucesso!");
            } else {
                System.out.println("Índice inválido.");
            }
        }

        public static void cancelarTransferencia (Scanner scanner, GestorTransferencias gestor){
            System.out.print("Digite o índice da transferência para cancelar: ");
            int indice = Integer.parseInt(scanner.nextLine());
            if (indice >= 0 && indice < gestor.getTransferencias().size()) {
                gestor.getTransferencias().get(indice).cancelarTransferencia();
                System.out.println("Transferência cancelada com sucesso!");
            } else {
                System.out.println("Índice inválido.");
            }
        }

        public static void editarClube (Scanner scanner, Clube clube){
            System.out.print("Novo clube atual: ");
            clube.setNome(scanner.nextLine());
            System.out.println("Informações do clube atualizadas.");
        }

        public static void listarInformacoesTreinador (Treinador treinador){
            treinador.exibirDetalhes();
        }

        public static void alterarInformacoesTreinador (Scanner scanner, Treinador treinador){
            System.out.print("Novo nome do treinador: ");
            treinador.setNome(scanner.nextLine());

            System.out.print("Nova idade: ");
            try {
                treinador.setIdade(Integer.parseInt(scanner.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println("Idade inválida! Mantendo a idade anterior.");
            }

            System.out.print("Novo time gerenciado: ");
            treinador.setTimeGerenciado(scanner.nextLine());

            System.out.println("Informações do treinador atualizadas.");
        }
        private static void salvarInformacoesEmTxt (String caminhoPasta, GestorTransferencias gestor, Treinador
        treinador){
            try {
                String caminhoTransferencias = caminhoPasta + "\\transferencias.txt";
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoTransferencias))) {
                    for (Transferencia t : gestor.getTransferencias()) {
                        writer.write(String.format("Jogador: %s, Clube de Origem: %s, Clube de Destino: %s, Valor: %.0f, Data: %s, Status: %s\n",
                                t.getJogador().getNome(),
                                t.getClubeOrigem().getNome(),
                                t.getClubeDestino().getNome(),
                                t.getValor(),
                                t.getData(),
                                t.getStatus()));
                    }
                }
                String caminhoTreinador = caminhoPasta + "\\treinador.txt";
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoTreinador))) {
                    writer.write("Treinador: " + treinador.getNome() + "\n");
                    writer.write("Idade: " + treinador.getIdade() + "\n");
                    writer.write("Time Gerenciado: " + treinador.getTimeGerenciado() + "\n");
                }

                System.out.println("Informações salvas com sucesso na pasta Transfermarket.");
            } catch (IOException e) {
                System.out.println("Erro ao salvar informações: " + e.getMessage());
            }
        }
}


