
ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ"

def encrypt(text, key):
    text = text.upper()
    encrypted_text = ""
    for ch in text:
        ch_index = ALPHABET.find(ch)
        encrypted_index = (ch_index + key) % len(ALPHABET)
        encrypted_text += ALPHABET[encrypted_index]
    return encrypted_text

def decrypt(text, key):
    decrypted_text = ""
    for ch in text:
        ch_index = ALPHABET.find(ch)
        decrypted_index = (ch_index - key) % len(ALPHABET)
        decrypted_text += ALPHABET[decrypted_index]

    return decrypted_text
    
text_to_encrypt = "This is a message"
encrypted_text = encrypt(text_to_encrypt, 3)
print(encrypted_text,decrypt(encrypted_text,3),sep="\n")

