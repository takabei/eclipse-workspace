package cn.gbf.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.gbf.domain.Student;
import cn.gbf.service.YuangongService;
import cn.gbf.service.impl.YuangongServiceImpl;

/*
 * 员工界面
 */
public class YuangongWindow extends JFrame {
	private String studentId;
	JButton jbMessage = new JButton("��Ϣ");
	JButton jbGrade = new JButton("�ɼ�");
	// �ɼ���Ϣ
	JPanel jpGrade = null;//面板容器类
	JLabel JLChinese = new JLabel("����:");
	JTextField JTChinese = new JTextField();
	JLabel JLMath = new JLabel("����:");
	JTextField JTMath = new JTextField();
	JLabel JLEnglish = new JLabel("����:");
	JTextField JTEnglish = new JTextField();
	
	//������Ϣ
	JPanel jpMessage = null;//面板容器类
	JLabel JLNumber = new JLabel("ѧ��:");
	JTextField JTNumber = new JTextField();
	JLabel JLName = new JLabel("����:");
	JTextField JTName = new JTextField();
	JLabel JLAge = new JLabel("����:");
	JTextField JTAge = new JTextField();
	JLabel JLSex = new JLabel("�Ա�:");
	JTextField JTSex = new JTextField();
	JLabel JL1 = new JLabel("����:");
	JTextField JT1 = new JTextField();

	public YuangongWindow(String id) {
		this.studentId = id;
		initUi();
		initListener();
		setStudentAllMessage();
	}
	public YuangongWindow() {
		initUi();
		initListener();
	}
	
	
	private void initUi() {
		this.setTitle("Ա������");
		this.setVisible(true);
		this.setLayout(null);//设置默认布局
		this.setBounds(500, 200, 400, 400);

		jbMessage.setBounds(140, 0, 60, 20);
		this.add(jbMessage);
		jbGrade.setBounds(201, 0, 60, 20);
		this.add(jbGrade);

		initMessageWindow();
		this.add(jpMessage);
		
		initGradeWindow();
		this.add(jpGrade);

	}
	public static void main(String[] args) {
		new YuangongWindow();
	}
	private void initListener() {
		this.addWindowListener(new WindowAdapter() {//设置退出
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		jbMessage.addActionListener(new ActionListener() {//窗体切换

			@Override
			public void actionPerformed(ActionEvent e) {
				jpMessage.setVisible(true);
				jpGrade.setVisible(false);
			}
		});

		jbGrade.addActionListener(new ActionListener() {//窗体切换

			@Override
			public void actionPerformed(ActionEvent e) {
				jpMessage.setVisible(false);
				jpGrade.setVisible(true);
			}
		});
	}

	private void initMessageWindow() {//初始化员工信息页面
		jpMessage = new JPanel();
		jpMessage.setBounds(0, 60, 400, 340);
		jpMessage.setLayout(null);
		jpMessage.setVisible(true);
		
		JLNumber.setBounds(100, 20, 100, 20);
		jpMessage.add(JLNumber);
		JTNumber.setBounds(200, 20, 80, 20);
		jpMessage.add(JTNumber);

		JLName.setBounds(100, 60, 60, 20);
		jpMessage.add(JLName);
		JTName.setBounds(200, 60, 80, 20);
		jpMessage.add(JTName);

		JLSex.setBounds(100, 100, 100, 20);
		jpMessage.add(JLSex);
		JTSex.setBounds(200, 100, 80, 20);
		jpMessage.add(JTSex);

		JLAge.setBounds(100, 140, 60, 20);
		jpMessage.add(JLAge);
		JTAge.setBounds(200, 140, 80, 20);
		jpMessage.add(JTAge);

		JL1.setBounds(100, 180, 60, 20);
		jpMessage.add(JL1);
		JT1.setBounds(200, 180, 80, 20);
		jpMessage.add(JT1);
	}
	
	private void initGradeWindow(){//初始化员工薪资页面
		jpGrade = new JPanel();
		jpGrade.setBounds(0, 60, 400, 340);
		jpGrade.setLayout(null);
		
		JLChinese.setBounds(100, 60, 60, 20);
		jpGrade.add(JLChinese);
		JTChinese.setBounds(200, 60, 80, 20);
		jpGrade.add(JTChinese);

		JLMath.setBounds(100, 100, 100, 20);
		jpGrade.add(JLMath);
		JTMath.setBounds(200, 100, 80, 20);
		jpGrade.add(JTMath);

		JLEnglish.setBounds(100, 140, 60, 20);
		jpGrade.add(JLEnglish);
		JTEnglish.setBounds(200, 140, 80, 20);
		jpGrade.add(JTEnglish);

		
	}
	
	private void setStudentAllMessage(){//添加员工所有信息
		if(studentId != null){//添加员工信息
			YuangongService studentService = new YuangongServiceImpl();
			Student student = studentService.findStudent(studentId);
			JTNumber.setText(student.getId());
			JTName.setText(student.getName());
			JTAge.setText(student.getAge()+"");
			JTSex.setText(student.getSex());
			JT1.setText(student.getCollage());
			
			if(student.getGrade() != null){//添加员工薪资
				JTChinese.setText(student.getGrade().getChinese()+"");
				JTMath.setText(student.getGrade().getMath()+"");
				JTEnglish.setText(student.getGrade().getChinese()+"");
			}else{
				JTChinese.setText("��");
				JTMath.setText("��");
				JTEnglish.setText("��");
			}
		}
	}
	
}
