package school.lemon.changerequest.java.io.hw1.exception;

import java.io.File;

public class FileAlreadyExistException extends FileAwareFileManagerException {
    public FileAlreadyExistException(File file) {
        super(file, String.format("File `%s` already exist on file system", file.getAbsolutePath()));
    }
}
