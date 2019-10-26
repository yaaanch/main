package seedu.address.logic.commands.gui;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.cli.AddModuleCommand;
import seedu.address.logic.commands.cli.DeleteModuleCommand;
import seedu.address.logic.commands.cli.SetCurrentSemesterCommand;
import seedu.address.logic.commands.datamanagement.ViewAllTagsCommand;
import seedu.address.logic.commands.datamanagement.ViewDefaultTagsCommand;
import seedu.address.logic.commands.storage.ActivateStudyPlanCommand;
import seedu.address.logic.commands.storage.CommitStudyPlanEditCommand;
import seedu.address.logic.commands.storage.CreateStudyPlanCommand;
import seedu.address.logic.commands.storage.DeleteCommand;
import seedu.address.logic.commands.storage.DeleteCommitCommand;
import seedu.address.logic.commands.storage.EditTitleCommand;
import seedu.address.logic.commands.storage.ListAllStudyPlansCommand;
import seedu.address.logic.commands.storage.RevertCommitCommand;
import seedu.address.logic.commands.storage.ViewCommitHistoryCommand;
import seedu.address.logic.commands.verification.DescriptionCommand;
import seedu.address.logic.commands.verification.ValidModsCommand;
import seedu.address.model.Model;

import javax.swing.text.View;

/**
 * Format full help instructions for every command for display.
 */
public class HelpCommand extends Command {

    public static final String COMMAND_WORD = "help";
    public static final String HELP_MESSAGE = COMMAND_WORD + ": Showing help";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "Example: " + COMMAND_WORD;
    public static final String AUTOCOMPLETE_MESSAGE = "Press TAB to autocomplete a command.";

    public static final String SHOWING_HELP_MESSAGE = "Type help <command> to find out more. List of commands:\n\n"
            + AUTOCOMPLETE_MESSAGE + "\n"
            + "\nStudy plans and committing:\n"
            + CreateStudyPlanCommand.HELP_MESSAGE + "\n"
            + DeleteCommand.HELP_MESSAGE + "\n"
            + CommitStudyPlanEditCommand.HELP_MESSAGE + "\n"
            + ViewCommitHistoryCommand.HELP_MESSAGE + "\n"
            + DeleteCommitCommand.HELP_MESSAGE + "\n"
            + RevertCommitCommand.HELP_MESSAGE + "\n"
            + ActivateStudyPlanCommand.HELP_MESSAGE + "\n"
            + EditTitleCommand.HELP_MESSAGE + "\n"
            + ListAllStudyPlansCommand.HELP_MESSAGE + "\n"
            + "NOT YET: viewcommit - Viewing a commit\n"
            + "NOT YET: viewplan - Viewing another study plan\n"
            + "NOT YET: remove - Deleting a semester from a study plan\n"
            + "NOT YET: default - Setting default study plan\n"
            + "\nGUI:\n"
            + HelpCommand.HELP_MESSAGE + "\n"
            + "NOT YET: expand - Expanding a semester\n"
            + "NOT YET: collapse - Collapsing a semester\n"
            + "\nSemesters and modules\n"
            + AddModuleCommand.HELP_MESSAGE + "\n"
            + DeleteModuleCommand.HELP_MESSAGE + "\n"
            + SetCurrentSemesterCommand.HELP_MESSAGE + "\n"
            + "???: nameue - Naming a UE from a semester\n"
            + "NOT YET: move - Moving a module from one semester to another\n"
            + "???: block - Blocking off the given semester\n"
            + "\nRegarding undo/redo\n"
            + "NOT YET: undo - Undo-ing the previous command\n"
            + "NOT YET: redo - Redo-ing the previous undone command\n"
            + "\nRegarding data classification and management:\n"
            + ViewAllTagsCommand.HELP_MESSAGE + "\n"
            + ViewDefaultTagsCommand.HELP_MESSAGE + "\n"
            + "viewdefaulttags - Viewing default tags\n"
            + "viewalltags - Viewing all tags\n"
            + "renametag - Renaming an existing tag\n"
            + "addtag - Tagging modules\n"
            + "removetag - Removing a tag from a module\n"
            + "removeall - Removing a tag from all modules\n"
            + "deletetag - Deleting tags\n"
            + "viewtagged - Viewing modules with specific tags\n"
            + "viewtags - Viewing tags for a specific module\n"
            + "findmod - Finding modules using the module code\n"
            + "getmodcode - Finding module code using keywords\n"
            + "mcs - Viewing total completed MCs\n"
            + "\nRegarding module information:\n"
            + DescriptionCommand.HELP_MESSAGE
            + ValidModsCommand.HELP_MESSAGE;

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(SHOWING_HELP_MESSAGE, true, false);
    }
}
