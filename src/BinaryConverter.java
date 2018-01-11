import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Converts a binary number entered into the program to decimal.
 * 
 * @author John Sweet
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class BinaryConverter extends JFrame {
	
	private JLabel label;
	private JTextField text;
	private JButton button;
	private int num;
	
	/**
	 * Constructor
	 */
	public BinaryConverter() {
		super("BinaryConverter");
		
		setLayout(new FlowLayout());
		
		label = new JLabel("Binary: ");
		text = new JTextField(10);
		button = new JButton("Convert to Decimal");
		
		add(label);
		add(text);
		add(button);
		num = 0;
		
		//center
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		pack();
		
		button();
	}
	
	private void toBinary(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '1') {
				num += Math.pow(2, s.length() - 1 - i);
			}
		}
	}
	
	private boolean isBinary(String s) {
		return (s.matches("^[0-1_]+$"));
	}
	
	private boolean sizeOk(String s) {
		return (s.length() <= 12);
	}
	
	
	private void button() {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String s = text.getText();
				if(isBinary(s) && sizeOk(s)) {
					toBinary(text.getText());
					JOptionPane.showMessageDialog(null,  Integer.toString(num), "Message", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(!isBinary(s)){
					JOptionPane.showMessageDialog(null,  "That is not a binary number.", "Message", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(!sizeOk(s)) {
					JOptionPane.showMessageDialog(null,  "Number was too long.", "Message", JOptionPane.INFORMATION_MESSAGE);
				}
				num = 0;
			}
		});
	}
	
	
	public static void main(String[] args) {
		JFrame f = new BinaryConverter();
		f.setVisible(true);
	}

}
