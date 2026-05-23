package academia.pessoas;

import academia.planos.Plano;
import academia.pagamentos.Pagavel;

public class Aluno extends Pessoa{

    // Atributos
    private int matricula;
    private double peso;
    private double altura;
    private Plano plano;
    private Pagavel pagamento;

    // Construtor
    public Aluno(String nome, String cpf, int idade, int matricula, double peso, double altura, Plano plano, Pagavel pagamento){
        super(nome, cpf, idade);
        this.matricula = matricula;
        this.peso = peso;
        this.altura = altura;
        this.plano = plano;
        this.pagamento = pagamento;

    };

    // Metodos
    public double calcularIMC(){
        return (peso/(altura*altura));
    };

    @Override
    public void exibirInfo(){
        System.out.println("Nome: " + getNome() + '\n' + "cpf: " + getCpf() + '\n' + "Idade: " + getIdade() + '\n' + "Matrícula: " + matricula + '\n' + "Peso: " + peso + '\n' + "Altura: " + altura + '\n');
    };

}
