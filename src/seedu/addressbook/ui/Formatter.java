package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;

import java.util.ArrayList;
import java.util.List;

/**
 * Collection of methods for formatting texts 
 */
public final class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;
    
    /** No need for class to be instantiated. */
    private Formatter() {
    }
    
    
    public static String[] formatWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        return new String[] { DIVIDER,
                DIVIDER,
                MESSAGE_WELCOME,
                version,
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
                storageFileInfo,
                DIVIDER};
    }
    
    /**
     * Adds the specified number of dividers to the message
     * @param numberOfDividers Number of dividers to be appended
     * @return String Array with dividers appended at index 1 onwards
     */
    public static String[] appendDividers(String message, int numberOfDividers) {
        List<String> stringList = new ArrayList<String>();
        stringList.add(message);
        for(int i=0; i<numberOfDividers; i++) {
            stringList.add(DIVIDER);
        }
        return stringList.toArray(new String[0]);
    }
    
    public static String insertLinePrefix(String message) {
        return LINE_PREFIX + message;
    }
    
    /** Formats message(s) to be shown to the user */
    public static String formatToShowToUser(String... message) {
        final StringBuilder formatted = new StringBuilder();
        for (String m : message) {
            formatted.append(LINE_PREFIX);
            formatted.append(m.replace("\n", LS + LINE_PREFIX));
            formatted.append(LS);
        }
        return formatted.toString();
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    public static String formatIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(formatIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    public static String formatIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
}
