package seedu.bagel.model.flashcard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Integer.parseInt;

/**
 * Maintains a set that keeps track of the current number of flashcardSets in use.
 */

public class SetOfFlashcardSets {

    public Set<FlashcardSet> setOfFlashcardSets;

    /* keeps track of the number of flashcards that have the same flashcardSet in an array.
    e.g. if 10 flashcards have flashcardSet 1, numOfFlashcardsWithFSet[0] = 10.
    e.g. 2 flashcards have flashcardSet 3, numOfFlashcardsWithFSet[2] = 2.
    */
    public int[] numOfFlashcardsWithFSet;

    public SetOfFlashcardSets() {
        setOfFlashcardSets = new HashSet<>();
        numOfFlashcardsWithFSet = new int[10];
    }

    /**
     * Checks if the flashcardSet of the flashcard already exists in the set.
     * If it doesn't, adds the flashcardSet into the set.
     * @param flashcard to be added
     */
    public void add(Flashcard flashcard) {
        FlashcardSet flashcardSet = flashcard.getFlashcardSet();
        setOfFlashcardSets.add(flashcardSet);

        //updating count
        int flashcardSetValue = parseInt(flashcardSet.value) - 1;
        numOfFlashcardsWithFSet[flashcardSetValue] ++;
    }

    public void edit(Flashcard target, Flashcard edited) {
        FlashcardSet targetFlashcardSet = target.getFlashcardSet();
        FlashcardSet editedFlashcardSet = edited.getFlashcardSet();
        setOfFlashcardSets.add(editedFlashcardSet);

        //updating count
        int editedFlashcardSetValue = parseInt(editedFlashcardSet.value) - 1;
        numOfFlashcardsWithFSet[editedFlashcardSetValue] ++;
        int targetFlashcardSetValue = parseInt(targetFlashcardSet.value) - 1;
        numOfFlashcardsWithFSet[targetFlashcardSetValue] --;

        //updating Set of flashcardSets
        if(numOfFlashcardsWithFSet[targetFlashcardSetValue] == 0) {
            setOfFlashcardSets.remove(editedFlashcardSet);
        }
    }

    public void remove(Flashcard flashcard) {
        FlashcardSet flashcardSet = flashcard.getFlashcardSet();

        //updating count
        int flashcardSetValue = parseInt(flashcardSet.value) - 1;
        numOfFlashcardsWithFSet[flashcardSetValue] --;

        if (numOfFlashcardsWithFSet[flashcardSetValue] == 0) {
            setOfFlashcardSets.remove(flashcardSet);
        }
    }

    /**
     * Returns a copy of the set of flashcardSets to ensure the set remains immutable.
     */
    public Set<FlashcardSet> get() {
        return new HashSet<>(setOfFlashcardSets);
    }
}
