import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.io.FileWriter;

public class ClipboardLogger {
    public static void main(String[] args) throws Exception {
        String ultimo = "";

        System.out.println("Monitorando Ctrl+C...");

        while (true) {
            String texto = (String) Toolkit.getDefaultToolkit()
                    .getSystemClipboard()
                    .getData(DataFlavor.stringFlavor);

            if (!texto.equals(ultimo)) {
                FileWriter fw = new FileWriter("Clipboard_Logger/java/JavaClipboard.txt", true);
                fw.write(texto + "\n");
                fw.close();
                ultimo = texto;
                System.out.println("Texto salvo");
            }
            Thread.sleep(1000);
        }
    }
}