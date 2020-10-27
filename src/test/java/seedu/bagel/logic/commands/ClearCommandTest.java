package seedu.bagel.logic.commands;

import static seedu.bagel.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.bagel.testutil.TypicalFlashcards.getTypicalBagel;

import org.junit.jupiter.api.Test;

import seedu.bagel.model.Bagel;
import seedu.bagel.model.Model;
import seedu.bagel.model.ModelManager;
import seedu.bagel.model.UserPrefs;

public class ClearCommandTest {

    @Test
    public void execute_emptyBagel_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptyBagel_success() {
        Model model = new ModelManager(getTypicalBagel(), new UserPrefs());
        Model expectedModel = new ModelManager(getTypicalBagel(), new UserPrefs());
        expectedModel.setBagel(new Bagel());

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
