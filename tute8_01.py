def encrypt(text, shift):
    result = ""
    for i in range(len(text)):
        char = text[i]
        if char.isupper():
            result += chr((ord(char) + shift - 65) % 26 + 65)
        elif char.islower():
            result += chr((ord(char) + shift - 97) % 26 + 97)
        else:
            result += char
    return result

def decrypt(text, shift):
    return encrypt(text, -shift)

def cipher(func, text, shift):
    return func(text, shift)

# Example usage:
plaintext = "Hello, World!"
shift = 3
encrypted = cipher(encrypt, plaintext, shift)
decrypted = cipher(decrypt, encrypted, shift)

print(f"Plaintext: {plaintext}")
print(f"Encrypted: {encrypted}")
print(f"Decrypted: {decrypted}")