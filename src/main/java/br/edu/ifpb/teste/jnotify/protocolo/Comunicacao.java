package br.edu.ifpb.teste.jnotify.protocolo;

public interface Comunicacao {

    void enviar(String msg);

    String receber();
}
