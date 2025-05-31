import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ReadCSV{
    public static void main(String[] args) {
        
        List<String[]> data = new ArrayList<String[]>();
        String filename = "C:\\Users\\jon\\Projects\\LearningJava\\JavaFundamentals\\ReadingCSVFile\\accounts.csv";
        String dataRow;
        try {

            BufferedReader br = new BufferedReader(new FileReader(filename));

           while ((dataRow = br.readLine()) != null){
              String[] line = dataRow.split(",");
              data.add(line);
           }
           br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        for(String[] account : data){
            System.out.print("[ ");            for( String field : account){
                System.out.print(field + " ");
            }
            System.out.println("]");
        }

    }
}