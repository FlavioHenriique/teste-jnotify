

import net.contentobjects.jnotify.JNotify;
import net.contentobjects.jnotify.JNotifyException;
import net.contentobjects.jnotify.JNotifyListener;

import java.util.Properties;

public class App {
    public static void main(String[] args) {
        String path = "/home/flavio/compartilhada";
        int mask = JNotify.FILE_CREATED |
                JNotify.FILE_MODIFIED |
                JNotify.FILE_RENAMED |
                JNotify.FILE_DELETED;
        boolean watch = true;
        try {
            int watchID = JNotify.addWatch(path, mask, watch, new JNotifyListener() {
                public void fileCreated(int i, String s, String s1) {
                    System.out.println("Criou");
                }

                public void fileDeleted(int i, String s, String s1) {
                    System.out.println("deletou");
                }

                public void fileModified(int i, String s, String s1) {
                    System.out.println("alterou");
                }

                public void fileRenamed(int i, String s, String s1, String s2) {
                    System.out.println("renomeou");
                }
            });
        } catch (JNotifyException e) {
            e.printStackTrace();
        }
    }
}