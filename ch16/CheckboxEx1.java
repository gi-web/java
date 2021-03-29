package ch16;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckboxEx1 extends MFrame 
/*인터페이스 구현 -> 추상메소드 오버라이딩*/
implements ItemListener{
	
	Checkbox cb1, cb2, cb3;
	Checkbox rb1, rb2, rb3;
	CheckboxGroup grp;//라디오버튼 그룹
	
	public CheckboxEx1() {
		super(220, 250);
		setTitle("Checkbox Example");
		add(cb1 = new Checkbox("선택1", false));
		add(cb2 = new Checkbox("선택2", true));
		add(cb3 = new Checkbox("선택3", false));
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		grp = new CheckboxGroup();
		add(rb1 = new Checkbox("라디오1",grp, true));
		add(rb2 = new Checkbox("라디오2",grp, false));
		add(rb3 = new Checkbox("라디오3",grp, false));
		
		validate();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Checkbox cb = (Checkbox)e.getSource();
		String str = cb.getLabel() + " : " + cb.getState();
		setTitle(str);
	}
	
	public static void main(String[] args) {
		new CheckboxEx1();
	}
}



