package domain.entities;

public class Endereco {

    private String logadouro;
    private String cidade;
    private String UF;
    private String pais;
    private String cep;

    public Endereco(String logadouro, String cidade, String UF, String pais, String cep) {
        if(logadouro == null){
            throw new IllegalArgumentException("O logadouro não pode ser nulo");
        }
        if(cidade == null){
            throw new IllegalArgumentException("A cidade não pode ser nulo");
        }
        if(UF == null){
            throw new IllegalArgumentException("A UF não pode ser nulo");
        }
        if(pais == null){
            throw new IllegalArgumentException("O pais não pode ser nulo");
        }
        if(cep == null){
            throw new IllegalArgumentException("O cep não pode ser nulo");
        }
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
