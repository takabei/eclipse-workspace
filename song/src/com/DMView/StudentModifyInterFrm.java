/*
 * StudentModifyInterFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.DMView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.DMModel.Room;
import com.DMModel.Student;
import com.DMUtil.DMUtil;
import com.Dao.RoomDao;
import com.Dao.StudentDao;

/**
 *
 * @author  __USER__
 */
public class StudentModifyInterFrm extends javax.swing.JInternalFrame {
	DMUtil dmutil = new DMUtil();
	RoomDao roomdao = new RoomDao();
	StudentDao studentdao = new StudentDao();

	/** Creates new form StudentModifyInterFrm */
	public StudentModifyInterFrm() {
		initComponents();
		this.setLocation(160, 50);
		this.fillTable(new Student());
		this.fillRoom();
		this.jb_man.setSelected(true);
	}

	public void fillRoom() {
		Connection con = null;
		Room room = new Room();
		try {
			con = dmutil.getCon();
			ResultSet rs = roomdao.roomList(con, room);
			Room room2 = new Room();
			room2.setMember("请选择...");
			room2.setId(-1 + "");
			this.jcb_room.addItem(room2);
			while (rs.next()) {
				room = new Room();
				room.setId(rs.getInt("id") + "");
				room.setMember(rs.getString("member"));
				room.setLeader(rs.getString("leader"));
				this.jcb_room.addItem(room);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dmutil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void fillTable(Student student) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dmutil.getCon();
			ResultSet rs = studentdao.StudentSearch(con, student);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("name"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("yuanxi"));
				v.add(rs.getString("classroom"));
				v.add(rs.getString("member"));
				v.add(rs.getString("bed"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dmutil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

buttonGroup1 = new javax.swing.ButtonGroup();
jLabel1 = new javax.swing.JLabel();
nameTxt = new javax.swing.JTextField();
jLabel2 = new javax.swing.JLabel();
classTxt = new javax.swing.JTextField();
jLabel3 = new javax.swing.JLabel();
yuanxiTxt = new javax.swing.JTextField();
jLabel4 = new javax.swing.JLabel();
bedTxt = new javax.swing.JTextField();
jLabel5 = new javax.swing.JLabel();
jb_man = new javax.swing.JRadioButton();
jb_women = new javax.swing.JRadioButton();
jLabel6 = new javax.swing.JLabel();
jcb_room = new javax.swing.JComboBox();
jScrollPane1 = new javax.swing.JScrollPane();
table = new javax.swing.JTable();
jb_modify = new javax.swing.JButton();
jButton2 = new javax.swing.JButton();
jLabel7 = new javax.swing.JLabel();
idTxt = new javax.swing.JTextField();

setClosable(true);
setIconifiable(true);
setTitle("\u5b66\u751f\u4fe1\u606f\u4fee\u6539");

jLabel1.setText("\u59d3\u540d\uff1a");

jLabel2.setText("\u73ed\u7ea7\uff1a");

jLabel3.setText("\u9662\u7cfb\uff1a");

jLabel4.setText("\u5e8a\u53f7\uff1a");

jLabel5.setText("\u6027\u522b\uff1a");

buttonGroup1.add(jb_man);
jb_man.setText("\u7537");

buttonGroup1.add(jb_women);
jb_women.setText("\u5973");

jLabel6.setText("\u5bdd\u5ba4\u53f7\uff1a");


table.setModel(new javax.swing.table.DefaultTableModel(
	new Object [][] {
		
	},
	new String [] {
		"编号", "姓名", "性别", "院系", "班级", "寝室号", "床号"
	}
) {
	boolean[] canEdit = new boolean [] {
		false, false, false, false, false, false, false
	};

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return canEdit [columnIndex];
	}
});
table.addMouseListener(new java.awt.event.MouseAdapter() {
public void mousePressed(java.awt.event.MouseEvent evt) {
tableMousePressed(evt);
}
});
jScrollPane1.setViewportView(table);

jb_modify.setIcon(new javax.swing.ImageIcon("D:\\Myelipse\\images4\\modify.png")); // NOI18N
jb_modify.setText("\u4fee\u6539");
jb_modify.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jb_modifyActionPerformed(evt);
}
});

jButton2.setIcon(new javax.swing.ImageIcon("D:\\Myelipse\\images4\\exit.png")); // NOI18N
jButton2.setText("\u9000\u51fa");
jButton2.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton2ActionPerformed(evt);
}
});

jLabel7.setText("\u7f16\u53f7\uff1a");

idTxt.setEditable(false);

javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
.addGap(32, 32, 32)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addComponent(jLabel1)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
.addGroup(layout.createSequentialGroup()
.addComponent(jLabel4)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(bedTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
.addGap(18, 18, 18)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
.addGap(8, 8, 8)
.addComponent(jLabel5)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(jb_man, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
.addComponent(jb_women, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
.addGap(18, 18, 18)
.addComponent(jLabel6)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(jcb_room, 0, 160, Short.MAX_VALUE))
.addGroup(layout.createSequentialGroup()
.addGap(4, 4, 4)
.addComponent(jLabel2)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(classTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
.addGap(18, 18, 18)
.addComponent(jLabel3)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(yuanxiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
.addComponent(jLabel7)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
.addComponent(idTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)))
.addGap(49, 49, 49))
.addGroup(layout.createSequentialGroup()
.addContainerGap()
.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
.addContainerGap())
.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
.addContainerGap(217, Short.MAX_VALUE)
.addComponent(jb_modify)
.addGap(119, 119, 119)
.addComponent(jButton2)
.addGap(151, 151, 151))
);
layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGap(24, 24, 24)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel1)
.addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
.addGap(39, 39, 39)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel4)
.addComponent(bedTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
.addGroup(layout.createSequentialGroup()
.addGap(23, 23, 23)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel2)
.addComponent(classTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jLabel3)
.addComponent(yuanxiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jLabel7)
.addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
.addGap(39, 39, 39)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jb_women)
.addComponent(jb_man)
.addComponent(jLabel5)))
.addGroup(layout.createSequentialGroup()
.addGap(83, 83, 83)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jLabel6)
.addComponent(jcb_room, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
.addGap(30, 30, 30)
.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
.addGap(18, 18, 18)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
.addComponent(jb_modify)
.addComponent(jButton2))
.addContainerGap(38, Short.MAX_VALUE))
);

pack();
}// </editor-fold>

	//GEN-END:initComponents

	private void jb_modifyActionPerformed(java.awt.event.ActionEvent evt) {
		String name = nameTxt.getText();
		String classroom = classTxt.getText();
		String yuanxi = yuanxiTxt.getText();
		String bed = bedTxt.getText();
		String sex = "";
		if (jb_man.isSelected()) {
			sex = "男";
		} else if (jb_women.isSelected()) {
			sex = "女";
		}
		String id = idTxt.getText();
		Room room = (Room) this.jcb_room.getSelectedItem();
		String roomnum = room.getId();
		Connection con = null;
		try {
			con = dmutil.getCon();
			Student student = new Student(Integer.parseInt(id), name, sex,
					yuanxi, classroom, Integer.parseInt(roomnum),
					Integer.parseInt(bed));
			int a = studentdao.StudentModify(con, student);
			if (a == 1) {
				JOptionPane.showMessageDialog(null, "修改成功！");
				resetValue();
				this.fillTable(new Student());
				return;
			} else {
				JOptionPane.showMessageDialog(null, "修改失败!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "修改失败!");
			e.printStackTrace();
		}
	}

	private void resetValue() {
		this.nameTxt.setText("");
		this.classTxt.setText("");
		this.bedTxt.setText("");
		this.yuanxiTxt.setText("");
		this.jb_man.setSelected(true);
		this.jcb_room.setSelectedIndex(0);
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		int a = JOptionPane.showConfirmDialog(null, "确认要退出？");
		if (a == 0) {
			this.dispose();
		}
	}

	private void tableMousePressed(java.awt.event.MouseEvent evt) {
		int row = table.getSelectedRow();
		nameTxt.setText(table.getValueAt(row, 1) + "");
		yuanxiTxt.setText(table.getValueAt(row, 3) + "");
		classTxt.setText(table.getValueAt(row, 4) + "");
		bedTxt.setText(table.getValueAt(row, 6) + "");
		String sex = table.getValueAt(row, 2) + "";
		idTxt.setText((String) table.getValueAt(row, 0));
		if (sex.equals("男")) {
			this.jb_man.setSelected(true);
		} else if (sex.equals("女")) {
			this.jb_women.setSelected(true);
		}
		String roomid = (String) table.getValueAt(row, 5);
		int n = this.jcb_room.getItemCount();
		for (int i = 0; i < n; i++) {
			Room item = (Room) this.jcb_room.getItemAt(i);
			if (item.getMember().equals(roomid)) {
				this.jcb_room.setSelectedIndex(i);
			}
		}
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTextField bedTxt;
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JTextField classTxt;
	private javax.swing.JTextField idTxt;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JRadioButton jb_man;
	private javax.swing.JButton jb_modify;
	private javax.swing.JRadioButton jb_women;
	private javax.swing.JComboBox jcb_room;
	private javax.swing.JTextField nameTxt;
	private javax.swing.JTable table;
	private javax.swing.JTextField yuanxiTxt;
	// End of variables declaration//GEN-END:variables

}