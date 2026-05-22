package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class ReportPermutations implements ICombinatoricsTask {
    private final String[] basicReports;
    private final String linkedReport1;
    private final String linkedReport2;

    public ReportPermutations() {
        this.linkedReport1 = "R1";
        this.linkedReport2 = "R2";
        this.basicReports = new String[]{"R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10"};
    }

    @Override
    public long calculateTotalCount() {
        return factorial(9) * factorial(2);
    }

    private long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    @Override
    public void generateAll(Consumer<String> resultConsumer) {

        String[] blockVariations = {
                linkedReport1 + "-" + linkedReport2,
                linkedReport2 + "-" + linkedReport1
        };

        for (String block : blockVariations) {
            List<String> elementsToPermute = new ArrayList<>(Arrays.asList(basicReports));
            elementsToPermute.add(block);

            permute(elementsToPermute, 0, resultConsumer);
        }
    }

    private void permute(List<String> arr, int k, Consumer<String> resultConsumer) {
        if (k == arr.size()) {
            resultConsumer.accept(String.join(", ", arr));
            return;
        }
        for (int i = k; i < arr.size(); i++) {
            java.util.Collections.swap(arr, i, k);
            permute(arr, k + 1, resultConsumer);
            java.util.Collections.swap(arr, k, i);
        }
    }
}