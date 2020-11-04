package seedu.bagel.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.bagel.logic.parser.CliSyntax.PREFIX_KEYWORD;

import java.util.Set;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

import seedu.bagel.model.Model;
import seedu.bagel.model.flashcard.Flashcard;
import seedu.bagel.model.tag.Tag;

/**
 * Deletes a flashcard identified using it's displayed index from Bagel.
 */
public class SearchCommand extends Command {

    public static final String COMMAND_WORD = "search";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Searches the flashcard by keyword from displayed flashcard list.\n"
            + "Parameters: " + PREFIX_KEYWORD + "KEYWORD\n"
            + "Example: " + COMMAND_WORD + " " + PREFIX_KEYWORD + "types";

    public static final String MESSAGE_SEARCH_FLASHCARD_SUCCESS = "Result of search: %s";

    private final String keyword;


    public SearchCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        assert true; // required for week 10 tP
        Logger logger = Logger.getLogger("logger"); // required for week 10 tP
        logger.log(Level.INFO, "log test"); // required for week 10 tP

        Predicate<Flashcard> searchFlashcard = flashcard ->
                flashcard.getDescription().toString().toLowerCase().contains(keyword.toLowerCase())
                || flashcard.getTitle().toString().toLowerCase().contains(keyword.toLowerCase())
                || searchFlashcardTags(flashcard.getTags());
        model.updateFilteredFlashcardList(searchFlashcard);

        return new CommandResult(String.format(MESSAGE_SEARCH_FLASHCARD_SUCCESS, keyword));
    }

    private boolean searchFlashcardTags(Set<Tag> tags) {
        for (Tag tag : tags) {
            if (tag.getTagName().toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
