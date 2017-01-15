package school.lemon.changerequest.java.io.hw1.exception;

import java.io.File;

public class IllegalDirectoryException extends DirectoryAwareFileManagerException {

    public IllegalDirectoryException(File directory) {
        super(directory, String.format("Illegal Directory `%s`", directory));
    }
}
