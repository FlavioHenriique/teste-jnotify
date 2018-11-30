package br.edu.ifpb.teste.jnotify.protocolo;

import java.util.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mensagem mensagem = (Mensagem) o;
        return Objects.equals(texto, mensagem.texto) &&
                Objects.equals(dataHoraEnvio, mensagem.dataHoraEnvio) &&
                Objects.equals(dataHoraEntrega, mensagem.dataHoraEntrega);
    }

    @Override
    public int hashCode() {
        return Objects.hash(texto, dataHoraEnvio, dataHoraEntrega);
    }

    @Override
    public String toString() {
        return "Mensagem{" +
                "texto='" + texto + '\'' +
                ", dataHoraEnvio=" + dataHoraEnvio +
                ", dataHoraEntrega=" + dataHoraEntrega +
                '}';
    }
}
