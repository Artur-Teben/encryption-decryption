package encryptdecrypt.model.output;

public class SimpleOutputProvider extends OutputProvider {

    @Override
    public void provideResult(String result) {
        System.out.println(result);
    }
}
