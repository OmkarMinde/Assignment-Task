import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SqrootNewtonB {

    public static double getSqrootByNewton(double inputNumber) {
        double z = 1;
        int maxIteration = 25;
        double tolerance = 0.001;

        for (int i = 0; i < maxIteration; i++) {
            double previousZ = z;
            z -= (z * z - inputNumber) / (2 * z); // Newton's method formula.

            if (Math.abs(z - previousZ) <= tolerance) { // Check for tolerance.
                break;
            }
        }
        return z;
    }

    public static void main(String[] args) {
        // Specify the path
        String filePath = "C:\\Users\\Admin\\Desktop\\file.txt"; // File path declare.
              
//        BufferedReader-Reads text from a character-input stream
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
        	String line;
            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue; // Skip empty lines
                }

                try {
                    double inputNumber = Double.parseDouble(line);

                    if (inputNumber < 0) { // Check for negative input.
                        System.out.printf("%.2f Number provided is negative.%n", inputNumber);
                    } else if (inputNumber == 0) { // Check for zero.
                        System.out.printf("%.2f Square root of zero is 0.%n", inputNumber);
                    } else {
                        double result = getSqrootByNewton(inputNumber); // Calculate the square root.
                        System.out.printf("%.2f %.4f %n", inputNumber, result);
                    }
                } catch (NumberFormatException e) { // Handle parsing errors
                    System.out.printf("%s Invalid input. Please enter a numeric value.%n", line);
                }
            }
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
 
    
}