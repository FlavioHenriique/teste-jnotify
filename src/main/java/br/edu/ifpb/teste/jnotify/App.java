package br.edu.ifpb.teste.jnotify;

import net.contentobjects.jnotify.JNotify;
import net.contentobjects.jnotify.JNotifyException;
import net.contentobjects.jnotify.JNotifyListener;

public class App {

    public static void main(String[] args) {

        String path = "/home/flavio/compartilhada";

        int mask = JNotify.FILE_CREATED
                | JNotify.FILE_MODIFIED
                | JNotify.FILE_RENAMED
                | JNotify.FILE_DELETED;
        boolean watch = true;

        try {

            int watchID = JNotify.addWatch(path, mask, watch, new JNotifyListener() {
                public void fileCreated(int i, String s, String s1) {
                    System.out.println("Arquivo criado: " + s1);
                }

                public void fileDeleted(int i, String s, String s1) {
                    System.out.println("Arquivo deletado: " + s1);
                }

                public void fileModified(int i, String s, String s1) {
                    System.out.println("Arquivo modificado: " + s1);
                }

                public void fileRenamed(int i, String s, String s1, String s2) {
                    System.out.println("Arquivo renomeado: " + s2);
                }
            });
            while (true) {

            }

        } catch (JNotifyException e) {
            e.printStackTrace();
        }

    }

}
