package hash;
import java.util.Scanner;

import arvore.ArvoreB;

public class HashArvoreB {
    private static int TAMANHO = 3;
    private Celula[] tabela = new Celula[TAMANHO];
    
    public void insere(String chave, String valor) {
        int hash = getHash(chave);
        final Celula entrada = new Celula(chave, valor);
        
        if(tabela[hash] == null) {
            tabela[hash] = entrada;
        }
        
        else {
            Celula temp = tabela[hash];
            if (temp.arvore.vazia()) {
            	temp.arvore.insere(chave, valor);
            }
            else
            	temp.arvore.insere(chave, valor);
        }
    }

    public String get(String chave) {
        int hash = getHash(chave);
        if(tabela[hash] != null) {
            Celula temp = tabela[hash];
            
            if (temp.chave == chave) return temp.valor;
            else if (!temp.arvore.vazia()) return temp.arvore.get(chave).toString();
        }

        return null;
    }

    private int getHash(String key) {
        return key.hashCode() % TAMANHO;
    }

    public static class Celula {
        String chave;
        String valor;
        ArvoreB arvore;

        public Celula(String chave, String valor) {
            this.chave = chave;
            this.valor = valor;
            this.arvore = new ArvoreB();
        }
    }
}