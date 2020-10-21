package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESC;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SET;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TITLE;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditCommand.EditFlashcardDescriptor;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.flashcard.FlashcardSet;


/**
 * Parses input arguments and creates a new EditCommand object
 */
public class EditCommandParser implements Parser<EditCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_TITLE, PREFIX_DESC, PREFIX_SET);

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE), pe);
        }

        EditFlashcardDescriptor editFlashcardDescriptor = new EditFlashcardDescriptor();
        if (argMultimap.getValue(PREFIX_TITLE).isPresent()) {
            editFlashcardDescriptor.setTitle(ParserUtil.parseTitle(argMultimap.getValue(PREFIX_TITLE).get()));
        }
        if (argMultimap.getValue(PREFIX_DESC).isPresent()) {
            editFlashcardDescriptor
                    .setDescription(ParserUtil.parseDescription(argMultimap.getValue(PREFIX_DESC).get()));
        }

        parseFlashcardSetsForEdit(argMultimap.getAllValues(PREFIX_SET))
                .ifPresent(editFlashcardDescriptor::setFlashcardSets);

        if (!editFlashcardDescriptor.isAnyFieldEdited()) {
            throw new ParseException(EditCommand.MESSAGE_NOT_EDITED);
        }

        return new EditCommand(index, editFlashcardDescriptor);
    }

    /**
    * Parses {@code Collection<String> flashcardSets} into a {@code Set<FlashcardSet>} if {@code flashcardSets} is
    * non-empty.
    * If {@code flashcardSets} contain only one element which is an empty string, it will be parsed into a
    * {@code Set<FlashcardSet>} containing zero tags.
    */
    private Optional<Set<FlashcardSet>> parseFlashcardSetsForEdit(Collection<String> sets) throws ParseException {
        assert sets != null;

        if (sets.isEmpty()) {
            return Optional.empty();
        }
        Collection<String> setOfFlashcardSets = sets.size() == 1 && sets.contains("") ? Collections.emptySet() : sets;
        return Optional.of(ParserUtil.parseSets(setOfFlashcardSets));
    }

}
