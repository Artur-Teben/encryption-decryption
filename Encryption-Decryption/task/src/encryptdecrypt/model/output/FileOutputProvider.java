package encryptdecrypt.model.output;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputProvider extends OutputProvider {

    private final String outputFilePath;

    public FileOutputProvider(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }

    @Override
    public void provideResult(String result) {
        try (FileWriter writer = new FileWriter(getOutputFilePath())) {
            writer.write(result);
        } catch (IOException exception) {
            System.out.printf("File %s not found!", outputFilePath);
        }
    }
}
