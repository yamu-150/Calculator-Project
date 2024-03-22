import java.awt.*;

import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
class CalculatorPopUp  implements ActionListener {
	JFrame frame=new JFrame();
	JTextArea textarea1=new JTextArea();
    JButton button =new JButton();
    JButton okbutton;
    
    public CalculatorPopUp()
    {
    	//frame designing
    	frame.setSize(300,230);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setTitle("Popup");
    	frame.setVisible(true);
    	frame.setLayout(null);
    	
    	//textarea 
    	textarea1.setBounds(40,45,200,50);
    	textarea1.setEditable(false);
    	
    	//buttons
    	okbutton =new JButton("ok");
    	okbutton.setBounds(200,130,50,40);
    	okbutton.addActionListener(this);
    	
    	frame.add(okbutton);
    	frame.add(textarea1);
    	frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==okbutton)
		{
			System.exit(0);
		}
	}
}
public class Calculatorapp  implements ActionListener
{
  JFrame frame=new JFrame();
 
  JPanel panel=new JPanel();
  JTextArea textarea =new JTextArea();
  JButton[] numberbuttons =new JButton[10];
  JButton[] functionbuttons =new JButton[7];
  JButton addbutton,subbutton,mulbutton,divbutton,equalbutton,clrbutton,dotbutton;
   double number1,number2 ,result;
   char operator;
  
  
   public Calculatorapp()
   {
	   //frame designing
	   frame.setSize(300,420);
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setTitle("CALCULATOR");
	   frame.setResizable(false);
	   frame.setLayout(null);
	   
	  //textarea designing
	   textarea.setBounds(40, 25, 200, 50);
	   textarea.setEditable(false);
	   textarea.setBackground(Color.WHITE);
	   
	   //function buttons 
	   addbutton=new JButton("+");
	   subbutton=new JButton("-");
	   mulbutton=new JButton("*");
	   divbutton=new JButton("/");
	   clrbutton=new JButton("c");
	   equalbutton=new JButton("=");
	   dotbutton=new JButton(".");
	   
	   functionbuttons[0]=addbutton;
	   functionbuttons[1]=subbutton;
	   functionbuttons[2]=mulbutton;
	   functionbuttons[3]=divbutton;
	   functionbuttons[4]=clrbutton;
	   functionbuttons[5]=equalbutton;
	   functionbuttons[6]=dotbutton;
	   
	   
	   for(int i=0;i<7;i++)
	   {
		   functionbuttons[i].addActionListener(this);
		   functionbuttons[i].setFocusable(false); 
	   }
	
	   //number buttons
	   for(int i=0;i<10;i++)
	   {
		   numberbuttons[i]=new JButton(String.valueOf(i));
		   numberbuttons[i].addActionListener(this);
		   numberbuttons[i].setFocusable(false);
	   }
	   
	  //panel designing
	   panel.setBounds(40, 100, 200, 200);
	   panel.setLayout(new GridLayout(4,4,10,10));
	   panel.setBackground(Color.WHITE);
	 
	   //number buttons assigning
	   for(int i=7;i<10;i++)
	  {
		  panel.add(numberbuttons[i]);
	  }
	   panel.add(mulbutton);
	   for(int i=4;i<7;i++)
	  {
		  panel.add(numberbuttons[i]);
	  }

	   panel.add(subbutton);
	   for(int i=1;i<4;i++)
	  {
		  panel.add(numberbuttons[i]);
	  }
	   panel.add(addbutton);
	   panel.add(clrbutton);
	   panel.add(numberbuttons[0]);
	   panel.add(dotbutton);
	   panel.add(equalbutton);
	   
	   //adding all to frame
       frame.add(panel);
       frame.add(textarea);
	   
	   frame.setVisible(true);
   }   

public static void main (String args[])
	{
		Calculatorapp calc= new Calculatorapp();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
        for(int i=0;i<10;i++)
        {
        	if(e.getSource()==numberbuttons[i])
        	{
        	textarea.setText(textarea.getText().concat(String.valueOf(i)));	
        	}
        }
        if(e.getSource()==dotbutton)
        	{
        	textarea.setText(textarea.getText().concat("."));
        	}
        if(e.getSource()==addbutton)
        {
        	number1=Double.parseDouble(textarea.getText());
        	operator='+';
        	textarea.setText("");
        }
        if(e.getSource()==subbutton)
        {
        	number1=Double.parseDouble(textarea.getText());
        	operator='-';
        	textarea.setText("");
        }
        if(e.getSource()==mulbutton)
        {
        	number1=Double.parseDouble(textarea.getText());
        	operator='*';
        	textarea.setText("");
        }
        if(e.getSource()==divbutton)
        {
        	number1=Double.parseDouble(textarea.getText());
        	operator='/';
        	textarea.setText("");
        }
        if(e.getSource()==equalbutton)
        {
        	number2=Double.parseDouble(textarea.getText());
        	switch(operator)
        	{
        	case'+':
        	{
        		result=number1+number2;
        		break;
        	}
        	case'-':
        	{
        		result=number1-number2;
        		break;
        	}
        	case'*':
        	{
        		result=number1*number2;
        		break;
        	}
        	case'/':
        	{
        		result=number1/number2;
        		break;
        	}
        	}
        	textarea.setText(String.valueOf(result));
        		{
        		CalculatorPopUp obj=new CalculatorPopUp();
        		obj.textarea1.setText(String.valueOf(result));
        		
        		}
        	number1=result;
        }
        if(e.getSource()==clrbutton)
        {
        	textarea.setText("");
        }
        }
		
		}
	

