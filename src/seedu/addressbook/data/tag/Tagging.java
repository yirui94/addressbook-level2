package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Represents a tagging in the AddressBook. 
 * Association between 1 Tag and 1 Person
 */
public class Tagging {
    
    public static enum Status {
        ADDED,
        DELETED;
    }
    
    private Person person;
    private Tag tag;
    private Status status;
    
    public Tagging(Person person, Tag tag, Status status) {
        this.person = person;
        this.tag = tag;
        this.status = status;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public Tag getTag() {
        return tag;
    }
    public void setTag(Tag tag) {
        this.tag = tag;
    }
    public Status getState() {
        return status;
    }
    public void setState(Status state) {
        this.status = state;
    }
    
    private String getStatusString() {
        if (this.status == Status.ADDED) {
            return "+";
        } else {
            return "-";
        }
    }
    
    public void printTagging() {
        System.out.println(getStatusString() + " " + this.person.getName() + " [" + this.tag.tagName + "]");
    }
    
    
}
