/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import service.UserService;

/**
 *
 * @author liuyi
 */
public class LoginClass extends JFrame {
	private static final long serialVersionUID = 1L;


	private ButtonGroup singleButton;
	private JLabel error;
	private JLabel errorName;
	private JLabel errorPass;
	private JRadioButton student;
	private JRadioButton teacher;
	private JRadioButton admin;
	private JButton login;
	private JTextField nameField;
	private JLabel nameLabel;
	private JPasswordField passField;
	private JLabel passLabel;
	private JButton regist;
	private Dialog dialog;
	private JButton confirm;
	private JLabel label;
	private String table = "";
	private UserService userService = new UserService();

	public LoginClass() {
		initComponents();
		Container c = getContentPane(); // 获取JFrame面板
		initLenster();
	}

	private void initLenster() {
		 // 对话框监听器
		dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            	dialog.setVisible(false);//设置对话框不可见
            }
        });
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
			}
		});
		
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		
		regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registActionPerformed(e);
			}
		});
		student.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table = "student";
			}
		});
		teacher.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table = "teacher";
			}
		});
		admin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table = "admin";
			}
		});
	}

	private void initComponents() {
		label = new JLabel();
		singleButton = new ButtonGroup();
		nameLabel = new JLabel();
		passLabel = new JLabel();
		nameField = new JTextField();
		passField = new JPasswordField();
		login = new JButton();
		regist = new JButton();
		error = new JLabel();
		errorPass = new JLabel();
		errorName = new JLabel();
		student = new JRadioButton();
		teacher = new JRadioButton();
		admin = new JRadioButton();

		singleButton.add(student);
		singleButton.add(teacher);
		singleButton.add(admin);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		nameLabel.setText("用户名");

		passLabel.setText("密码");

		nameField.setText("");
		nameField.setFont(new Font("宋体", Font.PLAIN, 25));

		passField.setText("");
		passField.setFont(new Font("宋体", Font.PLAIN, 25));

		login.setText("登陆");

		regist.setText("注册");

		error.setText(" ");

		errorPass.setText(" ");

		errorName.setText(" ");

		student.setText("学生");

		teacher.setText("老师");

		admin.setText("管理员");
		
		confirm = new JButton("确定");
		dialog = new Dialog(this, "提示信息-self", true);//弹出的对话框
		dialog.add(label);
		dialog.setBounds(400, 300, 350, 150);//设置弹出对话框的位置和大小
		dialog.setLayout(new FlowLayout());//设置弹出对话框的布局为流式布局
		dialog.add(confirm);//将确定按钮添加到弹出的对话框内。
		
	

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(284, 284, 284)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout
						.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(nameLabel)
								.addComponent(passLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addGroup(layout.createSequentialGroup()
										.addComponent(login, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
										.addComponent(regist, GroupLayout.PREFERRED_SIZE, 86,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(error, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(nameField).addComponent(passField)))
						.addGroup(layout.createSequentialGroup().addComponent(student).addGap(114, 114, 114)
								.addComponent(teacher).addGap(101, 101, 101).addComponent(admin)))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(errorName, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
						.addComponent(errorPass, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGap(36, 36, 36)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(147, 147, 147)
						.addComponent(error, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
								.addComponent(nameLabel)
								.addComponent(errorName, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
						.addGap(46, 46, 46)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(passField, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
								.addComponent(passLabel)
								.addComponent(errorPass, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
						.addGap(43, 43, 43)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(student)
								.addComponent(teacher).addComponent(admin))
						.addGap(47, 47, 47)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(login, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
								.addComponent(regist, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(153, Short.MAX_VALUE)));

		pack();
	}

	private void loginActionPerformed(ActionEvent evt) {
		String username = nameField.getText().trim();
		String password = passField.getText();
		
		if(username.trim().equals("") || password.trim().equals("")) {
			label.setText("请注意！请注意！请注意！请注意！你的用户名或密码为空！");
			dialog.setVisible(true);
			return;
		}
		if(table.equals("")) {
			label.setText("请注意！请注意！请注意！请注意！你还没有选择角色!");
			dialog.setVisible(true);
			return;
		}
		if(userService.Login(table, username, password) == 1) {
			label.setText("恭喜你成功登陆！");
			this.setVisible(false);
			new MainGUI().setVisible(true);
			dialog.setVisible(true);
		}
	}

	private void registActionPerformed(ActionEvent evt) {
		label.setText("暂不开放该接口");
		dialog.setVisible(true);
		return;
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(LoginClass.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(LoginClass.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(LoginClass.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(LoginClass.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LoginClass().setVisible(true);
			}
		});
	}

}
