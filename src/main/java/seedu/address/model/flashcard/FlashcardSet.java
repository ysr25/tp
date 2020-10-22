package seedu.address.model.flashcard;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class FlashcardSet {
    public static final String MESSAGE_CONSTRAINTS = "Set number should only contain numbers between 1 to 9.";
    public static final String VALIDATION_REGEX = "[1-9]";

    public final String setNumber;

    /**
     * Constructs a {@code FlashcardSet}.
     *
     * @param setNumber A valid set number.
     */
    public FlashcardSet(String setNumber) {
        requireNonNull(setNumber);
        checkArgument(isValidSetNumber(setNumber), MESSAGE_CONSTRAINTS);
        this.setNumber = setNumber;
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidSetNumber(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FlashcardSet // instanceof handles nulls
                && setNumber.equals(((FlashcardSet) other).setNumber)); // state check
    }

    @Override
    public int hashCode() {
        return setNumber.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + setNumber + ']';
    }
}
