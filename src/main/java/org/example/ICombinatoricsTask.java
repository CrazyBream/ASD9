package org.example;

import java.util.function.Consumer;

interface ICombinatoricsTask {
    long calculateTotalCount();
    void generateAll(Consumer<String> resultConsumer);
}