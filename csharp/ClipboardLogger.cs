using System;
using System.IO;
using System.Threading;
using System.Windows.Forms;

class Program
{
    [STAThread]
    static void Main()
    {
        string ultimo = "";

        Console.WriteLine("Monitorando Ctrl+C...");

        while (true)
        {
            if (Clipboard.ContainsText())
            {
                string texto = Clipboard.GetText();

                if (texto != ultimo)
                {
                    File.AppendAllText(
                        "CsharpClipboard.txt",
                        texto + Environment.NewLine
                    );
                    ultimo = texto;
                }
            }

            Thread.Sleep(1000);
        }
    }
}