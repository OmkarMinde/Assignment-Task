
public class MySqrootNewton {
public static void main(String[] args) {

	 // argument is passed for check
    if (args.length == 0) {
        System.out.println("Number not provided");
        return;
    }

    // Parse the input argument
    double inputNumber;
    try {
        inputNumber = Double.parseDouble(args[0]);
    } catch (NumberFormatException e) {
        System.out.println(args[0] + " Incorrect number");
        return;
    }

    // to Handle negative input
    if (inputNumber < 0) {
        System.out.println(inputNumber + " Number Provide Negative");
        return;
    }

    // Initialize Newton's method
    double z = 1.0;  // Initial guess
    int maxIterations = 25;
    double tolerance = 0.001;

    for (int i = 0; i < maxIterations; i++) {
        double prevZ = z;
        z -= (z * z - inputNumber) / (2 * z); // Newton's method formula= z-(z*z-x)/(2*z)

        // Check for diff.
        if (Math.abs(z - prevZ) <= tolerance) {
            break;
        }
    }

    // Print the result
    System.out.printf("%.2f %.4f",inputNumber,z);
}
    
}