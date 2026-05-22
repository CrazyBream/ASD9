package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class FileResultWriter implements IResultWriter {
    @Override
    public void writeToFile(String filename, ICombinatoricsTask task) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            task.generateAll(result -> {
                try {
                    writer.write(result);
                    writer.newLine();
                } catch (IOException e) {
                    throw new RuntimeException("Помилка запису у файл", e);
                }
            });
            System.out.println("Результати успішно збережено у файл: " + filename);
        } catch (IOException e) {
            System.err.println("Помилка при створенні файлу: " + e.getMessage());
        }
    }
}
