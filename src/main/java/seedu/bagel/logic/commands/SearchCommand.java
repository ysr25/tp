package seedu.bagel.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.bagel.logic.parser.CliSyntax.PREFIX_KEYWORD;

import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

import seedu.bagel.logic.commands.exceptions.CommandException;
import seedu.bagel.model.Model;
import seedu.bagel.model.flashcard.Flashcard;
import seedu.bagel.model.tag.Tag;

/**
 * Search a flashcard that has matching title, description, or tag to a keyword.
 */
public class SearchCommand extends Command {

    public static final String COMMAND_WORD = "search";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Searches the flashcard by keyword from displayed flashcard list.\n"
            + "Parameters: " + PREFIX_KEYWORD + "KEYWORD\n"
            + "Example: " + COMMAND_WORD + " " + PREFIX_KEYWORD + "GER";

    public static final String MESSAGE_SEARCH_FLASHCARD_SUCCESS = "Result of search: %s";

    private final String keyword;

    public SearchCommand(String keyword) {
        this.keyword = keyword;
    }

    private boolean has_matching_tag(Flashcard flashcard, String keyword) {
        boolean is_find = false;
        for (Tag tag : flashcard.getTags()) {
            if (tag.tagName.toLowerCase().contains(keyword.toLowerCase())) {
                is_find = true;
                break;
            }
        }
        return is_find;
    }

    private boolean has_matching_title(Flashcard flashcard, String keyword) {
        String title = flashcard.getTitle().fullTitle.toLowerCase();
        if (title.contains(keyword.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }

    private boolean has_matching_description(Flashcard flashcard, String keyword) {
        String description = flashcard.getDescription().value.toLowerCase();
        if (description.contains(keyword.toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        assert true; // required for week 10 tP
        Logger logger = Logger.getLogger("logger"); // required for week 10 tP
        logger.log(Level.INFO, "log test"); // required for week 10 tP

        // search flaschard that have matching title, description or tag
        Predicate<Flashcard> searchFlashcard = flashcard -> has_matching_title(flashcard, keyword)
                || has_matching_description(flashcard, keyword)
                || has_matching_tag(flashcard, keyword);

        model.updateFilteredFlashcardList(searchFlashcard);
        return new CommandResult(String.format(MESSAGE_SEARCH_FLASHCARD_SUCCESS, keyword));
    }

}
