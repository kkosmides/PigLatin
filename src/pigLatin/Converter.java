/**
 * 
 */
package pigLatin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author katri
 *
 */
public class Converter extends JPanel implements KeyListener {
	
	private String pigLatin;
	
	public Converter() {
			
	}
	
	public String wordChecker(String str) {
		pigLatin = "";
		str = str.toLowerCase();
		str = str.replaceAll("[-+,.!/]", "");
		if (str.contains(" ")) {
			this.multipleWords(str);
		}
		else {
			this.pigConverter(str);
		}
		return pigLatin;
	}
	
	public String multipleWords(String str) {
		if (str.contains(" ")) {
			String[] arrayString = str.split(" ");
			for (String word : arrayString) {
				pigLatin += " " + this.pigConverter(word);
			}		
		}
		return pigLatin;
	}
	
	public String pigConverter(String str) {
		int vowCount = 0;
		int conCount = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == 'a' || ch == 'e' || ch == 'i' ||
					ch == 'o' || ch == 'u') {
				vowCount++;
			}
			if (ch != 'a' || ch != 'e' || ch != 'i' ||
					ch != 'o' || ch != 'u') {
				break;
			}
			
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == 'a' || ch == 'e' || ch == 'i' ||
					ch == 'o' || ch == 'u') {
				break;
			}
			if (ch != 'a' || ch != 'e' || ch != 'i' ||
					ch != 'o' || ch != 'u') {
				conCount++;
			}
		}
		
		if (vowCount == 0 && conCount > 0) {
			pigLatin = (str.substring(conCount) + str.substring(0, conCount) + "ay");
		}
		else if (vowCount > 0) {
			pigLatin = (str + "way");
		}
		
		return pigLatin;
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
