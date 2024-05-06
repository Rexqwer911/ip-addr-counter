import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.BitSet;

public class Main {
    public static void main(String[] args) throws IOException {

        String inputFile = "<your_path_to_input_file>";

        long start = System.currentTimeMillis();
        BitSet bitSetPos = new BitSet(Integer.MAX_VALUE);
        BitSet bitSetNeg = new BitSet(Integer.MAX_VALUE);
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            int result = 0;
            int octet = 0;
            byte shift = 24;
            char[] buffer = new char[1024];
            int charsRead;
            while ((charsRead = reader.read(buffer)) != -1) {
                for (int i = 0; i < charsRead; i++) {
                    char c = buffer[i];
                    if (c == '\r') {
                        continue;
                    }
                    if (c == '\n') {
                        result |= octet << shift;
                        if (result < 0) {
                            bitSetNeg.set(-(result + 1));
                        } else {
                            bitSetPos.set(result);
                        }
                        result = 0;
                        octet = 0;
                        shift = 24;
                    } else if (c == '.') {
                        result |= octet << shift;
                        shift -= 8;
                        octet = 0;
                    } else {
                        octet = (octet << 3) + (octet << 1) + (c - '0');
                    }
                }
            }
        }
        System.out.println("Unique addresses: " + ((long) bitSetNeg.cardinality() + bitSetPos.cardinality()));
        System.out.println("Took in milis: " + (System.currentTimeMillis() - start));
    }
}
