package academia.academia;

public class Equipamento {

    // Atributos
    private int id; // para a tabela no bd
    private String nome;
    private String status;

    // Construtor
    public Equipamento(String nome, String status) {
        this.nome = nome;
        this.status = status;
    }

    ;

    // Metodo para o select funcionar no bd
    public void exibirInfo() {
        System.out.println(
                "ID: " + id +
                        "\nNome: " + nome +
                        "\nStatus: " + status + "\n"
        );
    };
    // Getters

    public int getId() {
        return id;
    };

    public String getNome() {
        return nome;
    };

    public String getStatus() {
        return status;
    };

    // Setters

    public void setNome(String nome) {
        this.nome = nome;
    };

    public void setId(int id) {
        this.id = id;
    };

    public void setStatus(String status) {
        this.status = status;
    };

}

