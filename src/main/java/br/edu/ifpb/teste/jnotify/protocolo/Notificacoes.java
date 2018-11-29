package br.edu.ifpb.teste.jnotify.protocolo;

import net.contentobjects.jnotify.JNotify;
import net.contentobjects.jnotify.JNotifyException;
import net.contentobjects.jnotify.JNotifyListener;

public class Notificacoes extends Thread {

    private Comunicacao comunicacao;
    private String arquivo1;
    private String arquivo2;

    public Notificacoes(String arquivo1, String arquivo2) {
        this.arquivo1 = arquivo1;
        this.arquivo2 = arquivo2;
    }

    @Override
    public void run() {
        notificar();
    }

    public void notificar() {
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
                    comunicacao.receber();
                }

                public void fileRenamed(int i, String s, String s1, String s2) {
                    System.out.println("Arquivo renomeado: " + s2);
                }
            });
            System.out.println("Monitorando o arquivo " + arquivo1);
            while (true) {

            }

        } catch (JNotifyException e) {
            e.printStackTrace();
        }

    }

}
