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
	}                   //�ĸ�������Ľ�� 
	public static String Ti(){
		if(c==1){
		ti= a+"+"+b;}
		if(c==2){
		ti= a+"-"+b;}
		if(c==3){
		ti= a+"��"+b;}
		if(c==4){
		ti= (a*b)+"��"+b;}  
		return ti;
	}                   //�����Ŀ

	public void zql(int F,int T,int JC){  //JC��ֹ���ϵ��ȷ���������Ӵ������ȷֵ
		jc = JC + jc;
		if(jc<2){
		f=F+f;t=t+T;}
	}
	public 	static String ZQL(){
 		return z = "��ȷ    "+t+"    ��                ����    "+f+"    ��                                                 ��ȷ��Ϊ    "+(((double)(double)t/(double)(t+f))*100)+"    ��    ";
	}
	//������ȷ��

	
	
	public static void main(String[] args){    
			
	    gai dy;
	    dy = new gai(); //ʵ�л�gai
        	              
	
	   
		Display display = new Display();
		final Shell shell = new Shell();
		shell.setLayout(null); 
		shell.setText("������ϰ-�������");
		shell.setSize(600, 400);		
		final Label lb2 = new Label(shell,SWT.NONE|SWT.CENTER);		
		final Label lb3 = new Label(shell,SWT.NONE|SWT.CENTER);		
		final Label lb4 = new Label(shell,SWT.NONE|SWT.CENTER);		
		final Label lb1 = new Label(shell,SWT.BORDER|SWT.RIGHT);  //�����͡������Ҷ��� //������ʾ��
		final Label lb5 = new Label(shell,SWT.NONE|SWT.CENTER);		
		final Label lb6 = new Label(shell,SWT.NONE|SWT.CENTER);
		final Label lb7 = new Label(shell,SWT.NONE|SWT.RIGHT);
		lb7.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		final Text text1 = new Text(shell,SWT.NULL|SWT.BORDER|SWT.RIGHT);  //���ô��߿���ı���
		Button b2 =new Button(shell,SWT.NONE);
		Button b3 = new Button(shell,SWT.NONE);
		Button b1 =new Button(shell,SWT.NONE);
		b2.setBounds(170,106,252,130);  //���ð�ť����ʾλ�ü���Ⱥ͸߶�
		b2.setText("��ʼ");
		b2.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				b1.setBounds(433,10,130,59);  //���ð�ť����ʾλ�ü���Ⱥ͸߶�
				b2.setBounds(0,0,0,0); 
				lb1.setBounds(10,10,400,100);
			}
			});
/*
 �����ı���text1 ֻ���������֣���cnds���������ģ�

 */
				  
		   
		  text1.addVerifyListener(new VerifyListener() {   
		   public void verifyText(VerifyEvent e) {   
		    // ���������������Ƽ����������ģ������ַ�����������   
		    // ��������֤   
		     Pattern pattern = Pattern.compile("[0-9]\\d*");   
		     Matcher matcher = pattern.matcher(e.text);   
		    if (matcher.matches()) // ��������   
		      e.doit = true;   
		    else if (e.text.length() > 0) // ���ַ����,�������ġ��ո�   
		      e.doit = false;   
		    else  
		     // ���Ƽ�   
		      e.doit = true;   
		    }
		   });           
                                            //		   �ı�����������

		  
		  
		b3.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				String s = text1.getText();//��ȡ�������
				lb7.setBounds(0,313,582,50);
			  if(text1.getText()==""){
				  lb3.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
				  lb3.setText("�������");
			  } else{ 
				  ff2 = true;          //��ʼ��
				  ff1 = 0;            //��ʼ��
				  b1.setText("��һ��");
	          int I = Integer.parseInt(s);          //ת��Ϊint�� 
		      if(I==zhengquedaan()){
		    	  dy.zql(0, 1,1);
		    	  lb3.setText("��ϲ�㣬�ش���ȷ��");
		    	  lb7.setText(""+ZQL());
		      }else{
		    	  dy.zql(1, 0,1);
		      lb4.setText(""+zhengquedaan());
	          lb3.setText("�ش����");
	          lb6.setText("��ȷ����");
	          lb6.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
	          lb4.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
	          lb7.setText(""+ZQL());}
			}
			}
		});                                          //ȷ�ϰ�ť
		
	
		
				
		

		b1.setText("��ʼ");
		b1.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				lb2.setBounds(10,135,200,50);
				lb4.setBounds(210,260,200,40);
				lb6.setBounds(10,260,200,40);
				lb3.setBounds(210,210,200,40);
				lb5.setBounds(10,210,200,40);  
				ff1 = ff1 + 1;     //�ж��Ƿ���ʾ�û������
                if(ff2){                          //��ֹ��Ŀ��û������𰸵�����¿��Ըı�ˢ�⡣
				int x = (int)(Math.random()*101);//
				int y = (int)(Math.random()*101);//	
				int h = (int)((Math.random()*4)+1);//
				jc=0;//����jc����飩
	
				text1.setBounds(210,120,200,50);    //��ʾ�ı���
				if(y > x){
					int P = x;
					x = y ;
					y = P;		
		}
				 dy.setfangfa(x,y,h); 
				
		
                 lb1.setText(""+Ti());//�����Ŀ
                 ff2 = false;
                }  
                
                
                 lb2.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
                 lb2.setText("�������");

		        b3.setBounds(433,120,130,50);  //���ð�ť����ʾλ�ü���Ⱥ͸߶�
		        b3.setText("ȷ��");	
		        b1.setBounds(433,10,130,50); //���ð�ťλ��
		        b1.setText("��һ��");
		        if(ff1>1)
		        	b1.setText("��������𰸣�");
		        lb4.setText("");           //�����ʾ
			    lb5.setText("");           //�����ʾ
			    lb6.setText("");
			    lb3.setText("");           //�����ʾ
			    text1.setText("");
			}
		});                
		

		
		
		
		
		
        shell.open();  //��������
        while(!shell.isDisposed()){  //���������û�йر���һֱѭ��
        	if(!display.readAndDispatch()){  //���display��æ
        		display.sleep();//����
	}
}
        		display.dispose();   //����display

	}
}
