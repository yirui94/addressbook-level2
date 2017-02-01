package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = 
            "Person addresses must be block number, street, unit number and postal code each separated by a comma.";
    public static final String ADDRESS_VALIDATION_REGEX = "\\d{3},\\s*.+,\\s*#\\d{2}-\\d{1,3},\\s*\\d{6}";
    public static final String ADDRESS_PROPERTY_DELIMITER = ", ";
    public static enum ADDRESS_PROPERTY { BLOCK, STREET, UNIT, POSTALCODE };

    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        // Extract address components without leading and trailing spaces
        String[] addressComponents = trimmedAddress.split("\\s*,\\s*");
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.block = new Block(addressComponents[ADDRESS_PROPERTY.BLOCK.ordinal()]);
        this.street = new Street(addressComponents[ADDRESS_PROPERTY.STREET.ordinal()]);
        this.unit = new Unit(addressComponents[ADDRESS_PROPERTY.UNIT.ordinal()]);
        this.postalCode = new PostalCode(addressComponents[ADDRESS_PROPERTY.POSTALCODE.ordinal()]);

    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return block.toString() + ADDRESS_PROPERTY_DELIMITER + street.toString() + ADDRESS_PROPERTY_DELIMITER
                + unit.toString() + ADDRESS_PROPERTY_DELIMITER + postalCode.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Address other = (Address) obj;
        if (block == null) {
            if (other.block != null)
                return false;
        } else if (!block.equals(other.block))
            return false;
        if (isPrivate != other.isPrivate)
            return false;
        if (postalCode == null) {
            if (other.postalCode != null)
                return false;
        } else if (!postalCode.equals(other.postalCode))
            return false;
        if (street == null) {
            if (other.street != null)
                return false;
        } else if (!street.equals(other.street))
            return false;
        if (unit == null) {
            if (other.unit != null)
                return false;
        } else if (!unit.equals(other.unit))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((block == null) ? 0 : block.hashCode());
        result = prime * result + (isPrivate ? 1231 : 1237);
        result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
        result = prime * result + ((street == null) ? 0 : street.hashCode());
        result = prime * result + ((unit == null) ? 0 : unit.hashCode());
        return result;
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
