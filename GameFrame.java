import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame implements ActionListener {
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] menuButtons = new JButton[3];
    JButton[] gameBoardButtons = new JButton[12];

    GameFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(Color.PINK);
        textField.setForeground(Color.RED);
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);
        textField.setBounds(0, 0, 800, 100); // Set bounds to make sure the text is visible

        getMenu();


        // setBoard();


        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);



    }

    private void getMenu() {
        buttonPanel.removeAll();
        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.setBackground(Color.RED);

        menuButtons[0] = new JButton("Single Player");
        menuButtons[1] = new JButton("Multiplayer");
        menuButtons[2] = new JButton("Exit");


        menuButtons[0].addActionListener(e -> setBoard());
        menuButtons[1].addActionListener(e -> setBoard());
        menuButtons[2].addActionListener(e -> System.exit(0));


        for (int i = 0; i < 3; i++) {
            menuButtons[i].setBackground(Color.PINK);
            menuButtons[i].setForeground(Color.RED);
            menuButtons[i].setFont(new Font("MV Boli", Font.BOLD, 40)); // Reduce font size
            menuButtons[i].setHorizontalAlignment(JLabel.CENTER);
            menuButtons[i].setOpaque(true);

            buttonPanel.add(menuButtons[i]);
        }
        frame.revalidate();
    }

    private void setBoard() {
        buttonPanel.removeAll();
        buttonPanel.setLayout(new GridLayout(4, 3));
        for (int i = 0; i < 12; i++) {
            gameBoardButtons[i] = new JButton();
            buttonPanel.add(gameBoardButtons[i]);
            gameBoardButtons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            gameBoardButtons[i].setBackground(Color.CYAN);
            gameBoardButtons[i].setBorderPainted(true);
            gameBoardButtons[i].setFocusable(false);
            gameBoardButtons[i].addActionListener(this);
        }
        gameBoardButtons[9].addActionListener(e->getMenu());
        gameBoardButtons[9].setText("Back");

        frame.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void initUI() {

        frame.revalidate(); // Ensure the frame is revalidated after adding components
    }
}
