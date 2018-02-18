package antiCyberSquattingTool;

import java.io.*;

public class Node {
    private boolean end;
    private Node child[];
    private int data;
	private BufferedReader br;
    public Node() {
        end = false;
        child = new Node[27];
        data = 0;
    }
    public Node(String fname) {
        end = false;
        data = 0;
        String strLine = new String("");
        child = new Node[27];
        try {
            FileInputStream fstream = new FileInputStream(fname);
            DataInputStream in = new DataInputStream(fstream);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null)   {
	//System.out.println("Exception in Node.java = "+strLine);
            insert(strLine);
            }
        } catch(Exception e) {
	//System.out.println("Exception in Node.java = " + strLine);
        	e.printStackTrace();
        }
    }
    void insert(String s) {
        String tmp = new String("");
        for(int i = 0; i < s.length(); i++) {
	tmp = tmp + Character.toLowerCase(s.charAt(i));
        }
        s = tmp;
        Node rt = this;
        int i = 0;

        while(i < s.length()) {
            if(tmp.charAt(i) == '\'') {
                if(rt.child[26] == null) {
                    rt.child[26] = new Node();
                }
                rt = rt.child[26];
            } else {
                if(rt.child[s.charAt(i)-97] == null) {
                    rt.child[s.charAt(i)-97] = new Node();
                }
                rt = rt.child[s.charAt(i)-97];
            }
            i++;
        }
        rt.end = true;
        rt.data++;
    }
    boolean search(String word) {
        

        int i = 0;
        Node rt = this;
        while(rt != null && i < word.length()) {
            if(word.charAt(i) == '\'') {
                rt = rt.child[26];
            } else {
                rt = rt.child[word.charAt(i)-97];
            }
            i++;
        }
        System.out.println("in Node");

        if(rt == null || rt.end == false) {
            return false;
        }

        return true;
    }
    int getvalue(String word) {
        String tmp = new String("");
        for(int i = 0; i < word.length(); i++) {
	tmp = tmp + Character.toLowerCase(word.charAt(i));
        }
        word = tmp;
        int i = 0;
        Node rt = this;
        while(rt != null && i < word.length()) {
            if(word.charAt(i) == '\'') {
                rt = rt.child[26];
            } else {
                rt = rt.child[word.charAt(i)-97];
            }
            i++;
        }

        if(rt == null || rt.end == false) {
            return 0;
        }

        return rt.data;
    }
 //   public static void main(String...args) {
        
//}
}
