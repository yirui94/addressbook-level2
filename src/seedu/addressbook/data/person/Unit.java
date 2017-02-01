package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Unit {

    public static final String EXAMPLE = "#12-34";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = 
            "Unit number must begin with a hash followed by floor number and unit number separated by a dash.";
    public static final String ADDRESS_VALIDATION_REGEX = "#\\d{2}-\\d{1,3}";

    private final String value;

    /**
     * Validates given block number.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Unit(String unit) throws IllegalValueException {
        String trimmedUnit = unit.trim();
        if (!isValidUnit(trimmedUnit)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedUnit;
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidUnit(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && this.value.equals(((Unit) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
