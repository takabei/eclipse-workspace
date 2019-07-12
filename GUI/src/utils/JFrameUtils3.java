package utils;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JFrameUtils3 extends JFrame implements NodeTWO{
	private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private String name;
    
    @Override
	public String toString() {
		return name;
	}

	@Override
	public JTabbedPane getJTabbedPane() {
		return this.jTabbedPane1;
	}
    
    public javax.swing.JTabbedPane getjTabbedPane1() {
		return jTabbedPane1;
	}

	public void setjTabbedPane1(javax.swing.JTabbedPane jTabbedPane1) {
		this.jTabbedPane1 = jTabbedPane1;
	}
	

	public JFrameUtils3(String name, String...args) {
		this.name = name;
		jTabbedPane1 = new javax.swing.JTabbedPane();
		 setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		 jPanel2 = new javax.swing.JPanel();
	     jPanel3 = new javax.swing.JPanel();
	     jPanel4 = new javax.swing.JPanel();
		for(int i = 0; i < args.length; i++) {
			if(i == 0) {
				jPanel2 = new javax.swing.JPanel();
				 jPanel2.setPreferredSize(new java.awt.Dimension(1021, 817));
			        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
			        jPanel2.setLayout(jPanel2Layout);
			        jPanel2Layout.setHorizontalGroup(
			            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			            .addGap(0, 677, Short.MAX_VALUE)
			        );
			        jPanel2Layout.setVerticalGroup(
			            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			            .addGap(0, 579, Short.MAX_VALUE)
			        );

			        jTabbedPane1.addTab(args[i], jPanel2);
			}else if(i == 1) {
				javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		        jPanel3.setLayout(jPanel3Layout);
		        jPanel3Layout.setHorizontalGroup(
		            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGap(0, 677, Short.MAX_VALUE)
		        );
		        jPanel3Layout.setVerticalGroup(
		            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGap(0, 579, Short.MAX_VALUE)
		        );

		        jTabbedPane1.addTab(args[i], jPanel3);
			}else if(i == 2) {

		        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		        jPanel4.setLayout(jPanel4Layout);
		        jPanel4Layout.setHorizontalGroup(
		            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGap(0, 677, Short.MAX_VALUE)
		        );
		        jPanel4Layout.setVerticalGroup(
		            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGap(0, 579, Short.MAX_VALUE)
		        );

		        jTabbedPane1.addTab(args[i], jPanel4);
			}
		}
	}

	public JFrameUtils3() {
    	jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setPreferredSize(new java.awt.Dimension(1021, 817));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab1", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab3", jPanel4);
	}

	
}
