public class Treinador extends Pessoa implements Exibivel {
     private String timeGerenciado;

     public Treinador(String nome, int idade, String timeGerenciado) {
          super(nome, idade);
          this.timeGerenciado = timeGerenciado;
     }

     public String getTimeGerenciado() {
          return timeGerenciado;
     }

     public void setTimeGerenciado(String timeGerenciado) {
          this.timeGerenciado = timeGerenciado;
     }

     @Override
     public void exibirDetalhes() {
          System.out.println("--- Detalhes do Treinador ---");
          System.out.println("Nome: " + getNome());
          System.out.println("Idade: " + getIdade());
          System.out.println("Time Gerenciado: " + timeGerenciado);
     }
}
