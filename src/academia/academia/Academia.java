package academia.academia;

import academia.pessoas.Aluno;
import academia.pessoas.Funcionario;
import java.util.List;

public class Academia {

    // Atributos
    private String nome;
    private List<Aluno> alunos;
    private List<Funcionario> funcionarios;
    private List<Equipamento> equipamentos;

    // Contrutor
    public Academia(String nome, List<Aluno> alunos, List<Funcionario> funcionarios, List<Equipamento> equipamentos){
        this.nome = nome;
        this.alunos = alunos;
        this.funcionarios = funcionarios;
        this.equipamentos = equipamentos;
    };

    // Metodos
    public void listarAlunos() {                                                    // metodo para listar os alunos da academia
        System.out.println("Alunos: ");
        for (Aluno a : alunos) {
            a.exibirInfo();
        };
    };

    public void listarFuncionarios() {                                                    // metodo para listar os funcionarios da academia
        System.out.println("Funcionarios: ");
        for (Funcionario f : funcionarios) {
            f.exibirInfo();
        };
    };

    public void listarEquipamentos() {                                                    // metodo para listar os equipamento da academia
        System.out.println("Equipamentos: ");
        for (Equipamento e : equipamentos){
            System.out.println("Nome: " + e.getNome() + '\n' + "Status: " + e.getStatus() + '\n');
        };
    };


}
