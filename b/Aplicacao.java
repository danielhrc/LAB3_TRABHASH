package aplicacao;
import hash.HashArvoreB;

import java.util.Scanner;

public class Aplicacao {
	public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
    	HashArvoreB hashArvoreB = new HashArvoreB();
       
        for(int i=0; i<30; i++) {
            final String chave = String.valueOf(i);
            final String valor = String.valueOf(i * 2);
            hashArvoreB.insere(chave, valor);
        }
        
        System.out.println("** Para cada chave 'k', o valor 'v' sera = (k * 2) **");
        System.out.println();
        System.out.println("Digite uma chave (0 < k < 30): ");
        
        String chave = input.next();
        System.out.println("\nValor para a chave(" + chave + ") : " + hashArvoreB.get(chave) );
    }
}
