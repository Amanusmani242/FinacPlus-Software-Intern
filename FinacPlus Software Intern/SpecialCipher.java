import java.util.*;
public class SpecialCipher {

    public static void main(String[] args) {
        String input = "AABCCC";
        int rotation = 3;
        String result = specialCipher(input, rotation);
        System.out.println("The special ciphered code is: " + result);
    }

  
    public static String specialCipher(String input, int rotation) {
        
        StringBuilder caesarCiphered = new StringBuilder();
        for (char c : input.toCharArray()) {
            caesarCiphered.append(rotateChar(c, rotation));
        }

        
        return runLengthEncoding(caesarCiphered.toString());
    }

   
    private static char rotateChar(char c, int rotation) {
        if (c >= 'A' && c <= 'Z') {
           
            return (char) ('A' + (c - 'A' + rotation) % 26);
        } else if (c >= 'a' && c <= 'z') {
            
            return (char) ('a' + (c - 'a' + rotation) % 26);
        }
        
        return c;
    }

   
    private static String runLengthEncoding(String input) {
        StringBuilder encoded = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                encoded.append(input.charAt(i - 1));
                if (count > 1) {
                    encoded.append(count);
                }
                count = 1;
            }
        }

        
        encoded.append(input.charAt(input.length() - 1));
        if (count > 1) {
            encoded.append(count);
        }

        return encoded.toString();
    }
}
