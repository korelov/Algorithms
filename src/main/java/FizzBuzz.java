import java.util.Arrays;

public class FizzBuzz {

    public String[] fizzBuzz(int startNumber, int endNumber) {
        String[] numbers = new String[endNumber - startNumber + 1];
        int newNumber = startNumber;
        for (int i = startNumber - startNumber; i < (endNumber - startNumber + 1); i++) {

            if (newNumber % 15 == 0) {
                numbers[i] = "FizzBuzz";
            } else if (newNumber % 3 == 0) {
                numbers[i] = "Fizz";
            } else if (newNumber % 5 == 0) {
                numbers[i] = "Buzz";
            } else {
                numbers[i] = String.valueOf(newNumber);
            }
            newNumber += 1;
        }
//        int[] numbers1 = new int[endNumber - startNumber + 1];
//        int indexArr = 0;
//        for (int i = startNumber; i <= endNumber; i++) {
//            numbers1[indexArr++] = i;
//        }
        System.out.println(Arrays.toString(numbers));
        return numbers;
    }
}
