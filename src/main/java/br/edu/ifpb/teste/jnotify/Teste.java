package br.edu.ifpb.teste.jnotify;

import br.edu.ifpb.teste.jnotify.protocolo.Comunicacao;
import br.edu.ifpb.teste.jnotify.protocolo.ComunicacaoIMPL;
import java.util.Scanner;

public class Teste {

    private static Comunicacao comunicacao;

    public static void main(String[] args) {
        String arquivo1 = "/home/flavio/compartilhada/arquivo1.txt";
        String arquivo2 = "/home/flavio/compartilhada2/arquivo2.txt";

        comunicacao = new ComunicacaoIMPL(arquivo1, arquivo2);
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
