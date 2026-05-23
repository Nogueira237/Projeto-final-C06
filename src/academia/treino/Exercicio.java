package academia.treino;

public class Exercicio {

    // Atributos
    private String nome;
    private int series;
    private int repeticoes;

    // Construtor
    public Exercicio(String nome, int series, int repeticoes){
        this.nome = nome;
        this.series = series;
        this.repeticoes = repeticoes;
    };

    // Getters
    public String getNome() {
        return nome;
    };
    public int getSeries() {
        return series;
    };
    public int getRepeticoes() {
        return repeticoes;
    };

}
