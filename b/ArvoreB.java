package arvore;
public class ArvoreB<Chave extends Comparable<Chave>, Valor>  {
    private static final int M = 4;

    private Pagina raiz;       
    private int altura;      
    private int n;           

    private static final class Pagina {
        private int m;              
        private Nodo[] filhos = new Nodo[M]; 

        private Pagina(int k) {
            m = k;
        }
    }

    private static class Nodo {
        private Comparable chave;
        private final Object valor;
        private Pagina prox;   
        public Nodo(Comparable chave, Object valor, Pagina prox) {
            this.chave  = chave;
            this.valor  = valor;
            this.prox = prox;
        }
    }

    public ArvoreB() {
        raiz = new Pagina(0);
    }
 
    public boolean vazia() {
        return tamanho() == 0;
    }

    public int tamanho() {
        return n;
    }

    public int alturaArvore() {
        return altura;
    }

    public Valor get(Chave chave) {
        if (chave == null) throw new IllegalArgumentException("argument to get() is null");
        return pesquisa(raiz, chave, altura);
    }

    private Valor pesquisa(Pagina x, Chave chave, int altura) {
        Nodo[] filhos = x.filhos;

        if (altura == 0) {
            for (int j = 0; j < x.m; j++) {
                if (igual(chave, filhos[j].chave)) return (Valor) filhos[j].valor;
            }
        }

        else {
            for (int j = 0; j < x.m; j++) {
                if (j+1 == x.m || menor(chave, filhos[j+1].chave))
                    return pesquisa(filhos[j].prox, chave, altura-1);
            }
        }
        return null;
    }

    public void insere(Chave chave, Valor valor) {
        if (chave == null) 
        	throw new IllegalArgumentException("O argumento nao pode ser null!");
        Pagina u = insere(raiz, chave, valor, altura); 
        n++;
        if (u == null) return;

        Pagina t = new Pagina(2);
        t.filhos[0] = new Nodo(raiz.filhos[0].chave, null, raiz);
        t.filhos[1] = new Nodo(u.filhos[0].chave, null, u);
        raiz = t;
        altura++;
    }

    private Pagina insere(Pagina h, Chave chave, Valor valor, int altura) {
        int j;
        Nodo t = new Nodo(chave, valor, null);

        if (altura == 0) {
            for (j = 0; j < h.m; j++) {
                if (menor(chave, h.filhos[j].chave)) break;
            }
        }

        else {
            for (j = 0; j < h.m; j++) {
                if ((j+1 == h.m) || menor(chave, h.filhos[j+1].chave)) {
                    Pagina u = insere(h.filhos[j++].prox, chave, valor, altura-1);
                    if (u == null) return null;
                    t.chave = u.filhos[0].chave;
                    t.prox = u;
                    break;
                }
            }
        }

        for (int i = h.m; i > j; i--)
            h.filhos[i] = h.filhos[i-1];
        
        h.filhos[j] = t;
        h.m++;
        
        if (h.m < M) 
        	return null;
        else         
        	return split(h);
    }

    private Pagina split(Pagina h) {
        Pagina t = new Pagina(M/2);
        h.m = M/2;
        for (int j = 0; j < M/2; j++)
            t.filhos[j] = h.filhos[M/2+j]; 
        return t;    
    }

    private boolean menor(Comparable chave_1, Comparable chave_2) {
        return chave_1.compareTo(chave_2) < 0;
    }

    private boolean igual(Comparable chave_1, Comparable chave_2) {
        return chave_1.compareTo(chave_2) == 0;
    }
}