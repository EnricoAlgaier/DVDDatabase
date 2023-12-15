package Frames;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Database.DataBaseConnection;

public class FrameIsClosed extends WindowAdapter{
	private Frame frame;
	private DataBaseConnection connectionData;
	
	public FrameIsClosed(Frame frame, DataBaseConnection connectionData) {
		this.frame = frame;
		this.connectionData = connectionData;
	}
	
	 @Override
	    public void windowClosing(WindowEvent e) {
	        close();
	    }
	 
	 public void close() {
		 connectionData.closeConnection();
	    }
}