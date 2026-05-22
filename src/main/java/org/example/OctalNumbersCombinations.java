package org.example;

import java.util.function.Consumer;

class OctalNumbersCombinations implements ICombinatoricsTask {
    private final int[] evenOctalDigits = {0, 2, 4, 6};

    @Override
    public long calculateTotalCount() {
        return 3 * 4 * 4;
    }

    @Override
    public void generateAll(Consumer<String> resultConsumer) {
        for (int d1 : evenOctalDigits) {
            if (d1 == 0) continue; // Число не починається з 0
            for (int d2 : evenOctalDigits) {
                for (int d3 : evenOctalDigits) {
                    resultConsumer.accept("" + d1 + d2 + d3);
                }
            }
        }
    }
}
