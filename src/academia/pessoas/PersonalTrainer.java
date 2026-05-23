package academia.pessoas;

public class PersonalTrainer extends Funcionario{

    // Atributos
    private String cref;

    // Construtor
    public PersonalTrainer(String nome, String cpf, int idade, double salario, String cref){
        super(nome, cpf, idade, salario);
        this.cref = cref;
    };

    // Metodos
    //public Treino montarTreino(){};       CRIAR CLASSE TREINO

    @Override
    public void exibirInfo(){
        System.out.println("Nome: " + getNome() + '\n' + "cpf: " + getCpf() + '\n' + "Idade: " + getIdade() + '\n' + "Salário: " + getSalario() + '\n' + "Cref: " + cref);
    };

};
