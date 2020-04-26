/**
 * 
 */
package pigLatin;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 * @author katrinakosmides
 *
 */
public class Window {
	
	public static final int WIDTH = 500, HEIGHT = 500;
	private static JTextField textbox;
	private JFrame window;
	private Converter converter;
	private JButton button;
	private JLabel outcome;
	
	public Window() {
		window = new JFrame("Pig Latin");
		window.setSize(WIDTH, HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		
		outcome = new JLabel();
		converter = new Converter();
		
		window.getContentPane().setLayout(new FlowLayout());
		textbox = new JTextField("Enter word here", 20);
		
		textbox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textbox.setText("");
			}
		});
		textbox.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!outcome.getText().isEmpty()) {
						window.remove(outcome);
					}
					String enteredText = textbox.getText();
					String pigText = converter.wordChecker(enteredText);
					outcome = new JLabel(pigText);
					window.getContentPane().add(outcome);
					window.pack();
					window.setVisible(true);
				}
			}
		});
		
		window.getContentPane().add(textbox);
		
		button = new JButton("Enter");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!outcome.getText().isEmpty()) {
					window.remove(outcome);
				}
				String enteredText = textbox.getText();
				String pigText = converter.wordChecker(enteredText);
				outcome = new JLabel(pigText);
				window.getContentPane().add(outcome);
				window.pack();
				window.setVisible(true);
			}
		});
		button.addKeyListener(converter);
		
		window.add(button);
		
		window.pack();	
		
		window.setVisible(true);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Window();
	}

}
