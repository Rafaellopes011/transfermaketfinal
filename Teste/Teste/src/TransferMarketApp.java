import javax.swing.*;
import java.util.Scanner;

public class TransferMarketApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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

        GestorTransferencias gestor = new GestorTransferencias();

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
            System.out.println("4. Editar informações de jogador");
            System.out.println("5. Editar informações de clube");
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
                    jogador.editarInformacoes();
                    break;
                case 5:
                    editarClube(scanner, clubeOrigem);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    public static void listarTransferencias(GestorTransferencias gestor) {
        System.out.println("\n--- Transferências ---");
        int index = 0;
        for (Transferencia t : gestor.getTransferencias()) {
            System.out.println(index + ". Jogador: " + t.getJogador().getNome());
            System.out.println("   Clube Origem: " + t.getClubeOrigem().getNome());
            System.out.println("   Clube Destino: " + t.getClubeDestino().getNome());
            System.out.println("   Valor: " + String.format("%.0f", t.getValor()));
            System.out.println("   Data: " + t.getData());
            System.out.println("   Status: " + t.getStatus());
            index++;
        }
    }

    public static void completarTransferencia(Scanner scanner, GestorTransferencias gestor) {
        System.out.println("\n--- Completar Transferência ---");
        listarTransferencias(gestor);

        System.out.print("Digite o índice da transferência para completar: ");
        int indice = Integer.parseInt(scanner.nextLine());

        if (indice >= 0 && indice < gestor.getTransferencias().size()) {
            gestor.getTransferencias().get(indice).completarTransferencia();
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public static void cancelarTransferencia(Scanner scanner, GestorTransferencias gestor) {
        System.out.println("\n--- Cancelar Transferência ---");
        listarTransferencias(gestor);

        System.out.print("Digite o índice da transferência para cancelar: ");
        int indice = Integer.parseInt(scanner.nextLine());

        if (indice >= 0 && indice < gestor.getTransferencias().size()) {
            gestor.getTransferencias().get(indice).cancelarTransferencia();
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public static void editarClube(Scanner scanner, Clube clube) {
        System.out.println("\n--- Editar Informações do Clube Origem ---");
        System.out.print("Novo nome do clube origem: ");
        clube.setNome(scanner.nextLine());
        System.out.println("Informações atualizadas com sucesso!");
        System.out.println("Nome: " + clube.getNome());
    }
}
