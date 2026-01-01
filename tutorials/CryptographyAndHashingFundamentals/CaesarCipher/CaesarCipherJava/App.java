package CaesarCipher.CaesarCipherJava;

public class App {
    public static void main(String[] args){
        String text = "This is a message";

        CaesarCipher cipher = new CaesarCipher();

        String cipherText = cipher.encrypt(text, 3);

        System.out.println(cipherText);

        System.out.println(cipher.decrypt(cipherText, 3));
    }
}
