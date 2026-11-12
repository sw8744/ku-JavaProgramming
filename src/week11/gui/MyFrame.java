package week11.gui;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyFrame(String title) {
//        super(title);
        this.setTitle(title);
        Toolkit kit = this.getToolkit();
//        Toolkit kit = Toolkit.getDefaultToolkit()

        Image img = kit.getImage("img/char.png");
        this.setIconImage(img);
        Dimension screenSize = kit.getScreenSize();

        this.setSize(screenSize.width / 2, screenSize.height / 2);
//        this.setLocation(screenSize.width / 4, screenSize.height / 4);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initLayout();

        this.setVisible(true);
    }

    private void initLayout() {
        Container frame = this.getContentPane();
        JButton btn = new JButton("이승원");
        frame.add(btn);
    }

    static void main() {
        MyFrame frame = new MyFrame("202611014 이승원");
    }
}
