package model;

/**
 *
 * @author Rodrigo
 */
public class RelatorioFechamento {

    int idpacientes;
    String paciente;
    int sessoes;
    String data;

    public int getIdpacientes() {
        return idpacientes;
    }

    public void setIdpacientes(int idpacientes) {
        this.idpacientes = idpacientes;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public int getSessoes() {
        return sessoes;
    }

    public void setSessoes(int sessoes) {
        this.sessoes = sessoes;
    }

}
