package classical;

import java.util.Arrays;

class Playfair {
	private String keystr=null;
	private char [] keyMatrix=new char[25];
	private char [] alfapatic={'A','B','C','D','E','F','G','H','I','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
public Playfair() {
	this("FEDCBA");
	}
public Playfair(String keystr)
	{
	setKeystr(keystr);
	}
public String getKeystr() {
	return keystr;
	}
public void setKeystr(String keystr) {
	this.keystr = keystr;
	consructKeyMatrix(keystr);
	}
private void consructKeyMatrix(String keystr) {
	keystr = keystr.toUpperCase();
	keystr = removeDupp(keystr);
	System.out.println(keystr);
	int i=0;
	for( i=0;i!=keystr.length();i++)
		{
		keyMatrix[i]=keystr.charAt(i);
		int res=Arrays.binarySearch(alfapatic, keystr.charAt(i));
		shift(alfapatic, res);
		}
	for(int index=0;index!=alfapatic.length-keystr.length();i+=1,index+=1)
		{
		keyMatrix[i]=(char)alfapatic[index];
		}
	//System.arraycopy(alfapatic, 0, keyMatrix, i, keyMatrix.length-1);
	//for(int j=0;j!=25;j++){System.out.print(keyMatrix[j]);}
	}
private String removeDupp(String keystr) {
	char [] prekey=keystr.toCharArray();	
	int j=0,l=keystr.length();
	for(int i=0;i!=keystr.length();i++){
		for(j=0;j!=l;j++){
		if((prekey[i]==prekey[j])&&(i!=j)){
			shift(prekey,j);
			j-=1;
			l-=1;
		}
		}
		j=0;
	}
	char [] key=new char[l];
	System.arraycopy(prekey, 0, key, 0, l);
	return new String(key);
	}
private void shift(char[] prekey, int j) {
	if(j==prekey.length-1){prekey[j]=0;return ;}
	for(int i=j;i!=prekey.length-1;i++){
	prekey[i]=prekey[i+1];
	}
	prekey[prekey.length-1]=0;	
	}
String Encrypt(String plainText){
	plainText = plainText.toUpperCase();
	plainText=plainText.replace('J', 'I');
	String cipherText="";
	String key=new String (keyMatrix);
	plainText=playFairFilter(plainText);
	System.out.println("\n"+plainText);
	char a,b;
	int a1,b1;
	int base ,offset_a1,offset_b1;
	int temp=0;
	for(int i=0;i!=plainText.length();i+=2)
	{
		a=plainText.charAt(i);
		b=plainText.charAt(i+1);
		if(a==b){i--;b='X';}
		a1=key.indexOf(a);
		b1=key.indexOf(b);
		int diff=(int)Math.abs(a1-b1);
		if((a1)/5==(b1)/5)
		{
		base=a1/5;
		offset_a1=(a1-base*5)+1;
		offset_b1=(b1-base*5)+1;
		a1=base*5+(offset_a1%5);
		b1=base*5+(offset_b1%5);
		}
		else if(diff%5==0)
		{
			a1=(a1+5)%25;
			b1=(b1+5)%25;	
		}
		else
		{
			//rowIndex * numberOfColumns + columnIndex.
			//columnIndex * numberOfRows + rowIndex.
			temp=a1;
			a1 = b1%5 + (a1/5)*5;
			b1 = temp%5 + (b1/5)*5;
		}
		cipherText+=keyMatrix[a1];
		cipherText+=keyMatrix[b1];
	}
	return cipherText;
	}
String Decrypt(String ciphertext){
	ciphertext = ciphertext.toUpperCase();
	String plaintext="";
	System.out.println("\n"+ciphertext);
	char a,b;
	int base ,offset_a1,offset_b1;
	int a1,b1;
	int temp=0;
	for(int i=0;i!=ciphertext.length();i+=2)
	{
		a=ciphertext.charAt(i);
		b=ciphertext.charAt(i+1);
		String key=new String (keyMatrix);
		a1=key.indexOf(a);
		b1=key.indexOf(b);
		System.out.println(a1+"\t"+b1);
		int diff=(int)Math.abs(a1-b1);
		System.out.println(diff);
		if((a1)/5==(b1)/5)
		{
			base=a1/5;
			offset_a1=(a1-base*5)-1;
			offset_b1=(b1-base*5)-1;
			a1=base*5+(offset_a1%5);
			b1=base*5+(offset_b1%5);
		}
		else if(diff%5==0)
		{
			a1=(a1-5)%25;
			b1=(b1-5)%25;	
		}
		else
		{
			//rowIndex * numberOfColumns + columnIndex.
			//columnIndex * numberOfRows + rowIndex.
			temp=a1;
			a1 = b1%5 + (a1/5)*5;
			b1 = temp%5 + (b1/5)*5;
		}
		plaintext+=keyMatrix[a1];
		plaintext+=keyMatrix[b1];
	}
	return plaintext;
	}
private String playFairFilter(String plainText) {
	int length =plainText.length();	
	char[] plainTextarr =new char[2*length];
	int index=-1;
	for(int i=0;i<length;i++)
	{
		if(Character.isAlphabetic(plainText.charAt(i)))
			{
			plainTextarr[++index]=plainText.charAt(i);
			}		
		else{continue;}
	}
	plainText=new String(plainTextarr, 0, index+1);
	System.out.println("clean\t:"+plainText);
	if(!((index+1)%2==0))plainTextarr[++index]='X';
	return new String(plainTextarr,0,index+1);
	}
}
