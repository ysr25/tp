package seedu.bagel.logic.commands;
//import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.bagel.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.bagel.testutil.TypicalFlashcards.getTypicalBagel;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.bagel.model.Model;
import seedu.bagel.model.ModelManager;
import seedu.bagel.model.UserPrefs;
import seedu.bagel.model.flashcard.Flashcard;

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
        expectedModel.viewFlashcard(flashcard -> flashcards.indexOf(flashcard) == 0);

        assertCommandSuccess(flipCommand, model, expectedMessage, expectedModel);
    }

    //@Test
    //public void execute_flipForWholeList_success() {
    //    FlipCommand.setIndex(0);
    //    ObservableList<Flashcard> flashcards = model.getBagel().getFlashcardList();
    //    FlipCommand flipCommand = new FlipCommand();

    //    String expectedMessage = String.format(FlipCommand.MESSAGE_SUCCESS);

    //    ModelManager expectedModel = new ModelManager(model.getBagel(), new UserPrefs());
    //    expectedModel.viewFlashcard(flashcard -> flashcards.indexOf(flashcard) == 1);

    //    assertCommandSuccess(flipCommand, model, expectedMessage, expectedModel);
    //}

}
