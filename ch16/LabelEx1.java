package ch16;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowEvent;
/*AWT����� ���
 * 1.�ʿ��� ������Ʈ�� �����Ѵ�.
 * 2.������Ʈ�� �����̳�(Frame->MFrame �߰�)
 * 3.���̾ƿ� �޴����� ����Ѵ�.
 * 4.�̺�Ʈ�� ����߰�(�ڿ�...)*/
public class LabelEx1 extends MFrame{
	
	Label label1, label2, label3, label4;
	
	public LabelEx1() {
		super(230, 200);
		setTitle("Label Example");
		String str = "������ ���ְ� ���۵Ǵ� ������";
		label1 = new Label(str);
		//����� �� �����ϴ���..
		label2 = new Label(str, Label.CENTER);
		label2.setBackground(MColor.rColor());
		label3 = new Label(str, Label.RIGHT);
		label3.setBackground(MColor.rColor());
		label4 = new Label(str, Label.LEFT);
		label4.setForeground(MColor.rColor());//�����(���ڻ�)
		add(label1);add(label2);add(label3);add(label4);
		
		validate();
	}

	public static void main(String[] args) {
		new LabelEx1();
	}
}




