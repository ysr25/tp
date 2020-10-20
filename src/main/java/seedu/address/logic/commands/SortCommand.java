package seedu.address.logic.commands;

import static seedu.address.logic.parser.CliSyntax.PREFIX_DESC;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TITLE;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.flashcard.Description;
import seedu.address.model.flashcard.Title;
import seedu.address.model.tag.Tag;

/**
 * Sorts the current list.
 */
public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + " title ";

    public static final String MESSAGE_SUCCESS = "Sorted the list by %1$s";

    public SortCommand(SortRequest sortRequest) {

    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        return null;
    }

    /**
     * Stores the details to sort the list with. Each non-empty field value will replace the
     * corresponding field value of the person.
     */
    public static class SortRequest {
        private Title title;
        private Description description;
        private Set<Tag> tags;

        public SortRequest() {}

        /**
         * Copy constructor.
         * A defensive copy of {@code tags} is used internally.
         */
        public SortRequest(SortCommand.SortRequest toCopy) {
            setTitle(toCopy.title);
            setDescription(toCopy.description);
            setTags(toCopy.tags);
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(title, description, tags);
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
        public void setTags(Set<Tag> tags) {
            this.tags = (tags != null) ? new HashSet<>(tags) : null;
        }

        /**
         * Returns an unmodifiable tag set, which throws {@code UnsupportedOperationException}
         * if modification is attempted.
         * Returns {@code Optional#empty()} if {@code tags} is null.
         */
        public Optional<Set<Tag>> getTags() {
            return (tags != null) ? Optional.of(Collections.unmodifiableSet(tags)) : Optional.empty();
        }


        @Override
        public boolean equals(Object other) {
            // short circuit if same object
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof EditCommand.EditFlashcardDescriptor)) {
                return false;
            }

            // state check
            EditCommand.EditFlashcardDescriptor e = (EditCommand.EditFlashcardDescriptor) other;

            return getTitle().equals(e.getTitle())
                    && getDescription().equals(e.getDescription())
                    && getTags().equals(e.getTags());
        }
    }
    }
}
