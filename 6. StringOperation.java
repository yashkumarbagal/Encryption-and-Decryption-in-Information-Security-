import java.util.Scanner;

public class StringOperation {
    public static String processString(String string, String operation) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if (operation.equals("AND")) {
                result.append((char) (currentChar & 127));
            } else if (operation.equals("XOR")) {
                result.append((char) (currentChar ^ 127));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        System.out.println("Input String: " + inputString);

        System.out.print("Choose operation (AND/XOR): ");
        String operation = scanner.nextLine();

        String result = processString(inputString, operation);
        System.out.println("Result: " + result);

        scanner.close();
    }
}
