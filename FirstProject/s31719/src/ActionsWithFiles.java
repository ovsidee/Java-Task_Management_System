import java.io.File;

public
    interface ActionsWithFiles<T> {
    T doesFileExist(File directory, String fileName);
}
