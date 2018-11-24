package org.eclipse.wb.swt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;

public class gai{  
    static int a=0;
	static int b=0;
	static int c=0;
	static int t=0;
	static int f=0;
	static int jc=0;
	static String z;
	static String ti;
	static int ff1 = 0;
	static boolean ff2 = true;
	public void setfangfa(int A,int B,int C){
		a = A;b= B;c=C;
	}
	public static int zhengquedaan(){
		int a1 = 0;
		if(c==1){
		a1=a + b;}
		if(c==2){
        a1=a - b;}
		if(c==3){
	    a1=a * b;}
		if(c==4){
		a1=(a*b) / b;}
		return a1;
	}                   //四个运算题的结果 
	public static String Ti(){
		if(c==1){
		ti= a+"+"+b;}
		if(c==2){
		ti= a+"-"+b;}
		if(c==3){
		ti= a+"×"+b;}
		if(c==4){
		ti= (a*b)+"÷"+b;}  
		return ti;
	}                   //输出题目

	public void zql(int F,int T,int JC){  //JC防止不断点击确定不断增加错误和正确值
		jc = JC + jc;
		if(jc<2){
		f=F+f;t=t+T;}
	}
	public 	static String ZQL(){
 		return z = "正确    "+t+"    题                错误    "+f+"    题                                                 正确率为    "+(((double)(double)t/(double)(t+f))*100)+"    ％    ";
	}
	//计算正确率

	
	
	public static void main(String[] args){    
			
	    gai dy;
	    dy = new gai(); //实列化gai
        	              
	
	   
		Display display = new Display();
		final Shell shell = new Shell();
		shell.setLayout(null); 
		shell.setText("算数练习-徐宇航制作");
		shell.setSize(600, 400);		
		final Label lb2 = new Label(shell,SWT.NONE|SWT.CENTER);		
		final Label lb3 = new Label(shell,SWT.NONE|SWT.CENTER);		
		final Label lb4 = new Label(shell,SWT.NONE|SWT.CENTER);		
		final Label lb1 = new Label(shell,SWT.BORDER|SWT.RIGHT);  //深陷型、文字右对齐 //设置显示屏
		final Label lb5 = new Label(shell,SWT.NONE|SWT.CENTER);		
		final Label lb6 = new Label(shell,SWT.NONE|SWT.CENTER);
		final Label lb7 = new Label(shell,SWT.NONE|SWT.RIGHT);
		lb7.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		final Text text1 = new Text(shell,SWT.NULL|SWT.BORDER|SWT.RIGHT);  //设置带边框的文本框
		Button b2 =new Button(shell,SWT.NONE);
		Button b3 = new Button(shell,SWT.NONE);
		Button b1 =new Button(shell,SWT.NONE);
		b2.setBounds(170,106,252,130);  //设置按钮的显示位置及宽度和高度
		b2.setText("开始");
		b2.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				b1.setBounds(433,10,130,59);  //设置按钮的显示位置及宽度和高度
				b2.setBounds(0,0,0,0); 
				lb1.setBounds(10,10,400,100);
			}
			});
/*
 限制文本框text1 只能输入数字（在cnds复制下来的）

 */
				  
		   
		  text1.addVerifyListener(new VerifyListener() {   
		   public void verifyText(VerifyEvent e) {   
		    // 几种情况，输入控制键，输入中文，输入字符，输入数字   
		    // 正整数验证   
		     Pattern pattern = Pattern.compile("[0-9]\\d*");   
		     Matcher matcher = pattern.matcher(e.text);   
		    if (matcher.matches()) // 处理数字   
		      e.doit = true;   
		    else if (e.text.length() > 0) // 有字符情况,包含中文、空格   
		      e.doit = false;   
		    else  
		     // 控制键   
		      e.doit = true;   
		    }
		   });           
                                            //		   文本框输入限制

		  
		  
		b3.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				String s = text1.getText();//读取输入的数
				lb7.setBounds(0,313,582,50);
			  if(text1.getText()==""){
				  lb3.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
				  lb3.setText("请输入答案");
			  } else{ 
				  ff2 = true;          //初始化
				  ff1 = 0;            //初始化
				  b1.setText("下一题");
	          int I = Integer.parseInt(s);          //转化为int型 
		      if(I==zhengquedaan()){
		    	  dy.zql(0, 1,1);
		    	  lb3.setText("恭喜你，回答正确！");
		    	  lb7.setText(""+ZQL());
		      }else{
		    	  dy.zql(1, 0,1);
		      lb4.setText(""+zhengquedaan());
	          lb3.setText("回答错误！");
	          lb6.setText("正确答案是");
	          lb6.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
	          lb4.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
	          lb7.setText(""+ZQL());}
			}
			}
		});                                          //确认按钮
		
	
		
				
		

		b1.setText("开始");
		b1.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				lb2.setBounds(10,135,200,50);
				lb4.setBounds(210,260,200,40);
				lb6.setBounds(10,260,200,40);
				lb3.setBounds(210,210,200,40);
				lb5.setBounds(10,210,200,40);  
				ff1 = ff1 + 1;     //判定是否提示用户输入答案
                if(ff2){                          //防止题目在没有输入答案的情况下可以改变刷题。
				int x = (int)(Math.random()*101);//
				int y = (int)(Math.random()*101);//	
				int h = (int)((Math.random()*4)+1);//
				jc=0;//归零jc（检查）
	
				text1.setBounds(210,120,200,50);    //显示文本框
				if(y > x){
					int P = x;
					x = y ;
					y = P;		
		}
				 dy.setfangfa(x,y,h); 
				
		
                 lb1.setText(""+Ti());//输出题目
                 ff2 = false;
                }  
                
                
                 lb2.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
                 lb2.setText("请输入答案");

		        b3.setBounds(433,120,130,50);  //设置按钮的显示位置及宽度和高度
		        b3.setText("确认");	
		        b1.setBounds(433,10,130,50); //重置按钮位置
		        b1.setText("下一题");
		        if(ff1>1)
		        	b1.setText("请先输入答案！");
		        lb4.setText("");           //清空显示
			    lb5.setText("");           //清空显示
			    lb6.setText("");
			    lb3.setText("");           //清空显示
			    text1.setText("");
			}
		});                
		

		
		
		
		
		
        shell.open();  //打开主窗体
        while(!shell.isDisposed()){  //如果主窗体没有关闭则一直循环
        	if(!display.readAndDispatch()){  //如果display不忙
        		display.sleep();//休眠
	}
}
        		display.dispose();   //销毁display

	}
}
