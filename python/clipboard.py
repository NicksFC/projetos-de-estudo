import pyperclip
import time

ultimo = ""

print("Monitorando Ctrl+C... (Ctrl+C no terminal para sair)")

while True:
    texto = pyperclip.paste()
    if texto != ultimo:
        with open("Clipboard_Logger/python/PythonClipboard.txt", "a", encoding="utf-8") as f:
            f.write(texto + "\n")
        ultimo = texto
    time.sleep(1)