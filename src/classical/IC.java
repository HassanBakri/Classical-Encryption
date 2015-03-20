package classical;

public class IC {

	/*
	 * I.C stand for Index of Coincidence
	 * The index of coincidence is a measure of how similar a frequency distribution is to the uniform
	 *	distribution. The I.C. of a piece of text does not change if the text is enciphered with a substitution cipher.
	 * */
	public IC() {
	
	}
	public double calc(String a) {
		a=a.toUpperCase();
		double []freq=new double[26];
		int i;//will hold The Value Of N-1
		for ( i = 0; i < a.length(); i++) {
			switch (a.charAt(i)) {
			case 'A':
				freq[0]++;
				break;
			case 'B':
				freq[1]++;
				break;
			case 'C':
				freq[2]++;
				break;
			case 'D':
				freq[3]++;
				break;
			case 'E':
				freq[4]++;
				break;
			case 'F':
				freq[5]++;
				break;
			case 'G':
				freq[6]++;
				break;
			case 'H':
				freq[7]++;
				break;
			case 'I':
				freq[8]++;
				break;
			case 'J':
				freq[9]++;
				break;
			case 'K':
				freq[10]++;
				break;
			case 'L':
				freq[11]++;
				break;
			case 'M':	
				freq[12]++;
				break;
			case 'N':	
				freq[13]++;
				break;
			case 'O':	
				freq[14]++;
				break;
			case 'P':	
				freq[15]++;
				break;
			case 'Q':	
				freq[16]++;
				break;
			case 'R':	
				freq[17]++;
				break;
			case 'S':	
				freq[18]++;
				break;
			case 'T':	
				freq[19]++;
				break;
			case 'U':	
				freq[20]++;
				break;
			case 'V':	
				freq[21]++;
				break;
			case 'W':	
				freq[22]++;
				break;
			case 'X':	
				freq[23]++;
				break;
			case 'Y':	
				freq[24]++;
				break;
			case 'Z':	
				freq[25]++;
				break;
			default:
				break;
			}
			
		}
		i*=(i-1);
		double summation=0;
		for (int j = 0; j < 26; j++) {
			freq[j]*=(freq[j]-1);
			summation+=freq[j];
		}
		return summation/(double)i;
	} 
public static void main(String[] args) {
	IC ic=new IC();
	System.out.println(ic.calc("wmzfxtdhzfngfwxwnwxjevxdmzoxfkvxdmzowmkwmkfgzzexenfzpjotkebmneloz"
					+"lfjpbzkofxwvjefxfwfjpfngfwxwnwxeszyzobdhkxewzawvmkokvwzopjoklxppz"
					+"ozewvxdmzowzawvmkokvwzoxwlxppzofpojtvkzfkovxdmzoxewmkwwmzvxdmzokh"
					+"dmkgzwxfejwfxtdhbwmzkhdmkgzwfmxpwzlxwxfvjtdhzwzhbrntghzl"));
	System.out.println(ic.calc("vptzmdrttzysubxaykkwcjmgjmgpwreqeoiivppalrujtlrzpchljftupucywvsyi"
	+"uuwufirtaxagfpaxzxjqnhbfjvqibxzpotciiaxahmevmmagyczpjxvtndyeuknul"
	+"vvpbrptygzilbkeppyetvmgpxuknulvjhzdtgrgapygzrptymevppaxygkxwlvtia"
	+"wlrdmipweqbhpqgngioirnxwhfvvawpjkglxamjewbwpvvmafnlojalh"));
	System.out.println(ic.calc("RADIUSREMOTEAUTHENTICATIONDIALINUSERSERVICERADIUSISBYFARTHEMOSTPOPULARAAASERVICEINUSETODAYITSPOPULARITYCANBEATTRIBUTEDTOLIVINGSTONSDECISIONTOOPENTHEDISTRIBUTIONOFTHERADIUSSOURCECODEUSERSWEREQUICKTOPORTTHESERVICEACROSSMULTIPLEPLATFORMSANDADDCUSTOMIZEDFEATURESMANYOFWHICHLIVINGSTONINCORPORATEDASSTANDARDFEATURESINLATERRELEASESTODAYVERSIONSOFTHERADIUSSERVERAREAVAILABLEFOREVERYMAIOROPERATINGSYSTEMFROMBOTHFREEWAREANDCOMMERCIALSOURCESANDTHERADIUSCLIENTCOMESSTANDARDONNASPRODUCTSFROMEVERYMAIORVENDORABASICRADIUSSERVERIMPLEMENTATIONREFERENCESTWOCONFIGURATIONFILESTHECLIENTCONFIGURATIONFILECONTAINSTHEADDRESSOFTHECLIENTANDTHESHAREDSECRETUSEDTOAUTHENTICATETRANSACTIONSTHEUSERFILECONTAINSTHEUSERIDENTIFICATIONANDAUTHENTICATIONINFORMATIONEGUSERIDANDPASSWORDASWELLASCONNECTIONANDAUTHORIZATIONPARAMETERSPARAMETERSAREPASSEDBETWEENTHECLIENTANDSERVERUSINGASIMPLEFIVEFIELDFORMATENCAPSULATEDINTOASINGLEUDPPACKET"));
}
}

