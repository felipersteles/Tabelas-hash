import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> disciplinas = new ArrayList<String>();
        disciplinas.add("ed2");
        disciplinas.add("es");

        Aluno<String> Malti = new Aluno(1234, "Malty", disciplinas);
        Aluno<String> Rodfode = new Aluno(4, "Rodfod", disciplinas);
        Aluno<String> canetazul = new Aluno(8, "canetazul", disciplinas);


        //Aluno<String> qualquer = criaAluno();

        //System.out.println("Nome do Aluno: " + qualquer.getNome()+ "\n" + "Nome da Matricula: " + qualquer.getMatricula() +"\n" + "Nome da(s) Diciplina(s): "+ qualquer.getCadeiras());

        Hash tabelaHash = new Hash(4);
        /*
        System.out.println("Insersao Linear:\n");
        tabelaHash.InserirValorLinear(Malti);
        tabelaHash.InserirValorLinear(Rodfode);
        tabelaHash.InserirValorLinear(canetazul);
        tabelaHash.InserirValorLinear(qualquer);
        System.out.println(tabelaHash);
        */
        System.out.println("Lista encadeada:\n");
        tabelaHash.InserirValorListaEncadeada(Malti);

        tabelaHash.InserirValorListaEncadeada(Rodfode);
        tabelaHash.InserirValorListaEncadeada(canetazul);
        //tabelaHash.print();
        System.out.println(tabelaHash.BuscarLinear(123));




    }


    private static Aluno< String> criaAluno() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o nome do Aluno:");
        String nome = scan.next();

        System.out.println("Digite a matrícula do Aluno:");
        Integer matricula = scan.nextInt();

        System.out.println("Inserir cadeiras do Aluno: ");
        System.out.println("Digite o numero de cadeiras: ");

        int num_cadeiras = scan.nextInt();

        ArrayList<String> cadeiras = new ArrayList<String>();


        System.out.println("Digite as diciplinas: ");


        for (int i = 0; i < num_cadeiras; i++) {

            String nome_cadeiras = scan.next();

            cadeiras.add(nome_cadeiras);
        }

        Aluno<String> novoAluno = new Aluno(matricula, nome, cadeiras);

        return novoAluno;
    }





}



