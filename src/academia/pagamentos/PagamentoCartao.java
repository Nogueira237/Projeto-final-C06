package academia.pagamentos;

public class PagamentoCartao implements Pagavel{

    // Metodos
    @Override
    public void pagar(double valor){
        System.out.println("Foi realizado um pagamento no valor de R$" + valor + "pelo cartão.");
    };
}
