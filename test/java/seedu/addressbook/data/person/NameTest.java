package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

    Name name;
    
    @Before
    public void initialiseTest() throws IllegalValueException {
        this.name = new Name("John K Smith"); 
    }
    
    @Test
    public void isNameSimilar() {
        assertFalse(name.isSimilar(null));
    }

}
