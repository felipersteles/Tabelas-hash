import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> disciplinas = new ArrayList<String>();
        disciplinas.add("ed2");
        disciplinas.add("es");

        Aluno<Integer, String> Rodrigo = new Aluno(123, "rodrigo", disciplinas);

        System.out.println("Nome do aluno: " + Rodrigo.getNome());
    }

    private static void criaAluno(){
        Scanner scan = new Scanner(System.in);

        System.out.println();
    }
}