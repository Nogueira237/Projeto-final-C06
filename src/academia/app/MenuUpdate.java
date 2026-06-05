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

public class MenuUpdate {

    public void executar(Scanner scanner){

        int opcaoTabela = -1;
        int opcaoAtualizacao = -1;

        TreinoDAO treinoDAO = new TreinoDAO();
        Treino treino = new Treino("Iniciante");

        System.out.println("Em que tabela você deseja atualizar um dado?");
        System.out.print("Aluno [1]" + "\n" + "Equipamento [2]" + "\n" + "Funcionario [3]" + "\n" + "Treino [4]" + "\n");
        try {
            opcaoTabela = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
            scanner.nextLine();
        }
        ;
        switch (opcaoTabela) {
            case 1:     // Aluno

                int idAluno = -1;
                System.out.println("Digite o ID do aluno que deseja atualizar:");
                try {
                    idAluno = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                    scanner.nextLine();
                    break;
                };

                int matricula = -1;
                try {
                    System.out.println("Qual a matrícula do aluno que deseja atualizar?");
                    matricula = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                    scanner.nextLine();
                    break;
                }
                ;

                AlunoDAO AlunoDAO = new AlunoDAO();
                Aluno aluno = null;

                for (Aluno a : AlunoDAO.selectAluno()) {
                    if (a.getMatricula() == matricula) {
                        aluno = a;
                        break;
                    }
                }

                if (aluno == null) {
                    System.out.println("Aluno não encontrado.");
                    break;
                }

                System.out.println("Qual dado deseja alterar?");
                System.out.println("[1] Nome");
                System.out.println("[2] CPF");
                System.out.println("[3] Idade");
                System.out.println("[4] Peso");
                System.out.println("[5] Altura");


                try {
                    opcaoAtualizacao = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                    scanner.nextLine(); // descarta o valor inválido
                    return;
                };

                switch (opcaoAtualizacao) {

                    case 1:
                        try{
                            System.out.println("Novo nome:");
                            aluno.setNome(scanner.nextLine());
                        } catch (InputMismatchException e) {
                            System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                            scanner.nextLine(); // descarta o valor inválido
                            return;
                        };

                        break;

                    case 2:
                        try{
                            System.out.println("Novo CPF:");
                            aluno.setCpf(scanner.nextLine());
                        } catch (InputMismatchException e) {
                            System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                            scanner.nextLine(); // descarta o valor inválido
                            return;
                        };
                        break;

                    case 3:
                        try{
                            System.out.println("Nova idade:");
                            aluno.setIdade(scanner.nextInt());

                        } catch (InputMismatchException e) {
                            System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                            scanner.nextLine(); // descarta o valor inválido
                            return;
                        }
                        break;
                    case 4:
                        try{
                            System.out.println("Novo peso:");
                            aluno.setPeso(scanner.nextDouble());
                        } catch (InputMismatchException e) {
                            System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                            scanner.nextLine(); // descarta o valor inválido
                            return;
                        };
                        break;

                    case 5:
                        try{
                            System.out.println("Nova altura:");
                            aluno.setAltura(scanner.nextDouble());
                        } catch (InputMismatchException e) {
                            System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                            scanner.nextLine(); // descarta o valor inválido
                            return;
                        };
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }

                AlunoDAO.updateAluno(idAluno, aluno);
                break;

            case 2: // Equipamento

                System.out.println("Digite o ID do equipamento:");
                int idEquipamento = -1;
                try{
                    idEquipamento = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                    scanner.nextLine(); // descarta o valor inválido
                    return;
                };

                EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
                Equipamento equipamento = null;

                for (Equipamento e : equipamentoDAO.selectEquipamento()) {
                    if (e.getId() == idEquipamento) {
                        equipamento = e;
                        break;
                    }
                }

                if (equipamento == null) {
                    System.out.println("Equipamento não encontrado.");
                    break;
                }

                System.out.println("Qual dado deseja alterar?");
                System.out.println("[1] Nome");
                System.out.println("[2] Status");

                opcaoAtualizacao = -1;

                try {
                    opcaoAtualizacao = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Erro! Opção inválida.");
                    scanner.nextLine();
                    break;
                }

                switch (opcaoAtualizacao) {

                    case 1:
                        System.out.println("Novo nome:");
                        try{
                            equipamento.setNome(scanner.nextLine());
                        } catch (InputMismatchException e) {
                            System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                            scanner.nextLine(); // descarta o valor inválido
                            return;
                        };
                        break;

                    case 2:
                        System.out.println("Novo status:");
                        try{
                            equipamento.setStatus(scanner.nextLine());
                        } catch (InputMismatchException e) {
                            System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                            scanner.nextLine(); // descarta o valor inválido
                            return;
                        };
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }

                equipamentoDAO.updateEquipamento(idEquipamento, equipamento);
                break;

            case 3: // Funcionario

                System.out.println("Digite o ID do funcionário:");
                int idFuncionario = -1;
                try{
                    idFuncionario = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                    scanner.nextLine(); // descarta o valor inválido
                    return;
                };

                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                Funcionario funcionario = null;

                for (Funcionario f : funcionarioDAO.selectFuncionario()) {
                    if (f.getId() == idFuncionario) {
                        funcionario = f;
                        break;
                    }
                }

                if (funcionario == null) {
                    System.out.println("Funcionário não encontrado.");
                    break;
                }

                System.out.println("Qual dado deseja alterar?");
                System.out.println("[1] Nome");
                System.out.println("[2] CPF");
                System.out.println("[3] Idade");
                System.out.println("[4] Salário");

                opcaoAtualizacao = -1;

                try {
                    opcaoAtualizacao = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Erro! Opção inválida.");
                    scanner.nextLine();
                    break;
                }

                switch (opcaoAtualizacao) {

                    case 1:
                        try{
                            System.out.println("Novo nome:");
                            funcionario.setNome(scanner.nextLine());
                        } catch (InputMismatchException e) {
                            System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                            scanner.nextLine(); // descarta o valor inválido
                            return;
                        };
                        break;

                    case 2:
                        try{
                            System.out.println("Novo CPF:");
                            funcionario.setCpf(scanner.nextLine());
                        } catch (InputMismatchException e) {
                            System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                            scanner.nextLine(); // descarta o valor inválido
                            return;
                        };
                        break;

                    case 3:
                        try{
                            System.out.println("Nova idade:");
                            funcionario.setIdade(scanner.nextInt());
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                            scanner.nextLine(); // descarta o valor inválido
                            return;
                        };
                        break;

                    case 4:
                        try{
                            System.out.println("Novo salário:");
                            funcionario.setSalario(scanner.nextDouble());
                            scanner.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                            scanner.nextLine(); // descarta o valor inválido
                            return;
                        };
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }

                funcionarioDAO.updateFuncionario(funcionario);
                break;

            case 4: // Treino

                System.out.println("Digite o ID do treino:");
                int idTreino = -1;
                try{
                    idTreino = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                    scanner.nextLine(); // descarta o valor inválido
                    return;
                };

                treinoDAO = new TreinoDAO();
                treino = null;

                for (Treino t : treinoDAO.selectTreino()) {
                    if (t.getId() == idTreino) {
                        treino = t;
                        break;
                    }
                }

                if (treino == null) {
                    System.out.println("Treino não encontrado.");
                    break;
                }

                System.out.println("Qual dado deseja alterar?");
                System.out.println("[1] Nome do treino");

                opcaoAtualizacao = -1;

                try {
                    opcaoAtualizacao = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Erro! Opção inválida.");
                    scanner.nextLine();
                    break;
                }

                switch (opcaoAtualizacao) {

                    case 1:

                        System.out.println("Novo nome:");
                        try{
                            treino.setNome(scanner.nextLine());
                        } catch (InputMismatchException e) {
                            System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                            scanner.nextLine(); // descarta o valor inválido
                            return;
                        }
                        break;


                    default:
                        System.out.println("Opção inválida.");
                        break;
                }

                treinoDAO.updateTreino(idTreino, treino);
                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }
    };
}
