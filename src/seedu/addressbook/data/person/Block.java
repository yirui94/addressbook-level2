package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;


public class Block {

    public static final String EXAMPLE = "123";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Block number should be a 3 digit number";
    public static final String ADDRESS_VALIDATION_REGEX = "\\d{3}";

    private final String value;

    /**
     * Validates given block number.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Block(String block) throws IllegalValueException {
        String trimmedBlock = block.trim();
        if (!isValidBlock(trimmedBlock)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedBlock;
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidBlock(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.value.equals(((Block) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
