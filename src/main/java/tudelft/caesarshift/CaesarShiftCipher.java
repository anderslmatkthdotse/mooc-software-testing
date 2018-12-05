package tudelft.caesarshift;

public class CaesarShiftCipher {

    public String encrypt(String message, int shift) {
        StringBuilder sb = new StringBuilder();
        char currentChar;
        int length = message.length();

        shift = shift % 26;


        for (int i = 0; i < length; i++) {
            currentChar = message.charAt(i);

            if (currentChar > 'z' || currentChar < 'a') {
                return "invalid";
            }

            char encrChar = (char) (currentChar + shift);
            if (encrChar > 'z') {
                encrChar -= 26;
            }
            else if (encrChar < 'a') {
                encrChar += 26;
            }

            sb.append(encrChar);
        }

        return sb.toString();
    }
}
