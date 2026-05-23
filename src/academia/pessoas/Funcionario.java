package academia.pessoas;

public class Funcionario extends Pessoa{

    // Atributos
    private double salario;

    // Construtor
    public Funcionario(String nome, String cpf, int idade, double salario){
        super(nome, cpf, idade);
        this.salario = salario;
    };

    // Metodos
    @Override
    public void exibirInfo(){
        System.out.println("Nome: " + getNome() + '\n' + "cpf: " + getCpf() + '\n' + "Idade: " + getIdade() + '\n' + "Salário: " + salario);
    };

    // Getters
    public double getSalario(){
        return salario;
    };

};
