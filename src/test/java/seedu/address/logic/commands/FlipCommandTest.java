package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showFlashcardAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_FLASHCARD;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_FLASHCARD;
import static seedu.address.testutil.TypicalFlashcards.getTypicalBagel;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.flashcard.Flashcard;

/**
 * Contains integration tests (interaction with the Model, UndoCommand and RedoCommand) and unit tests for
 * {@code FlipCommand}.
 */
public class FlipCommandTest {

    private Model model = new ModelManager(getTypicalBagel(), new UserPrefs());

    @Test
    public void execute_flipOnce_success() {
        ObservableList<Flashcard> flashcards = model.getBagel().getFlashcardList();
        FlipCommand flipCommand = new FlipCommand();

        String expectedMessage = String.format(FlipCommand.MESSAGE_SUCCESS);

        ModelManager expectedModel = new ModelManager(model.getBagel(), new UserPrefs());
        expectedModel.viewFlashcard(flashcard -> flashcards.indexOf(flashcard) == 1);

        assertCommandSuccess(flipCommand, model, expectedMessage, expectedModel);
    }

//    @Test
//    public void execute_flipForWholeList_success() {
//        FlipCommand.setIndex(0);
//        ObservableList<Flashcard> flashcards = model.getBagel().getFlashcardList();
//        FlipCommand flipCommand = new FlipCommand();
//
//        String expectedMessage = String.format(FlipCommand.MESSAGE_SUCCESS);
//
//        ModelManager expectedModel = new ModelManager(model.getBagel(), new UserPrefs());
//        expectedModel.viewFlashcard(flashcard -> flashcards.indexOf(flashcard) == 1);
//
//        assertCommandSuccess(flipCommand, model, expectedMessage, expectedModel);
//    }

}