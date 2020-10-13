package seedu.simplykitchen.logic.parser;

import static seedu.simplykitchen.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.simplykitchen.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.simplykitchen.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.simplykitchen.logic.commands.FindCommand;
import seedu.simplykitchen.model.food.DescriptionContainsKeywordsPredicate;

public class FindCommandParserTest {

    private FindCommandParser parser = new FindCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindCommand() {
        // no leading and trailing whitespaces
        FindCommand expectedFindCommand =
                new FindCommand(new DescriptionContainsKeywordsPredicate(Arrays.asList("Anchovies", "Bread")));
        assertParseSuccess(parser, "Anchovies Bread", expectedFindCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n Anchovies \n \t Bread  \t", expectedFindCommand);
    }

}
