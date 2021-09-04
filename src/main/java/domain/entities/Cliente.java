package domain.entities;

import domain.interfaces.IAggregationRoot;
import domain.valueObjects.Cpf;
import domain.valueObjects.Email;

public class Cliente extends Entity implements IAggregationRoot {

    private String nome;
    private Email email;
    private Cpf cpf;
    private boolean isActive;
    private Endereco endereco;
}
