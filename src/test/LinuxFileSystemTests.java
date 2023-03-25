import static org.junit.Assert.*;
import java.util.HashMap;
import org.junit.Test;

public class LinuxFileSystemTests
{
    HashMap<String, String> fileSystem;
    private final String CORRECT_LINUX_PATH = "/correntFolder/correctTestFile.txt";
    private final String CONTENT = "This is some good content!";

    //exists method
    @Test
    public void when_FileExistsInFileExplorer_Should_ReturnTrue()
    {
        // Arrange
        fileSystem = new HashMap<>();
        fileSystem.put(CORRECT_LINUX_PATH, CONTENT);
        LinuxFileSystem linuxFileSystem = new LinuxFileSystem(fileSystem);

        // Act
        boolean exists = linuxFileSystem.exists(CORRECT_LINUX_PATH);

        // Assert
        assertTrue(exists);
    }

    @Test
    public void when_FileDoesNotExistsInFileExplorer_Should_ReturnFalse()
    {
        // Arrange
        fileSystem = new HashMap<>();
        fileSystem.put(CORRECT_LINUX_PATH, CONTENT);
        LinuxFileSystem linuxFileSystem = new LinuxFileSystem(fileSystem);
        String nonExistentPath = "/nonExistentFolder/nonExistentFile.txt";

        // Act
        boolean exists = linuxFileSystem.exists(nonExistentPath);

        // Assert
        assertFalse(exists);
    }

    // read method
    @Test
    public void when_LinuxCanReadFile_Should_ReturnContentOfFile() throws Exception
    {
        // Arrange
        fileSystem = new HashMap<>();
        fileSystem.put(CORRECT_LINUX_PATH, CONTENT);
        LinuxFileSystem linuxFileSystem = new LinuxFileSystem(fileSystem);

        // Act
        String expected = CONTENT;
        String actual = linuxFileSystem.read(CORRECT_LINUX_PATH);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void when_LinuxCanNotReadFile_Should_ThrowExecption() throws Exception
    {
        // Arrange
        fileSystem = new HashMap<>();
        fileSystem.put(CORRECT_LINUX_PATH, CONTENT);
        LinuxFileSystem linuxFileSystem = new LinuxFileSystem(fileSystem);
        String nonExistentPath = "/nonExistentFolder/nonExistentFile.txt";

        // Act
       
        // Assert
        assertThrows(Exception.class, 
        () -> {
            linuxFileSystem.read(nonExistentPath);
        });
    }
}