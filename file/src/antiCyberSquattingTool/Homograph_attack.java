
package antiCyberSquattingTool;

public class Homograph_attack {

     public  boolean checkHomograph(String dns){
      //  System.out.println("homo " + dns);
       String tmp = new String("");
        for(int i = 0; i < dns.length(); i++) {
	tmp = tmp + Character.toLowerCase(dns.charAt(i));
        }
    dns = tmp;

    dns.replace('0', 'o');

    

    //System.out.println("homo " + dns);
    return true;
    }


}
