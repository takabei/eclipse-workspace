/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import utils.Node;

/**
 *
 * @author liuyi
 */
public class Exit extends JFrame implements Node {
	private JButton jButton1;
	private JButton jButton4;
	private JLabel jLabel1;
	private JPanel jPanel2;

	private String name;

	@Override
	public String toString() {
		return name;
	}

	@Override
	public JPanel getJpanel() {
		return jPanel2;
	}

	public Exit(String name) throws HeadlessException {
		super();
		this.name = name;

		initComponents();
	}

	public Exit() {
		initComponents();

	}

	private void initComponents() {

		jPanel2 = new JPanel();
		jLabel1 = new JLabel();
		jButton4 = new JButton();
		jButton1 = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("您是不是要退出当前系统？");

		jButton4.setText("否(N)");
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

			}
		});

		jButton1.setText("是(Y)");
		jButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Container parent2 = null;
				if (null != (parent2 = Exit.this.getJpanel().getParent())) {// 获取到当前jpanel的对象的父窗体
					while (parent2 != null) {
						parent2 = parent2.getParent();
//						System.out.println(parent2);
						if (parent2 instanceof MainGUI) {// 找到主窗体并且关闭他
							parent2.setVisible(false);
							new LoginClass().setVisible(true);// 开启新窗体
						}
					}
				}
			}
		});

		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(261, 261, 261)
						.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addGap(344, 344, 344)
						.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(265, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
								.addGap(345, 345, 345)));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(273, 273, 273)
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addGap(190, 190, 190)
								.addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(jButton4).addComponent(jButton1))
								.addContainerGap(293, Short.MAX_VALUE)));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jPanel2,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jPanel2,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}

	public static void main(String args[]) {
		
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Exit.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(Exit.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(Exit.class.getName()).log(Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			Logger.getLogger(Exit.class.getName()).log(Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Exit().setVisible(true);
			}
		});
	}

}
