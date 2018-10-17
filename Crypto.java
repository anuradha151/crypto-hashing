
import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;

public class Crypto {

    // prefix, number1, and number2 should contain equel digits
    // In this example, prefix and number2 contain 9 digits and number1 contains 3 digits
    // Feel free to use any length of number 
    private String prefix = "258654159";

    private static boolean bitOf(char in) {
        return (in == '1');
    }

    private static char charOf(boolean in) {
        return (in) ? '1' : '0';
    }


    // Hashing using SHA256
    public String encode(String number1, String number2) {
        // Use these lines of code if your numbers not equels to exact same digits
        // 9 is about how many digits each number contains

        // String str = Integer.toString(score);        
        // if (str.length() != 9) {
        //     int j = 9 - str.length();
        //     String newVal = "";
        //     for (int i = 1; i < (j + 1); i++) {
        //         str = str + Integer.toString(i);
        //     }
        // }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number2.length(); i++) {
            sb.append(charOf(bitOf(number2.charAt(i)) ^ bitOf(str.charAt(i)) ^ bitOf(prefix.charAt(i))));
        }
        String sha256hex = Hashing.sha256()
                .hashString(sb, StandardCharsets.UTF_8)
                .toString();
        return sha256hex;
    }

    public boolean decode(int score, String mobileNumber, String hash) {

        // Use these lines of code to equel number digits

        // String str = Integer.toString(score);
        // if (str.length() != 9) {
        //     int j = 9 - str.length();
        //     for (int i = 1; i < (j + 1); i++) {
        //         str = str + Integer.toString(i);
        //     }
        // }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mobileNumber.length(); i++) {
            sb.append(charOf(bitOf(mobileNumber.charAt(i)) ^ bitOf(str.charAt(i)) ^ bitOf(prefix.charAt(i))));
        }
        String sha256hex = Hashing.sha256()
                .hashString(sb, StandardCharsets.UTF_8)
                .toString();
        if (hash.equals(sha256hex)) {
            return true;
        } else {
            return false;
        }
    }
}
