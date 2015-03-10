package classical;

public class Main {

	public static void main(String[] args) {
		Caesar c=new  Caesar();
		System.out.println(c.Encrypt("MyNAme   \\\\:Is Khan", 3));
		Playfair p=new Playfair("AsababaAs");
		//System.out.println(p.Encrypt("HassanbakriHassanalmkki"));
		System.out.println(p.Decrypt(p.Encrypt("HassanbakriHassanalmkki")));
	}
}
