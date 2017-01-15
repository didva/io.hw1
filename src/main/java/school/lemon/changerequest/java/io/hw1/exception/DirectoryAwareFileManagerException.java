package school.lemon.changerequest.java.io.hw1.exception;

import java.io.File;

public class DirectoryAwareFileManagerException extends FileAwareFileManagerException {
    public DirectoryAwareFileManagerException(File file, String message) {
        super(file, message);
    }

    public String getDirectoryName() {
        return getFileName();
    }
}
