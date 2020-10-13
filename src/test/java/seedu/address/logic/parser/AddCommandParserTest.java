package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.*;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalFlashcards.BOB;
import static seedu.address.testutil.TypicalFlashcards.AMY;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddCommand;
import seedu.address.model.flashcard.Flashcard;
import seedu.address.model.flashcard.Description;
import seedu.address.model.flashcard.Title;
import seedu.address.testutil.FlashcardBuilder;

public class AddCommandParserTest {
    private AddCommandParser parser = new AddCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        Flashcard expectedFlashcard = new FlashcardBuilder(BOB).build(); //.withTags(VALID_TAG_FRIEND).build();

        // whitespace only preamble
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + TITLE_DESC_BOB + DESC_DESC_BOB, new AddCommand(expectedFlashcard));

        // multiple word titles accepted
        assertParseSuccess(parser, TITLE_DESC_AMY + TITLE_DESC_BOB + DESC_DESC_BOB, new AddCommand(expectedFlashcard));

        // multiple word desc accepted
        assertParseSuccess(parser, TITLE_DESC_BOB + DESC_DESC_AMY + DESC_DESC_BOB, new AddCommand(expectedFlashcard));
    }

//    @Test
//    public void parse_optionalFieldsMissing_success() {
//        // zero tags
//        Flashcard expectedFlashcard = new FlashcardBuilder(AMY).withTags().build();
//        assertParseSuccess(parser, TITLE_DESC_AMY + DESC_DESC_AMY,
//                new AddCommand(expectedFlashcard));
//    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE);

        // missing title prefix
        assertParseFailure(parser, VALID_TITLE_BOB + DESC_DESC_BOB,
                expectedMessage);

        // missing desc prefix
        assertParseFailure(parser, TITLE_DESC_BOB + VALID_DESC_BOB,
                expectedMessage);

        // all prefixes missing
        assertParseFailure(parser, VALID_TITLE_BOB + TITLE_DESC_BOB,
                expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        // invalid title
        assertParseFailure(parser, INVALID_TITLE_DESC + DESC_DESC_BOB, Title.MESSAGE_CONSTRAINTS);

        // invalid desc
        assertParseFailure(parser, TITLE_DESC_BOB + INVALID_DESC_DESC, Description.MESSAGE_CONSTRAINTS);

        // two invalid values, only first invalid value reported
        assertParseFailure(parser, INVALID_TITLE_DESC + INVALID_DESC_DESC,
                Title.MESSAGE_CONSTRAINTS);

        // non-empty preamble
        assertParseFailure(parser, PREAMBLE_NON_EMPTY + TITLE_DESC_BOB + DESC_DESC_BOB,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
    }
}
