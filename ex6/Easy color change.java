import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EasyColorChange extends JFrame {
    JPanel north, south, east, west, center;
    Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.MAGENTA, Color.CYAN, Color.YELLOW};
    int i = 0;

    EasyColorChange() {
        setTitle("BorderLayout Color Changer");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create panels
        north = new JPanel();
        south = new JPanel();
        east = new JPanel();
        west = new JPanel();
        center = new JPanel();

        north.setPreferredSize(new Dimension(100, 60));  // width, height
        south.setPreferredSize(new Dimension(100, 80));
        east.setPreferredSize(new Dimension(100, 100));
        west.setPreferredSize(new Dimension(120, 100));

        // Set initial colors
        north.setBackground(Color.RED);
        south.setBackground(Color.GREEN);
        east.setBackground(Color.BLUE);
        west.setBackground(Color.ORANGE);
        center.setBackground(Color.MAGENTA);

        // Add panels to frame
        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);
        add(east, BorderLayout.EAST);
        add(west, BorderLayout.WEST);
        add(center, BorderLayout.CENTER);

        // Timer to change colors every 3 seconds
        Timer timer = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                i = (i + 1) % colors.length;
                north.setBackground(colors[i]);
                south.setBackground(colors[(i + 1) % colors.length]);
                east.setBackground(colors[(i + 2) % colors.length]);
                west.setBackground(colors[(i + 3) % colors.length]);
                center.setBackground(colors[(i + 4) % colors.length]);
            }
        });
        timer.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new EasyColorChange();
    }
}
