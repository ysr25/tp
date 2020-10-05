package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyBagel;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;

/**
 * Manages storage of Bagel data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private BagelStorage bagelStorage;
    private UserPrefsStorage userPrefsStorage;

    /**
     * Creates a {@code StorageManager} with the given {@code BagelStorage} and {@code UserPrefStorage}.
     */
    public StorageManager(BagelStorage bagelStorage, UserPrefsStorage userPrefsStorage) {
        super();
        this.bagelStorage = bagelStorage;
        this.userPrefsStorage = userPrefsStorage;
    }

    // ================ UserPrefs methods ==============================

    @Override
    public Path getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
    }


    // ================ AddressBook methods ==============================

    @Override
    public Path getBagelFilePath() {
        return bagelStorage.getBagelFilePath();
    }

    @Override
    public Optional<ReadOnlyBagel> readBagel() throws DataConversionException, IOException {
        return readBagel(bagelStorage.getBagelFilePath());
    }

    @Override
    public Optional<ReadOnlyBagel> readBagel(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return bagelStorage.readBagel(filePath);
    }

    @Override
    public void saveBagel(ReadOnlyBagel bagel) throws IOException {
        saveAddressBook(bagel, bagelStorage.getBagelFilePath());
    }

    @Override
    public void saveBagel(ReadOnlyBagel bagel, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        bagelStorage.saveBagel(bagel, filePath);
    }

}
