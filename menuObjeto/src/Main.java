import java.util.ArrayList;

public class Main {

    private static ArrayList<Aluno> listaAlunos = new ArrayList<>();
    private static ArrayList<Turma> listaTurmas = new ArrayList<>();

    public static void main(String[] args) {
        menuPrincipal();
    }

    public static void menuPrincipal() {
        System.out.println("\n==== Secretaria ====");
        System.out.println("1 - Alunos");
        System.out.println("2 - Turmas");
        System.out.println("3 - Encerrar aplicação");
        String opcao = Leitura.dados("Digite a opção desejada: ");

        switch (opcao) {
            case "1":
                menuAlunos();
                break;

            case "2":
                menuTurmas();
                break;

            case "3":
                System.out.println("\n Até a próxima!");
                System.exit(0);
            default:
                System.out.printf("opção inválida! Tente novamente");
                menuPrincipal();

        }

    }

    private static void menuTurmas() {
        System.out.println("\n ==== TURMAS ====");
        System.out.println("1 - Listar Turmas");
        System.out.println("2 - Cadastrar Turma");
        System.out.println("3 - Atualizar Turma");
        System.out.println("4 - Excluir Turma");
        System.out.println("5 - Voltar ao menu principal");
        String opcao = Leitura.dados("Digite a opção desejada: ");
        switch (opcao) {
            case "1":
                listarTurmas();
                menuTurmas();
                break;
            case "2":
                cadastrarTurmas();
                menuTurmas();
                break;
            case "3":
                atualizarTurmas();
                menuTurmas();
                break;
            case "4":
                excluirTurmas();
                menuTurmas();
                break;
            case "5":
                menuPrincipal();
                break;
            default:
                System.out.printf("opção inválida! Tente novamente");
                menuTurmas();
        }
    }

    private static void menuAlunos() {
        System.out.println("\n==== ALUNOS ====");
        System.out.println("1 - Listar Alunos");
        System.out.println("2 - Cadastrar Aluno");
        System.out.println("3 - Atualizar Aluno");
        System.out.println("4 - Excluir Aluno");
        System.out.println("5 - Voltar ao menu principal");
        String opcao = Leitura.dados("Digite a opção desejada: ");

        switch (opcao) {
            case "1":
                listarAlunos();
                menuAlunos();
                break;
            case "2":
                cadastarAluno();
                menuAlunos();
                break;
            case "3":
                atualizarAluno();
                menuAlunos();
                break;
            case "4":
                excluirAlunos();
                menuAlunos();
                break;
            case "5":
                menuPrincipal();
                break;
            default:
                System.out.printf("opção inválida! Tente novamente");
                menuAlunos();
        }
    }

    private static void listarAlunos() {
        if (listaAlunos.isEmpty()) {
            System.out.println("Não exitem alunos cadastrados");
            return;
        }
        for (Aluno a : listaAlunos) {
            System.out.println(a);
        }

    }

    private static void cadastarAluno() {

    }

    private static void atualizarAluno() {

    }

    private static void excluirAlunos() {
    }


    private static void listarTurmas() {
        if (listaTurmas.isEmpty()) {
            System.out.println("Não exitem turmas cadastradas");
            return;
        }
        for (Turma t : listaTurmas) {
            System.out.println(t);
        }
    }

    private static void cadastrarTurmas() {
        Periodo periodo = validarPeriodo();
        String curso = Leitura.dados("Digite o curso: ");
            while(!isCharecter(curso)) {
                System.out.println("Nome inválido, não use números ou carecteres especiais.");
                curso = Leitura.dados("Digite o curso: ");
            }

        String sigla = Leitura.dados("Digite a sigla: ");
        boolean repetido = true;
        while(sigla.isBlank() || !repetido) {
            System.out.println("Sigla inválida");
            sigla = Leitura.dados("Digite a sigla: ");
            sigla = sigla.toUpperCase();

            for(Turma t : listaTurmas){
                if(t.getSigla().equals(sigla)) {
                    System.out.println("Turma já cadastrada.");
                    repetido = true;
                }
            }

            repetido = false;
        }






        Turma turma = new Turma(curso, sigla, periodo);



        listaTurmas.add(turma);
    }

    private static boolean isCharecter(String texto) {
        String cursoSemNumeros = texto.replaceAll("\\d", "");
        return !texto.isBlank() && texto.equals(cursoSemNumeros);
    }

    private static Periodo validarPeriodo() {
        String opcaoPeriodo = Leitura.dados(""" 
                Digite o número do periodo:
                1 - Matutino
                2 - Vespertino
                3 - Noturno
                4 - Integral""");
        switch (opcaoPeriodo) {
            case "1":
                return Periodo.MATUTINO;
            case "2":
                return Periodo.VESPERTINO;
            case "3":
                return Periodo.NOTURNO;
            case "4":
                return Periodo.INTEGRAL;
            default:
                System.out.println("Opção inválida, digite novamente");
                return validarPeriodo();
        }
    }


    private static void atualizarTurmas() {
    }

    private static void excluirTurmas() {

    }



}