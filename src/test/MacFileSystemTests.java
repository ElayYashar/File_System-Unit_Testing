import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import org.junit.Test;

// TODO: need to add test to read and write

public class MacFileSystemTests 
{
    HashMap<String, String> fileSystem;
    private final String DESKTOP_PATH = "/usr/desktop/filetInDesktop.txt";
    private final String NOT_DESKTOP_PATH = "/usr/notDesktop/fileNotInDesktop.txt";

    // read
    @Test
    public void when_CanReadFile_Should_ReturnContentOfFile() throws Exception
    {
        fileSystem = new HashMap<>();
        fileSystem.put(DESKTOP_PATH, "");
        MacFileSystem macFileSystem = new MacFileSystem(fileSystem);

        String excepted = "";
        String actual = macFileSystem.read(DESKTOP_PATH);

        assertEquals(excepted, actual);
    }

    // write

    // delete
    @Test
    public void when_Delete_Should_ReturnFalse()
    {
        // Arrange
        MacFileSystem macFileSystem = new MacFileSystem(fileSystem);

        // Act
        boolean deleted = macFileSystem.delete(DESKTOP_PATH);

        // Assert
        assertFalse(deleted);
    }

    // canWrite
    @Test
    public void when_PathIsInDesktopFolder_Should_ReturnTrue()
    {
        // Arrange
        MacFileSystem macFileSystem = new MacFileSystem(fileSystem);

        // Act
        boolean canWrite = macFileSystem.canRead(DESKTOP_PATH);

        // Assert
        assertTrue(canWrite);
    }

    @Test
    public void when_PathIsNotInDesktopFolder_Should_ReturnTrue()
    {
        // Arrange
        MacFileSystem macFileSystem = new MacFileSystem(fileSystem);

        // Act
        boolean canWrite = macFileSystem.canWrite(NOT_DESKTOP_PATH);

        // Assert
        assertFalse(canWrite);
    }

    // canRead ==> Uses canWrite() so there is no need to check it

    // isDesktopFolder
    @Test
    public void when_PathSyntaxIsCorrectAndInDesktopFolder_Should_ReturnTrue()
    {
        // Arrange
        MacFileSystem macFileSystem = new MacFileSystem(fileSystem);

        // Act
        boolean isDesktopFolder = macFileSystem.isDesktopFolder(DESKTOP_PATH);

        // Assert
        assertTrue(isDesktopFolder);
    }

    @Test
    public void when_PathSyntaxIsNotCorrectAndInDesktopFolder_Should_ReturnFalse()
    {
        // Arrange
        MacFileSystem macFileSystem = new MacFileSystem(fileSystem);
        String incorrectPathInDesktop = "/usr/desktop/text";

        // Act
        boolean isDesktopFolder = macFileSystem.isDesktopFolder(incorrectPathInDesktop);

        // Assert
        assertFalse(isDesktopFolder);
    }

    @Test
    public void when_PathSyntaxIsCorrectAndNotInDesktopFolder_Should_ReturnFalse()
    {
        // Arrange
        MacFileSystem macFileSystem = new MacFileSystem(fileSystem);

        // Act
        boolean isDesktopFolder = macFileSystem.isDesktopFolder(NOT_DESKTOP_PATH);

        // Assert
        assertFalse(isDesktopFolder);
    }

    @Test
    public void when_PathSyntaxIsNotCorrectAndNotInDesktopFolder_Should_ReturnFalse()
    {
        // Arrange
        MacFileSystem macFileSystem = new MacFileSystem(fileSystem);

        // Act
        String incorrectPathNotInDesktop = "/usr/notdesktop/text";
        boolean isDesktopFolder = macFileSystem.isDesktopFolder(incorrectPathNotInDesktop);

        // Assert
        assertFalse(isDesktopFolder);
    }
}
