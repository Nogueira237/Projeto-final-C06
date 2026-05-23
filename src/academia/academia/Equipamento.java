package academia.academia;

public class Equipamento {

    // Atributos
    private String nome;
    private String status;

    // Construtor
    public Equipamento(String nome, String status){
        this.nome = nome;
        this.status = status;
    };

    // Getters
    public String getNome(){
        return nome;
    };
    public String getStatus(){
        return status;
    };

}

