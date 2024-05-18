package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> currentRow = new ArrayList<>();
        List<List<String>> csvData = new ArrayList<>();

        System.out.println("Введите текст. Используйте 'next' для перехода строки и 'end' для завершения:");

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("end")) {
                if (!currentRow.isEmpty()) {
                    csvData.add(new ArrayList<>(currentRow));
                }
                break;
            } else if (input.equalsIgnoreCase("next")) {
                csvData.add(new ArrayList<>(currentRow));
                currentRow.clear();
            } else {
                currentRow.add(input);
            }
        }

        // Запись в CSV файл
        try (FileWriter writer = new FileWriter("output.csv")) {
            for (List<String> row : csvData) {
                writer.append(String.join(", ", row));
                writer.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("CSV файл 'output.csv' успешно создан.");
    }
}
