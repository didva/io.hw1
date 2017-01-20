package school.lemon.changerequest.java.io.hw1;

import school.lemon.changerequest.java.io.hw1.exception.DirectoryAlreadyExistException;
import school.lemon.changerequest.java.io.hw1.exception.FileAlreadyExistException;
import school.lemon.changerequest.java.io.hw1.exception.FileCopyException;
import school.lemon.changerequest.java.io.hw1.exception.FileManagerException;
import school.lemon.changerequest.java.io.hw1.exception.IllegalDirectoryException;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class FileManager implements IFileManager {

    private File currentDirectory;

    public FileManager(String path) {
        currentDirectory = new File(path);
        if (!currentDirectory.isDirectory()) {
            throw new IllegalArgumentException("Please specify directory!");
        }
    }

    @Override
    public String ls() {
        return ls(Order.BY_LEXICOGRAPHICAL_ASCENDING);
    }

    @Override
    public String ls(Order order) {
        return ls(order, true);
    }

    @Override
    public String ls(Order order, boolean directoriesFirst) {
        File[] files = currentDirectory.listFiles();
        Arrays.sort(files, new FileComparator(order, directoriesFirst));
        StringBuilder sb = new StringBuilder();
        for (File file : files) {
            sb.append(file.getName()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public List<File> filter(Order order, boolean directoriesFirst, FileFilter fileFilter) {
        return null;
    }

    @Override
    public String fileInfo(File file) {
        return null;
    }

    @Override
    public void createFile(String name) throws FileAlreadyExistException, FileManagerException {

    }

    @Override
    public void createDirectory(String name) throws DirectoryAlreadyExistException, FileManagerException {

    }

    @Override
    public void changeDirectory(String name) throws IllegalDirectoryException {

    }

    @Override
    public boolean delete(String name) throws FileNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String name, boolean force) throws FileNotFoundException {
        return false;
    }

    @Override
    public void copy(String source, String dest, CopyMode copyMode)
            throws FileNotFoundException, IllegalArgumentException, FileAlreadyExistException, FileCopyException {

    }

    @Override
    public void copy(String source, String dest)
            throws FileNotFoundException, IllegalArgumentException, FileAlreadyExistException, FileCopyException {

    }

    @Override
    public File currentDirectory() {
        return null;
    }
}
