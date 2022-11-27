
public class NoAVL<Tipo> {
    private NoAVL<Tipo> esquerda;
    private NoAVL<Tipo> direita;
    private NoAVL<Tipo> pai;
    private Tipo elemento;
    private int chave;
    private int altura;

    NoAVL(int chave, Tipo el){
        this.chave = chave;
        this.elemento = el;
        this.esquerda = null;
        this.direita = null;
    }
    //constutor copia
    NoAVL(int chave, Tipo el, NoAVL esq, NoAVL dir){
        this.elemento = el;
        this.esquerda = esq;
        this.direita = dir;
        this.altura = 0;
        this.chave = chave;
    }

    public String toString() {
        return getElemento().toString();
    }

    public Tipo getElemento() {
        return this.elemento;
    }
    public int getChave() {
        return this.chave;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    public int getAltura() {
        return this.altura;
    }


    public NoAVL setEsquerda(NoAVL esquerda) {
        this.esquerda = esquerda;
        return esquerda;
    }
    public NoAVL getEsquerda(){
        return this.esquerda;
    }

    public NoAVL setDireita(NoAVL direita) {
        this.direita = direita;
        return direita;
    }
    public NoAVL getDireita(){
        return this.direita;
    }

    public NoAVL setPai(NoAVL pai) {
        this.pai = pai;
        return pai;
    }
    public NoAVL getPai(){
        return this.pai;
    }
}