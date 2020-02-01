
public class Decrypter {

	public int decrypt(int input) {
		
		//Use division and remainder operator to split input into single digits
		int i1 = input / 1000;
		int i2 = (input % 1000) / 100;
		int i3 = (input % 100) / 10;
		int i4 = (input % 10);
		
		//First half of decryption
		i1 = (i1 + 3) % 10;
		i2 = (i2 + 3) % 10;
		i3 = (i3 + 3) % 10;
		i4 = (i4 + 3) % 10;
		
		//Second half of decryption and return
		return ((i3 * 1000) + (i4 * 100) + (i1 * 10) + i2);
		
	}
	
}
