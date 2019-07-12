/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import domain.Lesson;
import domain.Student;
import domain.Teacher;
import service.ClassService;
import service.LessonService;
import service.StuLessService;
import service.UserService;
import service.UserService;
import utils.Node;

public class CourseManager extends javax.swing.JFrame implements Node{
	private String name;
	private UserService userService = new UserService();
	private ClassService classService = new ClassService();
	private LessonService lessonService = new LessonService();
	private StuLessService stuLessService = new StuLessService();
	
	public String toString() {
		return name;
	}
	@Override
	public JPanel getJpanel() {
		return jPanel1;
	}
	public CourseManager(String name) {
		this.name = name;
        initComponents();
        initLenster();      
    }
    private void initLenster() {
		rest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lessId.setText("");
				lessname.setText("");
				teaId.setText("");
			}
		});
		
		submit.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				String tld = lessId.getText();
				String tln = lessname.getText();
				String ttd = teaId.getText();
				String obj = (String)jComboBox1.getSelectedItem();
				domain.Class lazz = classService.findClass(obj);
				int num = 0;
				Lesson less = new Lesson();
				less.setLessId(tld);
				less.setName(tln);
				Teacher tea = new Teacher();
				tea.setTeaId(ttd);
				tea.setTable("teacher");
				less.setTeacher(tea);
				if(tld.trim().equals("") || tln.trim().equals("") || tld.trim().equals("")) {
					JOptionPane.showMessageDialog(CourseManager.this,"请填写全部字段");
				} else if(userService.findTeacher(less.getTeacher()) == null) {
					JOptionPane.showMessageDialog(CourseManager.this,"请填写正确的授课教师");
					return;
				} else if((num = lessonService.addLesson(less)) == 0) {
					JOptionPane.showMessageDialog(CourseManager.this,"操作失败，请稍后重试");
				} else {
					JOptionPane.showMessageDialog(CourseManager.this,"恭喜添加成功");
					List<Student> list = userService.getstuAll();
					for(Student stu : list) {
						stuLessService.addstuandless(stu.getStuId(), lessId.getText().trim());
					}					
					lessId.setText("");
					lessname.setText("");
					teaId.setText("");
				}
			}
		});
	}
	public CourseManager() {
        initComponents();
        initLenster();     
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lessId = new javax.swing.JTextField();
        lessname = new javax.swing.JTextField();
        teaId = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<Object>();
        submit = new javax.swing.JButton();
        rest = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText(" 请输入需要添加的课程：");

        jLabel1.setText(" 课程号：");

        jLabel3.setText(" 课程名：");

        jLabel4.setText(" 教师：");

        jLabel5.setText(" 班级：");

        lessId.setText("1 ");

        lessname.setText("2 ");

        teaId.setText("3 ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<Object>(classService.getList().toArray()));
        
        submit.setText(" 确认");

        rest.setText(" 重置");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(413, 413, 413)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lessId, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(lessname)
                            .addComponent(teaId)
                            .addComponent(jComboBox1)
                            .addComponent(rest, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(207, 207, 207))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1))
                    .addComponent(lessId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lessname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(teaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(rest))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CourseManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseManager().setVisible(true);
            }
        });
    }
                  
    private javax.swing.JButton submit;
    private javax.swing.JButton rest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lessId;
    private javax.swing.JTextField lessname;
    private javax.swing.JTextField teaId;
    private javax.swing.JComboBox<Object> jComboBox1;
    // End of variables declaration                   
}
