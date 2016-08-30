package com.skyline.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.apache.log4j.Logger;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Utils {
	
	final static Logger logger = Logger.getLogger(Utils.class);

    public static boolean showAlert(String title, String header, String message, AlertType alertType) {
    	Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(message);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			return true;
		} else {
			return false;
		}
    }

    public static String hashMD5(String string) {
        MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(string.getBytes());

	        byte byteData[] = md.digest();

	        //convert the byte to hex format method 1
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }

	        return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public static Double stringToDouble(String string) {
    	try {
    		return Double.parseDouble(string.replaceAll(" ","."));
    	} catch(NumberFormatException e) {
    		e.printStackTrace();
    		return null;
    	}
    }
}
