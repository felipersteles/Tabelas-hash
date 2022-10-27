import java.util.ArrayList;

public class Aluno<Tipo1 extends Number, Tipo2> {

    private Tipo1 matricula;
    private Tipo2 nome;
    private ArrayList<String> cadeiras;

    Aluno(Tipo1 matricula, Tipo2 nome, ArrayList<String> cadeiras){ //construtor do objeto
        this.matricula = matricula; //this referencia o atributo da classe (atributo superior)
        this.nome = nome;
        this.cadeiras = cadeiras;
    }

    public Tipo1 getMatricula() {
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
}