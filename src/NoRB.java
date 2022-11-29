public class NoRB<Tipo> {
    //Atributos ----
    private NoRB<Tipo> esquerda, direita, pai;
    private Cor cor;
    private Tipo elemento; //valor
    private int chave;  //chave busca

    //Construtor -----

    public NoRB(){
        this.chave = chave;
        this.elemento = elemento;
        this.cor = Cor.preto;
        this.esquerda = null;
        this.direita = null;
    }

    // Métodos -----





    // Metodos Especiais

    public String toString() {
        return getElemento().toString();
    }
    public Tipo getElemento() {
        return this.elemento;
    }

    public int getChave() {
        return this.chave;
    }

    public NoRB getEsquerda(){
        return this.esquerda;
    }

    public NoRB setEsquerda(NoRB esquerda) {
        this.esquerda = esquerda;
        return esquerda;
    }

    public NoRB getDireita(){
        return this.direita;
    }

    public NoRB setDireita(NoRB direita) {
        this.direita = direita;
        return direita;
    }
    public NoRB getPai(){
        return this.pai;
    }

    public NoRB setPai(NoRB pai) {
        this.pai = pai;
        return pai;
    }

}

