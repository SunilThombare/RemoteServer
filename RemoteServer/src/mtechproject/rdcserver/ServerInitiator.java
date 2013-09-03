/*
 * Author Ahmed Abdelhalim - 2009
 * Email: englemo@hotmail.com
 * Please do not remove the above lines
 */
package mtechproject.rdcserver;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This is the entry class of the server
 */
public class ServerInitiator {
    //Main server frame
    private JFrame frame = new JFrame();
    //JDesktopPane represents the main container that will contain all
    //connected clients' screens
    private JDesktopPane desktop = new JDesktopPane();

    public static void main(String args[]){
        String port = JOptionPane.showInputDialog("Please enter listening port");
        new ServerInitiator().initialize(Integer.parseInt(port));
    }

    public void initialize(int port){

        try {
            ServerSocket sc = new ServerSocket(port);
            //Show Server GUI
            drawGUI();
            //Listen to server port and accept clients connections
            while(true){
                Socket client = sc.accept();
                System.out.println("New client Connected to the server");
                PrintWriter w = new PrintWriter(client.getOutputStream(), true);
                
                InetAddress ip;
                ip = InetAddress.getLocalHost();
        		System.out.println("Current IP address : " + ip.getHostAddress());
         
        		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
         
        		byte[] mac = network.getHardwareAddress();
         
        		System.out.print("Current MAC address : ");
         
        		StringBuilder sb = new StringBuilder();
        		for (int i = 0; i < mac.length; i++) {
        			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
        		}
        		System.out.println(sb.toString());
        		w.println(sb.toString());

                //Per each client create a ClientHandler
                new ClientHandler(client,desktop);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Draws the main server GUI
     */
    public void drawGUI(){
            frame.add(desktop,BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //Show the frame in a maximized state
            frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
    }
}
