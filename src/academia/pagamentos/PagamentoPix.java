package academia.pagamentos;

public class PagamentoPix implements Pagavel{

    // Metodos
    @Override
    public void pagar(double valor){
        System.out.println("Foi realizado um pagamento no valor de R$" + valor + "pelo pix.");
    };
}
