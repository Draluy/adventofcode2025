package aoc2025.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record MachineParser(String line) {
    private static final Pattern lightsAndJoltages = Pattern.compile("^\\[(?<lights>[.|#]+)\\].*?\\{(?<joltages>(\\d+\\,?)+)\\}$");
    private static final Pattern buttonsPattern = Pattern.compile("\\((?<btns>[0-9,]+)\\)");

    public int lights() {
        Matcher matcher = lightsAndJoltages.matcher(line);
        matcher.find();
        return getBitMask(matcher.group("lights").split(""));
    }

    public Joltages joltages() {
        Matcher matcher = lightsAndJoltages.matcher(line);
        matcher.find();
        int[] joltages = Arrays.stream(matcher.group("joltages").split(",")).mapToInt(Integer::parseInt).toArray();
        return new Joltages(joltages);
    }


    public int nbLights() {
        Matcher matcher = lightsAndJoltages.matcher(line);
        matcher.find();
        return matcher.group("lights").length();
    }

    public List<Button> getButtons() {
        Matcher matcher = buttonsPattern.matcher(line);
        List<Button> buttons = new ArrayList<>();
        while (matcher.find()) {
            buttons.add(new Button(matcher.group("btns"), nbLights()));
        }
        return buttons;
    }

    private int getBitMask(String[] lightsChars) {
        int res = 0;
        for (int i = 0; i < lightsChars.length; i++) {
            if (lightsChars[i].equals("#")) {
                res = res | 1 << lightsChars.length - i - 1;
            }
        }
        return res;
    }

}
