public class B4 {
    public static void main(String[] args) {
        String initialString = "abcdefghi".repeat(100000);

        StringBuilder sb = new StringBuilder(initialString);
        long startSB = System.currentTimeMillis();

        sb.reverse();
        sb.insert(sb.length() / 2, "INSERTED_TEXT");
        sb.delete(1000, 2000);
        sb.replace(3000, 3010, "REPLACED");

        long endSB = System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với StringBuilder: " + (endSB - startSB) + " ms");

        StringBuffer sbf = new StringBuffer(initialString);
        long startSBF = System.currentTimeMillis();

        sbf.reverse();
        sbf.insert(sbf.length() / 2, "INSERTED_TEXT");
        sbf.delete(1000, 2000);
        sbf.replace(3000, 3010, "REPLACED");

        long endSBF = System.currentTimeMillis();
        System.out.println("Thời gian thực hiện với StringBuffer: " + (endSBF - startSBF) + " ms");
    }
}

// ==> Thời gian xử lý của StringBuilder nhanh hơn so với thời gian xử lý của StringBuffer