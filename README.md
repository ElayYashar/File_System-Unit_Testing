This is a Java exercise that aims to mimic the permissions Operating Systems give to files on their file systems.
Every file system is being Unit Tested in the /src/test directory.
The file system holds 3 Operating systems:

## Windows

* Can write only if its not on C:\.  
C:\test.txt -> Bad  
C:\Some Folder\test.txt -> Good  

* Can delete only if its not on C:\.  
C:\test.txt -> Bad  
C:\Some Folder\test.txt -> Good   

* Can read any file.  

* Can check if any file exists.  

## Linux  

* Can write to any folder.  

* Can delete any file.  

* Can read any file.  

* Can check if any file exists.  

## Mac  

* Can write only to /usr/desktop/.  
/usr/text.txt -> Bad  
/usr/desktop/text.txt -> Good  

* Can't delete any  

* Can only read files on /usr/desktop.  
/usr/text.txt -> Bad  
/usr/desktop/text.txt -> Good  

* Can check if any file exists.  
