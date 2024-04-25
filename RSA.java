import java.util.Scanner;

public class RSA {

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int modInverse(int a, int m) {
        for (int x = 1; x < m; x++)
            if ((a * x) % m == 1)
                return x;
        return 1;
    }

    public static int encrypt(int message, int e, int n) {
        return (int) (Math.pow(message, e) % n);
    }

    public static int decrypt(int ct, int d, int n) {
        return (int) (Math.pow(ct, d) % n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the message to be encrypted: ");
        String message = scanner.nextLine();

        System.out.print("Enter the first prime number (p): ");
        int p = scanner.nextInt();

        System.out.print("Enter the second prime number (q): ");
        int q = scanner.nextInt();

        int n = p * q;
        int m = (p - 1) * (q - 1);

        int e = 0;
        for (int i = 2; i < m; i++) {
            if (gcd(i, m) == 1) {
                e = i;
                break;
            }
        }

        int d = modInverse(e, m);

        System.out.println("Original Message is: " + message);
        int[] encrypted = new int[message.length()];
        for (int i = 0; i < message.length(); i++) {
            int charValue = (int) message.charAt(i);
            encrypted[i] = encrypt(charValue, e, n);
            System.out.print(encrypted[i] + " ");
        }
        System.out.println();

        System.out.print("Decrypted Message is: ");
        for (int i = 0; i < encrypted.length; i++) {
            int decrypted = decrypt(encrypted[i], d, n);
            System.out.print((char) decrypted);
        }
        System.out.println();

        scanner.close();
    }
}

/*
 * Enter the message to be encrypted: Hello
 * Enter the first prime number (p): 17
 * Enter the second prime number (q): 11
 * Original Message is: Hello
 * Encrypted Message is: 88 38 68 68 79
 * Decrypted Message is: Hello
 */
