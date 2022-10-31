import java.util.*;


public class Aluno<Tipo2> {

    private int matricula;
    private Tipo2 nome;
    private ArrayList<String> cadeiras;

    Aluno(int matricula, Tipo2 nome, ArrayList<String> cadeiras){ //construtor do objeto
        this.matricula = matricula; //this referencia o atributo da classe (atributo superior)
        this.nome = nome;
        this.cadeiras = cadeiras;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public Tipo2 getNome() {
        return this.nome;
    }

    public ArrayList<String> getCadeiras() {
        return cadeiras;
    }

    public void ChangeNome(Tipo2 novoNome){
        this.nome = novoNome;
    }
    public String toString() {
        String out = "";

        out += this.nome + " " + this.matricula + " " + this.cadeiras;

        return out;
    }
}