package encryptdecrypt.model.coder.algorithm;

import java.util.List;

public class UnicodeCoderAlgorithm extends CoderAlgorithm {

    @Override
    protected String encodeData(List<String> symbols, int key) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String symbol : symbols) {
            stringBuilder.append((char) (symbol.charAt(0) + (char) key));
        }
        return stringBuilder.toString();
    }

    @Override
    protected String decodeData(List<String> symbols, int key) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String symbol : symbols) {
            stringBuilder.append((char) (symbol.charAt(0) - (char) key));
        }
        return stringBuilder.toString();
    }
}
