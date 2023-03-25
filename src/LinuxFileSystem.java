import java.util.HashMap;

public class LinuxFileSystem extends BaseFileSystem
{
    /**
     * <h3>Write</h3>
     * Can write to any folder.
     * 
     * <h3>Delete</h3>
     * Can delete any file.
     * 
     * <h3>Can Read</h3>
     * Can read any file.
     * 
     * <h3>Can Check</h3>
     * Can check any file.
     */
    public LinuxFileSystem(HashMap<String, String> fileSystem) 
    {
        super(fileSystem);
    }
}
