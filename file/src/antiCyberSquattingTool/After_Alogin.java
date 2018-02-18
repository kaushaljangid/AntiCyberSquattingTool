package antiCyberSquattingTool;


public class After_Alogin {

	public String ans ="";  // final result will be store in this String.
	public static String str = "";


	After_Alogin(String str){
		String_Preprocessing stp = new String_Preprocessing(str);
		str = stp.Ret();

		Node ob = new Node("C:\\Users\\kanishk\\Desktop\\Java\\ACST\\src\\antiCyberSquattingTool\\trademarks2.txt");
		//Homograph_attack ha = new Homograph_attack();//("C:\\Users\\sony\\workspace\\ACST\\src\\antiCyberSquattingTool\\trademarks2.txt");       

		//String fname = "trademarks1.txt";
		try {
			//  FileInputStream fstream = new FileInputStream(fname);
			// DataInputStream in = new DataInputStream(fstream);
			//BufferedReader br = new BufferedReader(new InputStreamReader(in));

			//String strLine;
			//while ((strLine = br.readLine()) != null)

			//checking if domain name is already matches with registered.
			//System.out.println("here" + str);
			if(ob.search(str)){
				ans="Already Registered!";
				System.out.println("domain name can't be registered"); // if matches

			}

			else {  // if not matches
				System.out.println("here");
				// if not matched than check if domain name is typing error of some domain name or not...
				typo_squatting tysq = new typo_squatting("C:\\Users\\kanishk\\Desktop\\Java\\ACST\\src\\antiCyberSquattingTool\\trademarks2.txt");
				System.out.println(tysq.correct(str));
				if(str.equals(tysq.correct(str))){
					// No typosquatting...




					ans = "Not Registered";
					After_Alogin.str = str;




				}else{
					// Typosquatting...
					ans="Already Registered!";
					System.out.println("domain name can't be registered");



				}



				/*if(tysq.correct(str)){      // i.e if return 1 than  no typo-squatting
                         Homograph_attack hmatt = new Homograph_attack();
                           System.out.println(hmatt.checkHomograph(str));



                     }else{  // if return 0 than there is tposquatting...
                          System.out.println("domain name can't be registered");
                     }*/





			}
			//ha.checkHomograph(str); 


		} catch(Exception e) {
			System.out.println("Exception in Node.java");
		}
	}
	public String ret_Gui(){

		return ans;

	}
	
	public static String retRegisteredDomain(){
		
		return str;
	}


}

