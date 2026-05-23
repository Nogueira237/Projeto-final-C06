package academia.planos;

public abstract class Plano {

    // Atributos
    private double valor;


    // Construtor
    public Plano(double valor){
        this.valor = valor;
    };

    // Metodos
    public abstract double calcularMensalidade();      // Metodo abstrato

    // Getters
    public double getValor() {
        return valor;
    };

}

