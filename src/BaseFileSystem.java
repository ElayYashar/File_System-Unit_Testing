import java.util.HashMap;

public abstract class BaseFileSystem
{
    private final HashMap<String, String> _fileSystem;

    public BaseFileSystem(HashMap<String, String> fileSystem)
    {
        _fileSystem = fileSystem;
    }

    public boolean exists(String path) 
    {
        return _fileSystem.containsKey(path);
    }

    public String read(String path) throws Exception
    {
        if(canRead(path) && exists(path))
        {
            return _fileSystem.get(path);
        }
        throw new Exception("File Does Not Exist!");
    }

    public void write(String path, String content) 
    {
        if(PathChecker.check(path)) 
        {
            _fileSystem.put(path, content);
        }
    }

    public boolean delete(String path) 
    {
        if(PathChecker.check(path))
        {
            _fileSystem.remove(path);
            return true;
        }
        return false;
    }

    public boolean canWrite(String path) 
    {
        return PathChecker.check(path);
    }

    public boolean canRead(String path) 
    {
        return PathChecker.check(path) && exists(path);
    }
} 