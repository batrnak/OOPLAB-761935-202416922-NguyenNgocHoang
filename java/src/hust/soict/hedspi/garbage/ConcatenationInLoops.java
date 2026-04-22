package hust.soict.hedspi.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        System.out.println("Thời gian dùng String +: " + (System.currentTimeMillis() - start) + " ms");

        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sbBuffer = new StringBuffer();
        for (int i = 0; i < 65536; i++) {
            sbBuffer.append(r.nextInt(2));
        }
        s = sbBuffer.toString();
        System.out.println("Thời gian dùng StringBuffer: " + (System.currentTimeMillis() - start) + " ms");
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sbBuilder = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sbBuilder.append(r.nextInt(2));
        }
        s = sbBuilder.toString();
        System.out.println("Thời gian dùng StringBuilder: " + (System.currentTimeMillis() - start) + " ms");
    }
}