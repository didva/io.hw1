package school.lemon.changerequest.java.io.hw1;

import school.lemon.changerequest.java.io.hw1.exception.*;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.List;


/**
 * File manager to navigate and modify file system
 */
public interface IFileManager {
    /**
     * Return current directory folders and files in {@link Order#BY_LEXICOGRAPHICAL_ASCENDING} order with directoriesFirst=true
     *
     * @see Order
     * @see #ls(Order, boolean)
     */
    String ls();


    /**
     * Return current directory folders and files in given order with directoriesFirst=true
     *
     * @param order in which directories and folders should be sorted
     * @see Order
     * @see #ls(Order, boolean)
     */
    String ls(Order order);

    /**
     * Return current directory folders and files in given order, printing directories firstly if directoriesFirst==true
     * in format supplied by {@link #fileInfo(File)} as a String
     *
     * @param order            in which directories and files should be sorted
     * @param directoriesFirst if true - print all directories firstly
     * @see Order
     * @see #fileInfo(File)
     */
    String ls(Order order, boolean directoriesFirst);

    /**
     * Generate list of files in given order with directories first(if directoriesFirst==true) and with items filtered out
     * by fileFilter
     *
     * @param order            in which directories and files should be sorted
     * @param directoriesFirst if true - print all directories firstly
     * @param fileFilter       filter to check whether file or directory should be in result
     * @return list of properly sorted files and directories of current directory
     */
    List<File> filter(Order order, boolean directoriesFirst, FileFilter fileFilter);

    /**
     * Generate file information in format:
     * last_modification_time | size | filename
     * <p>
     * Where last modification time should be printed in following format: "15.01.2017 13:54:44"
     * Size should be printed in bytes. If file is directory size should be 0
     * Filename of directory should be appended with '/'
     * <p>
     * First column should always be 20 characters (and additional whitespace before '|')
     * Second column should always be 15 characters (and additional whitespace after '|' and before '|')
     * Third column should take as much space as filename needs (and additional whitespace after '|')
     * <p>
     * Examples:
     * 15.01.2015 13:01:55 |               0 | testDirectoryA/
     * 15.01.2015 09:55:59 |             250 | testFileA.txt
     *
     * @param file file or directory to generate information for
     * @return file information in string format
     */
    String fileInfo(File file);


    /**
     * Create new file within current directory with given name
     *
     * @param name name of new file
     * @throws FileAlreadyExistException if file or directory with given name already exists
     * @throws FileManagerException      if any other problem happened
     */
    void createFile(String name) throws FileAlreadyExistException, FileManagerException;

    /**
     * Create new directory within current directory with given name
     *
     * @param name name of new directory
     * @throws DirectoryAlreadyExistException if file or directory with given name already exists
     * @throws FileManagerException           if any other problem happened
     */
    void createDirectory(String name) throws DirectoryAlreadyExistException, FileManagerException;

    /**
     * Change current directory to a new directory with given name
     *
     * @param name directory to change current to
     * @throws IllegalDirectoryException if given directory by given name is not a valid or existing directory
     */
    void changeDirectory(String name) throws IllegalDirectoryException;

    /**
     * Delete file or directory with a given name assuming that force=true.
     *
     * @param name file or directory name to delete
     * @return true if file or directory was deleted
     * @throws FileNotFoundException if file or directory could not be found
     * @see #delete(String, boolean)
     */
    boolean delete(String name) throws FileNotFoundException;

    /**
     * Delete file or directory with a given name.
     * If force == true delete directory even if it is not empty.
     *
     * @param name  file or directory name to delete
     * @param force should directory be removed even if it is not empty?
     * @return true if file or directory was deleted
     * @throws FileNotFoundException if file or directory could not be found
     */
    boolean delete(String name, boolean force) throws FileNotFoundException;

    /**
     * Copy file from source to dest using copyMode.
     *
     * @param source   source file to copy
     * @param dest     destination file to copy
     * @param copyMode copyMode
     * @throws FileNotFoundException     if source file doesn't exist
     * @throws IllegalArgumentException  if source file is directory
     * @throws FileAlreadyExistException if dest file already exist
     * @throws FileCopyException         if any exception happened during copying
     * @see CopyMode
     */
    void copy(String source, String dest, CopyMode copyMode)
            throws FileNotFoundException, IllegalArgumentException, FileAlreadyExistException, FileCopyException;

    /**
     * Copy file from source to dest using {@link CopyMode#BUFFERED}.
     *
     * @param source source file to copy
     * @param dest   destination file to copy
     * @throws FileNotFoundException     if source file doesn't exist
     * @throws IllegalArgumentException  if source file is directory
     * @throws FileAlreadyExistException if dest file already exist
     * @throws FileCopyException         if any exception happened during copying
     * @see CopyMode
     * @see #copy(String, String, CopyMode)
     */
    void copy(String source, String dest)
            throws FileNotFoundException, IllegalArgumentException, FileAlreadyExistException, FileCopyException;

    /**
     * Return current directory
     *
     * @return current directory
     */
    File currentDirectory();

}
