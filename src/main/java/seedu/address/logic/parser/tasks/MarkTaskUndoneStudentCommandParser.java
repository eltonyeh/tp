package seedu.address.logic.parser.tasks;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.tasks.MarkTaskDoneStudentCommand;
import seedu.address.logic.commands.tasks.MarkTaskUndoneStudentCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;

public class MarkTaskUndoneStudentCommandParser implements Parser<MarkTaskUndoneStudentCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the MarkTaskUndoneStudentCommand
     * and returns a MarkTaskUndoneStudentCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public MarkTaskUndoneStudentCommand parse(String args) throws ParseException {
        requireNonNull(args);
        Index personIndex;
        Index taskIndex;

        try {
            Index[] indices = ParserUtil.parseTwoIndices(args);
            personIndex = indices[0];
            taskIndex = indices[1];
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    MarkTaskDoneStudentCommand.MESSAGE_USAGE), pe);
        }

        return new MarkTaskUndoneStudentCommand(personIndex, taskIndex);
    }
}
