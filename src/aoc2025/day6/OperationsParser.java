package aoc2025.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class OperationsParser {

    private record Operation(List<Long> operands, Operator operator) {
        public long getResult() {
            return switch (operator) {
                case ADD -> operands.stream().mapToLong(Long::longValue).sum();
                case MULTIPLY -> operands.stream().mapToLong(Long::longValue).reduce(1, (a, b) -> a * b);
            };
        }
    }

    private record Column(char[] column) {
        public long getNumber() {
            char[] numbers = Arrays.copyOfRange(column, 0, column.length -1);
            return Long.parseLong(String.valueOf(numbers).trim());
        }

        public Operator getOperator() {
            return Operator.getOperator(column[column.length - 1]);
        }

        public boolean isEmpty() {
            return String.valueOf(column).trim().isEmpty();
        }
    }

    private final List<Operation> operations = new LinkedList<>();

    public OperationsParser(Stream<String> linesStream) {
        List<String> lines = linesStream.toList();
        int nbLines = lines.size();
        int nbChars = lines.getFirst().length() ;

        Operator operator = null;
        List<Long> operands = new LinkedList<>();
        for (int i = 0; i < nbChars; i++) {
            char[] column = getColumnChars(nbLines, lines, i);
            Column col = new Column(column);

            if (col.isEmpty()) {
                // new operation to store
                operations.add(new Operation(new ArrayList<>(operands), operator));
                operands.clear();
                continue;
            }

            if (col.getOperator() != null) {
                operator = col.getOperator() ;
            }
            operands.add(col.getNumber());
        }
        operations.add(new Operation(operands, operator));
    }

    private static char[] getColumnChars(int nbLines, List<String> lines, int i) {
        char[] column = new char[nbLines];
        for (int j = 0; j < nbLines; j++) {
            column[j] = lines.get(j).charAt(i);
        }
        return column;
    }


    public long getGrandTotal() {
        return operations.stream().mapToLong(Operation::getResult).sum();
    }
}
