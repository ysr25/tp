package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.Bagel;
import seedu.address.model.ReadOnlyBagel;
import seedu.address.model.flashcard.Description;
import seedu.address.model.flashcard.Flashcard;
import seedu.address.model.flashcard.Title;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Flashcard[] getSampleFlashcards() {
        return new Flashcard[] {
            new Flashcard(new Title("Types of Observational Studies"),
                new Description("Prospective, Retrospective, Cross-sectional")),
            new Flashcard(new Title("Types of Sampling Plan"),
                new Description("Probabililty Sampling: simple random, systematic, stratified, cluster\n"
                        + "Non-probability sampling: volunteer/self-selected, convenience, judgemental, quota")),
            new Flashcard(new Title("Ecological Fallacy"),
                new Description("Ecological fallacy is thinking that relationships observed for groups "
                        + "will hold for individuals. E.g. if countries with more fat in the diet have higher rates of"
                        + "breast cancer, then women who eat fatty foods must be more likely to get breast cancer.")),
            new Flashcard(new Title("Atomistic fallacy"),
                new Description("Atomistic fallacy is thinking that relation observed for individuals"
                        + "will hold for groups. The atomistic fallacy arises because associations between two "
                        + "variables at the individual level may differ from associations between analogous "
                        + "variables measured at the group level. ")),
            new Flashcard(new Title("Types of association"),
                new Description("r = 0: no linear association\n"
                        + "r > 0: positive association\n"
                        + "r < 0: negative association\n"
                        + "r = 1: perfect positive association\n"
                        + "r = -1: perfect negative association")),
            new Flashcard(new Title("Odds Ratio(OR) and Risk Ratio(RR)"),
                new Description("OR: odds(exp)/odds(unexp)\n"
                        + "RR: risk(exp)/risk(unexp)"))
        };
    }

    public static ReadOnlyBagel getSampleBagel() {
        Bagel sampleBagel = new Bagel();
        for (Flashcard sampleFlashcard : getSampleFlashcards()) {
            sampleBagel.addFlashcard(sampleFlashcard);
        }
        return sampleBagel;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
