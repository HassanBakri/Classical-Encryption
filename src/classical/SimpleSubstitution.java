/**
 * 
 */
package classical;


/**
 * @author Hassan Bakri
 *
 */
public class SimpleSubstitution {
	private String key;
	//private HashMap<Character, Character> keymap;
	//private Character [] alpha={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
public SimpleSubstitution(String k) {
	key=k.toUpperCase();
}
public SimpleSubstitution() {
	// TODO Auto-generated constructor stub
}
public String getKey() {
	return key;
}
public void setKey(String key) {
	key=key.toUpperCase();
	this.key = key;
}
public String Encrypt(String cipherText) {
	
	return Encrypt(cipherText,getKey());
}
public String Encrypt(String plainText,String key) {
	char [] cipherText = new char[plainText.length()];
	key=key.toUpperCase();
	plainText=plainText.toUpperCase();
	int i=0,j=0;
	for ( i = 0; i < plainText.length(); i++) {
		if(Character.isAlphabetic(plainText.charAt(i))){
			cipherText[j++]=key.charAt((int)plainText.charAt(i)-65);
		}
	}
	return new String(cipherText, 0, j);
}
public String Decrypt(String cipherText) {
	return Decrypt(cipherText,getKey());
}
public String Decrypt(String cipherText,String key) {
	char [] plainText = new char[cipherText.length()];
	key=key.toUpperCase();
	cipherText=cipherText.toUpperCase();
	int i=0,j=0;
	for ( i = 0; i < cipherText.length(); i++) {
			plainText[j++]=(char)(key.indexOf(cipherText.charAt(i))+65);
	}
	return  new String(plainText, 0, j);
}
public static void main(String[] args) {
	SimpleSubstitution c = new SimpleSubstitution("YBXONGSWKCPZFMTDHRQUJVELIA");
	System.out.println(c.Decrypt("SOWFBRKAWFCZFSBSCSBQITBKOWLBFXTBKOWLSOXSOXFZWWIBICFWUQLRXINOCIJLWJFQUNWXLFBSZXFBT"
			+"XAANTQIFBFSFQUFCZFSBSCSBIMWHWLNKAXBISWGSTOXLXTSWLUQLXJBUUWLWISTBKOWLSWGSTOXLXTSWL"
			+"BSJBUUWLFULQRTXWFXLTBKOWLBISOXSSOWTBKOWLXAKOXZWSBFIQSFBRKANSOWXAKOXZWSFOBUSWJBSBF"
			+"TQRKAWSWANECRZAWJ"));
}
}
