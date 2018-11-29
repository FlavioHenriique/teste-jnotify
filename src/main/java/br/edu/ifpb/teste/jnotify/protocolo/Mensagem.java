package br.edu.ifpb.teste.jnotify.protocolo;

import java.util.Date;

public class Mensagem {

    private String texto;
    private Date dataHoraEnvio;
    private Date dataHoraEntrega;

    public Mensagem() {

    }

    public Mensagem(String texto, Date dataHoraEnvio, Date dataHoraEntrega) {
        this.texto = texto;
        this.dataHoraEnvio = dataHoraEnvio;
        this.dataHoraEntrega = dataHoraEntrega;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDataHoraEnvio() {
        return dataHoraEnvio;
    }

    public void setDataHoraEnvio(Date dataHoraEnvio) {
        this.dataHoraEnvio = dataHoraEnvio;
    }

    public Date getDataHoraEntrega() {
        return dataHoraEntrega;
    }

    public void setDataHoraEntrega(Date dataHoraEntrega) {
        this.dataHoraEntrega = dataHoraEntrega;
    }

}
