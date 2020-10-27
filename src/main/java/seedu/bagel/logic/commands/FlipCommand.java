package seedu.bagel.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.bagel.model.Model;
import seedu.bagel.model.flashcard.Flashcard;

/**
 * Flip and show next flashcard in the list.
 */
public class FlipCommand extends Command {

    public static final String COMMAND_WORD = "flip";

    public static final String MESSAGE_SUCCESS = "Flipped flashcard";

    // added ----
    private static int currentIndex;
    private static int nextIndex;

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);

        ObservableList<Flashcard> flashcards = model.getBagel().getFlashcardList();
        ObservableList<Flashcard> filteredFlashcards = model.getFilteredFlashcardList();
        // find the index of flashcard currently shown
        currentIndex = flashcards.indexOf(filteredFlashcards.get(0));
        // find index of next flashcard
        if (filteredFlashcards.size() != 1) {
            nextIndex = currentIndex;
        } else if ((flashcards.size() - 1) <= currentIndex) {
            nextIndex = 0;
        } else {
            nextIndex = currentIndex + 1;
        }

        Predicate<Flashcard> nextFlashcard = flashcard -> flashcards.indexOf(flashcard) == nextIndex;
        model.updateFilteredFlashcardList(nextFlashcard);

        return new CommandResult(MESSAGE_SUCCESS);
    }

}
