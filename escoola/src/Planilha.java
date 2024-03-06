import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Planilha {
    private List<Aluno> alunos;
    private Map<Aluno, Map<String, Double>> notas;
    private Map<Aluno, String> datasMatricula;

    public Planilha() {
        this.alunos = new ArrayList<>();
        this.notas = new HashMap<>();
        this.datasMatricula = new HashMap<>();
    }

    public void registrarAluno(Aluno aluno, String dataMatricula) {
        alunos.add(aluno);
        notas.put(aluno, new HashMap<>());
        datasMatricula.put(aluno, dataMatricula);
    }

    public void adicionarNota(Aluno aluno, String disciplina, double nota) {
        notas.get(aluno).put(disciplina, nota);
    }

    public double getNota(Aluno aluno, String disciplina) {
        return notas.get(aluno).getOrDefault(disciplina, 0.0);
    }

    public String getDataMatricula(Aluno aluno) {
        return datasMatricula.get(aluno);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void imprimirPlanilha() {
        System.out.println("#-------------------------------------------------#");
        System.out.println("|                PLANILHA DE ALUNOS               |");
        System.out.println("#-------------------------------------------------#");
        System.out.printf("| %-14s| %-11s| %-20s|\n", "Nome", "Matrícula", "Matrícula Ativa");
        System.out.println("#-------------------------------------------------#");
        for (Aluno aluno : alunos) {
            System.out.printf("| %-14s| %-11s| %-20s|\n", aluno.getNome(), aluno.getMatricula(), aluno.isMatriculaAtiva() ? "Sim" : "Não");
            System.out.println("#---------------|------------|----------------------#");
            System.out.printf("| %-14s| %-11s|\n", "Disciplinas", "Nota");
            System.out.println("#---------------|------------|----------------------#");
            for (Map.Entry<String, Double> entry : notas.get(aluno).entrySet()) {
                System.out.printf("| %-14s| %-11s|\n", entry.getKey(), entry.getValue());
            }
            System.out.println("#-------------------------------------------------#");
        }
        System.out.println("| Fim da Planilha                                 |");
        System.out.println("#-------------------------------------------------#");
    }
}
