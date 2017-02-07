package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

    private Name name;
    private Name lowerCaseName;
    private Name upperCaseName;
    private Name subsetName;
    private Name mixedCaseName;
    private Name supersetName;
    
    @Before
    public void initialiseTest() throws IllegalValueException {
        this.name = new Name("John K Smith"); 
        this.lowerCaseName = new Name("john k smith");
        this.upperCaseName = new Name("JOHN K SMITH");
        this.mixedCaseName = new Name("JoHn K sMiTh");
        this.subsetName = new Name("John");
        this.supersetName = new Name("John K Smith Trump");
    }
    
    @Test
    public void isNameSimilar() {
        // null object
        assertFalse(name.isSimilar(null));
        
        // lower case name
        assertTrue(name.isSimilar(lowerCaseName));
        
        // upper case name
        assertTrue(name.isSimilar(upperCaseName));
        
        // mixed case name
        assertTrue(name.isSimilar(mixedCaseName));
        
        // subset name
        assertTrue(name.isSimilar(subsetName));
        
        // superset name
        assertTrue(name.isSimilar(supersetName));

    }

}
