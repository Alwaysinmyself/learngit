package Mylifegame;

import javax.swing.*;

public class Lifegame extends JFrame{	//继承JFrame类
	Lifegame(){
		this.setTitle("Welcome to my Lifegame");	//设计框架的标题
		this.setSize(640, 640);	//设计框架的长宽
		this.add(new Map());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//设计关闭设置
		this.setLocationRelativeTo(null); //设计框架的位置
		this.setVisible(false); //暂时不显示框架
	}
	
	public static void main(String[] args) {
		Lifegame lifegame = new Lifegame();	//开启游戏
		lifegame.setVisible(true);			//显示框架
	}
}
