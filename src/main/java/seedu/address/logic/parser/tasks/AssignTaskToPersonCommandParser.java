package seedu.address.logic.parser.tasks;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_INDEX_GIVEN;
import static seedu.address.logic.parser.ValidateUtil.hasExpectedSeparatedSegments;
import static seedu.address.logic.parser.ValidateUtil.isEmptyOrOnlyWhitespace;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.tasks.AssignTaskToPersonCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;

public class AssignTaskToPersonCommandParser implements Parser<AssignTaskToPersonCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AssignTaskToPersonCommand
     * and returns an AssignTaskToPersonCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AssignTaskToPersonCommand parse(String args) throws ParseException {
        requireNonNull(args);

        if (isEmptyOrOnlyWhitespace(args) || !hasExpectedSeparatedSegments(args, 2)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    AssignTaskToPersonCommand.MESSAGE_USAGE));
        }

        Index personIndex;
        Index taskIndex;

        try {
            Index[] indices = ParserUtil.parseTwoIndices(args);
            personIndex = indices[0];
            taskIndex = indices[1];
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    MESSAGE_INVALID_INDEX_GIVEN), pe);
        }

        return new AssignTaskToPersonCommand(personIndex, taskIndex);
    }
}
