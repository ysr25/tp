package seedu.address.logic.commands.sort;

import java.util.Comparator;

import seedu.address.model.flashcard.Flashcard;

public class SortByTitle implements Comparator<Flashcard> {

    @Override
    public int compare(Flashcard one, Flashcard two) {
        return one.getTitle().toString().compareTo(two.getTitle().toString());
    }
}
