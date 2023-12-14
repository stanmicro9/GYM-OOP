import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class main extends JFrame{
    private JPanel panelMain;
    private JButton LOGINButton;
    private JButton REGISTERButton;

    public main() {

        setContentPane(panelMain);
        setTitle("Welcome To Gym System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        REGISTERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register reg = new register();
            }
        });
        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login log = new Login();
            }
        });
    }

}


