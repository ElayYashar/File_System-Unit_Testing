import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import org.junit.Test;

public class WindowsFileSystemTests 
{
    HashMap<String, String> fileSystem;
    private final String CORRECT_WINDOWS_PATH = "C:/correntFolder/correctTestFile.txt";
    private final String CONTENT = "This is some good content!";

    //exists method
    @Test
    public void when_FileExistsInFileExplorer_Should_ReturnTrue()
    {
        // Arrange
        fileSystem = new HashMap<>();
        fileSystem.put(CORRECT_WINDOWS_PATH, CONTENT);
        WindowsFileSystem windowsFileSystemFileSystem = new WindowsFileSystem(fileSystem);

        // Act
        boolean exists = windowsFileSystemFileSystem.exists(CORRECT_WINDOWS_PATH);

        // Assert
        assertTrue(exists);
    }

    @Test
    public void when_FileDoesNotExistsInFileExplorer_ShouldReturnFalse()
    {
        // Arrange
        fileSystem = new HashMap<>();
        fileSystem.put(CORRECT_WINDOWS_PATH, CONTENT);
        WindowsFileSystem windowsFileSystem = new WindowsFileSystem(fileSystem);

        // Act
        boolean exists = windowsFileSystem.exists("C:/correctFolder/differentTestFile.txt");

        // Assert
        assertFalse(exists);
    }

    // read method
    @Test
    public void when_WindowsCanReadFile_Should_ReturnContentOfFile() throws Exception
    {
        // Arrange
        fileSystem = new HashMap<>();
        fileSystem.put(CORRECT_WINDOWS_PATH, CONTENT);
        WindowsFileSystem windowsFileSystem = new WindowsFileSystem(fileSystem);

        // Act
        String expected = CONTENT;
        String actual = windowsFileSystem.read(CORRECT_WINDOWS_PATH);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void when_WindowsCanNotReadFile_Should_ThrowException() throws Exception
    {
        // Arrange
        fileSystem = new HashMap<>();
        fileSystem.put(CORRECT_WINDOWS_PATH, CONTENT);
        WindowsFileSystem windowsFileSystem = new WindowsFileSystem(fileSystem);

        // Act
        Class<Exception> expected = Exception.class;

        // Assert
        assertThrows(expected, () -> 
        {
            windowsFileSystem.read("C:/folder/nottest.txt");
        });
    }

    // write method
    @Test
    public void when_WindowsCanWrite_Should_AddFileAndContent() throws Exception
    {
        // Arrange
        fileSystem = new HashMap<>();
        WindowsFileSystem windowsFileSystem = new WindowsFileSystem(fileSystem);
        windowsFileSystem.write(CORRECT_WINDOWS_PATH, CONTENT);

        // Act
        String excpected = CONTENT;
        String actual = windowsFileSystem.read(CORRECT_WINDOWS_PATH);

        // Assert
        assertEquals(excpected, actual);
    }

    @Test
    public void when_WindowsCanNotWrite_Should_DoNothing()
    {
        // Arrange
        fileSystem = new HashMap<>();
        WindowsFileSystem windowsFileSystem = new WindowsFileSystem(fileSystem);
        String pathInRoot = "C:/test.txt";
        windowsFileSystem.write(pathInRoot, CONTENT);

        // Act
        boolean exists = windowsFileSystem.exists(pathInRoot);

        // Assert
        assertFalse(exists);
    }

    // delete method
    @Test
    public void when_DeleteFileThatExist_Should_RemovePathAndReturnTrue()
    {
        // Arrange
        fileSystem = new HashMap<>();
        WindowsFileSystem windowsFileSystem = new WindowsFileSystem(fileSystem);
        windowsFileSystem.write(CORRECT_WINDOWS_PATH, CONTENT);

        // Act
        boolean deleted = windowsFileSystem.delete(CORRECT_WINDOWS_PATH);

        // Assert
        assertTrue(deleted);
    }

    @Test
    public void when_DeleteFileThatDoesNotExist_Should_ReturnFalse()
    {
        // Arrange
        fileSystem = new HashMap<>();
        WindowsFileSystem windowsFileSystem = new WindowsFileSystem(fileSystem);

        // Act
        boolean deleted = windowsFileSystem.delete(CORRECT_WINDOWS_PATH);

        // Assert
        assertFalse(deleted);
    }

    @Test
    public void when_DeleteFileInRootFolder_Should_ReturnFalse()
    {
        // Arrange
        fileSystem = new HashMap<>();
        WindowsFileSystem windowsFileSystem = new WindowsFileSystem(fileSystem);
        String pathInRoot = "C:/test.txt";
        windowsFileSystem.write(pathInRoot, CONTENT);

        // Act
        boolean deleted = windowsFileSystem.delete(pathInRoot);

        // Assert
        assertFalse(deleted);
    }

    // canRead method
    @Test
    public void when_FileSyntaxIsRight_Should_ReturnTrue()
    {
        // Arrange
        fileSystem = new HashMap<>();
        fileSystem.put(CORRECT_WINDOWS_PATH, CONTENT);
        WindowsFileSystem windowsFileSystem = new WindowsFileSystem(fileSystem);

        // Act
        boolean canRead = windowsFileSystem.canRead(CORRECT_WINDOWS_PATH);

        // Assert
        assertTrue(canRead);
    }

    @Test
    public void when_FileSyntaxIsWrong_Should_ReturnFalse()
    {
        // The file system can be empty because it won't even check the files

        // Arrange
        WindowsFileSystem windowsFileSystem = new WindowsFileSystem(fileSystem);
        String pathWithNoExtension = "C:/folder/anotherfolder/text";

        // Act
        boolean canRead = windowsFileSystem.canRead(pathWithNoExtension);

        // Assert
        assertFalse(canRead);
    }

    // canWrite method
    @Test
    public void when_FileIsInRoot_Should_ReturnFalse()
    {
        // Arrange
        WindowsFileSystem windowsFileSystem = new WindowsFileSystem(fileSystem);
        String pathInRoot = "C:/text.txt";

        // Act
        boolean canWrite = windowsFileSystem.canWrite(pathInRoot);

        // Assert
        assertFalse(canWrite);
    }

    @Test
    public void when_FileIsInNotRoot_Should_ReturnTrue()
    {
        // Arrange
        WindowsFileSystem windowsFileSystem = new WindowsFileSystem(fileSystem);

        // Act
        boolean canWrite = windowsFileSystem.canWrite(CORRECT_WINDOWS_PATH);

        // Assert
        assertTrue(canWrite);
    }

        // isPathInRootFolder protected method    
        @Test
        public void when_FileIsInRootFolder_Should_ReturnTrue()
        {
            // Arrange
            WindowsFileSystem windowsFileSystem = new WindowsFileSystem(fileSystem);

            // Act
            String pathInRoot = "/fileInRoot.txt";
            boolean isPathInRootFolder = windowsFileSystem.isPathInRoot(pathInRoot);

            // Assert
            assertTrue(isPathInRootFolder);
        }
    
        @Test
        public void when_FileIsNotInRootFolder_Should_ReturnFalse()
        {
            // Arrange
            WindowsFileSystem windowsFileSystem = new WindowsFileSystem(fileSystem);

            // Act
            boolean isPathInRoot = windowsFileSystem.isPathInRoot(CORRECT_WINDOWS_PATH);
            assertFalse(isPathInRoot);
        }
}
