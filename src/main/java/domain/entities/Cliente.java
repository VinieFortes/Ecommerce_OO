package domain.entities;

import domain.interfaces.IAggregationRoot;
import domain.valueObjects.Cpf;
import domain.valueObjects.Email;

/*
 * Grupo
 *
 * Vinicius Fortes
 * Yuri Dias
 *
 * */

public class Cliente extends Entity  {

    private String nome;
    private Email email;
    private Cpf cpf;
    private boolean isActive;
    private Endereco endereco;

    public Cliente(String nome, Email email, Cpf cpf, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.isActive = true;
        this.endereco = endereco;
    }

    public Cliente setActive(boolean active) {
        isActive = active;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Email getEmail() {
        return email;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public boolean isActive() {
        return isActive;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
