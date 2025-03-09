public class B8 {
    public static void main(String[] args) {
        String[] phoneNumbers = {"0987-654-321", "0123.456.789", "+84987654321", "123456"};
        for (int i = 0; i < phoneNumbers.length; i++) {
            phoneNumbers[i] = phoneNumbers[i].replaceAll("[^\\d+]", "");
            if (phoneNumbers[i].matches("0\\d{9}")) {
                phoneNumbers[i] = "+84 " + phoneNumbers[i].substring(1, 4) + " " +
                        phoneNumbers[i].substring(4, 7) + " " + phoneNumbers[i].substring(7);
            } else if (phoneNumbers[i].matches("\\+849\\d{8}")) {
                phoneNumbers[i] = phoneNumbers[i].substring(0, 3) + " " +
                        phoneNumbers[i].substring(3, 6) + " " + phoneNumbers[i].substring(6, 9) + " " +
                        phoneNumbers[i].substring(9);
            } else {
                phoneNumbers[i] = "số điện thoại không hợp lệ";
            }
        }
        for (String phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber);
        }
    }
}
