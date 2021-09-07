package domain.entities;

public class Endereco {

    private String logadouro;
    private String cidade;
    private String UF;
    private String pais;
    private String cep;

    public Endereco(String logadouro, String cidade, String UF, String pais, String cep) {
        this.logadouro = logadouro;
        this.cidade = cidade;
        this.UF = UF;
        this.pais = pais;
        this.cep = cep;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUF() {
        return UF;
    }

    public String getPais() {
        return pais;
    }

    public String getCep() {
        return cep;
    }
}
