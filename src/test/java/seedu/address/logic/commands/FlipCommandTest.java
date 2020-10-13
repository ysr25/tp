package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showFlashcardAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_FLASHCARD;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_FLASHCARD;
import static seedu.address.testutil.TypicalFlashcards.getTypicalBagel;

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

    // change test cases for flip command
//    @Test
//    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
//        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredFlashcardList().size() + 1);
//        ViewCommand viewCommand = new ViewCommand(outOfBoundIndex);
//
//        assertCommandFailure(viewCommand, model, Messages.MESSAGE_INVALID_FLASHCARD_DISPLAYED_INDEX);
//    }
//
//    @Test
//    public void execute_validIndexFilteredList_success() {
//        Flashcard flashcardToView = model.getFilteredFlashcardList().get(INDEX_FIRST_FLASHCARD.getZeroBased());
//        ViewCommand viewCommand = new ViewCommand(INDEX_FIRST_FLASHCARD);
//
//        String expectedMessage = String.format(ViewCommand.MESSAGE_VIEW_FLASHCARD_SUCCESS, flashcardToView);
//
//        ModelManager expectedModel = new ModelManager(model.getBagel(), new UserPrefs());
//        expectedModel.viewFlashcard(flashcard -> flashcard.equals(flashcardToView));
//
//        assertCommandSuccess(viewCommand, model, expectedMessage, expectedModel);
//    }
//
//    @Test
//    public void execute_invalidIndexFilteredList_throwsCommandException() {
//        showFlashcardAtIndex(model, INDEX_FIRST_FLASHCARD);
//
//        Index outOfBoundIndex = INDEX_SECOND_FLASHCARD;
//        // ensures that outOfBoundIndex is still in bounds of bagel (flashcards) list
//        assertTrue(outOfBoundIndex.getZeroBased() < model.getBagel().getFlashcardList().size());
//
//        ViewCommand viewCommand = new ViewCommand(outOfBoundIndex);
//
//        assertCommandFailure(viewCommand, model, Messages.MESSAGE_INVALID_FLASHCARD_DISPLAYED_INDEX);
//    }

}