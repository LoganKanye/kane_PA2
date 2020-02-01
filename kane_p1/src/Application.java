import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		//Create encrypt and decrypter objects
		Encrypter enc = new Encrypter();
		Decrypter dec = new Decrypter();
		
		//Declare relevant variables
		int input;
		int encOutput;
		int decOutput;
		
		//Open input stream
		Scanner in = new Scanner(System.in);
		
		//Read user input
		System.out.print("Please Enter a Four Digit Number: ");
		input = in.nextInt();
		System.out.println();
		
		//Encrypt
		encOutput = enc.encrypt(input);
		
		//Print encrypted number
		System.out.print("Your Encrypted Number is: ");
		for (int i = 0; i < 4 - String.valueOf(encOutput).length(); i++) {
			System.out.print("0");
		}
		System.out.printf("%d", encOutput);
		System.out.println();
		System.out.println();
		
		//Decrypt
		decOutput = dec.decrypt(encOutput);
		
		//Print decrypted number
		System.out.print("Your Decrypted Number is: ");
		for (int i = 0; i < 4 - String.valueOf(decOutput).length(); i++) {
			System.out.print("0");
		}
		System.out.printf("%d", decOutput);
		System.out.println();
		
		//Close input stream
		in.close();

	}

}
