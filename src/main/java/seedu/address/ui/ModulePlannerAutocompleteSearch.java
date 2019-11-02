package seedu.address.ui;

import javafx.collections.ListChangeListener;
import javafx.scene.control.ContextMenu;
import seedu.address.logic.commands.cli.*;
import seedu.address.logic.commands.datamanagement.*;
import seedu.address.logic.commands.gui.*;
import seedu.address.logic.commands.storage.*;
import seedu.address.logic.commands.verification.CheckCommand;
import seedu.address.logic.commands.verification.ClearInvalidModsCommand;
import seedu.address.logic.commands.verification.DescriptionCommand;
import seedu.address.logic.commands.verification.ValidModsCommand;
import seedu.address.model.ReadOnlyModulePlanner;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.UniqueTagList;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * Handles autocompletion searching.
 */
public class ModulePlannerAutocompleteSearch {
    public static final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";

    private final ReadOnlyModulePlanner modulePlanner;

    private SortedSet<String> commandKeywords;
    private SortedSet<String> argumentKeywords;
    private UniqueTagList tags;

    public ModulePlannerAutocompleteSearch(ReadOnlyModulePlanner modulePlanner) {
        super();
        this.modulePlanner = modulePlanner;
        tags = modulePlanner.getActiveTags();
        tags.asUnmodifiableObservableList().addListener((ListChangeListener<Tag>) change
            -> generateArgumentKeywords());
        generateCommandKeywords();
        generateArgumentKeywords();
    }

    /**
     * Generates the sorted set of required command keywords.
     */
    private void generateCommandKeywords() {
        commandKeywords = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        commandKeywords.add(AddModuleCommand.COMMAND_WORD);
        commandKeywords.add(BlockCurrentSemesterCommand.COMMAND_WORD);
        commandKeywords.add(DeleteModuleCommand.COMMAND_WORD);
        commandKeywords.add(UnblockCurrentSemesterCommand.COMMAND_WORD);
        commandKeywords.add(SetCurrentSemesterCommand.COMMAND_WORD);
        commandKeywords.add(FindModuleCommand.COMMAND_WORD);
        commandKeywords.add(CommitStudyPlanCommand.COMMAND_WORD);
        commandKeywords.add(CreateStudyPlanCommand.COMMAND_WORD);
        commandKeywords.add(DeleteStudyPlanCommand.COMMAND_WORD);
        commandKeywords.add(DeleteCommitCommand.COMMAND_WORD);
        commandKeywords.add(RevertCommitCommand.COMMAND_WORD);
        commandKeywords.add(TagModuleCommand.COMMAND_WORD);
        commandKeywords.add(ViewCommitHistoryCommand.COMMAND_WORD);
        commandKeywords.add(RemoveTagFromModuleCommand.COMMAND_WORD);
        commandKeywords.add(ViewModuleTagsCommand.COMMAND_WORD);
        commandKeywords.add(DeleteTagCommand.COMMAND_WORD);
        commandKeywords.add(RemoveTagFromAllCommand.COMMAND_WORD);
        commandKeywords.add(RenameTagCommand.COMMAND_WORD);
        commandKeywords.add(ViewAllTagsCommand.COMMAND_WORD);
        commandKeywords.add(ViewDefaultTagsCommand.COMMAND_WORD);
        commandKeywords.add(ViewTaggedCommand.COMMAND_WORD);
        commandKeywords.add(EditTitleCommand.COMMAND_WORD);
        commandKeywords.add(ActivateStudyPlanCommand.COMMAND_WORD);
        commandKeywords.add(ListAllStudyPlansCommand.COMMAND_WORD);
        commandKeywords.add(HelpCommand.COMMAND_WORD);
        commandKeywords.add(TagStudyPlanCommand.COMMAND_WORD);
        commandKeywords.add(RemoveTagFromStudyPlanCommand.COMMAND_WORD);
        commandKeywords.add(SortStudyPlansByPriorityTagCommand.COMMAND_WORD);
        commandKeywords.add(ValidModsCommand.COMMAND_WORD);
        commandKeywords.add(DescriptionCommand.COMMAND_WORD);
        commandKeywords.add(CheckCommand.COMMAND_WORD);
        commandKeywords.add(ClearInvalidModsCommand.COMMAND_WORD);
        commandKeywords.add(DeleteSemesterCommand.COMMAND_WORD);
        commandKeywords.add(AddSemesterCommand.COMMAND_WORD);
        commandKeywords.add(ViewCommitCommand.COMMAND_WORD);
        commandKeywords.add(ViewStudyPlanCommand.COMMAND_WORD);
        commandKeywords.add(DefaultStudyPlanCommand.COMMAND_WORD);
        commandKeywords.add(CollapseCommand.COMMAND_WORD);
        commandKeywords.add(ExpandCommand.COMMAND_WORD);
        commandKeywords.add(CollapseAllCommand.COMMAND_WORD);
        commandKeywords.add(ExpandAllCommand.COMMAND_WORD);
    }

    /**
     * Generates the sorted set of required argument keywords.
     */
    private void generateArgumentKeywords() {
        argumentKeywords = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        if (tags != null) {
            argumentKeywords.addAll(tags.asListOfStrings());
        }
        argumentKeywords.addAll(modulePlanner.getModuleCodes());
    }

    /**
     * Resets the argument keywords when there is a change in the active study plan.
     */
    public void handleChangeOfActiveStudyPlan() {
        tags = modulePlanner.getActiveStudyPlan().getModuleTags();
        tags.asUnmodifiableObservableList().addListener((ListChangeListener<Tag>) change
            -> generateArgumentKeywords());
        generateArgumentKeywords();
    }

    public List<String> getSearchResults(String input) {
        requireNonNull(input);
        String[] inputArray = input.split(String.format(WITH_DELIMITER, " "));
        if (inputArray.length == 1) {
            return performSearch(inputArray[0], commandKeywords);
        } else if (inputArray[0].equals(HelpCommand.COMMAND_WORD)) {
            // The Help command uses commands as arguments.
            return performSearch(inputArray[inputArray.length - 1], commandKeywords);
        } else {
            return performSearch(inputArray[inputArray.length - 1], argumentKeywords);
        }
    }

    private List<String> performSearch(String input, SortedSet<String> keywords) {
        requireAllNonNull(input, keywords);
        List<String> searchResults = new ArrayList<>(keywords.subSet(input,
                input + Character.MAX_VALUE));
        return searchResults;
    }
}
