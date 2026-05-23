package academia.planos;

public abstract class Plano {

    // Atributos
    private double valor;
    private String tipo;

    // Construtor
    public Plano(double valor, String tipo){
        this.valor = valor;
        this.tipo = tipo;
    };

    // Metodos
    public abstract double calcularMensalidade();      // Metodo abstrato

    // Getters
    public double getValor() {
        return valor;
    };
    public String getTipo() {
        return tipo;
    };

}

