IO. Home work 1 
===============
# File Manager

Your task is to create implementation of IFileManager interface.

Your file manager should have `currentDirectory` state - the directory to start FileManager from.

It should be possible to set `currentDirectory` during creation of FileManager instance or it should point to the directory
from what user runs the program by default.

#### File manager commands

* `String ls(Order order, boolean directoriesFirst)` - list current directory folders and files in given Order 
with directories listed firstly if `directoriesFirst == true`
* `String ls(Order order)` - list current directory folders and files in given Order with directories listed firstly.
* `String ls()` - list current directory folders and files in lexicographical ascending order 
with directories listed firstly.
* `List<File> filter(Order order, boolean directoriesFirst, FileFilter fileFilter)` - Generate list of files in given 
order with directories first(if `directoriesFirst==true`) and with items filtered out by fileFilter
* `String fileInfo(File file)` - Generate file information in format:
  
  `last_modification_time | size | filename`
  
  Where last modification time should be printed in following format: `15.01.2017 13:54:44`
  
  Size should be printed in bytes. If file is directory size should be `0`
  
  Filename of directory should be appended with `/`
  
  First column should always be `20` characters (and additional whitespace before `|`)
  
  Second column should always be `15` characters (and additional whitespace after `|` and before `|`)
  
  Third column should take as much space as filename needs (and additional whitespace after `|`)
  
  Examples:
  ```
  15.01.2015 13:01:55 |               0 | testDirectoryA/
  15.01.2015 09:55:59 |             250 | testFileA.txt
  ```
* `createFile(String name)` - Create new file within current directory with given name
* `createDirectory(String name) - `Create new directory within current directory with given name
* `changeDirectory(String name)`- Change current directory to a new directory with given name
* `boolean delete(String name, boolean force)` - Delete file or directory with a given name.
If force == true delete directory even if it is not empty. Return `true` if file or directory was deleted.
* `boolean delete(String name)` - Delete file or directory with a given name assuming that force=true.
Return `true` if file or directory was deleted.
* `copy(String source, String dest, CopyMode copyMode)` - Copy file from source to dest using copyMode.
* `copy(String source, String dest)` - Copy file from source to dest using CopyMode = BUFFERED.

More information about methods contracts could be find in [IFileManager](src/main/java/school/lemon/changerequest/java/io/hw1/IFileManager.java).

#### Order  values

* BY_LEXICOGRAPHICAL_ASCENDING - alphabet ascending order
* BY_LEXICOGRAPHICAL_DESCENDING - alphabet descending order
* BY_LAST_UPDATE_ASCENDING - last update timestamp ascending order
* BY_LAST_UPDATE_DESCENDING - last update timestamp descending order

OrderValues enum could be find [here](src/main/java/school/lemon/changerequest/java/io/hw1/Order.java)

#### CopyMode values

* SIMPLE - read/write byte-by-byte
* BUFFERED - use some buffering technology for read/write operations

CopyMode enum could be find [here](src/main/java/school/lemon/changerequest/java/io/hw1/CopyMode.java)

### Additional requirements

Create Demo class to show all methods in action. (Preferably it should have some basic menu)

Do not duplicate your code. If it's possible to reuse some methods within others - do it!

Create jUnit tests to test your implementation. Code coverage should be more than 90%.
