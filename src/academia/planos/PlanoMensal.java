package academia.planos;

public class PlanoMensal extends Plano{

    // Construtor
    public PlanoMensal(double valor){
        super(valor, "Mensal");
    };

    // Metodos
    @Override
    public double calcularMensalidade(){        // Mostra o valor da mensalidade no formato "R$100.0"
        System.out.print("Seu plano é" + getTipo() +  "| Valor da mensalidade: R$");
        return getValor();
    };

}
