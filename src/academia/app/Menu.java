package academia.app;

import academia.academia.Equipamento;
import academia.dao.*;
import academia.pagamentos.PagamentoCartao;
import academia.pagamentos.PagamentoDinheiro;
import academia.pagamentos.PagamentoPix;
import academia.pagamentos.Pagavel;
import academia.pessoas.Aluno;
import academia.pessoas.Funcionario;
import academia.planos.Plano;
import academia.planos.PlanoAnual;
import academia.planos.PlanoMensal;
import academia.treino.Treino;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu implements Runnable {

    @Override
    public void run() {

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;     // valor aleatorio para inicializar a variavel
        int opcaoTabela = -1;
        int opcaoPlano = -1;
        int opcaoPagamento = -1;
        int opcaoAtualizacao = -1;

        // PLANOS
        PlanoMensal planoMensal = new PlanoMensal(135);
        PlanoAnual planoAnual = new PlanoAnual(120);    // valor por mes

        // MÉTODOS DE PAGAMENTO
        PagamentoCartao pagamentoCartao = new PagamentoCartao();
        PagamentoDinheiro pagamentoDinheiro = new PagamentoDinheiro();
        PagamentoPix pagamentoPix = new PagamentoPix();

        // TREINO PADRAO
        TreinoDAO treinoDAO = new TreinoDAO();

        Treino treino = new Treino("Iniciante");
        treino.adicionarExercicio("Supino", 3, 10);
        treino.adicionarExercicio("Remada baixa", 3, 10);
        treino.adicionarExercicio("Bíceps com halter", 3, 10);
        treino.adicionarExercicio("Tríceps na polia", 3, 10);
        treino.adicionarExercicio("Agachamento", 3, 10);
        treino.adicionarExercicio("Cadeira flexora", 3, 10);
        treino.adicionarExercicio("Elevação lateral", 3, 10);

        do {
            // PRIMEIRO MOSTRA AS OPCOES
            System.out.println("Qual operação você deseja realizar? [digite o número da opção selecionada]");
            System.out.println("Finalizar [0]");
            System.out.println("Nova inserção [1]");
            System.out.println("Atualização [2]");
            System.out.println("Deletar [3]");
            System.out.println("Mostrar dados [4]");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                scanner.nextLine(); // descarta o valor inválido
                continue;
            }
            ;

            switch (opcao) {
                case 1:     // Insere dados
                    System.out.println("Em que tabela você deseja inserir um novo dado?");
                    System.out.print("Aluno [1]" + "\n" + "Equipamento [2]" + "\n" + "Funcionario [3]" + "\n" + "Treino [4]" + "\n");
                    try {
                        opcaoTabela = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                        scanner.nextLine();
                        break;
                    }
                    ;
                    switch (opcaoTabela) {
                        case 1:     // tabela aluno
                            String nome_aluno;
                            //  Aceita apenas letras e espaços, valida com regex
                            do {

                                System.out.print("Nome do aluno: ");
                                nome_aluno = scanner.nextLine();

                                if (!nome_aluno.matches("[a-zA-ZÀ-ÿ ]+")) {
                                    System.out.println("Nome inválido! Digite apenas letras.");
                                }

                            } while (!nome_aluno.matches("[a-zA-ZÀ-ÿ ]+"));


                            String cpf;
                            //  Aceita apenas 11 digitos, valida com regex
                            do {
                                System.out.print("CPF [Apenas números: 11122233344]: ");
                                cpf = scanner.nextLine();

                                if (!cpf.matches("\\d{11}")) {
                                    System.out.println("CPF deve conter exatamente 11 números.");
                                }

                            } while (!cpf.matches("\\d{11}"));

                            int idade = -1;
                            // maior que zero, menor que 120
                            while (idade < 0 || idade > 120) {
                                try {
                                    System.out.print("Idade: ");
                                    idade = Integer.parseInt(scanner.nextLine());

                                    if (idade < 0 || idade > 120) {
                                        System.out.println("Idade inválida.");
                                    }

                                } catch (NumberFormatException e) {
                                    System.out.println("Digite um número inteiro.");
                                }
                            }

                            int matricula = -1;
                            // Nao pode ser negativo
                            while (matricula <= 0) {
                                try {
                                    System.out.print("Matrícula: ");
                                    matricula = Integer.parseInt(scanner.nextLine());

                                    if (matricula <= 0) {
                                        System.out.println("A matrícula deve ser positiva.");
                                    }

                                } catch (NumberFormatException e) {
                                    System.out.println("Digite um número inteiro.");
                                }
                            }

                            double peso = 0;
                            // Nao pode ser negativo
                            while (peso <= 0 || peso > 500) {
                                try {
                                    System.out.print("Peso: ");
                                    peso = Double.parseDouble(scanner.nextLine());

                                    if (peso <= 0 || peso > 500) {
                                        System.out.println("Peso inválido.");
                                    }

                                } catch (NumberFormatException e) {
                                    System.out.println("Digite um número válido.");
                                }
                            }

                            double altura = 0;
                            // Nao negativo
                            while (altura <= 0 || altura > 3.0) {
                                try {
                                    System.out.print("Altura: ");
                                    altura = Double.parseDouble(scanner.nextLine());

                                    if (altura <= 0 || altura > 3.0) {
                                        System.out.println("Altura inválida.");
                                    }

                                } catch (NumberFormatException e) {
                                    System.out.println("Digite um número válido.");
                                }
                            }

                            // Escolha do plano
                            System.out.println("Plano:");
                            System.out.println("Mensal [1]");
                            System.out.println("Anual [2]");

                            Plano plano = null;
                            do {
                                try {
                                    opcaoPlano = scanner.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("Opção inválida!");
                                    scanner.nextLine(); // descarta a entrada inválida
                                }
                                ;

                                if (opcaoPlano == 1) {
                                    plano = planoMensal;
                                } else if (opcaoPlano == 2) {
                                    plano = planoAnual;
                                } else {
                                    System.out.println("Erro! A opção selecionada não existe.");
                                }
                                ;
                            } while (opcaoPlano != 1 && opcaoPlano != 2);

                            // Escolha do pagamento
                            System.out.println("Pagamento:");
                            System.out.println("Cartão [1]");
                            System.out.println("Dinheiro [2]");
                            System.out.println("Pix [3]");

                            Pagavel pagamento = null;
                            do {
                                try {
                                    opcaoPagamento = scanner.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("Opção inválida!");
                                    scanner.nextLine(); // descarta a entrada inválida
                                }
                                ;

                                if (opcaoPagamento == 1) {
                                    pagamento = pagamentoCartao;
                                } else if (opcaoPagamento == 2) {
                                    pagamento = pagamentoDinheiro;
                                } else if (opcaoPagamento == 3) {
                                    pagamento = pagamentoPix;
                                } else {
                                    System.out.println("Opção inválida!");
                                }
                                ;
                            } while (opcaoPagamento != 1 && opcaoPagamento != 2 && opcaoPagamento != 3);

                            // Treino -> ja criado
                            // Finalmente, cria o aluno
                            Aluno aluno = new Aluno(nome_aluno, cpf, idade, matricula, peso, altura, plano, pagamento, treino);
                            // Por fim, salva no banco de dados
                            AlunoDAO alunoDAO = new AlunoDAO();
                            if (alunoDAO.insertAluno(aluno)) {
                                System.out.println("Aluno cadastrado com sucesso!");
                            } else {
                                System.out.println("Erro ao cadastrar aluno.");
                            }
                            break;
                        case 2:         // Tabela equipamento
                            String nome_equipamento;
                            //  Aceita apenas letras e espaços, valida com regex
                            do {
                                System.out.print("Nome do equipamento: ");
                                nome_equipamento = scanner.nextLine();

                                if (!nome_equipamento.matches("[a-zA-ZÀ-ÿ ]+")) {
                                    System.out.println("Nome inválido! Digite apenas letras.");
                                }

                            } while (!nome_equipamento.matches("[a-zA-ZÀ-ÿ ]+"));

                            String status;
                            //  Aceita apenas letras e espaços, valida com regex
                            do {
                                System.out.print("Status do equipamento: ");
                                status = scanner.nextLine();

                                if (!status.matches("[a-zA-ZÀ-ÿ ]+")) {
                                    System.out.println("Digite apenas letras.");
                                }

                            } while (!status.matches("[a-zA-ZÀ-ÿ ]+"));

                            // Finalmente, cria o equipamento
                            Equipamento equipamento = new Equipamento(nome_equipamento, status);
                            // Por fim, salva no banco de dados
                            EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
                            if (equipamentoDAO.insertEquipamento(equipamento)) {
                                System.out.println("Equipamento cadastrado com sucesso!");
                            } else {
                                System.out.println("Erro ao cadastrar equipamento.");
                            }
                            break;

                        case 3:     // Tabela funcionario
                            String nome_funcionario;
                            //  Aceita apenas letras e espaços, valida com regex
                            do {

                                System.out.print("Nome do funcionário: ");
                                nome_funcionario = scanner.nextLine();

                                if (!nome_funcionario.matches("[a-zA-ZÀ-ÿ ]+")) {
                                    System.out.println("Nome inválido! Digite apenas letras.");
                                }

                            } while (!nome_funcionario.matches("[a-zA-ZÀ-ÿ ]+"));


                            //  Aceita apenas 11 digitos, valida com regex
                            do {
                                System.out.print("CPF [Apenas números: 11122233344]: ");
                                cpf = scanner.nextLine();

                                if (!cpf.matches("\\d{11}")) {
                                    System.out.println("CPF deve conter exatamente 11 números.");
                                }

                            } while (!cpf.matches("\\d{11}"));

                            idade = -1;
                            // maior que zero, menor que 120
                            while (idade < 0 || idade > 120) {
                                try {
                                    System.out.print("Idade: ");
                                    idade = Integer.parseInt(scanner.nextLine());

                                    if (idade < 0 || idade > 120) {
                                        System.out.println("Idade inválida.");
                                    }

                                } catch (NumberFormatException e) {
                                    System.out.println("Digite um número inteiro.");
                                }
                            }

                            double salario = -1;
                            // maior que zero
                            while (salario < 0) {
                                try {
                                    System.out.print("Salário: ");
                                    salario = Integer.parseInt(scanner.nextLine());

                                    if (salario < 0) {
                                        System.out.println("Salário inválido.");
                                    }

                                } catch (NumberFormatException e) {
                                    System.out.println("Digite um número inteiro.");
                                }
                            }

                            // Finalmente, cria o funcionario
                            Funcionario funcionario = new Funcionario(nome_funcionario, cpf, idade, salario);
                            // Por fim, salva no banco de dados
                            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                            if (funcionarioDAO.insertFuncionario(funcionario)) {
                                System.out.println("Funcionário cadastrado com sucesso!");
                            } else {
                                System.out.println("Erro ao cadastrar funcionário.");
                            }
                            break;

                        case 4:         // Tabela Treino
                            String nome_treino;
                            // Apenas letras e espaços
                            do {

                                System.out.print("Nome do treino: ");
                                nome_treino = scanner.nextLine();

                                if (!nome_treino.matches("[a-zA-ZÀ-ÿ ]+")) {
                                    System.out.println("Nome inválido! Digite apenas letras.");
                                }

                            } while (!nome_treino.matches("[a-zA-ZÀ-ÿ ]+"));

                            Treino treinoUsuario = new Treino(nome_treino);

                            System.out.println("Quais exercícios gostaria de incluir no treino?");
                            System.out.println("[1] Supino");
                            System.out.println("[2] Remada baixa");
                            System.out.println("[3] Bíceps com halter");
                            System.out.println("[4] Tríceps na polia");
                            System.out.println("[5] Agachamento");
                            System.out.println("[6] Cadeira flexora");
                            System.out.println("[7] Elevação lateral");
                            System.out.println("[0] Finalizar seleção");

                            int opcaoExercicio = -1;

                            while (opcaoExercicio != 0) {

                                System.out.print("Escolha o exercício: ");

                                try {
                                    opcaoExercicio = Integer.parseInt(scanner.nextLine().trim());
                                } catch (NumberFormatException e) {
                                    System.out.println("Digite apenas números!");
                                    continue;
                                }

                                switch (opcaoExercicio) {

                                    case 1:
                                        treinoUsuario.adicionarExercicio("Supino", 3, 10);
                                        System.out.println("Supino adicionado!");
                                        break;

                                    case 2:
                                        treinoUsuario.adicionarExercicio("Remada baixa", 3, 10);
                                        System.out.println("Remada baixa adicionada!");
                                        break;

                                    case 3:
                                        treinoUsuario.adicionarExercicio("Bíceps com halter", 3, 10);
                                        System.out.println("Bíceps adicionado!");
                                        break;

                                    case 4:
                                        treinoUsuario.adicionarExercicio("Tríceps na polia", 3, 10);
                                        System.out.println("Tríceps adicionado!");
                                        break;

                                    case 5:
                                        treinoUsuario.adicionarExercicio("Agachamento", 3, 10);
                                        System.out.println("Agachamento adicionado!");
                                        break;

                                    case 6:
                                        treinoUsuario.adicionarExercicio("Cadeira flexora", 3, 10);
                                        System.out.println("Cadeira flexora adicionada!");
                                        break;

                                    case 7:
                                        treinoUsuario.adicionarExercicio("Elevação lateral", 3, 10);
                                        System.out.println("Elevação lateral adicionada!");
                                        break;

                                    case 0:
                                        System.out.println("Finalizando seleção...");
                                        break;

                                    default:
                                        System.out.println("Opção inválida!");
                                }
                            }

                            // Por fim, salva no banco de dados
                            if (treinoDAO.insertTreino(treinoUsuario)) {
                                System.out.println("Treino cadastrado com sucesso!");
                            } else {
                                System.out.println("Erro ao cadastrar treino.");
                            }
                            break;

                    }
                    break;

                case 2:     // Atualiza dados
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
                                continue;
                            };

                            switch (opcaoAtualizacao) {

                                case 1:
                                    try{
                                        System.out.println("Novo nome:");
                                        aluno.setNome(scanner.nextLine());
                                    } catch (InputMismatchException e) {
                                        System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                                        scanner.nextLine(); // descarta o valor inválido
                                        continue;
                                    };

                                    break;

                                case 2:
                                    try{
                                        System.out.println("Novo CPF:");
                                        aluno.setCpf(scanner.nextLine());
                                    } catch (InputMismatchException e) {
                                        System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                                        scanner.nextLine(); // descarta o valor inválido
                                        continue;
                                    };
                                    break;

                                case 3:
                                    try{
                                        System.out.println("Nova idade:");
                                        aluno.setIdade(scanner.nextInt());

                                    } catch (InputMismatchException e) {
                                        System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                                        scanner.nextLine(); // descarta o valor inválido
                                        continue;
                                    }
                                    break;
                                case 4:
                                    try{
                                        System.out.println("Novo peso:");
                                        aluno.setPeso(scanner.nextDouble());
                                    } catch (InputMismatchException e) {
                                        System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                                        scanner.nextLine(); // descarta o valor inválido
                                        continue;
                                    };
                                    break;

                                case 5:
                                    try{
                                        System.out.println("Nova altura:");
                                        aluno.setAltura(scanner.nextDouble());
                                    } catch (InputMismatchException e) {
                                        System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                                        scanner.nextLine(); // descarta o valor inválido
                                        continue;
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
                                continue;
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
                                        continue;
                                    };
                                    break;

                                case 2:
                                    System.out.println("Novo status:");
                                    try{
                                    equipamento.setStatus(scanner.nextLine());
                                    } catch (InputMismatchException e) {
                                        System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                                        scanner.nextLine(); // descarta o valor inválido
                                        continue;
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
                                continue;
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
                                        continue;
                                    };
                                    break;

                                case 2:
                                    try{
                                        System.out.println("Novo CPF:");
                                        funcionario.setCpf(scanner.nextLine());
                                    } catch (InputMismatchException e) {
                                        System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                                        scanner.nextLine(); // descarta o valor inválido
                                        continue;
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
                                        continue;
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
                                        continue;
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
                                continue;
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
                                        continue;
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

                    break;
                case 3:
                    System.out.println("Em que tabela você deseja deletar um dado?");
                    System.out.print("Aluno [1]" + "\n" + "Equipamento [2]" + "\n" + "Funcionario [3]" + "\n" + "Treino [4]" + "\n");
                    try {
                        opcaoTabela = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                        scanner.nextLine();
                        break;
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
                    break;


                case 4:
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
                        break;
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
                break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
            ;

        } while (opcao != 0);

    }

    ;

};


