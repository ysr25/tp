package seedu.bagel.logic.parser;

import static seedu.bagel.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.bagel.logic.commands.CommandTestUtil.DESC_DESC_AMY;
import static seedu.bagel.logic.commands.CommandTestUtil.DESC_DESC_BOB;
import static seedu.bagel.logic.commands.CommandTestUtil.INVALID_DESC_DESC;
import static seedu.bagel.logic.commands.CommandTestUtil.INVALID_LINK_DESC;
import static seedu.bagel.logic.commands.CommandTestUtil.INVALID_TAG_DESC;
import static seedu.bagel.logic.commands.CommandTestUtil.INVALID_TITLE_DESC;
import static seedu.bagel.logic.commands.CommandTestUtil.TAG_DESC_FRIEND;
import static seedu.bagel.logic.commands.CommandTestUtil.TAG_DESC_HUSBAND;
import static seedu.bagel.logic.commands.CommandTestUtil.TITLE_DESC_AMY;
import static seedu.bagel.logic.commands.CommandTestUtil.TITLE_DESC_BOB;
import static seedu.bagel.logic.commands.CommandTestUtil.VALID_DESC_AMY;
import static seedu.bagel.logic.commands.CommandTestUtil.VALID_DESC_BOB;
import static seedu.bagel.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.bagel.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.bagel.logic.commands.CommandTestUtil.VALID_TITLE_AMY;
import static seedu.bagel.logic.commands.CommandTestUtil.VALID_TITLE_BOB;
import static seedu.bagel.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.bagel.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.bagel.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.bagel.testutil.TypicalIndexes.INDEX_FIRST_FLASHCARD;
import static seedu.bagel.testutil.TypicalIndexes.INDEX_SECOND_FLASHCARD;
import static seedu.bagel.testutil.TypicalIndexes.INDEX_THIRD_FLASHCARD;

import org.junit.jupiter.api.Test;

import seedu.bagel.commons.core.index.Index;
import seedu.bagel.logic.commands.EditCommand;
import seedu.bagel.logic.commands.EditCommand.EditFlashcardDescriptor;
import seedu.bagel.model.flashcard.Description;
import seedu.bagel.model.flashcard.Link;
import seedu.bagel.model.flashcard.Title;
import seedu.bagel.model.tag.Tag;
import seedu.bagel.testutil.EditFlashcardDescriptorBuilder;

public class EditCommandParserTest {

    private static final String TAG_EMPTY = " " + PREFIX_TAG;

    private static final String MESSAGE_INVALID_FORMAT =
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE);

    private EditCommandParser parser = new EditCommandParser();

    @Test
    public void parse_missingParts_failure() {
        // no index specified
        assertParseFailure(parser, VALID_TITLE_AMY, MESSAGE_INVALID_FORMAT);

        // no field specified
        assertParseFailure(parser, "1", EditCommand.MESSAGE_NOT_EDITED);

        // no index and no field specified
        assertParseFailure(parser, "", MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidPreamble_failure() {
        // negative index
        assertParseFailure(parser, "-5" + TITLE_DESC_AMY, MESSAGE_INVALID_FORMAT);

        // zero index
        assertParseFailure(parser, "0" + TITLE_DESC_AMY, MESSAGE_INVALID_FORMAT);

        // invalid arguments being parsed as preamble
        assertParseFailure(parser, "1 some random string", MESSAGE_INVALID_FORMAT);

        // invalid prefix being parsed as preamble
        assertParseFailure(parser, "1 i/ string", MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidValue_failure() {
        assertParseFailure(parser, "1" + INVALID_TITLE_DESC, Title.MESSAGE_CONSTRAINTS); // invalid title
        assertParseFailure(parser, "1" + INVALID_DESC_DESC, Description.MESSAGE_CONSTRAINTS); // invalid desc
        assertParseFailure(parser, "1" + INVALID_LINK_DESC, Link.MESSAGE_CONSTRAINTS); // invalid link
        assertParseFailure(parser, "1" + INVALID_TAG_DESC, Tag.MESSAGE_CONSTRAINTS); // invalid tag

        // invalid title followed by valid description
        assertParseFailure(parser, "1" + INVALID_TITLE_DESC + DESC_DESC_AMY, Title.MESSAGE_CONSTRAINTS);

        // while parsing {@code PREFIX_TAG} alone will reset the tags of the {@code Person} being edited,
        // parsing it together with a valid tag results in error
        assertParseFailure(parser, "1" + TAG_DESC_FRIEND + TAG_DESC_HUSBAND + TAG_EMPTY, Tag.MESSAGE_CONSTRAINTS);
        assertParseFailure(parser, "1" + TAG_DESC_FRIEND + TAG_EMPTY + TAG_DESC_HUSBAND, Tag.MESSAGE_CONSTRAINTS);
        assertParseFailure(parser, "1" + TAG_EMPTY + TAG_DESC_FRIEND + TAG_DESC_HUSBAND, Tag.MESSAGE_CONSTRAINTS);

        // multiple invalid values, but only the first invalid value is captured
        assertParseFailure(parser, "1" + INVALID_TITLE_DESC + VALID_DESC_AMY + INVALID_TITLE_DESC,
                Title.MESSAGE_CONSTRAINTS);
    }

    @Test
    public void parse_allFieldsSpecified_success() {
        Index targetIndex = INDEX_SECOND_FLASHCARD;
        String userInput = targetIndex.getOneBased() + TAG_DESC_HUSBAND
                + DESC_DESC_AMY + TITLE_DESC_AMY + TAG_DESC_FRIEND;

        EditFlashcardDescriptor descriptor = new EditFlashcardDescriptorBuilder().withTitle(VALID_TITLE_AMY)
                .withDescription(VALID_DESC_AMY).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
                .build();
        EditCommand expectedCommand = new EditCommand(targetIndex, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_oneFieldSpecified_success() {
        // title
        Index targetIndex = INDEX_THIRD_FLASHCARD;
        String userInput = targetIndex.getOneBased() + TITLE_DESC_AMY;
        EditFlashcardDescriptor descriptor = new EditFlashcardDescriptorBuilder().withTitle(VALID_TITLE_AMY).build();
        EditCommand expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // description
        userInput = targetIndex.getOneBased() + DESC_DESC_AMY;
        descriptor = new EditFlashcardDescriptorBuilder().withDescription(VALID_DESC_AMY).build();
        expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // tags
        userInput = targetIndex.getOneBased() + TAG_DESC_FRIEND;
        descriptor = new EditFlashcardDescriptorBuilder().withTags(VALID_TAG_FRIEND).build();
        expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_multipleRepeatedFields_acceptsLast() {
        Index targetIndex = INDEX_FIRST_FLASHCARD;
        String userInput = targetIndex.getOneBased() + DESC_DESC_AMY + TAG_DESC_FRIEND
                + DESC_DESC_AMY + TAG_DESC_FRIEND
                + DESC_DESC_BOB + TAG_DESC_HUSBAND;

        EditFlashcardDescriptor descriptor = new EditFlashcardDescriptorBuilder().withDescription(VALID_DESC_BOB)
                .withTags(VALID_TAG_FRIEND, VALID_TAG_HUSBAND)
                .build();
        EditCommand expectedCommand = new EditCommand(targetIndex, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_invalidValueFollowedByValidValue_success() {
        // no other valid values specified
        Index targetIndex = INDEX_FIRST_FLASHCARD;
        String userInput = targetIndex.getOneBased() + INVALID_TITLE_DESC + TITLE_DESC_BOB;
        EditFlashcardDescriptor descriptor = new EditFlashcardDescriptorBuilder().withTitle(VALID_TITLE_BOB).build();
        EditCommand expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // other valid values specified
        userInput = targetIndex.getOneBased() + DESC_DESC_BOB + INVALID_TITLE_DESC + TITLE_DESC_BOB;
        descriptor = new EditFlashcardDescriptorBuilder().withTitle(VALID_TITLE_BOB).withDescription(VALID_DESC_BOB)
                .build();
        expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_resetTags_success() {
        Index targetIndex = INDEX_THIRD_FLASHCARD;
        String userInput = targetIndex.getOneBased() + TAG_EMPTY;

        EditFlashcardDescriptor descriptor = new EditFlashcardDescriptorBuilder().withTags().build();
        EditCommand expectedCommand = new EditCommand(targetIndex, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }
}
