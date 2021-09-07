package domain.valueObjects;

import domain.entities.Produto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void deveRetornarEmailNulo(){
        try{
            Email email = new Email(null);
            fail();
        } catch (IllegalArgumentException e){
            assertEquals("O endereco de email não pode ser nulo", e.getMessage());
        }
    }

}