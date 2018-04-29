import javax.swing.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WelcomeScreen //extends JFrame
{
	JFrame f;//rame;  
	WelcomeScreen()
	{
		f=new JFrame();
		Font font=new Font("Vederna",Font.PLAIN,30);
		Font head=new Font("SanSerif",Font.BOLD,60);
		Font warning=new Font("SanSerif",Font.PLAIN,20);
		//EventQueue.invokeLater(new Runnable() 
		{
            //@Override
          //  public void run() 
            {
                //try 
                {
                   // UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } //catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex)
                {
                }

                FocusListener highlighter = new FocusListener()
                {
					
					@Override
					public void focusLost(FocusEvent e)
					{
						// TODO Auto-generated method stub
						e.getComponent().setBackground(UIManager.getColor("TextField.background"));

					}
					
					@Override
					public void focusGained(FocusEvent e)
					{
						// TODO Auto-generated method stub
						e.getComponent().setBackground(Color.yellow);
					}
				};
		//JPanel f=(JPanel)frame.getContentPane();
		JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0,-500,2000,2000);
        lblNewLabel.setSize(2000, 2000);
        lblNewLabel.setIcon(new ImageIcon("/home/yash/Downloads/Drlogo.jpg"));
		//f.add(lblNewLabel);
		
		JLabel Lname=new JLabel("Name");
		Lname.setBounds(100,100,100,40);
        Lname.setFont(font);
        
        JLabel Lage=new JLabel("Age");
        Lage.setBounds(100,200,100,40);
        //Font font=new Font("Vederna",Font.PLAIN,30);
        Lage.setFont(font);
       
        JLabel Lmob=new JLabel("Mobile no");
        Lmob.setBounds(100,300,200,40);
        Lmob.setFont(font);
        f.add(Lmob);
       
        JLabel Lmail=new JLabel("Mail");
        Lmail.setBounds(100,400,400,40);
        Lmail.setFont(font);
        f.add(Lmail);
        
        JTextField Tname=new JTextField();
        Tname.setBounds(250,100,500,40);
        Tname.setFont(font);
        String Pname=Tname.getText();
       // Tname.addKeyListener(Color.);
              
        JTextField Tage=new JTextField();
        Tage.setBounds(250,200,150,40);
        Tage.setFont(font);
        //int Page=Integer.parseInt(Tage.getText());
        //System.out.println(Page);
        
       final JTextField Tmob=new JTextField(10);
        Tmob.setBounds(250,300,300,40);
        Tmob.setFont(font);
        f.add(Tmob);
               
        JTextField Tmail=new JTextField();
        Tmail.setBounds(250, 400, 400, 40);
        Tmail.setFont(font);
        f.add(Tmail);
        
        Tname.addFocusListener(highlighter);
        Tmail.addFocusListener(highlighter);
        Tage.addFocusListener(highlighter);
        Tmob.addFocusListener(highlighter);
        
        JLabel K=new JLabel("The K's");
        K.setBounds(850,900,600,60);
        K.setFont(head);
        
        JButton nxt=new JButton("Next");
        nxt.setBounds(150,620,400,40);
        
        nxt.addActionListener(new ActionListener()
        {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				//f.getDefaultCloseOperation();
				
				String pname=Tname.getText();
				String pmail=Tmail.getText();
				Pattern pat=Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
				Matcher matcher=pat.matcher(pmail);
				String mob=Tmob.getText();
				
				int age=Integer.parseInt(Tage.getText());
				
				Pattern pat1=Pattern.compile("\\d{10}");
				Matcher matcher1=pat1.matcher(mob);
				if(matcher1.matches()&&matcher.matches())
				{
					System.out.println(mob);
					System.out.println(pmail);
					try
					{
						new Pgui();
					} catch (Exception e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					f.setVisible(false);// added to close
				}
				else
				{
					Tmob.setText("Enter appropriate number");
					Tmob.setFont(warning);
					Tmail.setText("Enter appropriate mail id");
					Tmail.setFont(warning);
					new JoptionPane();
				}
			}
        });
        
        f.add(K);
        f.add(Lname);
		f.add(nxt);
		f.add(Lage);
		f.add(Tname);
		f.add(Tage);
		
		f.setLayout(null);    
		f.add(lblNewLabel);
		f.setSize(2000,2000);    
		f.setVisible(true);
	
           }
        }//);
	}

	public static void main(String args[])
	{
		new WelcomeScreen();
	}
}





