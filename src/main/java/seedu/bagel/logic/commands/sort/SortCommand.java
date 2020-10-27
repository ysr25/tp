package seedu.bagel.logic.commands.sort;

import static java.util.Objects.requireNonNull;

import seedu.bagel.logic.commands.Command;
import seedu.bagel.logic.commands.CommandResult;
import seedu.bagel.logic.commands.exceptions.CommandException;
import seedu.bagel.model.Model;

/**
 * Sorts the current list.
 */
public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_SUCCESS = "Sorted the list";

    // sorts by title for now.
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.sortFlashcardList(new SortByTitle());
        return new CommandResult(String.format(MESSAGE_SUCCESS));
    }

}
