package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static seedu.address.testutil.TypicalFlashcards.getTypicalBagel;

import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.address.commons.core.GuiSettings;
import seedu.address.model.Bagel;
import seedu.address.model.ReadOnlyBagel;
import seedu.address.model.UserPrefs;

public class StorageManagerTest {

    @TempDir
    public Path testFolder;

    private StorageManager storageManager;

    @BeforeEach
    public void setUp() {
<<<<<<< HEAD
        JsonBagelStorage addressBookStorage = new JsonBagelStorage(getTempFilePath("ab"));
=======
        JsonBagelStorage bagelStorage = new JsonBagelStorage(getTempFilePath("ab"));
>>>>>>> a0f1560e2c1a16498aa44176cfb5d7df4e027f0f
        JsonUserPrefsStorage userPrefsStorage = new JsonUserPrefsStorage(getTempFilePath("prefs"));
        storageManager = new StorageManager(bagelStorage, userPrefsStorage);
    }

    private Path getTempFilePath(String fileName) {
        return testFolder.resolve(fileName);
    }

    @Test
    public void prefsReadSave() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonUserPrefsStorage} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonUserPrefsStorageTest} class.
         */
        UserPrefs original = new UserPrefs();
        original.setGuiSettings(new GuiSettings(300, 600, 4, 6));
        storageManager.saveUserPrefs(original);
        UserPrefs retrieved = storageManager.readUserPrefs().get();
        assertEquals(original, retrieved);
    }

    @Test
    public void bagelReadSave() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonBagelStorage} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonBagelStorageTest} class.
         */
        Bagel original = getTypicalBagel();
        storageManager.saveBagel(original);
        ReadOnlyBagel retrieved = storageManager.readBagel().get();
        assertEquals(original, new Bagel(retrieved));
    }

    @Test
    public void getBagelFilePath() {
        assertNotNull(storageManager.getBagelFilePath());
    }

}
