package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.flashcard.Description;
import seedu.address.model.flashcard.FlashcardSet;
import seedu.address.model.flashcard.Title;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     *
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Title parseTitle(String title) throws ParseException {
        requireNonNull(title);
        String trimmedTitle = title.trim();
        if (!Title.isValidTitle(trimmedTitle)) {
            throw new ParseException(Title.MESSAGE_CONSTRAINTS);
        }
        return new Title(trimmedTitle);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Description parseDescription(String description) throws ParseException {
        requireNonNull(description);
        String trimmedDesc = description.trim();
        if (!Description.isValidDescription(trimmedDesc)) {
            throw new ParseException(Description.MESSAGE_CONSTRAINTS);
        }
        return new Description(trimmedDesc);
    }

    /**
     * Parses a {@code String set} into a {@code set}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code set} is invalid.
     */
    public static FlashcardSet parseSet(String setNumber) throws ParseException {
        requireNonNull(setNumber);
        String trimmedSetNumber = setNumber.trim();
        if (!FlashcardSet.isValidSetNumber(trimmedSetNumber)) {
            throw new ParseException(FlashcardSet.MESSAGE_CONSTRAINTS);
        }
        return new FlashcardSet(trimmedSetNumber);
    }

    /**
     * Parses {@code Collection<String> flashcardSets} into a {@code Set<FlashcardSet>}.
     */
    public static Set<FlashcardSet> parseSets(Collection<String> flashcardSets) throws ParseException {
        requireNonNull(flashcardSets);
        final Set<FlashcardSet> setOfFlashcardSets = new HashSet<>();
        for (String setNumber : flashcardSets) {
            setOfFlashcardSets.add(parseSet(setNumber));
        }
        return setOfFlashcardSets;
    }
}

