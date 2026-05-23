package academia.treino;

import java.util.ArrayList;
import java.util.List;

public class Treino {

    // Atributos
    private String nome;
    private List<Exercicio> exercicios;

    // Construtor
    public Treino(String nome){
        this.nome = nome;
        this.exercicios = new ArrayList<>();
    };

    // Metodos
    public void adicionarExercicio(String nome, int series, int repeticoes){            // metodo para adicionar criar e adicionar os exercicios ao treino
        Exercicio exercicio = new Exercicio(nome, series, repeticoes);
        exercicios.add(exercicio);
    };
}
