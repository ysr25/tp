package seedu.address.logic.commands;
//import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalFlashcards.getTypicalBagel;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
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
