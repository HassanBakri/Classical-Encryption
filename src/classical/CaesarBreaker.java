package classical;

public class CaesarBreaker {
	private Caesar c;
	private NgramScore ngram;
	private String cipher;
	public CaesarBreaker(String cipherText) {
		cipher  = cipherText;
		c  		= new Caesar();
		ngram	= new NgramScore("english_quadgrams.txt", 4);
	}
	public int[] Break() {
		String plainText;
		double fitness;
		System.out.println("Key\tPlaintex\t\t\t\t\t\tFitness");
		for (int i = 0; i < 26; i++) {
			plainText = c.Decrypt(cipher.intern(),i);
			//System.out.println("test\t"+c.Decrypt("YMJHFJX", 5));
			fitness	  = ngram.score(plainText);
			System.out.println(i+"\t"+plainText+"\t"+fitness);
		}
		return null;
		
	}
	public static void main(String[] args) {
		new CaesarBreaker("YMJHFJXFWHNUMJWNXTSJTKYMJJFWQNJXYPSTBSFSIXNRUQJXYHNUMJWX").Break();
	}
}
