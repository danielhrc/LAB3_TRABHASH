
import java.io.*;
import java.util.*;
import java.util.logging.*;

public class Teste {
    public static void main(String[]args){
        
        String nomeArquivo = new String("");
        carregarDadosNasEstruturas(nomeArquivo);

        
    }
    public static void carregarDadosNasEstruturas(String nomeArquivo){
        File arquivo = new File(nomeArquivo);
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
            Inserivel dados[] = new Inserivel[3];
           //dados[0] = new HashLinear();
            //dados[1] = new HashArvoreB();
            //dados[2] = new HashArvoreBMais();
            String linha;
            while((linha = leitor.readLine()) != null ){
                Integer i = Integer.parseInt(linha);
                for (Inserivel hash : dados) {
                    hash.insere(i);
                }
            }
	    leitor.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
