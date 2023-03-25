import java.util.HashMap;

public class MacFileSystem extends BaseFileSystem
{
    /**
     * <h3>Write</h3>
     * Write only to /usr/desktop/.
     * <br>
     * /usr/text.txt -> Bad
     * <br>
     * /usr/desktop/text.txt -> Good
     * 
     * <h3>Delete</h3>
     * Can't Delete!
     * 
     * <h3>Can Read</h3>
     * Can only read files on /usr/desktop.
     * <br>
     * /usr/text.txt -> Bad
     * <br>
     * /usr/desktop/text.txt -> Good
     * 
     * <h3>Can Check</h3>
     * Can check any file.
     */
    public MacFileSystem(HashMap<String, String> fileSystem) 
    {
        super(fileSystem);
    }

    @Override
    @Deprecated
    public boolean delete(String path) 
    {
        return false;
    }

    @Override
    public boolean canWrite(String path) 
    {
        return isDesktopFolder(path);
    }

    @Override
    public boolean canRead(String path) 
    {
        return canWrite(path);
    }
    
    protected boolean isDesktopFolder(String path)
    {
        if(PathChecker.check(path) && path.startsWith("/usr/desktop"))
        {
            return true;
        }
        return false;
    }
}
