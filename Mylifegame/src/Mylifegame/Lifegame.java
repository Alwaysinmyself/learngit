package Mylifegame;

import javax.swing.*;

public class Lifegame extends JFrame{	//�̳�JFrame��
	Lifegame(){
		this.setTitle("Welcome to my Lifegame");	//��ƿ�ܵı���
		this.setSize(640, 640);	//��ƿ�ܵĳ���
		this.add(new Map());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//��ƹر�����
		this.setLocationRelativeTo(null); //��ƿ�ܵ�λ��
		this.setVisible(false); //��ʱ����ʾ���
	}
	
	public static void main(String[] args) {
		Lifegame lifegame = new Lifegame();	//������Ϸ
		lifegame.setVisible(true);			//��ʾ���
	}
}
