package seedu.address.ui;

import java.util.Comparator;

import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.model.flashcard.Flashcard;

/**
 * An UI component that displays information of a {@code Flashcard}.
 */
public class FlashcardCard extends UiPart<Region> {

    private static final String FXML = "FlashcardList.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Flashcard flashcard;
    private HostServices hostServices;

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
    @FXML
    private VBox vBox;

    /**
     * Creates a {@code FlashcardCode} with the given {@code Flashcard} and index to display.
     */
    public FlashcardCard(Flashcard flashcard, int displayedIndex, HostServices hostServices) {
        super(FXML);
        this.flashcard = flashcard;
        this.hostServices = hostServices;
        id.setText(displayedIndex + ". ");
        title.setText(flashcard.getTitle().fullTitle);
        description.setText(flashcard.getDescription().value);

        String link = flashcard.getLink().value;
        if (!link.isEmpty()) {
            Hyperlink hyperlink = new Hyperlink();
            hyperlink.setText(link);
            hyperlink.getStyleClass().add("cell_small_hyperlink");
            hyperlink.setOnMouseClicked(t -> hostServices.showDocument(hyperlink.getText()));
            vBox.getChildren().add(hyperlink);
        }

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
