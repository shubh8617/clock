import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyWindow extends JFrame {

    private JLabel heading;
    private JLabel clocklabel;
    private Font font = new Font ("", Font.BOLD, 35);
    MyWindow()
    {
        super.setTitle("My Clock");
        super.setSize(500, 500);
        super.setLocation(300,50);
        this.createGui();
        this.startClock();
        super.setVisible(true);
    }

    public void createGui()
    {
        heading = new JLabel("My Clock");
        clocklabel = new JLabel("Clock");
        heading.setFont(font);
        clocklabel.setFont(font);

        this.setLayout(new GridLayout(2,1));

        this.add(heading);
        this.add(clocklabel);
    }

    public void startClock() {
        Thread t = new Thread() {
            public void run() {
                try {
                    while (true) {
                        Date d = new Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("hh: mm: ss a");
                        String dateTime = sdf.format(d);
                        clocklabel.setText(dateTime);
                        Thread.currentThread().sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.fillInStackTrace();
                }
            }
        };
        t.start();
    }
}
