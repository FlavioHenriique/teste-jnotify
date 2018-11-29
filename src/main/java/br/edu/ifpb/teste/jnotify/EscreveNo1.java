package br.edu.ifpb.teste.jnotify;

import br.edu.ifpb.teste.jnotify.protocolo.Comunicacao;
import br.edu.ifpb.teste.jnotify.protocolo.ComunicacaoIMPL;
import br.edu.ifpb.teste.jnotify.protocolo.Notificacoes;
import java.util.Scanner;

public class EscreveNo1 {

    private static Comunicacao comunicacao;

    public static void main(String[] args) {
        String arquivo1 = "/home/flavio/compartilhada/arquivo1.txt";
        String arquivo2 = "/home/flavio/compartilhada2/arquivo2.txt";

        Notificacoes notificacoes = new Notificacoes(arquivo1, arquivo2);
        notificacoes.start();

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
