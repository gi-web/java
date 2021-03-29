package test;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class MouseSampleFrame extends JFrame {
 JLabel la;
 public MouseSampleFrame(){
  setContentPane(new MousePanel()); // MousePanel�� ���δ�
  setSize(400,400); // ũ������
  setVisible(true); // ���δ�
 }
 class MousePanel extends JPanel{
  
  public MousePanel(){
   setLayout(null); // ���̾ƿ� ��
   la = new JLabel("Hello"); // ���̺��ʱ�ȭ
   la.setLocation(100,100); // ��ġ����
   la.setSize(80,30); // ũ�� ����
   add(la); // �гο� �߰� ���
   this.addMouseListener(new MyMouseListener()); // ���콺������
   this.addMouseMotionListener(new MyMouseListener()); // ��Ǹ�����
  }
 }
 class MyMouseListener extends MouseAdapter implements MouseMotionListener{
  public void mousePressed(MouseEvent e){ // ��������
   int x = e.getX();
   int y = e.getY();
   la.setLocation(x, y); // ��ġ ����
  }
  public void mouseDragged(MouseEvent e){ // �巡���Ͻ�
   int x = e.getX();
   int y = e.getY();
   setLocation(x, y); // ��ġ ����
  }
 }
 
 public static void main(String[] args) {
  new MouseSampleFrame();
 }
}