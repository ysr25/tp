package seedu.bagel.logic.parser;

import static seedu.bagel.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.bagel.logic.parser.CliSyntax.PREFIX_REQ;

import seedu.bagel.logic.commands.sort.SortCommand;
import seedu.bagel.logic.commands.sort.SortCommand.SortRequirement;
import seedu.bagel.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new SortCommand object
 */
public class SortCommandParser implements Parser<SortCommand> {

    @Override
    public SortCommand parse(String args) throws ParseException {
        try {
            ArgumentMultimap argMultimap =
                    ArgumentTokenizer.tokenize(args, PREFIX_REQ);
            SortRequirement req = ParserUtil.parseRequirement(argMultimap.getValue(PREFIX_REQ).get());
            return new SortCommand(req);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortCommand.MESSAGE_USAGE), pe);
        }
    }
}
