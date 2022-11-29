public class ArvoreRB<Tipo> {

    private NoRB<Tipo> raiz, nulo;

    public ArvoreRB(){
        nulo = new NoRB();
        raiz = nulo; //variavel nulo = cor preta
    }

    void rotacaoEsquerda(NoRB inicial){

        NoRB direita = inicial.getDireita();  //No direita =  filho direito do inicial

        inicial.setPai(inicial.getPai()) ;//O filho do inicial a direita -> Recebe o pai do inicial como seu pai

        inicial.setDireita(direita.getEsquerda()); //Inicial direita recebe no filho

        if (inicial.getDireita() != null){
            inicial.getDireita().
        }

    }
}
