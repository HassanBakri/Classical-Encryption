package classical;

class Caesar {
	private int key;
	public Caesar() {
		this(3);
	}
	public  Caesar(int key) {
		setKey(key);
	}
	public void setKey(int key) {
		this.key = key;
	}
	private int getkey(){
		return key;
	}
public String Encrypt(String plainText){
	return Encrypt(plainText, getkey());
}
public String Encrypt(String painText,int key)
	{
	painText=painText.trim();

	painText=painText.toUpperCase();
	char [] cipherTextarr=new char[painText.length()];
	cipherTextarr=painText.toCharArray();
	int i;
	for(  i=0;i<painText.length();i++)
		{
		if (!Character.isAlphabetic(cipherTextarr[i])){continue;}
		cipherTextarr[i]-=65;
		System.out.println((byte)cipherTextarr[i]);
		//System.out.print((int)cipherTextarr[i]+"\t");
		cipherTextarr[i]=(char)(((byte)cipherTextarr[i]+key)%26);
		//System.out.println((int)cipherTextarr[i]);
		cipherTextarr[i]+=65;
		}
		return new String (cipherTextarr,0,i);

	}
public String Decrypt(String cipherText){
	return Decrypt(cipherText, getkey());
}
public String Decrypt(String cipherText,int key)
	{
	cipherText=cipherText.toUpperCase();
	char [] plainTextarr= cipherText.toCharArray();
	int i,j=0;
	for(  i=0;i <cipherText.length();j++,i++)
		{
		if (!Character.isAlphabetic(cipherText.charAt(i))){j--;continue;}
		plainTextarr[i]-=65;
		//System.out.print((int)plainTextarr[i]+"\t");
		plainTextarr[j]=(char) ((plainTextarr[i]-key+26)%26);
		plainTextarr[j]+=65;
		}
		return new String (plainTextarr,0,j);
	}
public static void main(String[] args) {
	Caesar cipher=new Caesar();
	String plain="BahryUniVersityz";
	String ciphertext=cipher.Encrypt(plain);
	String plainText=cipher.Decrypt(ciphertext);
	System.out.println("Plain Text     : "+plain+"\nCipherText     : "+ciphertext+"\nDecrypted Text : "+plainText);
}
}
