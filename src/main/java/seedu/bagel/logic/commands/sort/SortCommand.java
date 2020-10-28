package seedu.bagel.logic.commands.sort;

import static java.util.Objects.requireNonNull;
import static seedu.bagel.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.bagel.logic.parser.CliSyntax.PREFIX_REQ;

import java.util.Comparator;
import seedu.bagel.logic.commands.Command;
import seedu.bagel.logic.commands.CommandResult;
import seedu.bagel.logic.commands.exceptions.CommandException;
import seedu.bagel.model.Model;
import seedu.bagel.model.flashcard.Flashcard;

/**
 * Sorts the current list.
 */
public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts the list of flashcards "
            + "by the given requirement.\n"
            + "List can be sorted by title or by tag.\n"
            + "Sorting by title sorts via alphabetical order, while "
            + "sorting by tag sorts by the first tag of the flashcard.\n"
            + "Parameters: [" + PREFIX_REQ + "REQUIREMENT] "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_REQ + "title\n";

    public static final String MESSAGE_SUCCESS = "Sorted the list";

    private SortRequirement req;

    public SortCommand(SortRequirement req) {
        this.req = req;
    }

    // sorts by title for now.
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.sortFlashcardList(this.req.getSortComparator());
        return new CommandResult(String.format(MESSAGE_SUCCESS));
    }

    public static class SortRequirement {

        public static final String MESSAGE_CONSTRAINTS =
                "Sorting requirement should not be blank";
        public static final String VALIDATION_REGEX = "(?s)[^\\s].*";

        private String req;

        public SortRequirement(String req) {
            this.req = req;
        }

        public static boolean isValidRequirement(String test) {
            return test.matches(VALIDATION_REGEX);
        }

        public Comparator<Flashcard> getSortComparator() throws CommandException {
            switch (this.req) {
            case "title":
                return new SortByTitle();
            case "tag":
                return new SortByTag();
            default:
                throw new CommandException(
                        String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortCommand.MESSAGE_USAGE));
            }
        }
    }
}
