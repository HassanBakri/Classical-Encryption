package classical;

import java.util.Random;

public class SimpleSubBreak extends Thread {
/*
 * The hill-climbing algorithm looks like this:
 * 1. Generate a random key, called the 'parent', decipher the ciphertext using this key. Rate the fitness and store the result.
 * 2. Change the key slightly (swap two characters in the key at random), measure the fitness of the
 * deciphered text using the new key.
 * 3. If the fitness is higher with the modified key, discard our old parent 
 * 4. Go back to 2, unless no improvement in fitness occurred in the last 1000 iterations.
 * */
	String cipherText;
	SimpleSubstitution cipher;
	NgramScore ngram;
	public SimpleSubBreak(String cipherText) {
		setPriority(MAX_PRIORITY);
		this.cipherText=cipherText;
		ngram  = new NgramScore("english_quadgrams.txt", 4);
		cipher = new SimpleSubstitution();
	}
	public void Break(String parentKey){
		double maxscore=-99e9;
		String maxkey = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int j=0,count=0;
		while (j<5000) {
		String chaildKey=parentKey;
		String decripted1=null,decripted   = cipher.Decrypt(cipherText,parentKey);
		double newFitness,currFitness = ngram.score(decripted);
		int rand1,rand2;		
		Random ra=new Random();
		for (int i = 0; i < 1000; i++) {
			
			rand1=ra.nextInt(26);
			rand2=ra.nextInt(26);
			chaildKey=swap(rand1,rand2,chaildKey);
			decripted1   = cipher.Decrypt(cipherText,chaildKey);
			newFitness = ngram.score(decripted1);
			 if (newFitness > currFitness){
				currFitness = newFitness;
			 	parentKey = chaildKey;
		            i = 0;}
		}
		if (currFitness>maxscore){
			maxscore=currFitness;
			maxkey = parentKey;
			count=j;
			System.out.println("Count "+count+"  Fitness "+maxscore+" Best Key is  : "+maxkey+"\t"+cipher.Decrypt(cipherText, maxkey));}
		j++;
		 randKey(parentKey);
		}
		System.out.println("Count "+count+"  Fitness "+maxscore+" Best Key is  : "+maxkey+"\t"+cipher.Decrypt(cipherText, maxkey));
	}
	private void randKey(String parentKey) {
		Random ra=new Random();
		for (int i = 0; i <26; i++) {
			parentKey=swap(ra.nextInt(26), ra.nextInt(26), parentKey);
		}
		return  ;
	}
	private String swap(int rand1, int rand2, String chaildKey) {
		char [] ch=chaildKey.toCharArray();
		char temp=ch[rand1];
		ch[rand1]=ch[rand2];
		ch[rand2]=temp;
		return new String(ch);
	}
	public static void main(String[] args) {
		new SimpleSubBreak("SOWFBRKAWFCZFSBSCSBQITBKOWLBFXTBKOWLSOXSOXFZWWIBICFWUQLRXINOCIJLWJFQUNWXLFBSZXFBT"
				+"XAANTQIFBFSFQUFCZFSBSCSBIMWHWLNKAXBISWGSTOXLXTSWLUQLXJBUUWLWISTBKOWLSWGSTOXLXTSWL"
				+"BSJBUUWLFULQRTXWFXLTBKOWLBISOXSSOWTBKOWLXAKOXZWSBFIQSFBRKANSOWXAKOXZWSFOBUSWJBSBF"
				+"TQRKAWSWANECRZAWJ").Break("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	}
}