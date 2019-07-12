package cn.gbf.ui;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.gbf.domain.Teacher;
import cn.gbf.service.AdminService;
import cn.gbf.service.YuangongService;
import cn.gbf.service.impl.AdminServiceImpl;
import cn.gbf.service.impl.YuangongServiceImpl;

public class LoginWindow extends Frame{
	private JLabel jlUsername = new JLabel("�û���");//用户名标签
	private JLabel jlPassword = new JLabel("����");//密码标签
	private JTextField jfUsername = new JTextField();//用户名普通文本域
	private JPasswordField jfPassword = new JPasswordField();//密码文本域
	private JLabel jlShenFen = new JLabel("ְλ");//职位标签
	private JComboBox<String> jcComboBox = new JComboBox<String>();//下拉框
	private JButton jbButtonLogin = new JButton("��¼");//登陆按钮
	private JButton jbButtonRegister = new JButton("ע��");//注册按钮
	private AdminService teacherService = new AdminServiceImpl();//提供服务管理员
	private YuangongService studentService = new YuangongServiceImpl();//员工
	public LoginWindow() {//构造器
		initUi();//设置样式的方法
		initListener();//设置监听器
	}
	private void initUi(){
		this.setTitle("Ա������ϵͳ");//设置标题
		this.setLayout(null);//设置布局
		jlUsername.setBounds(100, 40, 100, 20);//int x, int y, int width, int height
		this.add(jlUsername);
		jfUsername.setBounds(200, 40, 80, 20);
		this.add(jfUsername);
		
		jlPassword.setBounds(100,100,60,20);
		this.add(jlPassword);
		jfPassword.setBounds(200,100, 80, 20);
		this.add(jfPassword);
		
		jlShenFen.setBounds(100, 150, 60, 20);
		this.add(jlShenFen);
		jcComboBox.setBounds(200,150,80,20);//下拉框
		this.add(jcComboBox);
		jcComboBox.addItem("Ա��");//添加子选项
		jcComboBox.addItem("����Ա");
		
		jbButtonRegister.setBounds(100,200,60,20);
		this.add(jbButtonRegister);
		jbButtonLogin.setBounds(200,200,60,20);
		this.add(jbButtonLogin);
		this.setVisible(true);//设置可见性
		this.setBounds(500, 200, 400, 300);
	}
	private void initListener(){
		this.addWindowListener(new WindowAdapter() {//设置窗体监听器
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);//设置退出
			}
		});
		
		jbButtonLogin.addActionListener(new ActionListener() {//设置登陆按钮监听器
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = jfUsername.getText();//获取文本域
				String password = jfPassword.getText();//获取文本域
				
				if (id == null | id.equals("") | password == null | password.equals("")) {
					JOptionPane.showMessageDialog(LoginWindow.this, "�˺Ż����벻��Ϊ��");//弹框
					return;
				}
				String selectedBox = (String) jcComboBox.getSelectedItem();//获取被选中的子选项
				if(selectedBox.equals("Ա��")){
					if(studentService.findStudent(id, password) == null){
						JOptionPane.showMessageDialog(LoginWindow.this, "�˺Ż����벻��ȷ");//弹框
					}else{
						new YuangongWindow(id);//打开员工
						LoginWindow.this.setVisible(false);//设置当前窗体隐藏
					}
					
				}else{//管理员
					Teacher teacher = new Teacher();
					teacher.setId(id);
					teacher.setPassword(password);
					if(teacherService.findTeacher(teacher) == null){
						JOptionPane.showMessageDialog(LoginWindow.this, "�˺Ż����벻��ȷ");
					}else{
						new AdminWindow();//打开管理员
						LoginWindow.this.setVisible(false);//设置当前窗体隐藏
					}
				}
			}
		});
		
		jbButtonRegister.addActionListener(new ActionListener() {//注册按钮监听器
			@Override
			public void actionPerformed(ActionEvent e) {
				new RegisterWindow();//打开注册页面
				LoginWindow.this.setVisible(false);//设置当前窗体隐藏
			}
		});
	}
	public static void main(String[] args) {
		new LoginWindow();
	}
}
