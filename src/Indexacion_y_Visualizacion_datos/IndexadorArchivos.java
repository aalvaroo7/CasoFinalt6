package Indexacion_y_Visualizacion_datos;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class IndexadorArchivos {

    private List<String> fileNames;
    private List<String> filePaths;

    public IndexadorArchivos() {
        fileNames = new ArrayList<>();
        filePaths = new ArrayList<>();
    }

    public void index(String directory) {
        File directoryFile = new File(directory);
        if (!directoryFile.exists() || !directoryFile.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory path: " + directory);
        }

        for (File file : directoryFile.listFiles()) {
            if (file.isDirectory()) {
                index(file.getAbsolutePath());
            } else {
                fileNames.add(file.getName());
                filePaths.add(file.getAbsolutePath());
            }
        }
    }

    public List<String> getFileNames() {
        return fileNames;
    }

    public List<String> getFilePaths() {
        return filePaths;
    }
}
