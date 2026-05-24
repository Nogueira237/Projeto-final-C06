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

    public void listarExercicios(){                                                    // metodo para listar os exercicios do treino
        System.out.println("Treino: " + nome);
        for(Exercicio e : exercicios){              // para cada instancia 'e' do tipo Exercicio na lista 'exercicios', é feito um sout [nome|series|repeticoes]
            System.out.println("Exercício: " + e.getNome() + '\n' + "Séries: " + e.getSeries() + '\n' + "Repetições: " + e.getRepeticoes() + '\n');
        };
    };

    // Getters
    public String getNome() {
        return nome;
    };
}
