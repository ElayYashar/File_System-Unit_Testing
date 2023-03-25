public class PathChecker 
{
    // test.txt/folder => Bad (Folder cant come after file)
	// test.txt => Bad (No path)
	// folder/file => Bad (Missing extension)

    public static boolean check(String path)
    {
        path = getPathAfterDrive(path);
        return hasExtension(path) && hasPath(path) && isFolderNotAfterFile(path);
    }

    public static String getPathAfterDrive(String path)
    {
        if((path.charAt(1) == ':' && path.charAt(2) == '/'))
        {
            path = path.substring(path.indexOf("/"));
        }

        return path;
    }

    private static boolean isFolderNotAfterFile(String path)
    {
        if(path.contains("."))
        {
            int extensionIndex = path.indexOf(".");
            path = path.substring(extensionIndex, path.length());

            if(path.contains("/"))
            {
                return false;
            }
        }
        return true;
    }

    private static boolean hasPath(String path)
    {
        if(path.charAt(0) != '/')
        {
            return false;
        }
        return true;
    }

    private static boolean hasExtension(String path)
    {
        if(!path.contains("."))
        {
            return false;
        }
        return true;
    }
}
