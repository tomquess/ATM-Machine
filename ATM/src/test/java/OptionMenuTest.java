package src.test.java;

import junit.framework.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import src.main.java.Account;
import src.main.java.OptionMenu;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;

public class OptionMenuTest {

    @Disabled("Not implemented yet! I will do it tomorrow...")
    @Test
    void getLogin_GivenInvalidCharacters_ThrowsInputMismatchException(){

        //Arrange
        OptionMenu optionMenu = new OptionMenu();

        //Act
        //var result = optionMenu.getLogin();

        //Assert
        //assertEquals();
    }

    @Disabled("bugged test. TODO: fix it!")
    @Test
    void getAccountType_() {

        //Arrange
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("4".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        OptionMenu optionMenu = new OptionMenu();
        Account acc = new Account(1, 4321, 1200.0, 600.0);
        optionMenu.getAccountType(acc);

        System.setIn(stdin);
        System.setOut(stdout);

        String outputText = byteArrayOutputStream.toString();
        String key = "output";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();


        Assert.assertEquals(output, "\nInvalid Choice.");
    }
}
