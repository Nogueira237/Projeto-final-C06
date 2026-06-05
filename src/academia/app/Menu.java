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

        // Criação de classes Menu
        MenuInsert menuInsert = new MenuInsert();
        MenuUpdate menuUpdate = new MenuUpdate();
        MenuDelete menuDelete = new MenuDelete();
        MenuSelect menuSelect = new MenuSelect();


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
                    menuInsert.executar(scanner);
                    break;

                case 2:     // Atualiza dados
                    menuUpdate.executar(scanner);
                    break;

                case 3:
                    menuDelete.executar(scanner);
                    break;

                case 4:
                    menuSelect.executar(scanner);
                    break;

                default:
                    if(opcao != 0)System.out.println("Opção inválida.");
                    break;
            }
            ;

        } while (opcao != 0);
    };

};


