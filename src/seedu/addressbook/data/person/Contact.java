package seedu.addressbook.data.person;

/**
 * Represents a general contact detail
 */
public abstract class Contact {
    protected String value;
    protected boolean isPrivate;

    public Contact() {
    }

    public String toString() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public int hashCode() {
        return value.hashCode();
    }
    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }
    
    public abstract boolean equals(Object other);
}