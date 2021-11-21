package encryptdecrypt.model.coder.algorithm;

import java.util.List;

public class ShiftCoderAlgorithm extends CoderAlgorithm {

    public static final String LOWER_CASE_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPER_CASE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWER_CASE_LETTER_PATTERN = "[a-z]";
    public static final String UPPER_CASE_LETTER_PATTERN = "[A-Z]";
    public static final String ENCODE_MODE = "encode";
    public static final String DECODE_MODE = "decode";

    @Override
    protected String encodeData(List<String> symbols, int key) {
        return shiftSymbols(symbols, key, ENCODE_MODE);
    }

    @Override
    protected String decodeData(List<String> symbols, int key) {
        return shiftSymbols(symbols, key, DECODE_MODE);
    }

    private String shiftSymbols(List<String> symbols, int key, String mode) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String symbol : symbols) {
            if (symbol.matches(LOWER_CASE_LETTER_PATTERN)){
                shiftSymbol(symbol, key, stringBuilder, LOWER_CASE_ALPHABET, mode);
            } else if (symbol.matches(UPPER_CASE_LETTER_PATTERN)) {
                shiftSymbol(symbol, key, stringBuilder, UPPER_CASE_ALPHABET, mode);
            } else {
                stringBuilder.append(symbol);
            }
        }
        return stringBuilder.toString();
    }

    private void shiftSymbol(String symbol, int key, StringBuilder stringBuilder, String alphabet, String direction) {
        int letterIndex = alphabet.indexOf(symbol);
        int shiftedLetterIndex;
        if (DECODE_MODE.equals(direction)) {
            shiftedLetterIndex = letterIndex - key;

            if (shiftedLetterIndex < 0) {
                shiftedLetterIndex += alphabet.length();
            }
        } else {
            shiftedLetterIndex = letterIndex + key;

            if (shiftedLetterIndex >= alphabet.length()) {
                shiftedLetterIndex -= alphabet.length();
            }
        }

        stringBuilder.append(alphabet.charAt(shiftedLetterIndex));
    }
}
