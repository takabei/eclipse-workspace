package cn.gbf.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import cn.gbf.domain.Student;
import cn.gbf.service.YuangongService;
import cn.gbf.service.impl.YuangongServiceImpl;



public class AdminWindow extends JFrame {
	private YuangongService studentService = new YuangongServiceImpl();
	private List<Student> allStudent;
	
	
	JMenuBar jmb = new JMenuBar();
	JMenu jmMessage = new JMenu("Ա����Ϣ");
	JMenuItem jmiAddMessage = new JMenuItem("�����Ϣ");
	JMenuItem jmiQueryMessage = new JMenuItem("��ѯ��Ϣ");
	JMenu jmGrade = new JMenu("Ա��н��");
	JMenuItem jmiAddGrade = new JMenuItem("���н��");
	JMenuItem jmiQueryGrade = new JMenuItem("��ѯн��");
	
	//��Ϣ
	JPanel jpMessage = null;//面板窗体类
	
	//н��
	JPanel jpGrade = null;//面板窗体类
	
	
	public AdminWindow() {
		initUi();
		initListener();
	}
	public static void main(String[] args) {
		new AdminWindow();
	}
	private void initUi() {
		this.setTitle("����Ա����");
		this.setLayout(null);
		this.setVisible(true);
		this.setBounds(500, 200, 415, 300);

		this.setJMenuBar(jmb);
		jmb.add(jmMessage);
		jmMessage.add(jmiAddMessage);
		jmMessage.add(jmiQueryMessage);
		jmb.add(jmGrade);
		jmGrade.add(jmiAddGrade);
		jmGrade.add(jmiQueryGrade);
		
		initMessageWindow();
		this.add(jpMessage);
		
		initGradeWindow();
		this.add(jpGrade);
		
		
	}
	private void initMessageWindow() {//初始化消息窗体类
		jpMessage = new JPanel(null);
		jpMessage.setVisible(true);
		jpMessage.setBounds(0, 0, 400, 300);
		
		allStudent = studentService.findAllStudent();
		Object[][] tableData = new Object[allStudent.size()][5];
		for(int i = 0; i < allStudent.size(); i ++){
				tableData[i][0] = allStudent.get(i).getId();
				tableData[i][1] = allStudent.get(i).getName();
				tableData[i][2] = allStudent.get(i).getSex();
				tableData[i][3] = allStudent.get(i).getAge();
				tableData[i][4] = allStudent.get(i).getCollage();
		}
		/*
		 * 表格
		 */
		JTable table = new JTable(tableData , new String[]{"����","����","�Ա�","����","����"});		
		JScrollPane jScrollPane = new JScrollPane(table);//添加水平滚动条
		jScrollPane.setBounds(0, 0, 400, 300);
		jpMessage.add(jScrollPane);
		
	}
	private void initGradeWindow() {//初始化薪资窗体类
		jpGrade =  new JPanel(null);
		jpGrade.setVisible(false);
		jpGrade.setBounds(0, 0, 400, 300);
		
		allStudent = studentService.findAllStudent();
		Object[][] tableData = new Object[allStudent.size()][5];
		for(int i = 0; i < allStudent.size(); i ++){
			tableData[i][0] = allStudent.get(i).getId();
			tableData[i][1] = allStudent.get(i).getName();
			if(allStudent.get(i).getGrade()!= null){
				tableData[i][2] = allStudent.get(i).getGrade().getChinese();
				tableData[i][3] = allStudent.get(i).getGrade().getMath();
				tableData[i][4] = allStudent.get(i).getGrade().getEnglish();
			}else{
				tableData[i][2] = "��";
				tableData[i][3] = "��";
				tableData[i][4] = "��";
			}
			
	}
		JTable table = new JTable(tableData , new String[]{"����","����","����","����","����"});
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(0, 0, 400, 300);
		jpGrade.add(jScrollPane);
	}

	

	private void initListener() {
		//������Ա����Ϣ �������Ϣ����
		jmiAddMessage.addActionListener(new ActionListener() {//添加员工的事件
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminWindow.this.setVisible(false);//当前的窗体隐藏
				new AddYuanGongWindow();//开启新窗体
			}
		});
		jmiQueryMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {//窗体切换
				jpMessage.setVisible(true);
				jpGrade.setVisible(false);
			}
		});
		jmiAddGrade.addActionListener(new ActionListener() {//另一个添加事件
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddMoneyWindow();
				AdminWindow.this.setVisible(false);
			}
		});
		jmiQueryGrade.addActionListener(new ActionListener() {//窗体切换
			@Override
			public void actionPerformed(ActionEvent e) {
				jpMessage.setVisible(false);
				jpGrade.setVisible(true);
			}
		});
		this.addWindowListener(new WindowAdapter() {//退出
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}
}
