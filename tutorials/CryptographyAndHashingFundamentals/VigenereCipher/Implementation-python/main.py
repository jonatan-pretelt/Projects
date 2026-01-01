ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ"


def vigenere_encrypt(plain_text, key):
    plain_text = plain_text.upper()
    key = key.upper()
    cipher_text = ""
    key_index = 0

    for ch in plain_text:

        index = (ALPHABET.find(ch) + ALPHABET.find(key[key_index])) % len(ALPHABET)

        cipher_text += cipher_text + ALPHABET[index]

        key_index = key_index + 1
        if key_index == len(key):
            key_index = 0

    return cipher_text


def vigenere_decrypt(cipher_text, key):
    cipher_text = cipher_text.upper()
    key = key.upper()
    key_index = 0

    plain_text = ""
    for ch in cipher_text:
        index = (ALPHABET.find(ch) - ALPHABET.find(key[key_index])) % len(ALPHABET)

        plain_text += ALPHABET[index]

        key_index = key_index + 1
        if key_index == len(key):
            key_index = 0
    
    return plain_text

if __name__ == '__main__':
    print('RUNNING')
    text = "CRYPTOGRAPHY IS QUITE IMPORTANT IN CRYPTOCURRENCIES"
    secret = 'SECRET'
    encrypted_text = vigenere_encrypt(text,secret)
    # print(encrypted_text)
    print(vigenere_decrypt(encrypted_text, secret))

