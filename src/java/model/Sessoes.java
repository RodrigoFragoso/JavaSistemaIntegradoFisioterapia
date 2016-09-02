package model;

/**
 *
 * @author Rodrigo
 */
public class Sessoes {
    private int idsessoes;
    private String dias_sessoes;
    private String hora_sessoes;
    private String data; 
    private String status;

    public int getIdsessoes() {
        return idsessoes;
    }

    public void setIdsessoes(int idsessoes) {
        this.idsessoes = idsessoes;
    }

    public String getDias_sessoes() {
        return dias_sessoes;
    }

    public void setDias_sessoes(String dias_sessoes) {
        this.dias_sessoes = dias_sessoes;
    }

    public String getHora_sessoes() {
        return hora_sessoes;
    }

    public void setHora_sessoes(String hora_sessoes) {
        this.hora_sessoes = hora_sessoes;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
