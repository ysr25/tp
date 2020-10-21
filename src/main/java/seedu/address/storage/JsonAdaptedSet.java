package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.flashcard.FlashcardSet;

public class JsonAdaptedSet {

    private final String setNumber;

    /**
     * Constructs a {@code JsonAdaptedSet} with the given {@code setNumber}.
     */
    @JsonCreator
    public JsonAdaptedSet(String setNumber) {
        this.setNumber = setNumber;
    }

    /**
     * Converts a given {@code FlashcardSet} into this class for Jackson use.
     */
    public JsonAdaptedSet(FlashcardSet source) {
        setNumber = source.setNumber;
    }

    @JsonValue
    public String getSetNumber() {
        return setNumber;
    }

    /**
     * Converts this Jackson-friendly adapted flashcardSet object into the model's {@code FlashcardSet} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted flashcardSet.
     */
    public FlashcardSet toModelType() throws IllegalValueException {
        if (!FlashcardSet.isValidSetNumber(setNumber)) {
            throw new IllegalValueException(FlashcardSet.MESSAGE_CONSTRAINTS);
        }
        return new FlashcardSet(setNumber);
    }
}
