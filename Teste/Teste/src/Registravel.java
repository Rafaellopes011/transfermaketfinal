import java.io.IOException;

interface Registravel {
    void salvarEmArquivo(String caminho) throws IOException;
    void carregarDeArquivo(String caminho) throws IOException;
}