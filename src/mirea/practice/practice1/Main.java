package mirea.practice.practice1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Comparator<Integer> comparator = (a, b) -> Integer.compare(Math.abs(a), Math.abs(b));
        int a, b;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            a = scanner.nextInt();
            b = scanner.nextInt();

            System.out.println(comparator.compare(a, b));
        }
    }
}
