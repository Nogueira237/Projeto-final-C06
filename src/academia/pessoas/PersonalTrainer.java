package academia.pessoas;

import academia.treino.Treino;

public class PersonalTrainer extends Funcionario{

    // Atributos
    private String cref;

    // Construtor
    public PersonalTrainer(String nome, String cpf, int idade, double salario, String cref){
        super(nome, cpf, idade, salario);
        this.cref = cref;
    };

    // Metodos
    public void montarTreino(Aluno aluno, Treino treino){       // funcao para o personal adicionar o treino do aluno
        aluno.adicionarTreino(treino);
    };

    @Override
    public void exibirInfo(){
        System.out.println("Nome: " + getNome() + '\n' + "cpf: " + getCpf() + '\n' + "Idade: " + getIdade() + '\n' + "Salário: " + getSalario() + '\n' + "Cref: " + cref + '\n');
    };

}
