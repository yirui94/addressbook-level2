package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class PostalCode {

    public static final String EXAMPLE = "231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Postal Code must be a 6 digit number";
    public static final String ADDRESS_VALIDATION_REGEX = "\\d{6}";

    private final String value;

    /**
     * Validates given block number.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public PostalCode(String postalCode) throws IllegalValueException {
        String trimmedPostalCode = postalCode.trim();
        if (!isValidPostalCode(trimmedPostalCode)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedPostalCode;
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidPostalCode(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && this.value.equals(((PostalCode) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
