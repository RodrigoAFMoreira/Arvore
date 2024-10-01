package formativa;

/**
 *
 *
 * @author RAFMo
 */

class No {

    int info;
    No esquerda;
    No direita;

    public No(int info) {
        this.info = info;
        this.esquerda = null;
        this.direita = null;
    }
}

public class ArvoreBinaria {

    private No raiz;
    
    public ArvoreBinaria() {
        this.raiz = null;
    }

    // inserir um novo valor na árvore
    public void inserirNo(int valor) {
        raiz = inserirNo(raiz, valor);  
    }

    private No inserirNo(No atual, int valor) {
        if (atual == null) {
            return new No(valor);  
        }
        if (valor < atual.info) {
            atual.esquerda = inserirNo(atual.esquerda, valor);  
        } else if (valor > atual.info) {
            atual.direita = inserirNo(atual.direita, valor);  
        }
        return atual;  
    }

    // raiz, esquerda, direita
    public void percorrerPreOrdem() {
        preOrdem(raiz);  
        System.out.println();  
    }

    private void preOrdem(No no) {
        if (no != null) {
            System.out.print(no.info + " ");  
            preOrdem(no.esquerda); 
            preOrdem(no.direita);  
        }
    }

    // esquerda, raiz, direita
    public void percorrerInOrdem() {
        inOrdem(raiz);  
        System.out.println();
    }


    private void inOrdem(No no) {
        if (no != null) {
            inOrdem(no.esquerda);  
            System.out.print(no.info + " ");  
            inOrdem(no.direita);  
        }
    }

    // esquerda, direita, raiz
    public void percorrerPosOrdem() {
        posOrdem(raiz);  
        System.out.println();  
    }


    private void posOrdem(No no) {
        if (no != null) {
            posOrdem(no.esquerda);  
            posOrdem(no.direita);  
            System.out.print(no.info + " ");  
        }
    }

    public void removerMaiorValor() {
        raiz = removerMaiorValor(raiz);  
    }

    private No removerMaiorValor(No atual) {
        if (atual == null) {
            return null; 
        }
        if (atual.direita == null) {
            return atual.esquerda;  
        }
        atual.direita = removerMaiorValor(atual.direita);  
        return atual;  
    }

    public void removerMenorValor() {
        raiz = removerMenorValor(raiz);  
    }

    private No removerMenorValor(No atual) {
        if (atual == null) {
            return null;  
        }
        if (atual.esquerda == null) {
            return atual.direita; 
        }
        atual.esquerda = removerMenorValor(atual.esquerda);  
        return atual;  
    }

    public void removerPorValor(int valor) {
        raiz = removerPorValor(raiz, valor);  
    }

    private No removerPorValor(No atual, int valor) {
        if (atual == null) {
            return null;  
        }

        if (valor < atual.info) {
            atual.esquerda = removerPorValor(atual.esquerda, valor); 
        } else if (valor > atual.info) {
            atual.direita = removerPorValor(atual.direita, valor);  
        } else {
            if (atual.esquerda == null) {
                return atual.direita;  
            } else if (atual.direita == null) {
                return atual.esquerda;  
            }
            atual.info = encontrarMenorValor(atual.direita);
            atual.direita = removerPorValor(atual.direita, atual.info);
        }
        return atual;  
    }

    private int encontrarMenorValor(No atual) {
        int menorValor = atual.info;
        while (atual.esquerda != null) {
            menorValor = atual.esquerda.info;
            atual = atual.esquerda;
        }
        return menorValor;
    }

public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        int[] valores = {14, 15, 4, 9, 7, 18, 3, 5, 16, 20, 17, 9, 5};

        for (int valor : valores) {
            arvore.inserirNo(valor);
        }

        System.out.println("In-Ordem: ");
        arvore.percorrerInOrdem();

        System.out.println("Pré-Ordem: ");
        arvore.percorrerPreOrdem();

        System.out.println("Pós-Ordem: ");
        arvore.percorrerPosOrdem();

        System.out.println("Remover o maior elemento . . .");
        arvore.removerMaiorValor();
        arvore.percorrerInOrdem();

        System.out.println("Remover o menor elemento. . .");
        arvore.removerMenorValor();
        arvore.percorrerInOrdem();

        System.out.println("Remover o elemento 16 . . .");
        arvore.removerPorValor(16);
        arvore.percorrerInOrdem();
    }
}
