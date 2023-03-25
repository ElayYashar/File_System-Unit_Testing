import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

    // test.txt/folder => Bad (Folder cant come after file)
    // test.txt => Bad (No path)
    // folder/file => Bad (Missing extension)

public class PathCheckerTests 
{
    // check method
    @Test
    public void when_PathHasExtension_Should_ReturnTrue()
    {
        assertTrue(PathChecker.check("/folder/test.txt"));
    }

    @Test
    public void when_PathDoesntHaveExtension_Should_ReturnFalse()
    {
        assertFalse(PathChecker.check("/folder/test"));
    }

    @Test
    public void when_FileComesAfterFolder_Should_ReturnTrue()
    {
        assertTrue(PathChecker.check("/folder/test.txt"));
    }

    @Test
    public void when_FileDoesntComesAfterFolder_Should_ReturnTrue()
    {
        assertFalse(PathChecker.check("/test.txt/folder"));
    }

    @Test
    public void when_FileHasFullPath_Should_ReturnTrue()
    {
        assertTrue(PathChecker.check("/folder/test.txt"));
    }

    @Test
    public void when_DoesntFileHasFullPath_Should_ReturnTrue()
    {
        assertFalse(PathChecker.check("folder/test.txt"));
    }

    @Test
    public void when_FileHasFullPathAndDrive_Should_ReturnTrue()
    {
        assertTrue(PathChecker.check("C:/folder/test.txt"));
    }

    // getPathAfterDrive private method
    @Test
    public void when_FileWithDriveInPath_Should_ReturnFilePathAfterDrive()
    {
        assertEquals(PathChecker.getPathAfterDrive("C:/text.txt"), "/text.txt");
    }

    @Test
    public void when_FileWithNoDriveInPath_Should_ReturnFilePath()
    {
        assertEquals(PathChecker.getPathAfterDrive("/text.txt"), "/text.txt");
    }
}
