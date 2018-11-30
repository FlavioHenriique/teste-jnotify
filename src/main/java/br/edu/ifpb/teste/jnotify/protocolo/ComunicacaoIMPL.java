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

    //-Djava.library.path=/home/flavio/Downloads/jnotify-lib-0.94
    private String arquivo1;
    private String arquivo2;
    private Gson gson;
    private Mensagem minhaUltima;

    public ComunicacaoIMPL(String path, String minhaPasta) {
        this.arquivo1 = path;
        this.arquivo2 = minhaPasta;
        this.minhaUltima = new Mensagem();
        gson = new Gson();
    }

    @Override
    public void enviar(String texto) {
        Mensagem msg = new Mensagem();
        msg.setTexto(texto);
        msg.setDataHoraEnvio(new Date());
        msg.setDataHoraEntrega(null);

        escrever(msg, arquivo1);
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
                Mensagem msg = gson.fromJson(atual, Mensagem.class);
                if (msg.getDataHoraEntrega() == null) {
                    msg.setDataHoraEntrega(new Date());
                    escrever(msg, arquivo2);
                    minhaUltima = msg;
                    //System.out.println("Modificação no arquivo: " + msg.getTexto());
                    return msg.getTexto();
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private void escrever(Mensagem msg, String arquivo) {

        if (!gson.toJson(msg).equals(gson.toJson(minhaUltima))) {
            BufferedWriter buffWrite;
            try {
                buffWrite = new BufferedWriter(new FileWriter(arquivo, true));
                buffWrite.write(gson.toJson(msg) + "\n");
                buffWrite.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
