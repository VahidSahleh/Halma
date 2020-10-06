import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Halma02 extends JFrame {
	private JButton b1 = new JButton("New Game");
	private JButton b2 = new JButton("EXIT");
	

	public JButton getExitButton() {
		return b2;
	}

	public JButton getNewGame() {
		return b1;
	}

	public void H() {
		setTitle("Halma Game!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel centerPanel = new JPanel(new FlowLayout());
		//button for start game
		centerPanel.add(b1);
		//button for exit game
		centerPanel.add(b2);
		//exits game by pressing button b2
		getExitButton().addActionListener(new Listener());
		//start game by pressing button b1
		getNewGame().addActionListener(new Listener1());
		add(centerPanel, BorderLayout.CENTER);
		setSize(1000, 200);
		setVisible(true);

	}

	public void addReportPanel() {
		JPanel reportPanel = createNewPanel();
		getContentPane().add(reportPanel, BorderLayout.CENTER);

	}

	public JPanel createNewPanel() {
		JPanel localJPanel = new JPanel();
		localJPanel.setLayout(new FlowLayout());
		return localJPanel;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Halma02 h = new Halma02();
		h.H();
	}

}
