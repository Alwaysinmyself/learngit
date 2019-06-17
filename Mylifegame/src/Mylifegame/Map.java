package Mylifegame;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Map extends JPanel{
	private final int width = 22;	//单元格的宽度
	private final int height = 22;	//单元格的高度
	private final char MAP_NONE = 'N';
	private final char MAP_ACTIVE = 'A';
	private Timer timer;
	private final int DELAY_TIME = 1200;	/*每秒变换一次*/
	
	private final char[][] world = {  
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
            { 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N' },  
            { 'N', 'A', 'A', 'A', 'N', 'N', 'N', 'N' },  
            { 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N' },  
            { 'N', 'N', 'A', 'N', 'N', 'N', 'N', 'N' },  
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' },  
            { 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N' }  
  
    }; 
	
	private char[][] nextStatus = new char[world.length][world[0].length];
	private char[][] nowStatus = new char[world.length][world[0].length];
	
	Map(){
		this.startChange();
	}
	private void startChange() {
		for(int row = 0;row < world.length; row++) {
			for(int col = 0;col < world[0].length; col++) {
				nextStatus[row][col] = world[row][col];
				nowStatus[row][col] = world[row][col];
			}
		}
		
		//创建计时器
		timer = new Timer(DELAY_TIME,new ActionListener() {
			public void actionPerformed(ActionEvent e) {  
		        changeStatus();  
		        repaint();  
		    }
		});
		timer.start();
	}
	
	
	/** 
     * 画图形界面 
     *  
     */  
    protected void paintComponent(Graphics g) {  
        super.paintComponent(g);  
        for (int i = 0; i < nextStatus.length; i++) {  
            for (int j = 0; j < nextStatus[i].length; j++) {  
                if (nextStatus[i][j] == MAP_ACTIVE) {  
                    g.fillRect( j * width, i * height, width, height);  
                   
                }
                else {  
                	 g.drawRect( j * width, i * height, width, height); 
                }  
            }  
        }  
    } 
	
	/**
	 * 改变细胞形态
	 */
	private void changeStatus() {
		for(int row = 0;row < nextStatus.length; row++) {
			for(int col = 0;col < nextStatus[0].length; col++) {
				switch(neighborsCount(row, col)) {
				case 0:
				case 1:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
					nextStatus[row][col] = MAP_NONE;
					break;
				case 2:
					nextStatus[row][col] = nowStatus[row][col];
					break;
				case 3:
					nextStatus[row][col] = MAP_ACTIVE;
					break;
				}
			}
		}
		next2now();
	}
		
	protected int neighborsCount(int row, int col) {	//返回周围存活点的个数
		int count = 0,r = 0,c = 0;
		for(r = row - 1;r <= row + 1; r++) {
			for(c = col - 1;c <= col + 1; c++) {
				if(r < 0 || r >= nowStatus.length || c < 0 || c >= nowStatus[0].length) {
					continue;
				}
				if(nowStatus[r][c] == MAP_ACTIVE) {
					count ++;
				}
			}
		}
		if(nowStatus[row][col] == MAP_ACTIVE) {
			count --;
		}
		return count;
	}
	
	/** 
     * 复制地图 
     *  
     */  
	private void next2now() {
		for(int row = 0;row < nextStatus.length; row++) {
			for(int col = 0;col < nextStatus[0].length; col++) {
				nowStatus[row][col] = nextStatus[row][col];
			}
		}
	}
	
}
