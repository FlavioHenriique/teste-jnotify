package br.edu.ifpb.teste.jnotify.protocolo;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class ComunicacaoIMPL implements Comunicacao {

    //-Djava.library.path=/home/flavio/Downloads/jnotify-lib-0.94/

    
    private String arquivo1 = "/home/flavio/compartilhada/arquivo1.txt";
    private String arquivo2 = "/home/flavio/compartilhada2/arquivo2.txt";
    private Gson gson;

    public ComunicacaoIMPL(String path, String minhaPasta) {
        this.arquivo1 = path;
        this.arquivo2 = minhaPasta;
        gson = new Gson();
    }

    public ComunicacaoIMPL() {
        gson = new Gson();
    }

    @Override
    public void enviar(String texto) {

        Mensagem msg = new Mensagem();
        msg.setTexto(texto);
        msg.setDataHoraEnvio(new Date());
        msg.setDataHoraEntrega(null);

        BufferedWriter buffWrite;
        try {
            buffWrite = new BufferedWriter(new FileWriter(arquivo1, true));

            buffWrite.write(gson.toJson(msg) + "\n");

            buffWrite.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String receber() {
        BufferedReader buffRead;
        try {
            buffRead = new BufferedReader(new FileReader(arquivo1));

            String ultima, atual = null;
            while ((ultima = buffRead.readLine()) != null) {
                atual = ultima;
            }

            if (atual != null) {
                return gson.fromJson(atual, Mensagem.class).getTexto();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
