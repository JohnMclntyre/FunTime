import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CaesarCipher
{
    /**
     *Returns the character shifted by the given number of leltters.
     */
     public static char shiftLetter(char c, int n)
     {
        int ch = c;
        
        if (!Character.isLetter(c))
            return c;
            
        ch = ch + n;
        if (Character.isUpperCase(c) && ch > 'Z' || Character.isLowerCase(c) && ch > 'z')
            ch -= 26;
        if (Character.isUpperCase(c) && ch < 'A' || Character.isLowerCase(c) && ch < 'a')
            ch += 26;
            
        return (char)ch;
    }
    public static void main(String[] args) throws Exception
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Name your new ciphered message output file.");
        String saveFile = input.nextLine();
        
        String plaintext, cipher = "";
        int shift;
        File in = new File(saveFile);
        
        if (in.createNewFile())
        {
            System.out.println("File name doesn't exist, creating one.");
        }
        
        System.out.print("Message: ");
        plaintext = input.nextLine();
        System.out.print("Shift (0-26): ");
        shift = input.nextInt();
        
        for (int i=0; i<plaintext.length(); i++)
        {
            cipher += shiftLetter(plaintext.charAt(i),shift);
        }
        System.out.println(cipher);
        
        PrintWriter out = new PrintWriter(new FileWriter(saveFile));
        out.println(cipher);
        out.close();       
    }
}
