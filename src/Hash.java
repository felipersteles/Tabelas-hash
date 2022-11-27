import java.lang.reflect.Array;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;

public class Hash<Tipo> {

    // Funcao Hash Linear
    //      h(x) = x % m
    // Quando colidir
    //      h'(x) = ( h(x) + j ) % m  ---> para j = 1
    int operador; // chave/valor
    Tipo[] vetor;
    Lista<Tipo>[] lista; //lista do tipo Tipo
    ArvoreAVL<Tipo>[] arvoreAVL;     //array<Tipo> de arvoreAVL

    //Criar Tabela atraves de um construtor de classe
    Hash(int operador){

        this.operador = operador;
        vetor = (Tipo[]) new Object[operador];
                            //Objeto generaliza o Tipo[] para o Tipo que quisermos passar
        //cria lista
        lista = new Lista[operador];
        for (int i = 0; i < operador; i++) lista[i] = new Lista<Tipo>();

        //criar arvoreAvl
        arvoreAVL = new ArvoreAVL[operador];
        // para cada posição do array cria-se um no de arvoreAVL
        for ( int i = 0; i < operador; i++) arvoreAVL[i] = new ArvoreAVL<Tipo>();
    }

    Hash(Tipo valor){
        //vetor possui valores?
        if(vetor!=null){

        }else {
            System.out.println("Vetor não existe");
            this.operador = 37;
            vetor = (Tipo[]) new Object[this.operador];

            InserirValorLinear((Tipo)valor);
        }
    }

    void InserirValorLinear(Tipo valor) {

        Aluno aluno = (Aluno)valor;


        int chave = this.getMatricula(aluno) % this.operador;

        //converter aluno para Tipo;
        if (vetor[chave] != null) {
            int i = chave + 1;

            while (i < vetor.length) {
                if (vetor[i] == null) {
                    vetor[i] = (Tipo) aluno;
                    return;
                } else {
                    i++;
                }
            }
            InserirValorListaEncadeada(aluno);
        }else{
            vetor[chave] = (Tipo) aluno;
        }
    }

    //Poderia ser um tipo Aluno em vez de "Tipo", mas nós estamos fazendo no vetor um Aluno como tipo "Tipo"
    Tipo BuscarLinear(int codigo){

        Tipo perdido;

        Aluno aluno;
        int chave = codigo % this.operador;

        int i = chave;
        while (i < vetor.length) {
            aluno = (Aluno) vetor[i];
            if (aluno.getMatricula() == codigo) {
                perdido = (Tipo) aluno;
                return perdido;
            } else {
                i++;
            }
        }
        perdido = BuscarListaEncadeada(codigo);
        if(perdido == null){
            perdido = BuscaArvoreAVL(codigo);
        }
        return perdido;
    }

    public void InserirArvoreAVL(int codigo, Tipo novo){
        arvoreAVL[ codigo%operador ].inserir(codigo,novo);
    }

    Tipo BuscaArvoreAVL(int codigo){
        NoAVL<Tipo> raiz = arvoreAVL[codigo%operador].getRaiz();
        return arvoreAVL[codigo%operador].BuscaAVL( codigo, raiz );
    }

    Tipo BuscarListaEncadeada(int codigo){
        return (Tipo)lista[codigo % this.operador].buscar(codigo);
    }
    void print(){
        System.out.println(this.vetor);
    }

    public String toString() {
        String out = "";
        for(int i = 0; i < operador; i++) {
            out += "" + i + ": ";
            out += vetor[i % operador] + " ";
            out += lista[i % operador] + "\n";
        }
        return out;
    }

    void InserirValorListaEncadeada(Aluno aluno) {

        int chave = aluno.getMatricula() % this.operador;
        lista[chave].inserir((Tipo)aluno);
    }

    void InserirValorArvoreAVL(Tipo valor){
        //Criando arvoreAVL para inserir
        ArvoreAVL<Tipo> arvoreAVL = new ArvoreAVL<Tipo>();

        //Valor do tipo aluno que sera inserido na arvoreAVL
        Aluno aluno = (Aluno) valor;

        arvoreAVL.inserir(aluno.getMatricula(), valor);
    }


    public int getMatricula(Aluno aluno) {return aluno.getMatricula();}

}
