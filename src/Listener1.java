import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Listener1 implements ActionListener {
	public JFrame ff;
	public JPanel vv;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		vv = new JPanel(new GridLayout(100, 100, 100, 100));
		final JButton[][] squares = new JButton[8][8];
		ff = new JFrame("New Game");

		// image for buttons
		ImageIcon icon = new ImageIcon("White.png");
		ImageIcon icon2 = new ImageIcon("Black.png");
		// creating instance of JButton
		// 2 for loop for row and column of jButtons
		for (int i = 0; i < squares.length; i += 1) {
			for (int j = 0; j < squares[i].length; j += 1) {
				ActionEvent actionEvent = null;
				JButton b1 = new JButton();
				int i1 = i;
				int j1 = j;
				int i2 = i;
				int j2 = j;

				b1.setSize(100, 100);

				int x = i * 100;
				int y = j * 100;
				// set Locations of buttons for game
				b1.setLocation(x, y);
				squares[i][j] = b1;

				int t = i + j;
				// place for white buttons,if i+j%2=0 its white
				if (t % 2 == 0) {

					squares[i][j].setBackground(Color.white);
					vv.add(squares[i][j]);
					// place for black buttons,if i+j%2!=0 its black
				} else {

					squares[i][j].setBackground(Color.black);
					vv.add(squares[i][j]);
				}

				if ((i >= 4 && j <= 3) || (i <= 3 && j >= 4)) {
					// set icon for buttons that we want use (black)
				} else if (i <= 3 && j <= 3 - i) {

					squares[i][j].setIcon(icon2);

					squares[i2][j2].addActionListener(new ActionListener() {

						JButton pieceToMoveButton = null;
						//actionPerformed for moving icon2 buttons
						public void actionPerformed(ActionEvent e) {

							((JButton) e.getSource()).setIcon(null);

							if (pieceToMoveButton == null) // if this button press is selecting the piece to move
							{
								// save the button used in piece selection for later use
								pieceToMoveButton = squares[i2][j2];

							} else // if this button press is selecting where to move
							{
								// move the image to the new button (the one just pressed)

								squares[i2][j2].setIcon(icon2);

								pieceToMoveButton = null; // makes the next button press a piece selection
							}

						}

					});
					ff.add(squares[i2][j2]);

				} else {

				}

				// set icon for buttons that we want use (white)
				if (i >= 4 && j >= 11 - i) {

					squares[i][j].setIcon(icon);

				} else {

				}
				//actionPerformed for moving icon buttons
				if (i >= 4 && j >= 11 - i) {

					squares[i1][j1].addActionListener(new ActionListener() {

						JButton pieceToMoveButton = null;

						public void actionPerformed(ActionEvent e) {

							((JButton) e.getSource()).setIcon(null);

							if (pieceToMoveButton == null) // if this button press is selecting the piece to move
							{
								// save the button used in piece selection for later use
								pieceToMoveButton = squares[i1][j1];

								// ((JButton)e.getSource()).setIcon(null);
							} else // if this button press is selecting where to move
							{
								// move the image to the new button (the one just pressed)

								squares[i1][j1].setIcon(icon);

								pieceToMoveButton = null; // makes the next button press a piece selection
							}

						}

					});
					ff.add(squares[i1][j1]);
				}

			}

		}

		ff.setSize(900, 900);// 400 width and 500 height
		ff.setLayout(null);// using no layout managers
		ff.setVisible(true);// making the frame visible
		vv.setSize(900, 900);// 400 width and 500 height
		vv.setLayout(null);// using no layout managers
		vv.setVisible(true);// making the frame visible
		ff.add(vv);
		ff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
