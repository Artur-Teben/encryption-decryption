package encryptdecrypt.model.coder;

import encryptdecrypt.model.coder.algorithm.CoderAlgorithm;

public class Coder {

    private CoderAlgorithm coderAlgorithm;

    public void setCoderAlgorithm(CoderAlgorithm coderAlgorithm) {
        this.coderAlgorithm = coderAlgorithm;
    }

    public String processData(String mode, String data, String inputFilePath, int key) {
        return this.coderAlgorithm.processData(mode, data, inputFilePath, key);
    }
}
