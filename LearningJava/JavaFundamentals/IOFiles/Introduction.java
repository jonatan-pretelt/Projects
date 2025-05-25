import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

class Introduction{

    public static void main(String[] args) throws IOException{

        FileWriter output = new FileWriter("output.txt");

        String statement = "A new message was created.";
        output.write(statement);
        output.close();

        FileReader reader = new FileReader("output.txt");

        while(reader.ready())
        {
            System.out.print((char)reader.read());
        }

        reader.close();
    }

}