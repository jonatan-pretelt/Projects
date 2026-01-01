package CaesarCipher.CaesarCipherJava;

 class CaesarCipher {
    private String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encrypt(String plainText, int key) {
        String cipherText = "";
        plainText = plainText.toUpperCase();

        for (int i = 0; i < plainText.length(); i++) {
            char character = plainText.charAt(i);

            int charIndex = ALPHABET.indexOf(character);

            int encryptedIndex = (charIndex + key) % ALPHABET.length();

            cipherText += ALPHABET.charAt(encryptedIndex);
        }

        return cipherText;
    }

    public String decrypt(String chipherText, int key) {
        String plainText = "";

        for (int i = 0; i < chipherText.length(); ++i) {
            char character = chipherText.charAt(i);
            int charIndex = ALPHABET.indexOf(character);
            // int decryptedIndex = (charIndex - key) % ALPHABET.length();
            int decryptedIndex = Math.floorMod(charIndex - key, ALPHABET.length());
            plainText += ALPHABET.charAt(decryptedIndex);
        }

        return plainText;
    }


}
