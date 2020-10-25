package seedu.bagel.ui;

import java.util.Comparator;
import java.util.logging.Logger;

import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.bagel.commons.core.LogsCenter;
import seedu.bagel.model.flashcard.Flashcard;

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
    private final Logger logger = LogsCenter.getLogger(FlashcardCard.class);
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
    private FlowPane sets;
    @FXML
    private FlowPane tags;
    @FXML
    private VBox vBox;

    /**
     * Creates a {@code FlashcardCard} with the given {@code Flashcard} and index to display.
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
            addLink(link);
        }

        sets.getChildren().add(new Label(flashcard.getFlashcardSet().value));

        flashcard.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }

    /**
     * Adds a {@code Hyperlink} with value {@code link} to display.
     */
    public void addLink(String link) {
        Hyperlink hyperlink = new Hyperlink();
        hyperlink.setText(link);
        hyperlink.getStyleClass().add("cell_small_hyperlink");
        hyperlink.setOnMouseClicked(t -> {
            String linkText = hyperlink.getText();
            assert !linkText.isEmpty();
            logger.info("Link clicked: " + linkText);
            hostServices.showDocument(linkText);
        });
        vBox.getChildren().add(hyperlink);
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
