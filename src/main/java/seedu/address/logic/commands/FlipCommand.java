package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_FLASHCARDS;

import javafx.collections.ObservableList;
import seedu.address.model.Model;
import seedu.address.model.flashcard.Flashcard;

import java.util.function.Predicate;

/**
 * Flip and show next flashcard in the list.
 */
public class FlipCommand extends Command {

    public static final String COMMAND_WORD = "flip";

    public static final String MESSAGE_SUCCESS = "flipped flashcard";

    // added ----
    public int index = 0;

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);


        ObservableList<Flashcard> filteredFlashcards =  model.getFilteredFlashcardList();
        Predicate<Flashcard> NEXT_FLASHCARD = flashcard -> filteredFlashcards.indexOf(flashcard) == index? true: false;
        model.updateFilteredFlashcardList(NEXT_FLASHCARD);

        if ((filteredFlashcards.size()-1) <= index) {
            index = 0;
        } else {
            index += 1;
        }

        return new CommandResult(MESSAGE_SUCCESS);
    }
}
