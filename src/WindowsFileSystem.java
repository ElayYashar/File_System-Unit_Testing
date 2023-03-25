import java.util.HashMap;

public class WindowsFileSystem extends BaseFileSystem
{
    /**
     * <h3>Write</h3>
     * Write only if its not on C:\.
     * <br>
     * C:\test.txt -> Bad
     * <br>
     * C:\Some Folder\test.txt -> Good
     * 
     * <h3>Delete</h3>
     * Delete only if its not on C:\.
     * <br>
     * C:\test.txt -> Bad
     * <br>
     * C:\Some Folder\test.txt -> Good 
     * 
     * <h3>Can Read</h3>
     * Can read any file.
     * 
     * <h3>Can Check</h3>
     * Can check any file.
     */
    public WindowsFileSystem(HashMap<String, String> fileSystem) 
    {
        super(fileSystem);
    }

    @Override
    public void write(String path, String content)
    {
        if(canWrite(path)) 
        {
            super.write(path, content);
        }
    }

    @Override
    public boolean delete(String path)
    {
        if(isPathInRoot(path) || !exists(path))
        {
            return false;
        }
        super.delete(path);
        return true;
    }

    @Override
    public boolean canWrite(String path) 
    {
        return !isPathInRoot(path);
    }

    protected boolean isPathInRoot(String path)
    {
        path = PathChecker.getPathAfterDrive(path);

        if(!path.contains(".") || path.substring(1).contains("/"))
        {
            return false;
        }
        return true;
    }
}
