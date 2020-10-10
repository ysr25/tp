package seedu.bagel.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
<<<<<<< HEAD:src/main/java/seedu/address/ui/PersonCard.java
import seedu.address.model.flashcard.Person;
=======
import seedu.bagel.model.flashcard.Flashcard;
>>>>>>> a0f1560e2c1a16498aa44176cfb5d7df4e027f0f:src/main/java/seedu/address/ui/FlashcardCard.java

/**
 * An UI component that displays information of a {@code Flashcard}.
 */
public class FlashcardCard extends UiPart<Region> {

    private static final String FXML = "FlashcardListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

<<<<<<< HEAD:src/main/java/seedu/address/ui/PersonCard.java
    public final Person flashcard;
=======
    public final Flashcard flashcard;
>>>>>>> a0f1560e2c1a16498aa44176cfb5d7df4e027f0f:src/main/java/seedu/address/ui/FlashcardCard.java

    @FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label title;
    @FXML
    private Label description;
    @FXML
    private FlowPane tags;

    /**
     * Creates a {@code FlashcardCode} with the given {@code Flashcard} and index to display.
     */
<<<<<<< HEAD:src/main/java/seedu/address/ui/PersonCard.java
    public PersonCard(Person flashcard, int displayedIndex) {
        super(FXML);
        this.flashcard = flashcard;
        id.setText(displayedIndex + ". ");
        name.setText(flashcard.getName().fullName);
        phone.setText(flashcard.getPhone().value);
        address.setText(flashcard.getAddress().value);
        email.setText(flashcard.getEmail().value);
=======
    public FlashcardCard(Flashcard flashcard, int displayedIndex) {
        super(FXML);
        this.flashcard = flashcard;
        id.setText(displayedIndex + ". ");
        title.setText(flashcard.getTitle().fullName);
        description.setText(flashcard.getDescription().value);
>>>>>>> a0f1560e2c1a16498aa44176cfb5d7df4e027f0f:src/main/java/seedu/address/ui/FlashcardCard.java
        flashcard.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FlashcardCard)) {
            return false;
        }

        // state check
        FlashcardCard card = (FlashcardCard) other;
        return id.getText().equals(card.id.getText())
                && flashcard.equals(card.flashcard);
    }
}
