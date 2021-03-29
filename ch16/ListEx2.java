package ch16;

import java.awt.Choice;
import java.awt.Color;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ListEx2 extends MFrame 
implements ItemListener{
	
	List name, star;
	String ms[] = {"현 빈","원 빈","이민호","김수현","김우빈","이종석"};
	String fs[] = {"고아라","이연희","이하늬","문채원","수 지","김연아"};
	
	public ListEx2() {
		setTitle("연예인 선택");
		name = new List(2, false);
		name.add("남자연예인");
		name.add("여자연예인");
		star = new List(6, true);
		inputItem(star, ms);
		add(name);
		add(star);
		name.addItemListener(this);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(name.getSelectedItem().equals("남자연예인"))
			inputItem(star, ms);
		else
			inputItem(star, fs);
	}
	
	public void inputItem(List list, String item[]) {
		list.removeAll();
		for (int i = 0; i < item.length; i++) {
			list.add(item[i]);
		}
	}
	
	public static void main(String[] args) {
		new ListEx2();
	}
}



