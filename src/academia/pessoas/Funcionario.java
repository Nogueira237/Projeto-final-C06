package academia.pessoas;

public class Funcionario extends Pessoa{

    // Atributos
    private int id;         // para o bd
    private double salario;

    // Construtor
    public Funcionario(String nome, String cpf, int idade, double salario){
        super(nome, cpf, idade);
        this.salario = salario;
    };

    // Metodos
    @Override
    public void exibirInfo(){
        System.out.println("Nome: " + getNome() + '\n' + "cpf: " + getCpf() + '\n' + "Idade: " + getIdade() + '\n' + "Salário: " + salario + '\n');
    };

    // Getters

    public int getId() {
        return id;
    };

    public double getSalario(){
        return salario;
    };

    // Setters

    public void setId(int id) {
        this.id = id;
    };

    public void setSalario(double salario) {
        this.salario = salario;
    };
}
