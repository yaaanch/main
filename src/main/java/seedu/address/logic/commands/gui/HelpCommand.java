package seedu.address.logic.commands.gui;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.cli.AddModuleCommand;
import seedu.address.logic.commands.cli.DeleteModuleCommand;
import seedu.address.logic.commands.cli.RedoCommand;
import seedu.address.logic.commands.cli.SetCurrentSemesterCommand;
import seedu.address.logic.commands.cli.UndoCommand;
import seedu.address.logic.commands.datamanagement.DeleteTagCommand;
import seedu.address.logic.commands.datamanagement.RemoveTagFromAllCommand;
import seedu.address.logic.commands.datamanagement.RemoveTagFromModuleCommand;
import seedu.address.logic.commands.datamanagement.RenameTagCommand;
import seedu.address.logic.commands.datamanagement.TagModuleCommand;
import seedu.address.logic.commands.datamanagement.ViewAllTagsCommand;
import seedu.address.logic.commands.datamanagement.ViewDefaultTagsCommand;
import seedu.address.logic.commands.datamanagement.ViewModuleTagsCommand;
import seedu.address.logic.commands.datamanagement.ViewTaggedCommand;
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

/**
 * Format full help instructions for every command for display.
 */
public class HelpCommand extends Command {

    public static final String COMMAND_WORD = "help";
    public static final String HELP_MESSAGE = COMMAND_WORD + ": Showing help";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "Example: " + COMMAND_WORD;
    public static final String AUTOCOMPLETE_MESSAGE = "Press TAB to autocomplete a command.";

    public static final String SHOWING_HELP_MESSAGE = "Type help <command> to find out more.\n"
            + AUTOCOMPLETE_MESSAGE + "\n\n"
            + "List of commands:\n"
            + "\nSemesters and Modules:\n"
            + AddModuleCommand.HELP_MESSAGE + "\n"
            + DeleteModuleCommand.HELP_MESSAGE + "\n"
            + SetCurrentSemesterCommand.HELP_MESSAGE + "\n"
            + "???: nameue - Naming a UE from a semester\n"
            + "NOT YET: move - Moving a module from one semester to another\n"
            + "???: block - Blocking off the given semester\n"
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
            + "\nTags:\n"
            + ViewAllTagsCommand.HELP_MESSAGE + "\n"
            + ViewDefaultTagsCommand.HELP_MESSAGE + "\n"
            + TagModuleCommand.HELP_MESSAGE + "\n"
            + RemoveTagFromModuleCommand.HELP_MESSAGE + "\n"
            + RemoveTagFromAllCommand.HELP_MESSAGE + "\n"
            + RenameTagCommand.HELP_MESSAGE + "\n"
            + DeleteTagCommand.HELP_MESSAGE + "\n"
            + ViewModuleTagsCommand.HELP_MESSAGE + "\n"
            + ViewTaggedCommand.HELP_MESSAGE + "\n"
            + "\nModule information:\n"
            + DescriptionCommand.HELP_MESSAGE + "\n"
            + ValidModsCommand.HELP_MESSAGE + "\n"
            + "NOT YET: findmod - Finding modules using the module code\n"
            + "NOT YET: getmodcode - Finding module code using keywords\n"
            + "\nGUI:\n"
            + "NOT YET: expand - Expanding a semester\n"
            + "NOT YET: collapse - Collapsing a semester\n"
            + "\nUndo/Redo:\n"
            + UndoCommand.HELP_MESSAGE + "\n"
            + RedoCommand.HELP_MESSAGE;

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(SHOWING_HELP_MESSAGE, false, false);
    }
}
