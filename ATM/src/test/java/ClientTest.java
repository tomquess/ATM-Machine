package src.test.java;

import org.junit.jupiter.api.Test;
import src.main.java.Client;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ClientTest {

    @Test
    void isOver18YearsOld_ProvidedLessThan18_ShouldReturnFalse(){

        //Arrange
        Client client = new Client(1, "Adam", "Nowak", 17, false);

        //Act
        boolean result = client.isOver18YearsOld();

        //Assert
        assertTrue(result == false);
    }

    @Test
    void isClientBankAccountNull_shouldReturnTrue() {

        //Arrange
        Client EmptyClient = new Client(2, "Maria", "Kowalska", 21, true);

        //Act
        boolean result = EmptyClient.getBankAccount() == null;

        //Assert
        assertFalse(!result);

    }
}
