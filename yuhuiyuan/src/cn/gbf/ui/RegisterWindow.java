package cn.gbf.ui;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.gbf.domain.Teacher;
import cn.gbf.exceptioin.AdminExistException;
import cn.gbf.service.AdminService;
import cn.gbf.service.impl.AdminServiceImpl;

public class RegisterWindow extends JFrame {
	private JLabel jlUsername = new JLabel("Ա����");
	private JLabel jlPassword = new JLabel("����");
	private JTextField jfUsername = new JTextField();
	private JPasswordField jfPassword = new JPasswordField();
	private JLabel jlShenFen = new JLabel("���");
	private JComboBox<String> jcComboBox = new JComboBox<String>();//下拉框
	private JButton jbButtonRegister = new JButton("ע��");
	private JButton jbButtonQuXiao = new JButton("ȡ��");
	private AdminService teacherService = new AdminServiceImpl();//管理员服务层
	public RegisterWindow() {//构造器
		initUi();
		initListener();
	}

	private void initUi() {
		this.setTitle("Ա������ϵͳ-ע�����");
		this.setLayout(null);
		jlUsername.setBounds(100, 40, 100, 20);
		this.add(jlUsername);
		jfUsername.setBounds(200, 40, 80, 20);
		this.add(jfUsername);

		jlPassword.setBounds(100, 100, 60, 20);
		this.add(jlPassword);
		jfPassword.setBounds(200, 100, 80, 20);
		this.add(jfPassword);

		jlShenFen.setBounds(100, 150, 60, 20);
		this.add(jlShenFen);
		jcComboBox.setBounds(200, 150, 80, 20);
		this.add(jcComboBox);
		jcComboBox.addItem("Ա��");
		jcComboBox.addItem("����Ա");

		jbButtonQuXiao.setBounds(100, 200, 60, 20);
		this.add(jbButtonQuXiao);
		jbButtonRegister.setBounds(200, 200, 60, 20);
		this.add(jbButtonRegister);
		this.setVisible(true);
		this.setBounds(500, 200, 400, 300);
	}

	private void initListener() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				RegisterWindow.this.setVisible(false);
				new LoginWindow();//打开新的登陆页面
			}
		});

		jbButtonRegister.addActionListener(new ActionListener() {//注册的监听事件
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = jfUsername.getText();
				String password = jfPassword.getText();
				if (id == null | id.equals("") | password == null | password.equals("")) {
					JOptionPane.showMessageDialog(RegisterWindow.this, "�˺Ż����벻��Ϊ��");
					return;
				}
				String selectedBox = (String) jcComboBox.getSelectedItem();
				if (selectedBox.equals("Ա��")) {
					JOptionPane.showMessageDialog(RegisterWindow.this, "Ա���Լ�����ע��,ֻ��ͨ������Ա�ṩ�˺�.");
				} else {
					Teacher teacher = new Teacher();
					teacher.setId(id);
					teacher.setPassword(password);
					if(teacherService.findTeacher(teacher) == null){//校验用户名和密码是否存在
						try {
							if(teacherService.addTeacher(teacher) == 0){//添加用户失败
								JOptionPane.showMessageDialog(RegisterWindow.this, "ע��ʧ��,������!");
							}else{
								/*
								 * 显示一个信息面板，其 options 为 "yes/no"，message 为 'choose one'：
					   				JOptionPane.showConfirmDialog(null,
					            	"choose one", "choose one", JOptionPane.YES_NO_OPTION); 
								 */
								int index = JOptionPane.showConfirmDialog(RegisterWindow.this, "ע��ɹ�,ǰȥ��¼?","",JOptionPane.YES_NO_OPTION);
								if(index == 0){//YES_NO_OPTION 	0
									//代表是
									new LoginWindow();//开启
									RegisterWindow.this.setVisible(false);
								}
							}
						} catch (HeadlessException e1) {//捕获异常
							JOptionPane.showMessageDialog(RegisterWindow.this, "ע��ʧ��,������!");
							e1.printStackTrace();
						} catch (AdminExistException e1) {//捕获异常
							JOptionPane.showMessageDialog(RegisterWindow.this, "Ա���Ѵ���,��������д");
							e1.printStackTrace();
						}
					}else{//用户已存在
						JOptionPane.showMessageDialog(RegisterWindow.this, "Ա���Ѵ���,��������дs");
					}
					
				}
			}
		});

		jbButtonQuXiao.addActionListener(new ActionListener() {//重置按钮 

			@Override
			public void actionPerformed(ActionEvent e) {//将用户名和密码文本域置为空
				jfUsername.setText("");
				jfPassword.setText("");
			}
		});
	}
	
}
