package br.edu.ifpb.teste.jnotify;

import br.edu.ifpb.teste.jnotify.protocolo.Comunicacao;
import br.edu.ifpb.teste.jnotify.protocolo.ComunicacaoIMPL;
import java.util.Scanner;

public class EscreveNo2 {

    private static Comunicacao comunicacao;

    public static void main(String[] args) {
        String arquivo1 = "/run/user/1000/gvfs/smb-share:server=matheus-inspiron-5566.local,share=compartilhada/matheus.txt";
        String arquivo2 = "/home/flavio/ADS/compart/flavio.txt";

        comunicacao = new ComunicacaoIMPL(arquivo2, arquivo1);
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
