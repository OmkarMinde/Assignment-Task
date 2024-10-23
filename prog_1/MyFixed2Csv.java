import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyFixed2Csv {
public static void main(String[] args) {
    if (args.length < 3) {
        System.err.println("Usage: myfixed2csv <fixed-width-file> <n-columns> <length1> <length2>");
        return;
    }

    String inputFileName = args[0];
    int nColumns = Integer.parseInt(args[1]);
    int[] lengths = new int[nColumns];

    for (int i = 0; i < nColumns; i++) {
        lengths[i] = Integer.parseInt(args[i + 2]);
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
         BufferedWriter writer = new BufferedWriter(new FileWriter("output.csv"))) {

        String line;
        while ((line = reader.readLine()) != null){
            StringBuilder csvLine = new StringBuilder();
            int startIndex = 0;

            for (int length : lengths) {
                if (startIndex + length > line.length()){
                    break;
                }
                String field = line.substring(startIndex, startIndex + length).trim();
                field = field.replaceFirst("^0+", ""); // Remove leading zeros
                csvLine.append("\"").append(field).append("\"").append(",");
                startIndex += length;
            }

            // Remove trailing comma and write to file
            if (csvLine.length() > 0) {
                csvLine.setLength(csvLine.length() - 1); // Remove last comma
            }
            writer.write(csvLine.toString());
            writer.newLine();
        }

    } catch (IOException e){
        e.printStackTrace();
    }
 }    
}