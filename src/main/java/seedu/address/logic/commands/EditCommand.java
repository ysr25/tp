package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.flashcard.Description;
import seedu.address.model.flashcard.Flashcard;
import seedu.address.model.flashcard.Title;
import seedu.address.model.tag.Tag;

/**
 * Edits the details of an existing person in the address book.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the details of the flashcard identified "
            + "by the index number used in the displayed flashcard list. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "[" + PREFIX_TITLE + "TITLE] "
            + "[" + PREFIX_DESCRIPTION + "DESCRIPTION] \n"
            + "Example: " + COMMAND_WORD + " 1 "
            + PREFIX_TITLE + "91234567 "
            + PREFIX_DESCRIPTION + "johndoe@example.com";

    public static final String MESSAGE_EDIT_FLASHCARD_SUCCESS = "Edited Flashcard: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_DUPLICATE_FLASHCARD = "This flashcard already exists in Bagel.";

    private final Index index;
    private final EditFlashcardDescriptor editFlashcardDescriptor;

    /**
     * @param index of the person in the filtered person list to edit
     * @param editFlashcardDescriptor details to edit the person with
     */
    public EditCommand(Index index, EditFlashcardDescriptor editFlashcardDescriptor) {
        requireNonNull(index);
        requireNonNull(editFlashcardDescriptor);

        this.index = index;
        this.editFlashcardDescriptor = new EditFlashcardDescriptor(editFlashcardDescriptor);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Flashcard> lastShownList = model.getFilteredFlashcardList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Flashcard flashcardToEdit = lastShownList.get(index.getZeroBased());
        Flashcard editedFlashcard = createEditedFlashcard(flashcardToEdit, editFlashcardDescriptor);

        if (!flashcardToEdit.isSameFlashcard(editedFlashcard) && model.hasFlashcard(editedFlashcard)) {
            throw new CommandException(MESSAGE_DUPLICATE_FLASHCARD);
        }

        model.setFlashcard(flashcardToEdit, editedFlashcard);
        model.updateFilteredFlashcardList(Model.PREDICATE_SHOW_ALL_FLASHCARDS);
        return new CommandResult(String.format(MESSAGE_EDIT_FLASHCARD_SUCCESS, editedFlashcard));
    }

    /**
     * Creates and returns a {@code Person} with the details of {@code personToEdit}
     * edited with {@code editFlashcardDescriptor}.
     */
    private static Flashcard createEditedFlashcard(Flashcard flashcardToEdit, EditFlashcardDescriptor editFlashcardDescriptor) {
        assert flashcardToEdit != null;

        Title updatedTitle = editFlashcardDescriptor.getTitle().orElse(flashcardToEdit.getTitle());
        Description updatedDescription = editFlashcardDescriptor.getDescription().orElse(flashcardToEdit.getDescription());
        // Set<Tag> updatedTags = editFlashcardDescriptor.getTags().orElse(flashcardToEdit.getTags());

        return new Flashcard(updatedTitle, updatedDescription);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditCommand)) {
            return false;
        }

        // state check
        EditCommand e = (EditCommand) other;
        return index.equals(e.index)
                && editFlashcardDescriptor.equals(e.editFlashcardDescriptor);
    }

    /**
     * Stores the details to edit the person with. Each non-empty field value will replace the
     * corresponding field value of the person.
     */
    public static class EditFlashcardDescriptor {
        private Title title;
        private Description description;
        // private Set<Tag> tags;

        public EditFlashcardDescriptor() {}

        /**
         * Copy constructor.
         * A defensive copy of {@code tags} is used internally.
         */
        public EditFlashcardDescriptor(EditFlashcardDescriptor toCopy) {
            setTitle(toCopy.title);
            setDescription(toCopy.description);
            // setTags(toCopy.tags);
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(title, description);
        }

        public void setTitle(Title title) {
            this.title = title;
        }

        public Optional<Title> getTitle() {
            return Optional.ofNullable(title);
        }

        public void setDescription(Description description) {
            this.description = description;
        }

        public Optional<Description> getDescription() {
            return Optional.ofNullable(description);
        }

        /**
         * Sets {@code tags} to this object's {@code tags}.
         * A defensive copy of {@code tags} is used internally.
         */
        // public void setTags(Set<Tag> tags) {
        //     this.tags = (tags != null) ? new HashSet<>(tags) : null;
        // }

        /**
         * Returns an unmodifiable tag set, which throws {@code UnsupportedOperationException}
         * if modification is attempted.
         * Returns {@code Optional#empty()} if {@code tags} is null.
         */
        // public Optional<Set<Tag>> getTags() {
        //     return (tags != null) ? Optional.of(Collections.unmodifiableSet(tags)) : Optional.empty();
        // }

        @Override
        public boolean equals(Object other) {
            // short circuit if same object
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof EditFlashcardDescriptor)) {
                return false;
            }

            // state check
            EditFlashcardDescriptor e = (EditFlashcardDescriptor) other;

            return getTitle().equals(e.getTitle())
                    && getDescription().equals(e.getDescription());
                    // && getTags().equals(e.getTags());
        }
    }
}
