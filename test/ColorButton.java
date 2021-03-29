package test;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class ColorButton extends JFrame{
 ColorButton(){
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 윈도우를 닫으면 프로그램 종료
  setTitle("배경색이 다른 버튼"); // 프레임 제목
  GridLayout grid = new GridLayout(); //GridLayout 배치관리자 생성

  setLayout(grid); // grid를 컨텐트팬의 배치관리자로 지정

  JButton btn1 = new JButton("1");
  JButton btn2 = new JButton("2");
  JButton btn3 = new JButton("3");
  JButton btn4 = new JButton("4");
  JButton btn5 = new JButton("5");

 

  add(btn1);
  add(btn2);
  add(btn3);
  add(btn4);
  add(btn5);


  MyMouseListener listener = new MyMouseListener();
  btn1.addMouseListener(listener);
  btn2.addMouseListener(listener);
  btn3.addMouseListener(listener);
  btn4.addMouseListener(listener);
  btn5.addMouseListener(listener);

  setSize(500,300);
  setVisible(true);

 }
 public static void main(String[] args) {
  new ColorButton();
 }
}
class MyMouseListener implements MouseListener{
 public void mouseClicked(MouseEvent e){
  JButton buttonn = (JButton)e.getSource();
  String str = buttonn.getText();
  
  if(str.equals("1"))
   buttonn.setBackground(Color.red);
  else if(str.equals("2"))
   buttonn.setBackground(Color.blue);
  else if(str.equals("3"))
   buttonn.setBackground(Color.pink);
  else if(str.equals("4"))
   buttonn.setBackground(Color.yellow);
  else
   buttonn.setBackground(Color.green);
  
 }
 public void mouseExited(MouseEvent e){ }
 public void mousePressed(MouseEvent e){}
 public void mouseReleased(MouseEvent e){}
 public void mouseEntered(MouseEvent arg0) {
  // TODO Auto-generated method stub

 }
}