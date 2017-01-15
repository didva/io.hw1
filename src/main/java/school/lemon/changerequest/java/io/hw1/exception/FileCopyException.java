package school.lemon.changerequest.java.io.hw1.exception;

import java.io.File;

public class FileCopyException extends FileManagerException {
    private final File source;
    private final File dest;

    public FileCopyException(File source, File dest, Throwable e) {
        super(String.format("Cannot copy file '%s' into '%s'.", source, dest), e);
        this.source = source;
        this.dest = dest;
    }

    public File getSource() {
        return source;
    }

    public File getDest() {
        return dest;
    }
}
