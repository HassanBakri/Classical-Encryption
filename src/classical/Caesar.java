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
	int j=0;
	for( int i=0;i!=painText.length();j++,i++)
		{
		if (!Character.isAlphabetic(cipherTextarr[i])){j--;continue;}
		cipherTextarr[i]-=65;
		System.out.print((int)cipherTextarr[i]+"\t");
		cipherTextarr[i]=(char)(((int)cipherTextarr[i]+key)%26);
		System.out.println((int)cipherTextarr[i]);
		cipherTextarr[i]+=65;
		}
		return new String (cipherTextarr,0,j);

	} 
public String Decrypt(String cipherText){
	return Decrypt(cipherText, getkey());
}
public String Decrypt(String cipherText,int key)
	{
	byte [] plainTextarr=new byte[cipherText.length()];
	int i=0;
	for( i=0;i==cipherText.length();i++)
		{
		plainTextarr[i]=(byte)((cipherText.charAt(i)+key)%26);
		}
		return new String (plainTextarr,0,i);
	}
}
