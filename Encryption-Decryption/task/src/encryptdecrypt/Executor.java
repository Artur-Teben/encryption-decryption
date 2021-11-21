package encryptdecrypt;

import encryptdecrypt.model.coder.Coder;
import encryptdecrypt.model.coder.algorithm.ShiftCoderAlgorithm;
import encryptdecrypt.model.coder.algorithm.UnicodeCoderAlgorithm;
import encryptdecrypt.model.output.FileOutputProvider;
import encryptdecrypt.model.output.OutputProvider;
import encryptdecrypt.model.output.SimpleOutputProvider;

public class Executor {

    public static void run(String[] args) {
        String mode = "";
        String data = "";
        String inputFilePath = "";
        String outputFilePath = "";
        String algorithm = "";
        int key = 0;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    if (i + 1 < args.length) {
                        mode = args[i + 1];
                    }
                    break;
                case "-key":
                    if (i + 1 < args.length) {
                        key = Integer.parseInt(args[i + 1]);
                    }
                    break;
                case "-data":
                    if (i + 1 < args.length) {
                        data = args[i + 1];
                    }
                    break;
                case "-in":
                    if (i + 1 < args.length) {
                        inputFilePath = args[i + 1];
                    }
                    break;
                case "-out":
                    if (i + 1 < args.length) {
                        outputFilePath = args[i + 1];
                    }
                    break;
                case "-alg":
                    if (i + 1 < args.length) {
                        algorithm = args[i + 1];
                    }
                    break;
            }
        }

        Coder coder = new Coder();

        if ("unicode".equals(algorithm)) {
            coder.setCoderAlgorithm(new UnicodeCoderAlgorithm());
        } else {
            coder.setCoderAlgorithm(new ShiftCoderAlgorithm());
        }

        String result = coder.processData(mode, data, inputFilePath, key);

        OutputProvider outputProvider;

        if (!outputFilePath.isEmpty()) {
            outputProvider = new FileOutputProvider(outputFilePath);
        } else {
            outputProvider = new SimpleOutputProvider();
        }

        outputProvider.provideResult(result);
    }
}
