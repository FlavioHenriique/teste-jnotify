package br.edu.ifpb.teste.jnotify;

import br.edu.ifpb.teste.jnotify.protocolo.Comunicacao;
import br.edu.ifpb.teste.jnotify.protocolo.ComunicacaoIMPL;
import net.contentobjects.jnotify.JNotify;
import net.contentobjects.jnotify.JNotifyException;
import net.contentobjects.jnotify.JNotifyListener;

public class App {

    private static String arquivo1 = "/home/flavio/compartilhada/arquivo1.txt";
    private static String arquivo2 = "/home/flavio/compartilhada2/arquivo2.txt";
    private static Comunicacao comunicacao;

    public static void main(String[] args) {

        comunicacao = new ComunicacaoIMPL(arquivo1, arquivo2);

        int mask = JNotify.FILE_CREATED
                | JNotify.FILE_MODIFIED
                | JNotify.FILE_RENAMED
                | JNotify.FILE_DELETED;
        boolean watch = true;

        try {

            int watchID = JNotify.addWatch(arquivo1, mask, watch, new JNotifyListener() {
                public void fileCreated(int i, String s, String s1) {
                    System.out.println("Arquivo criado: " + s1);
                }

                public void fileDeleted(int i, String s, String s1) {
                    System.out.println("Arquivo deletado: " + s1);
                }

                public void fileModified(int i, String s, String s1) {
                    System.out.println("Modificação do arquivo: " + comunicacao.receber());
                }

                public void fileRenamed(int i, String s, String s1, String s2) {
                    System.out.println("Arquivo renomeado: " + s2);
                }
            });
            System.out.println("Monitorando a pasta ...");
            while (true) {

            }

        } catch (JNotifyException e) {
            e.printStackTrace();
        }

    }

}
