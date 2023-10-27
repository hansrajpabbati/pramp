public class ValidateIPV4 {
    static boolean validateIP(String ip) {
        String[] parts = ip.split("\\.");

        if (parts.length != 4) {
            return false; // IPv4 address should have exactly 4 parts
        }

        for (String part : parts) {
            if (!isValidPart(part)) {
                return false; // Each part should be a valid integer
            }
        }

        return true;

    }

    private static boolean isValidPart(String part) {
        if (part.isEmpty() || part.length() > 3) {
            return false; // Part should not be empty and should not exceed 3 characters in length
        }

        for (int i = 0; i < part.length(); i++) {
            if (!Character.isDigit(part.charAt(i)) || part.charAt(0) == '0' && part.length() > 1) {
                return false; // Each character should be a digit, and leading zeros are not allowed
            }
        }

        int num = Integer.parseInt(part);
        return num >= 0 && num <= 255; // Each part should be in the range [0, 255]
    }






    public static void main(String[] args) {
        String ip1 = "12.34.5.6";
        String ip2 = "12.34.56.oops";
        String ip3 = "123.235.153.425";

        System.out.println(validateIP(ip1));  // Output: true
        System.out.println(validateIP(ip2));  // Output: false
        System.out.println(validateIP(ip3));  // Output: false


    }
}
