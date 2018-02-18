
package antiCyberSquattingTool;


public class String_Preprocessing {
    public String preprocessed = new String("");

    public String_Preprocessing(String str){
        String tmp = new String("");
        for(int i = 0; i < str.length(); i++) {
	tmp = tmp + Character.toLowerCase(str.charAt(i));
        }
        str = tmp;

        char[] arr = new char[20];

        for(int i = 0; i < str.length(); i++)arr[i]= str.charAt(i);

        for(int i = 0; i < str.length(); i++){
            if (((arr[i+1] < '1') || arr[i+1] >'9') && arr[i] =='0' && (arr[i-1] <'1' || arr[i-1] >'9')){
                arr[i] ='o';
            }
          }
        
        /*String preprocessed1 = new String("");
        for(int i =0; i < str.length(); i++){
            preprocessed1 = preprocessed1 + arr[i];

        }*/

        //System.out.println("here is prepro  " + preprocessed1);


        for(int i = 0; i < str.length(); i++){
            if(arr[i]=='0' || arr[i]=='1' || arr[i]=='2'||arr[i]=='3'||arr[i]=='4'||arr[i]=='5'
                    ||arr[i]=='6'||arr[i]=='7'||arr[i]=='8'||arr[i]=='9')arr[i] = '.';
         }
         for(int i = 0; i < str.length(); i++){
            if(arr[i]=='#' || arr[i]=='%'||arr[i]=='^'||arr[i]=='&'||arr[i]=='*'
                    ||arr[i]=='('||arr[i]==')'||arr[i]=='-'||arr[i]=='_' || arr[i]==';' || arr[i]==','
                     || arr[i]=='.' || arr[i]=='!' || arr[i]=='@')arr[i] = '.';

            }
        
        for(int i =0; i < str.length(); i++){
            if(arr[i] !='.')
                preprocessed = preprocessed + arr[i];

        }

        
        System.out.println("here is prepro  " + preprocessed);
        
        }

        
        public String Ret(){

            return preprocessed;
        }

        

    }



