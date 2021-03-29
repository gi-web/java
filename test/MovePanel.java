package test;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MovePanel extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public JPanel jPanel1 = new JPanel();

    /* move by mouse pointer */
    Point mainFrameLocation = new Point(0, 0);
    Point mouseClickedLocation = new Point(0, 0);

    public MovePanel() {

//        jPanel1.setOpaque(true);
        addMouseListener(new FrameMove_mouseAdapter(this));
        addMouseMotionListener(new FrameMove_mouseMotionAdapter(this));

        /* root frame */
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(200, 200));
        setUndecorated(true);

        getContentPane().add(jPanel1, BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                MovePanel mainFrame = new MovePanel();
                mainFrame.setVisible(true);
            }
        });
    }
}

/**
 * @author tobby48 2009. 07. 22
 */
class FrameMove_mouseAdapter extends MouseAdapter {
    private MovePanel frame;

    FrameMove_mouseAdapter(MovePanel mainframe) {
        this.frame = mainframe;
    }

    public void mousePressed(MouseEvent e) {
        frame.mouseClickedLocation.x = e.getX();
        frame.mouseClickedLocation.y = e.getY();
    }

    public void mouseReleased(MouseEvent e) {
    }
}

/**
 * @author tobby48 2009. 07. 22
 */
class FrameMove_mouseMotionAdapter extends MouseMotionAdapter {
    private MovePanel frame;
    
    FrameMove_mouseMotionAdapter(MovePanel mainframe) {
        this.frame = mainframe;
    }

    public void mouseMove(MouseEvent e) {}

    public void mouseDragged(MouseEvent e) {
        frame.setLocation(e.getLocationOnScreen().x - frame.mouseClickedLocation.x,
                e.getLocationOnScreen().y - frame.mouseClickedLocation.y);
    }
}
