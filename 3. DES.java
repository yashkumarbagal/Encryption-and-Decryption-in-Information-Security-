import java.util.Scanner;
import javax.crypto.*;
import javax.crypto.spec.*;

public class DES {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Get plaintext from the user
            System.out.print("Enter the plaintext: ");
            String plainText = scanner.nextLine();

            // Get key from the user
            System.out.print("Enter the 8-byte key for DES: ");
            String keyString = scanner.nextLine();

            byte[] keyData = keyString.getBytes();
            SecretKeySpec key = new SecretKeySpec(keyData, "DES");
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedData = cipher.doFinal(plainText.getBytes());
            System.out.println("Encrypted: " + bytesToHex(encryptedData));

            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedData = cipher.doFinal(encryptedData);
            System.out.println("Decrypted: " + new String(decryptedData));

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02X", b));
        }
        return result.toString();
    }
}
