/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import service.UserService;
import utils.Node;
/**
 *
 * @author liuyi
 */
public class PasswordChange extends javax.swing.JFrame implements Node{
	private String name;
	private UserService userService;
	private String table = "";

	@Override
	public String toString() {
		return name;
	}

	@Override
	public JPanel getJpanel() {
		return jPanel1;
	}

	public PasswordChange(String name) throws HeadlessException {
		super();
		this.name = name;

		initComponents();
		initLenster();
	}

	private void initLenster() {
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
		rest.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				jConfirmPass.setText("");
				jNewPass.setText("");
				jOldPass.setText("");
				jUsername.setText("");
			}
		});
		
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String tcp = jConfirmPass.getText();
				String tnp = jNewPass.getText();
				String top = jOldPass.getText();
				String tun = jUsername.getText();
				int num = 0;
				if(tun.trim().equals("") || 
						tcp.trim().equals("") || 
						top.trim().equals("") || 
						tnp.trim().equals("")) {
					JOptionPane.showMessageDialog(PasswordChange.this,"请填写全部字段！");
				} else if((num = userService.Login(table, tun, top)) == 0) {//没有该用户
					JOptionPane.showMessageDialog(PasswordChange.this,"请输入正确的用户名和密码");
				} else if(!tnp.equals(tcp)) {//新密码和确认密码不一致！
					JOptionPane.showMessageDialog(PasswordChange.this,"新密码和确认密码不一致！");
				} else if((num = userService.updateUserPass(table, tun, top, tnp)) == 0) {
					JOptionPane.showMessageDialog(PasswordChange.this,"操作失败，请稍候重试！");
				} else {
					JOptionPane.showMessageDialog(PasswordChange.this,"恭喜修改成功！请记住你的新密码：" + tnp);
					jConfirmPass.setText("");
					jNewPass.setText("");
					jOldPass.setText("");
					jUsername.setText("");
				}
			}
		});
	}

	public PasswordChange() {
		initComponents();

	}
                        
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        oldPass = new javax.swing.JLabel();
        newPass = new javax.swing.JLabel();
        confirmPass = new javax.swing.JLabel();
        admin = new javax.swing.JRadioButton();
        teacher = new javax.swing.JRadioButton();
        student = new javax.swing.JRadioButton();
        jUsername = new javax.swing.JTextField();
        jOldPass = new javax.swing.JTextField();
        jNewPass = new javax.swing.JTextField();
        jConfirmPass = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        confirm = new javax.swing.JButton();
        rest = new javax.swing.JButton();
        username = new javax.swing.JLabel();
        userService = new UserService();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(admin);
        buttonGroup1.add(teacher);
        buttonGroup1.add(student);
        oldPass.setText(" 原始密码：");

        newPass.setText(" 新密码：");

        confirmPass.setText(" 确认密码：");

        admin.setText(" 管理员");

        teacher.setText(" 教师");

        student.setText(" 学生");

        jUsername.setText("");
        jNewPass.setText("");

        jOldPass.setText("");

        jConfirmPass.setText("");

        jLabel4.setText(" 请输入相应的字段：");

        confirm.setText(" 确认修改");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        rest.setText(" 重置");

        username.setText(" 用户名：");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(407, 407, 407)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(283, 283, 283)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(admin)
                                    .addComponent(oldPass)
                                    .addComponent(newPass)
                                    .addComponent(confirmPass)
                                    .addComponent(username))
                                .addGap(172, 172, 172))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(165, 165, 165)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(teacher)
                                .addGap(81, 81, 81)
                                .addComponent(student))
                            .addComponent(jUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addComponent(jOldPass)
                            .addComponent(jNewPass)
                            .addComponent(jConfirmPass)
                            .addComponent(rest, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(342, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin)
                    .addComponent(teacher)
                    .addComponent(student))
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(oldPass)
                    .addComponent(jOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newPass)
                    .addComponent(jNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmPass)
                    .addComponent(jConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirm)
                    .addComponent(rest))
                .addContainerGap(160, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

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
            java.util.logging.Logger.getLogger(PasswordChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasswordChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasswordChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasswordChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PasswordChange().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton confirm;
    private javax.swing.JLabel confirmPass;
    private javax.swing.JTextField jConfirmPass;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jNewPass;
    private javax.swing.JTextField jOldPass;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton admin;
    private javax.swing.JRadioButton teacher;
    private javax.swing.JRadioButton student;
    private javax.swing.JTextField jUsername;
    private javax.swing.JLabel newPass;
    private javax.swing.JLabel oldPass;
    private javax.swing.JButton rest;
    private javax.swing.JLabel username;
    // End of variables declaration                   
}
