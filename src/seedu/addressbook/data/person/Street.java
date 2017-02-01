package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Street {

    public static final String EXAMPLE = "Clementi Ave 3";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Street can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    private final String value;

    /**
     * Validates given block number.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Street(String street) throws IllegalValueException {
        String trimmedstreet = street.trim();
        if (!isValidStreet(trimmedstreet)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedstreet;
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidStreet(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && this.value.equals(((Street) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
