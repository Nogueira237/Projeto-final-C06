package academia.pessoas;

import academia.planos.Plano;
import academia.pagamentos.Pagavel;
import academia.treino.Treino;

public class Aluno extends Pessoa{

    // Atributos
    private int matricula;
    private double peso;
    private double altura;
    private Plano plano;
    private Pagavel pagamento;
    private Treino treino;

    // Construtor
    public Aluno(String nome, String cpf, int idade, int matricula, double peso, double altura, Plano plano, Pagavel pagamento, Treino treino){
        super(nome, cpf, idade);
        this.matricula = matricula;
        this.peso = peso;
        this.altura = altura;
        this.plano = plano;
        this.pagamento = pagamento;
        this.treino = treino;
    };

    // Metodos
    public double calcularIMC(){
        return (peso/(altura*altura));
    };
    public void adicionarTreino(Treino treino){         // funcao para o personal adicionar um treino
        this.treino = treino;
    };

    @Override
    public void exibirInfo(){
        System.out.println("Nome: " + getNome() + '\n' + "CPF: " + getCpf() + '\n' + "Idade: " + getIdade() + '\n' + "Matrícula: " + matricula + '\n' + "Peso: " + peso + '\n' + "Altura: " + altura + '\n');
    };

    // Getters

    public int getMatricula() {
        return matricula;
    };
    public double getPeso() {
        return peso;
    };
    public double getAltura() {
        return altura;
    };
    public Plano getPlano() {
        return plano;
    };
    public Pagavel getPagamento() {
        return pagamento;
    };
    public Treino getTreino() {
        return treino;
    };

}
