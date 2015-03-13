/**
 * 
 */
package classical;

/**
 * @author Hassan Bakri hassanbakry@gmail.com
 *
 *
 */
public class Vigenere {
	private String Key;
	private Caesar cipher = new Caesar();
public Vigenere() {

}
public Vigenere(String Key){
	setKey(Key);
}
public String getKey() {
	return Key;
}
public void setKey(String key) {
	key=key.toUpperCase();
	Key = key;
}
public String Encrypt(String plainText) {
	plainText=plainText.toUpperCase();
	plainText=clean(plainText);
	setKey(stretch(plainText, getKey()));
	String k=getKey();
	char [] ciphertextarr=new char [plainText.length()];
	int i;
	for( i=0;i!=plainText.length();i++){
		//System.out.println(plainText.charAt(i)+"\t"+k.charAt(i));
		ciphertextarr[i] = cipher.Encrypt(""+plainText.charAt(i),k.charAt(i)-65).charAt(0);
		System.out.println(plainText.charAt(i)+"\t"+k.charAt(i)+"\t"+ciphertextarr[i]);
	}
	return new String(ciphertextarr, 0, i);	
}

private String clean(String plainText) {
	byte strarr[]=new byte[plainText.length()];
	int i=0;
	char temp ;
	for (int j=0;j!=plainText.length();i++,j++){
		temp=plainText.charAt(j);
		if(!Character.isAlphabetic(temp)){i--;continue;}
		else {
			strarr[i]=(byte) temp;		}
	}
	return new  String(strarr, 0, i);
}
public String Decrypt(String cipherText) {
	cipherText=cipherText.toUpperCase();
	setKey(stretch(cipherText, getKey()));
	String k=getKey();
	char [] ciphertextarr=new char [cipherText.length()];
	int i;
	for( i=0;i!=cipherText.length();i++){
		ciphertextarr[i]=cipher.Decrypt(""+cipherText.charAt(i),k.charAt(i)-65).charAt(0);
	}
	return new String(ciphertextarr, 0, i);	
}
private String  stretch(String plaintext,String Key) {
	char keyarr []=new char[plaintext.length()];
	for(int i=0;i!=plaintext.length();i++){
		keyarr[i]=Key.charAt(i%Key.length());
		}
	return new String (keyarr);
	
}
}
