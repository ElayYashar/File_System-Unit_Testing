import static org.junit.Assert.*;
import java.util.HashMap;
import org.junit.Test;

public class BaseFileSystemTests
{
    HashMap<String, String> fileSystem;
    private final String PATH = "/folder/text.txt";

    //exists method
    @Test
    public void when_FileExistsInFileExplorer_Should_ReturnTrue()
    {
        // Arrange
        fileSystem = new HashMap<>();
        fileSystem.put(PATH, "");
        ConcreteBaseFileSystem baseFileSystem = new ConcreteBaseFileSystem(fileSystem);

        // Act
        boolean exists = baseFileSystem.exists(PATH);

        // Assert
        assertTrue(exists);
    }

    // read method
    @Test
    public void when_CanReadFile_Should_ReturnContentOfFile() throws Exception
    {
        // Arrange
        fileSystem = new HashMap<>();
        fileSystem.put(PATH, "");
        ConcreteBaseFileSystem baseFileSystem = new ConcreteBaseFileSystem(fileSystem);

        // Act
        String expected = "";
        String actual = baseFileSystem.read(PATH);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void when_CanNotReadFile_Should_ThrowException() throws Exception
    {
        // Arrange
        fileSystem = new HashMap<>();
        fileSystem.put(PATH, "");
        ConcreteBaseFileSystem baseFileSystem = new ConcreteBaseFileSystem(fileSystem);

        // Act
        Class<Exception> expected = Exception.class;

        // Assert
        assertThrows(expected, () -> 
        {
            baseFileSystem.read("/folder/nottest.txt");
        });
    }

    // write method

    // canRead method
    @Test
    public void when_FileSyntaxIsRight_Should_ReturnTrue()
    {
        // Arrange
        fileSystem = new HashMap<>();
        fileSystem.put(PATH, "");
        ConcreteBaseFileSystem baseFileSystem = new ConcreteBaseFileSystem(fileSystem);

        // Act
        boolean canRead = baseFileSystem.canRead(PATH);

        // Assert
        assertTrue(canRead);
    }

    @Test
    public void when_FileSyntaxIsWrong_Should_ReturnFalse()
    {
        // The file system can be empty because it won't even check the files

        // Arrange
        ConcreteBaseFileSystem baseFileSystem = new ConcreteBaseFileSystem(fileSystem);
        String pathWithNoExtension = "C:/folder/anotherfolder/text";

        // Act
        boolean canRead = baseFileSystem.canRead(pathWithNoExtension);

        // Assert
        assertFalse(canRead);
    } 

    // canWrite method
}