import java.util.Scanner;

public class RailFenceCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Input message:");
        String name = scanner.next();
        System.out.println("Enter Number  of Rails:");
        int key = scanner.nextInt();
        int len = name.length();
        char[][] matrix = new char[30][30];
        
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < len; j++) {
                matrix[i][j] = '*';
            }
        }
        
        int k = 0, l = 0, temp = 0, flag = 0;
        for (int i = 0; i < len; i++) {
            flag = 0;
            temp = 0;

            if (k == 0 || k == key - 1) {
                k = k * (-1);
            }

            if (k < 0) {
                temp = k;
                k = k * (-1);
                flag = 1;
            }
            matrix[k][i] = name.charAt(l);
            if (flag == 1) {
                k = temp;
            }
            l++;
            k++;
        }
        
        System.out.println("\nRailfence Matrix is: ");
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }

        char[] str = new char[100];
        int glo = 0;
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < len; j++) {
                if (matrix[i][j] != '*') {
                    str[glo++] = matrix[i][j];
                }
            }
        }

        System.out.println("\nOriginal message : ");
        System.out.println(name);
        System.out.println("\nEncrypted message : ");
        System.out.println(str);

        char[] dstr = new char[100];
        int glob = 0;
        System.out.println("\nDecrypted message : ");
        int p = 0, temp1 = 0;
        for (int i = 0; i < len; i++) {
            temp1 = 0;
            flag = 0;
            if (p == 0 || p == key - 1) {
                p = p * (-1);
            }
            if (p < 0) {
                temp1 = p;
                p = p * (-1);
                flag = 1;
            }
            char ct = matrix[p][i];
            dstr[glob++] = ct;

            if (flag == 1) {
                p = temp1;
            }
            p++;
        }
        for (int i = 0; i < len; i++) {
            System.out.print(dstr[i]);
        }
        System.out.println();
        scanner.close();
    }
}
