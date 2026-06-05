package academia.app;

import academia.dao.AlunoDAO;
import academia.dao.EquipamentoDAO;
import academia.dao.FuncionarioDAO;
import academia.dao.TreinoDAO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuDelete {

    int opcaoTabela = -1;

    public void executar(Scanner scanner){

        System.out.println("Em que tabela você deseja deletar um dado?");
        System.out.print("Aluno [1]" + "\n" + "Equipamento [2]" + "\n" + "Funcionario [3]" + "\n" + "Treino [4]" + "\n");
        try {
            opcaoTabela = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
            scanner.nextLine();
            return;
        }
        ;

        switch (opcaoTabela) {
            case 1: // Aluno
                System.out.print("Digite o ID do aluno: ");
                try {
                    int idAlunoDelete = scanner.nextInt();
                    scanner.nextLine();
                    AlunoDAO alunoDAODelete = new AlunoDAO();
                    alunoDAODelete.deleteAluno(idAlunoDelete);
                } catch (InputMismatchException e) {
                    System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                    scanner.nextLine();
                }
                ;
                break;

            case 2: // Equipamento
                System.out.print("Digite o ID do equipamento: ");
                try {
                    int idEquipamentoDelete = scanner.nextInt();
                    scanner.nextLine();
                    EquipamentoDAO equipamentoDAODelete = new EquipamentoDAO();
                    equipamentoDAODelete.deleteEquipamento(idEquipamentoDelete);
                } catch (InputMismatchException e) {
                    System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                    scanner.nextLine();
                }
                ;
                break;

            case 3: // Funcionário
                System.out.print("Digite o ID do funcionário: ");
                try {
                    int idFuncionarioDelete = scanner.nextInt();
                    scanner.nextLine();
                    FuncionarioDAO funcionarioDAODelete = new FuncionarioDAO();
                    funcionarioDAODelete.deleteFuncionario(idFuncionarioDelete);
                } catch (InputMismatchException e) {
                    System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                    scanner.nextLine();
                }
                ;
                break;

            case 4: // Treino

                System.out.print("Digite o ID do treino: ");
                try {
                    int idTreinoDelete = scanner.nextInt();
                    scanner.nextLine();
                    TreinoDAO treinoDAODelete = new TreinoDAO();
                    treinoDAODelete.deleteTreino(idTreinoDelete);
                } catch (InputMismatchException e) {
                    System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                    scanner.nextLine();
                }
                ;
                break;

            default:
                System.out.println("Opção inválida.");
        }
    };
}
