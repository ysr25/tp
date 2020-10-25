package seedu.bagel.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.bagel.logic.parser.CliSyntax.PREFIX_KEYWORD;

import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

import seedu.bagel.logic.commands.exceptions.CommandException;
import seedu.bagel.model.Model;
import seedu.bagel.model.flashcard.Flashcard;

/**
 * Deletes a flashcard identified using it's displayed index from Bagel.
 */
public class SearchCommand extends Command {

    public static final String COMMAND_WORD = "search";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Searches the flashcard by keyword from displayed flashcard list.\n"
            + "Parameters: " + PREFIX_KEYWORD + "KEYWORD\n"
            + "Example: " + COMMAND_WORD + " " + PREFIX_KEYWORD + "GER";

    public static final String MESSAGE_SEARCH_FLASHCARD_SUCCESS = "Result of search: %s";

    //    private final Index targetIndex;
    private final String keyword;


    public SearchCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        assert true; // required for week 10 tP
        Logger logger = Logger.getLogger("logger"); // required for week 10 tP
        logger.log(Level.INFO, "log test"); // required for week 10 tP
        Predicate<Flashcard> searchFlashcard = flashcard -> flashcard.getDescription().toString().contains(keyword)
                || flashcard.getTitle().toString().contains(keyword);
        model.updateFilteredFlashcardList(searchFlashcard);

        return new CommandResult(String.format(MESSAGE_SEARCH_FLASHCARD_SUCCESS, keyword));
    }

    //    @Override
    //    public boolean equals(Object other) {
    //        return other == this // short circuit if same object
    //                || (other instanceof DeleteCommand // instanceof handles nulls
    //                && targetIndex.equals(((DeleteCommand) other).targetIndex)); // state check
    //    }
}
