package academia.util;

import academia.pessoas.Aluno;

public class RelatorioAluno {

    // Metodos
    public void gerarRelatorio(Aluno aluno){                // gera um relatorio com todos os atributos do aluno
        System.out.println("===== RELATÓRIO DO ALUNO =====");
        System.out.println("Nome: " + aluno.getNome() + '\n' + "CPF: " + aluno.getCpf() + '\n' + "Idade: " + aluno.getIdade() + '\n' + "Plano: " + aluno.getPlano().getTipo() + '\n' + "IMC: "
                + aluno.calcularIMC() + '\n' + "Forma de pagamento: " + aluno.getPagamento().getTipo() + '\n' + "==============================");
    };

}
