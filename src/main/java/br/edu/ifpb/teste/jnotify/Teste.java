package br.edu.ifpb.teste.jnotify;

import br.edu.ifpb.teste.jnotify.protocolo.Comunicacao;
import br.edu.ifpb.teste.jnotify.protocolo.ComunicacaoIMPL;
import java.util.Scanner;

public class Teste {
    
    private static Comunicacao comunicacao;
    
    public static void main(String[] args) {
        
        comunicacao = new ComunicacaoIMPL();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Digite a mensagem:");
            String msg = scanner.next();
            if (!msg.equalsIgnoreCase("exit")) {
                comunicacao.enviar(msg);
            } else {
                System.exit(0);
            }
        }
        
    }
}
