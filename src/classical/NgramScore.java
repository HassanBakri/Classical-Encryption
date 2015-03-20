/**
 * 
 */
package classical;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Hassan Bakri
 *
 */
public class NgramScore {
	private File ngramfile;
	//private String ngramFielDelm;
	double L=0;//the number of entries in the n-gram file  
	int N;//the number of letters in the n in the gram e.g 1,2,3,4,5
	double floor;
	File cash;
	HashMap<String , Double > set;
	public NgramScore(String filename,int gramSize) {
		System.out.println(1);
		ngramfile=new File(new String(filename));
		//ngramFielDelm=delm;
		N=gramSize;
		cash=new File(filename+".cash");
		if(!cash.exists())
		init();
		else {
		readFromCash();
		}
	}

	@SuppressWarnings("unchecked")
	private void readFromCash() {
		try {
			ObjectInputStream is=new ObjectInputStream(new FileInputStream(cash));
			set=(HashMap<String, Double>) is.readObject();
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void init() {
		System.out.println("init");
		System.out.println(2);
		Scanner scan =null,scan1 = null ;
		try {
			System.out.println(3);
			scan = new Scanner(ngramfile);
			
		} catch (FileNotFoundException e) {
			System.err.println("NGramFile Doesn't Exist");
			e.printStackTrace();
		}
		System.out.println(4);
		while (scan.hasNextLine()) {scan.next();L++;}
		scan.close();
		try {
			scan1 =new Scanner(ngramfile);
		} catch (FileNotFoundException e) {
			System.err.println("NGramFile Doesn't Exist");
			e.printStackTrace();
		}
		System.out.println(5);
		
		//scan1=scan1.useDelimiter(ngramFielDelm);
		set=new HashMap<String, Double>();
		Double dub;
		String temp;
		while (scan1.hasNextLine()) {
			temp=scan1.next();
			dub=scan1.nextDouble();
			dub  =   Math.log10(dub/L);
			//System.out.println(temp+"\t"+dub);
			set.put(temp, dub);	
		}
		scan1.close();
		floor=Math.log10(0.01/N);
		System.out.println(6);
		try {
			ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream(cash));
			os.writeObject(set);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public double score(String text) {
		String tempNgram;
		double score=0;
		//System.out.println(8);
		//System.out.println("P(ATTA) = "+set.get("ATTA"));
		for (int i = 0; i <= text.length()-N; i++) {
			//System.out.println(i+"\t"+N);
			tempNgram=text.substring(i,i+N);
			//System.out.println(tempNgram);
			if(set.containsKey(tempNgram)){
				//System.out.println(set.get(tempNgram).doubleValue());
			score+=set.get(tempNgram).doubleValue();
			}else {
				score+=floor;
			}
		}
		//System.out.println(9);
		return score;
		
	} 
public static void main(String[] args) {
	NgramScore quadgram=new NgramScore("english_quadgrams.txt", 4);
	System.out.println(7);//QKPC zer freq and LOG small prob = -2.6020599913279625
	System.out.println(quadgram.score("AAAA")+"\t"+quadgram.set.get("AAAA"));
	//System.out.println(quadgram.score("ATTACKTHEEASTWALLOFTHECASTLEATDAWN"));
	//System.out.println(quadgram.score("FYYFHPYMJJFXYBFQQTKYMJHFXYQJFYIFBS"));
	System.out.println(10);
	//\\FYYFHP YMJ JFXY BFQQ TK YMJ HFXYQJ FY IFBS
}
}
