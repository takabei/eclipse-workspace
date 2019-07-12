
package views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import service.UserService;
import utils.JFrameUtils3;
import utils.Node;
import utils.NodeTWO;
import utils.TreeNodeUtils;

public class MainGUI extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	

    public MainGUI() {
        initComponents();
        initLenster();
    }
             
    private void initLenster() {
    	 jTree1.addTreeSelectionListener(new TreeSelectionListener() {
 			
 			@Override
 			public void valueChanged(TreeSelectionEvent e) {
 				DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree1
                         .getLastSelectedPathComponent();
  
                 if (node == null)
                     return;
  
                 Object obj = node.getUserObject();
                 if (node.isLeaf()) {
                 	Node nod = null;
                 	NodeTWO nodTwo = null;
                     rigthPanel.removeAll();
                     rigthPanel.setVisible(false);
                     if(obj instanceof Node) {
                     	nod = (Node)obj;
                     	rigthPanel.add(nod.getJpanel());
                     }
                     	
                     else if(obj instanceof NodeTWO) {
                     	nodTwo = (NodeTWO)obj;
                     	rigthPanel.add(nodTwo.getJTabbedPane());
                     }
                     	
                     
                     rigthPanel.setVisible(true);
                 }
 			}
 		});
	}

	private void initComponents() {
        jScrollPane1 = new JScrollPane();
        jTree1 = new JTree(TreeNodeUtils.getTreeNode());
       
        rigthPanel = new JPanel();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenu2 = new JMenu();
        JMenuItem helpItem = new JMenuItem("退出");
        JMenuItem helpItem1 = new JMenuItem("帮助");
        helpItem1.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainGUI.this,"尊敬的使用者：\n" + 
						"  您好！\n" + 
						"  本系统是面向高校教务处人员（管理员）、高校教师（教师）、高校学生（学生）服务的，\n"
						+ "为了更好的方便高校教务处人员、教师和学生的课程信息、基本个人信息、成绩信息的管理与\n"
						+ "量化，特意设置本系统。\n" + 
						"  该学生管理系统涉及到学生、教师、管理员（教务处老师）、学院、班级、课程。设置一个系\n"
						+ "统管理员对系统进行管理。所有用户均需要输入账号密码进行登录；管理员进入系统后可对学生、\n"
						+ "教师、班级、课程进行"
						+ "增删改查操作；学生进入系统，查看成绩、查看和修改自己的部分个人信息（电话、邮箱）；\n"
						+ "教师进入系统后，对自己这门课程的学生成绩进行录入、修改，也可以查看和修改自己信息。\n" + 
						"  系统管理员为课程设置教师，一个教师有多门课程，一门课程只有一名教师，为学生设置课程，\n"
						+ "一个学生有多门课程，一门课程有多个学生，一门课程有多个班级，一个班级有多门课程；教师为\n"
						+ "选择自己的这门课程"
						+ "的学生登记成绩。");
			}
		});
        helpItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				int showConfirmDialog = JOptionPane.showConfirmDialog(MainGUI.this,"是否确定退出？", "", JOptionPane.OK_OPTION);
				if(showConfirmDialog == 0) {
					MainGUI.this.setVisible(false);
				}
			}
		});
        jMenu1.add(helpItem);
        jMenu1.add(helpItem1);
        JMenuItem guanyu = new JMenuItem("版本情况");
        guanyu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainGUI.this,"Version information：V1.7\nUpdate：2019.6\nCopyright@liuyi,duzhimin,qinxiaodong.\n" + 
						"\nAll right reserved.\n版权所有，违反必究。");
			}
		});
        jMenu2.add(guanyu);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1200, 900));

        jScrollPane1.setViewportView(jTree1);
        
        rigthPanel.setLayout(new FlowLayout());
        rigthPanel.setPreferredSize(new Dimension(1021, 817));

        jMenu1.setText("帮助");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("关于");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rigthPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
            .addComponent(rigthPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        rigthPanel.add(new Welcome().getJpanel());

        pack();
    }
    public static void main(String args[]) {
            
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

      
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JPanel rigthPanel;
    private JScrollPane jScrollPane1;
    private JTree jTree1;
	private JFrameUtils3 jFrameTest3 = new JFrameUtils3();
}
