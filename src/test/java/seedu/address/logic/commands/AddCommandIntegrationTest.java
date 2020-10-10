package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
<<<<<<< HEAD
import seedu.address.model.flashcard.Person;
import seedu.address.testutil.PersonBuilder;
=======
import seedu.address.model.person.Person;
import seedu.address.testutil.FlashcardBuilder;
>>>>>>> a0f1560e2c1a16498aa44176cfb5d7df4e027f0f

/**
 * Contains integration tests (interaction with the Model) for {@code AddCommand}.
 */
public class AddCommandIntegrationTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_newPerson_success() {
<<<<<<< HEAD
        Person validFlashcard = new PersonBuilder().build();
=======
        Person validPerson = new FlashcardBuilder().build();
>>>>>>> a0f1560e2c1a16498aa44176cfb5d7df4e027f0f

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.addPerson(validFlashcard);

        assertCommandSuccess(new AddCommand(validFlashcard), model,
                String.format(AddCommand.MESSAGE_SUCCESS, validFlashcard), expectedModel);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        Person flashcardInList = model.getAddressBook().getPersonList().get(0);
        assertCommandFailure(new AddCommand(flashcardInList), model, AddCommand.MESSAGE_DUPLICATE_PERSON);
    }

}
