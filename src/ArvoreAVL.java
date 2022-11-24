
/*
*  Quando uma árvore binária de busca está balanceada ela é chamada de Árvore AVL
*  Uma árvore é balanceada quando as alturas dass sub arvores direita e esquerda
*  de cada nó da árvore diferem de no máximo UMA unidade
*/

public class ArvoreAVL<Tipo> {
    private NoAVL<Tipo> raiz;

    ArvoreAVL(){
        System.out.println("Árvore iniciada");
    }

    public void inserir(int chave, Tipo k) {
        NoAVL novoNo = new NoAVL(chave, k);
        inserirAVL(this.raiz, novoNo);
    }

    private void inserirAVL(NoAVL aComparar, NoAVL aInserir) {

        if (aComparar == null) {
            this.raiz = aInserir;
        }else{
            if (aInserir.getChave() < aComparar.getChave()) {
                // System.out.println("chegou aqui com"+aInserir.getChave() +" e "+aComparar.getChave());
                if (aComparar.getEsquerda() == null) {
                    aComparar.setEsquerda(aInserir);
                    aInserir.setPai(aComparar);
                    verificarBalanceamento(aComparar);
                } else {
                    inserirAVL(aComparar.getEsquerda(), aInserir);
                }

            } else if (aInserir.getChave() > aComparar.getChave()) {

                if (aComparar.getDireita() == null) {
                    aComparar.setDireita(aInserir);
                    aInserir.setPai(aComparar);
                    verificarBalanceamento(aComparar);
                } else {
                    inserirAVL(aComparar.getDireita(), aInserir);
                }

            } else {
                // O nó já existe
            }
        }
    }

    private void verificarBalanceamento(NoAVL atual) {
        setBalanceamento(atual);
        int balanceamento = atual.getAltura();

        if (balanceamento == -2) {

            if (altura(atual.getEsquerda().getEsquerda()) >= altura(atual.getEsquerda().getDireita())) {
                atual = rotacaoDireita(atual);

            } else {
                atual = duplaRotacaoEsquerdaDireita(atual);
            }

        } else if (balanceamento == 2) {

            if (altura(atual.getDireita().getDireita()) >= altura(atual.getDireita().getEsquerda())) {
                atual = rotacaoEsquerda(atual);

            } else {
                atual = duplaRotacaoDireitaEsquerda(atual);
            }
        }

        if (atual.getPai() != null) {
            verificarBalanceamento(atual.getPai());
        } else {
            this.raiz = atual;
        }
    }

    private NoAVL rotacaoEsquerda(NoAVL inicial) {

        NoAVL direita = inicial.getDireita();
        direita.setPai(inicial.getPai());

        inicial.setDireita(direita.getEsquerda());

        if (inicial.getDireita() != null) {
            inicial.getDireita().setPai(inicial);
        }

        direita.setEsquerda(inicial);
        inicial.setPai(direita);

        if (direita.getPai() != null) {

            if (direita.getPai().getDireita() == inicial) {
                direita.getPai().setDireita(direita);

            } else if (direita.getPai().getEsquerda() == inicial) {
                direita.getPai().setEsquerda(direita);
            }
        }

        setBalanceamento(inicial);
        setBalanceamento(direita);

        return direita;
    }

    private NoAVL rotacaoDireita(NoAVL inicial) {

        NoAVL esquerda = inicial.getEsquerda();
        esquerda.setPai(inicial.getPai());

        inicial.setEsquerda(esquerda.getDireita());

        if (inicial.getEsquerda() != null) {
            inicial.getEsquerda().setPai(inicial);
        }

        esquerda.setDireita(inicial);
        inicial.setPai(esquerda);

        if (esquerda.getPai() != null) {

            if (esquerda.getPai().getDireita() == inicial) {
                esquerda.getPai().setDireita(esquerda);

            } else if (esquerda.getPai().getEsquerda() == inicial) {
                esquerda.getPai().setEsquerda(esquerda);
            }
        }

        setBalanceamento(inicial);
        setBalanceamento(esquerda);

        return esquerda;
    }

    private NoAVL duplaRotacaoEsquerdaDireita(NoAVL inicial) {
        inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
        return rotacaoDireita(inicial);
    }

    private NoAVL duplaRotacaoDireitaEsquerda(NoAVL inicial) {
        inicial.setDireita(rotacaoDireita(inicial.getDireita()));
        return rotacaoEsquerda(inicial);
    }

    private int altura(NoAVL atual) {
        if (atual == null) {
            return -1;
        }

        if (atual.getEsquerda() == null && atual.getDireita() == null) {
            return 0;

        } else if (atual.getEsquerda() == null) {
            return 1 + altura(atual.getDireita());

        } else if (atual.getDireita() == null) {
            return 1 + altura(atual.getEsquerda());

        } else {
            return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
        }
    }

    private void setBalanceamento(NoAVL no) {
        no.setAltura(altura(no.getDireita()) - altura(no.getEsquerda()));
    }

    //print stuffs
    public String toString() {              // Sobrescreve o metodo toString
        String out = "Raiz->";                    // Cria uma string vazia para retorno
        NoAVL no = raiz;
        out += prefixado(no);

        return out;                         // Retorna a string
    }

    public String prefixado(NoAVL no) {
        String out = "";
        if(no != null){
            out += no.getElemento();
            if(no.getEsquerda() != null) out+=" Esquerda é " + no.getEsquerda().getElemento();
            if(no.getDireita() != null) out+=" Direita é " + no.getDireita().getElemento();

            out += "\n";
            out += prefixado(no.getEsquerda());
            out += prefixado(no.getDireita());
        }

        return out;
    }
}