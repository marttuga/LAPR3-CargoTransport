package lapr.project.utils;

public class CountingAlgorithms {
    private CountingAlgorithms() {
    }

    public static int numberLength(int number) {

        int count = 0;
        while (number != 0) {
            number = number / 10;
            ++count;
        }
        return count;
    }

    public static int stringLength(String string) {
        int count = 0;

        //Counts each character except space
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != ' ')
                count++;
        }
        return count;
    }
}
