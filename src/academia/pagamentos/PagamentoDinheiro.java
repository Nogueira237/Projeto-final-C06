package academia.pagamentos;

public class PagamentoDinheiro implements Pagavel{

    // Metodos
    @Override
    public void pagar(double valor){
        System.out.println("Foi realizado um pagamento no valor de R$" + valor + "com dinheiro.");
    };
}
