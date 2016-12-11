import javafx.scene.control.TextArea;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by margus on 11.12.2016.
 */
public class Console extends OutputStream {

    private TextArea output;

    public Console(TextArea ta) {
        this.output = ta;
    }

    @Override
    public void write(int i) throws IOException {
        output.appendText(String.valueOf((char) i));
    }
}
