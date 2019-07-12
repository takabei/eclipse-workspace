package cn.gbf.ui;

import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import cn.gbf.domain.Grade;
import cn.gbf.domain.Student;
import cn.gbf.service.GradeService;
import cn.gbf.service.YuangongService;
import cn.gbf.service.impl.GradeServiceImpl;
import cn.gbf.service.impl.YuangongServiceImpl;



public class AddMoneyWindow extends Frame {//添加员工工资
	GradeService gradeServie = new GradeServiceImpl();//提供工资的服务层
	YuangongService studentService = new YuangongServiceImpl();//员工的服务层

	JLabel JLNumber = new JLabel("����:");//标签
	JTextField JTNumber = new JTextField();//文本域

	JLabel JLChinese = new JLabel("����:");
	JTextField JTChinese = new JTextField();

	JLabel JLMath = new JLabel("����:");
	JTextField JTMath = new JTextField();

	JLabel JLEnglish = new JLabel("����:");
	JTextField JTEnglish = new JTextField();

	JButton JBAdd = new JButton("���");
	JButton JBNext = new JButton("����");

	public AddMoneyWindow() throws HeadlessException {
		initUi();
		initListener();
	}

	private void initUi() {
		this.setTitle("��ӹ���");
		this.setVisible(true);
		this.setLayout(null);//BorderLayout（边界布局）
		this.setBounds(500, 200, 350, 320);

		JLNumber.setBounds(100, 60, 60, 20);
		this.add(JLNumber);
		JTNumber.setBounds(200, 60, 80, 20);
		this.add(JTNumber);

		JLChinese.setBounds(100, 100, 60, 20);
		this.add(JLChinese);
		JTChinese.setBounds(200, 100, 80, 20);
		this.add(JTChinese);

		JLMath.setBounds(100, 140, 100, 20);
		this.add(JLMath);
		JTMath.setBounds(200, 140, 80, 20);
		this.add(JTMath);

		JLEnglish.setBounds(100, 180, 60, 20);
		this.add(JLEnglish);
		JTEnglish.setBounds(200, 180, 80, 20);
		this.add(JTEnglish);

		JBAdd.setBounds(100, 220, 60, 20);
		this.add(JBAdd);

		JBNext.setBounds(200, 220, 80, 20);
		this.add(JBNext);
	}

	private void initListener() {//初始化监听器
		
		this.addWindowListener(new WindowAdapter() {//监听关闭事件
			@Override
			public void windowClosing(WindowEvent e) {
				AddMoneyWindow.this.setVisible(false);//隐藏当前窗体
				new AdminWindow();
			}
		});
		JBAdd.addActionListener(new ActionListener() {//添加事件

			@Override
			public void actionPerformed(ActionEvent ae) {
				String id = JTNumber.getText();//获取文本域的文本
				String chinese = JTChinese.getText();
				String math = JTMath.getText();
				String english = JTEnglish.getText();
				if (id.trim().equals("") | chinese.trim().equals("") | math.trim().equals("")
						| english.trim().equals("")) {
					JOptionPane.showMessageDialog(AddMoneyWindow.this, "��д��Ϣ����Ϊ��");
				} else {
					try {
						int ch = Integer.parseInt(chinese);//将字符串转换为整数
						int ma = Integer.parseInt(math);
						int en = Integer.parseInt(english);
						Student student = studentService.findStudent(id);
						if (student != null) {
							Grade grade = new Grade();
							grade.setChinese(ch);
							grade.setMath(ma);
							grade.setEnglish(en);
							student.setGrade(grade);//把薪资付给员工
							int i = gradeServie.add(student);//将薪资添加到数据库中
							/*
							 * i代表的add（）方法对数据库的操作是否成功
							 * update（）会返回对数据库的影响行数
							 */
							if (i == 0) {//代表失败
								JOptionPane.showMessageDialog(AddMoneyWindow.this, "���ʧ��,������!");
							} else {
								int index = JOptionPane.showConfirmDialog(AddMoneyWindow.this, "��ӳɹ�,�������?", "",
										JOptionPane.YES_NO_OPTION);
								if (index == 1) {//代表否
									new AdminWindow();
									AddMoneyWindow.this.setVisible(false);
								}
							}

						} else {
							JOptionPane.showMessageDialog(AddMoneyWindow.this, "�ù��Ų�����,������ӳɼ�");
						}
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(AddMoneyWindow.this, "����ֻ��������!");
					}
				}

			}
		});
		JBNext.addActionListener(new ActionListener() {//按钮添加一个事件监听器

			@Override
			public void actionPerformed(ActionEvent e) {//重置
				JTNumber.setText("");
				JTChinese.setText("");
				JTMath.setText("");
				JTEnglish.setText("");
			}
		});
	}

}
