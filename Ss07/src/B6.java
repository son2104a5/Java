public class B6 {
    public static void main(String[] args) {
        int iterations = 1_000_000;

        String str = "Hello";
        long startString = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            str += " World";
        }
        long endString = System.currentTimeMillis();
        System.out.println("Thời gian với String: " + (endString - startString) + " ms");

        StringBuilder sb = new StringBuilder("Hello");
        long startBuilder = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            sb.append(" World");
        }
        long endBuilder = System.currentTimeMillis();
        System.out.println("Thời gian với StringBuilder: " + (endBuilder - startBuilder) + " ms");

        StringBuffer sf = new StringBuffer("Hello");
        long startBuffer = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            sf.append(" World");
        }
        long endBuffer = System.currentTimeMillis();
        System.out.println("Thời gian với StringBuffer: " + (endBuffer - startBuffer) + " ms");
    }
}
