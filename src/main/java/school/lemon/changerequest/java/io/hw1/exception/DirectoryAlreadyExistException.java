package school.lemon.changerequest.java.io.hw1.exception;


import java.io.File;

public class DirectoryAlreadyExistException extends DirectoryAwareFileManagerException {
    public DirectoryAlreadyExistException(File directory) {
        super(directory, String.format("Directory `%s` already exist on file system", directory.getAbsolutePath()));
    }
}
