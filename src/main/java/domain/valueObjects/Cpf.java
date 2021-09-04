package domain.valueObjects;

public class Cpf {
    private static final int CpfMaxLength = 11;
    private String numero;

    public Cpf(String numero) {
        if(numero == null){
            throw new IllegalArgumentException("O numero de cpf não pode ser nulo");
        }
        if(numero.length() != CpfMaxLength){
            throw new IllegalArgumentException("O numero de cpf deve ter 11 digitos");
        }
        if(!numero.matches("[0-9]*")){
            throw new IllegalArgumentException("O numero deve conter apenas números");
        }

        this.numero = numero;
    }
}
