package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Лабораторна робота 2.3 | Варіант 5 ---");

        System.out.println("\n[Рівень 1] Перестановки без повторень (Доповіді)");
        ICombinatoricsTask level1Task = new ReportPermutations();
        System.out.println("Кількість способів розмістити доповіді: " + level1Task.calculateTotalCount());

        System.out.println("\n[Рівень 2] Розміщення з повтореннями (Парні вісімкові цифри)");
        ICombinatoricsTask level2Task = new OctalNumbersCombinations();
        System.out.println("Кількість можливих тризначних чисел: " + level2Task.calculateTotalCount());

        System.out.println("Перелік чисел:");
        level2Task.generateAll(result -> System.out.print(result + " "));
        System.out.println();

        System.out.println("\n[Рівень 3] Запис результатів першого рівня у файл");
        IResultWriter writer = new FileResultWriter();
        writer.writeToFile("permutations_level1.txt", level1Task);
    }
}
