package academia.pessoas;

public abstract class Pessoa {

    // Atributos
    private String nome;
    private String cpf;
    private int idade;

    // Construtor
    public Pessoa(String nome, String cpf, int idade){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    };

    // Metodos
    public abstract void exibirInfo();      // Metodo abstrato

    // Getters
    public String getNome() {
        return nome;
    };
    public String getCpf(){
        return cpf;
    };
    public int getIdade(){
        return idade;
    };

};
