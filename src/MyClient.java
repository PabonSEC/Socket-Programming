
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Shahnawaz Hossan
 */
public class MyClient {

    public static void main(String[] args) throws Exception {

        Socket s = new Socket("localhost", 6666);
        
        DataInputStream din = new DataInputStream(s.getInputStream());
        
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "", str2 = "";
        
        while (!str.equals("stop")) {
            
            str = br.readLine();
            
            dout.writeUTF(str);
            
            dout.flush();
            
            str2 = din.readUTF();
            
            System.out.println("Server says: " + str2);
        }

        dout.close();
        
        s.close();
    }
}
