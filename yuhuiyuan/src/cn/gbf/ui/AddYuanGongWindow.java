package cn.gbf.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import cn.gbf.domain.Student;
import cn.gbf.exceptioin.YuangongExistException;
import cn.gbf.service.YuangongService;
import cn.gbf.service.impl.YuangongServiceImpl;



public class AddYuanGongWindow extends JFrame {//添加员工信息
	JLabel JL = new JLabel("�� �� �� �� �� Ϣ", JLabel.CENTER);
	JLabel JLNumber = new JLabel("����:");
	JTextField JTNumber = new JTextField();
	JLabel JLName = new JLabel("����:");
	JTextField JTName = new JTextField();
	JLabel JLAge = new JLabel("����:");
	JTextField JTClass = new JTextField();
	JLabel JLsex = new JLabel("�Ա�:");
	ButtonGroup BG = new ButtonGroup();//按钮组
	JRadioButton JRB1 = new JRadioButton("��");//单选按钮
	JRadioButton JRB2 = new JRadioButton("Ů");//单选按钮
	JLabel JL1 = new JLabel("����:");
	JTextField JT1 = new JTextField();
	JButton JBAdd = new JButton("���");
	JButton JBNext = new JButton("����");
	YuangongService studentServie = new YuangongServiceImpl();//提供服务员工服务层
	public AddYuanGongWindow() {
		initUi();
		initListener();
	}

	private void initUi() {
		this.setTitle("���Ա����Ϣ");
		this.setBounds(500, 200, 400, 400);
		this.setLayout(null);//设置布局默认（BorderLayout（边界布局））
		this.setVisible(true);

		JL.setBounds(100, 30, 200, 40);
		this.add(JL);
		JLNumber.setBounds(100, 80, 100, 20);
		this.add(JLNumber);
		JTNumber.setBounds(200, 80, 80, 20);
		this.add(JTNumber);
		JLName.setBounds(100, 120, 60, 20);
		this.add(JLName);
		JTName.setBounds(200, 120, 80, 20);
		this.add(JTName);
		JLsex.setBounds(100, 160, 100, 20);
		this.add(JLsex);
		JRB1.setBounds(200, 160, 40, 20);
		JRB2.setBounds(250, 160, 40, 20);
		this.add(JRB1);//添加单选按钮到窗体
		this.add(JRB2);//添加单选按钮到窗体
		BG.add(JRB1);//把单选按钮合并分组
		BG.add(JRB2);//把单选按钮合并分组
		JLAge.setBounds(100, 200, 60, 20);
		this.add(JLAge);
		JTClass.setBounds(200, 200, 80, 20);
		this.add(JTClass);
		JL1.setBounds(100, 240, 60, 20);
		this.add(JL1);
		JT1.setBounds(200, 240, 80, 20);
		this.add(JT1);
		JBAdd.setBounds(80, 280, 90, 20);
		this.add(JBAdd);

		JBNext.setBounds(190, 280, 90, 20);
		this.add(JBNext);

	}

	private void initListener() {
		JBAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String snumber=JTNumber.getText();
				String sname=JTName.getText();
				String sage=JTClass.getText();
				String scollege = JT1.getText();
				String ssex="��";//���ص�ѡ��ť��ֵ
				if(JRB2.isSelected())
				    ssex="Ů";
				if(snumber.equals("") | sname.equals("") | snumber.equals("") | sage.equals("") | scollege.equals("") ){
					JOptionPane.showMessageDialog(AddYuanGongWindow.this,"��д��Ϣ����Ϊ��");//弹框
				}else{
					Student student = new Student();
					student.setId(snumber);
					student.setPassword("123456");
					student.setName(sname);
					student.setAge(Integer.parseInt(sage));
					student.setSex(ssex);
					student.setCollage(scollege);
				
					try {
						int i = studentServie.addStudent(student);
						if(i == 0){
							JOptionPane.showMessageDialog(AddYuanGongWindow.this,"���ʧ��,������!");
						}else{
							int index = JOptionPane.showConfirmDialog(AddYuanGongWindow.this, "��ӳɹ�,������� ?","",JOptionPane.YES_NO_OPTION);
							if(index == 1){ //否
								new AdminWindow();
								AddYuanGongWindow.this.setVisible(false);
							}else{
								//������ӵ�ʱ�� �����ı�
								JTNumber.setText("");
								JTName.setText("");
								BG.clearSelection();
								JTClass.setText("");
								JT1.setText("");
							}
						}
					} catch (YuangongExistException e1) {
						JOptionPane.showMessageDialog(AddYuanGongWindow.this,"Ա���Ѵ���!");
						e1.printStackTrace();//在控制台输出
					}	
				}
			}
		});
		JBNext.addActionListener(new ActionListener() {//重置按钮
			@Override
			public void actionPerformed(ActionEvent e) {
				JTNumber.setText("");
				JTName.setText("");
				BG.clearSelection();
				JTClass.setText("");
				JT1.setText("");
			}
		});
		this.addWindowListener(new WindowAdapter() {//监听关闭事件
			public void windowClosing(WindowEvent e) {
				new AdminWindow();
				AddYuanGongWindow.this.setVisible(false);	
			}
		});
	}
	
}
