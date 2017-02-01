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
        return block.toString() + ", " + street.toString() + ", " 
                + unit.toString() + ", " + postalCode.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
