package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
//import static seedu.address.model.Model.PREDICATE_SHOW_ALL_FLASHCARDS;

import java.util.function.Predicate;
import javafx.collections.ObservableList;
import seedu.address.model.Model;
import seedu.address.model.flashcard.Flashcard;

/**
 * Flip and show next flashcard in the list.
 */
public class FlipCommand extends Command {

    public static final String COMMAND_WORD = "flip";

    public static final String MESSAGE_SUCCESS = "Flipped flashcard";

    // added ----
    private static int current_index;
    private static int next_index;

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);

        ObservableList<Flashcard> flashcards =  model.getBagel().getFlashcardList();
        ObservableList<Flashcard> filteredFlashcards = model.getFilteredFlashcardList();
        // find the index of flashcard currently shown
        current_index = flashcards.indexOf(filteredFlashcards.get(0));
        // find index of next flashcard
        if (filteredFlashcards.size() != 1) {
            next_index = current_index;
        } else if ((flashcards.size() - 1) <= current_index) {
            next_index = 0;
        } else {
            next_index = current_index + 1;
        }

        Predicate<Flashcard> NEXT_FLASHCARD = flashcard -> flashcards.indexOf(flashcard) == next_index;
        model.updateFilteredFlashcardList(NEXT_FLASHCARD);

        return new CommandResult(MESSAGE_SUCCESS);
    }

}
