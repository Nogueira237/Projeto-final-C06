package academia.app;

import academia.dao.AlunoDAO;
import academia.dao.FuncionarioDAO;
import academia.dao.EquipamentoDAO;
import academia.dao.TreinoDAO;
import academia.dao.ConnectionDAO;
import java.sql.Connection;
import java.util.ArrayList;

import academia.pessoas.Aluno;
import academia.pessoas.Funcionario;

import academia.academia.Equipamento;
import academia.treino.Treino;

import academia.planos.PlanoMensal;
import academia.pagamentos.PagamentoPix;

public class Main {

    public static void main(String[] args) {

        // =========================
        // LIGANDO O BD
        // =========================
        ConnectionDAO dao = new ConnectionDAO();

        Connection conn = dao.connectToDb();

        if(conn != null) {
            System.out.println("Banco conectado!");
        } else {
            System.out.println("Falha na conexão!");
        }

        // =========================
        // TESTE TREINO
        // =========================
        TreinoDAO treinoDAO = new TreinoDAO();

        Treino treino = new Treino("Hipertrofia");
        treino.adicionarExercicio("Supino", 4, 10);

        treinoDAO.insertTreino(treino);


        // =========================
        // TESTE EQUIPAMENTO
        // =========================
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO();

        Equipamento eq1 = new Equipamento("Esteira", "Funcionando");
        Equipamento eq2 = new Equipamento("Bicicleta", "Manutenção");

        equipamentoDAO.insertEquipamento(eq1);
        equipamentoDAO.insertEquipamento(eq2);


        // =========================
        // TESTE FUNCIONÁRIO
        // =========================
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        Funcionario func = new Funcionario(
                "Carlos",
                "12345678900",
                35,
                2500.00
        );

        funcionarioDAO.insertFuncionario(func);


        // =========================
        // TESTE ALUNO
        // =========================
        AlunoDAO alunoDAO = new AlunoDAO();

        Aluno aluno = new Aluno(
                "Eduardo",
                "98765432110",
                22,
                1001,
                75.5,
                1.78,
                new PlanoMensal(80),
                new PagamentoPix(),
                treino
        );

        alunoDAO.insertAluno(aluno);


        // =========================
        // TESTE SELECT (verificação)
        // =========================
        ArrayList<Aluno> alunos = alunoDAO.selectAluno();

        System.out.println("=== LISTA DE ALUNOS ===");

        for (Aluno a : alunos) {
            System.out.println(
                    "Nome: " + a.getNome() +
                            " | CPF: " + a.getCpf() +
                            " | Matrícula: " + a.getMatricula() + '\n'
            );
        }

        ArrayList<Funcionario> funcionarios = funcionarioDAO.selectFuncionario();

        System.out.println("=== LISTA DE FUNCIONÁRIOS ===");

        for (Funcionario f : funcionarios) {
            System.out.println(
                    "Nome: " + f.getNome() +
                            " | CPF: " + f.getCpf() +
                            " | Idade: " + f.getIdade() +
                            " | Salário: " + f.getSalario() + '\n'
            );
        }


        System.out.println("\n=== LISTA DE EQUIPAMENTOS ===");
        for (Equipamento e : equipamentoDAO.selectEquipamento()) {
            System.out.println(e.getNome() + " - Status: " + e.getStatus());
        }

        System.out.println("\n=== LISTA DE TREINOS ===");
        for (Treino t : treinoDAO.selectTreino()) {
            System.out.println(t.getNome());
        }
    }

}

