package academia.pagamentos;

public class PagamentoCartao implements Pagavel{

    // Atributos
    private String tipo;

    // Construtor
    public PagamentoCartao(){
        this.tipo = "cartão";
    };

    // Metodos
    @Override
    public void pagar(double valor){
        System.out.println("Foi realizado um pagamento no valor de R$" + valor + "pelo método " + tipo);
    };

    // Getters
    public String getTipo(){
        return tipo;
    };

}
