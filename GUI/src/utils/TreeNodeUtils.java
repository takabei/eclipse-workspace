package utils;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import views.Exit;

import views.PasswordChange;
import views.AdminBasicInformation;
import views.AdminGradeQuery;
import views.AdminInformationQuery;
import views.ClassManager;
import views.CourseManager;



public class TreeNodeUtils {
	public static DefaultTreeModel getTreeNode() {
		Exit exit = new Exit("退出");
		PasswordChange userObject = new PasswordChange("修改密码");
		DefaultMutableTreeNode      root = new DefaultMutableTreeNode("操作选项");
        DefaultMutableTreeNode      parent;

        parent = new DefaultMutableTreeNode("系统选项");
        root.add(parent);
        parent.add(new DefaultMutableTreeNode(exit));
        
		parent.add(new DefaultMutableTreeNode(userObject));

        parent = new DefaultMutableTreeNode("信息管理");
        root.add(parent);
        parent.add(new DefaultMutableTreeNode(new AdminBasicInformation("基本信息登记")));
        parent.add(new DefaultMutableTreeNode(new AdminInformationQuery("基本信息查询")));
        parent.add(new DefaultMutableTreeNode(new AdminGradeQuery("成绩查询")));

        parent = new DefaultMutableTreeNode(new CourseManager("课程管理"));
        root.add(parent);
        
        parent = new DefaultMutableTreeNode(new ClassManager("班级管理"));
        root.add(parent);
        return new DefaultTreeModel(root);
	}
}
