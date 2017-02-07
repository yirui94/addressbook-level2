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
    private Name unorderedName;
    private Name otherName;
    
    @Before
    public void initialiseTest() throws IllegalValueException {
        this.name = new Name("John K Smith"); 
        this.lowerCaseName = new Name("john k smith");
        this.upperCaseName = new Name("JOHN K SMITH");
        this.mixedCaseName = new Name("JoHn K sMiTh");
        this.subsetName = new Name(" JoHn ");
        this.supersetName = new Name("JoHn  k  Smith  TRUMP");
        this.unorderedName = new Name("Smith John");
        this.otherName = new Name("Hillary Clinton");
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
        
        // subset name regardless of case and spaces
        assertTrue(name.isSimilar(subsetName));
        
        // superset name regardless of case and spaces
        assertTrue(name.isSimilar(supersetName));
        
        // same name but in different order
        assertTrue(name.isSimilar(unorderedName));
        
        // different name
        assertFalse(name.isSimilar(otherName));

    }

}
