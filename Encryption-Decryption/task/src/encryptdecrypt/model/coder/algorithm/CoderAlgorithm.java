package encryptdecrypt.model.coder.algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public abstract class CoderAlgorithm {

    protected abstract String decodeData(List<String> symbols, int key);

    protected abstract String encodeData(List<String> symbols, int key);

    public String processData(String mode, String data, String inputFilePath, int key) {
        List<String> symbols;

        if (data.isEmpty() && !inputFilePath.isEmpty()) {
            symbols = Arrays.asList(readFile(new File(inputFilePath)).split(""));
        } else {
            symbols = Arrays.asList(data.split(""));
        }

        if ("dec".equals(mode)) {
            return decodeData(symbols, key);
        } else {
            return encodeData(symbols, key);
        }
    }

    private String readFile(File inputFile) {
        StringBuilder data = new StringBuilder();

        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNext()) {
                data.append(scanner.nextLine());
            }
        } catch (FileNotFoundException exception) {
            System.out.printf("File %s not found!", inputFile.getName());
        }

        return data.toString();
    }
}
