package academia.pagamentos;

public interface Pagavel {

    // Metodos
    public void pagar(double valor);

    // Getter
    String getTipo();       // getter abstrato para ser usado no relatorioAluno

}
