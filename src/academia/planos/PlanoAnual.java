package academia.planos;

public class PlanoAnual extends Plano{

    // Construtor
    public PlanoAnual(double valor){
        super(valor);
    };

    // Metodos
    @Override
    public double calcularMensalidade(){        // Mostra o valor da mensalidade no formato "R$100.0"
        System.out.print("Seu plano é anual | Valor da mensalidade: R$");
        return getValor();
    };
}
