package domain.valueObjects;

public class Email {
    private String endereco;

    public Email(String endereco) {
        if(endereco == null){
            throw new IllegalArgumentException("O endereco de email não pode ser nulo");
        }
        this.endereco = endereco;
    }
}
