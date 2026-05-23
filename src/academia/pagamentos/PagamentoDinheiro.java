package academia.pagamentos;

public class PagamentoDinheiro implements Pagavel{

    // Atributos
    private String tipo;

    // Construtor
    public PagamentoDinheiro(){
        this.tipo = "dinheiro";
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
