package ssms;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JFrame {
	public Test(JPanel jp) {
		add(jp);
	}
	public static void main(String[] args) {

		
		Test test3 = new Test(new adminClassManagement());
		test3.setBounds(500, 500, 1010, 800);
		test3.setVisible(true);
		
		
		Test test5 = new Test(new adminCourseManagement());
		test5.setBounds(500, 500, 1010, 800);
		test5.setVisible(true);
	}
}
