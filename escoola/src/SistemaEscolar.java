import java.util.Scanner;

public class SistemaEscolar {
    private static Scanner scanner = new Scanner(System.in);
    private static Escola escola = new Escola();
    private static Planilha planilha = new Planilha();

    public static void main(String[] args) {
        System.out.println("### Bem-vindo ao Sistema Escolar ###");

        while (true) {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1. Cadastrar aluno");
            System.out.println("2. Verificar lista de alunos e notas");
            System.out.println("3. Adicionar nota");
            System.out.println("4. Trancar matrícula");
            System.out.println("5. Destancar matrícula");
            System.out.println("6. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    verificarListaAlunos();
                    break;
                case 3:
                    adicionarNota();
                    break;
                case 4:
                    trancarMatricula();
                    break;
                case 5:
                    destrancarMatricula();
                    break;
                case 6:
                    System.out.println("Saindo do Sistema Escolar. Até logo!");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarAluno() {
        System.out.println("\nDigite o nome do aluno:");
        String nome = scanner.nextLine();
        System.out.println("Digite a matrícula do aluno:");
        String matricula = scanner.nextLine();
        System.out.println("Digite a data de matrícula do aluno:");
        String dataMatricula = scanner.nextLine();

        Aluno aluno = new Aluno(nome, matricula);
        escola.registrarAluno(aluno);
        planilha.registrarAluno(aluno, dataMatricula);

        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void verificarListaAlunos() {
        planilha.imprimirPlanilha();
    }

    private static void adicionarNota() {
        System.out.println("\nDigite a matrícula do aluno:");
        String matricula = scanner.nextLine();
        Aluno aluno = escola.buscarAluno(matricula);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.println("Digite a disciplina:");
        String disciplina = scanner.nextLine();
        System.out.println("Digite a nota:");
        double nota;
        try {
            nota = scanner.nextDouble();
            scanner.nextLine(); // Limpar o buffer do scanner
        } catch (Exception e) {
            System.out.println("Nota inválida. Certifique-se de digitar um número válido.");
            return;
        }

        aluno.adicionarNota(disciplina, nota);
        planilha.adicionarNota(aluno, disciplina, nota);
        System.out.println("Nota adicionada com sucesso para o aluno " + aluno.getNome());
    }

    private static void trancarMatricula() {
        System.out.println("\nDigite a matrícula do aluno:");
        String matricula = scanner.nextLine();
        Aluno aluno = escola.buscarAluno(matricula);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        aluno.trancarMatricula();
        System.out.println("Matrícula do aluno " + aluno.getNome() + " foi trancada.");
    }

    private static void destrancarMatricula() {
        System.out.println("\nDigite a matrícula do aluno:");
        String matricula = scanner.nextLine();
        Aluno aluno = escola.buscarAluno(matricula);

        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        aluno.destrancarMatricula();
        System.out.println("Matrícula do aluno " + aluno.getNome() + " foi destrancada.");
    }
}
