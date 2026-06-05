package academia.app;

import academia.academia.Equipamento;
import academia.dao.AlunoDAO;
import academia.dao.EquipamentoDAO;
import academia.dao.FuncionarioDAO;
import academia.dao.TreinoDAO;
import academia.pessoas.Aluno;
import academia.pessoas.Funcionario;
import academia.treino.Treino;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuSelect {

    public void executar(Scanner scanner){

        int opcaoTabela = -1;

        System.out.println("Qual tabela deseja visualizar?");
        System.out.print("Aluno [1]\n" +
                "Equipamento [2]\n" +
                "Funcionario [3]\n" +
                "Treino [4]\n");

        try {
            opcaoTabela = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Erro! A opção escolhida é inválida: " + e.getMessage());
            scanner.nextLine();
            return;
        }

        switch (opcaoTabela) {

            case 1: // Aluno

                AlunoDAO alunoDAOSelect = new AlunoDAO();

                for (Aluno a : alunoDAOSelect.selectAluno()) {
                    a.exibirInfo();
                }

                break;

            case 2: // Equipamento

                EquipamentoDAO equipamentoDAOSelect = new EquipamentoDAO();

                for (Equipamento e : equipamentoDAOSelect.selectEquipamento()) {
                    e.exibirInfo();
                }

                break;

            case 3: // Funcionário

                FuncionarioDAO funcionarioDAOSelect = new FuncionarioDAO();

                for (Funcionario f : funcionarioDAOSelect.selectFuncionario()) {
                    f.exibirInfo();
                }

                break;

            case 4: // Treino

                TreinoDAO treinoDAOSelect = new TreinoDAO();

                for (Treino t : treinoDAOSelect.selectTreino()) {
                    System.out.println("ID: " + t.getId());
                    System.out.println("Nome: " + t.getNome());
                    System.out.println();
                }

                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }
    };

}
