package school.lemon.changerequest.java.io.hw1.exception;

import java.io.File;

public abstract class FileAwareFileManagerException extends FileManagerException {
    private final File file;

    public FileAwareFileManagerException(File file, String message) {
        super(message);
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public String getFileName() {
        return file != null ? file.getName() : "";
    }
}
