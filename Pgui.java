import javax.swing.*; 
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.*;    
import java.awt.font.*;
import java.sql.*;

public class Pgui 
    {    
    JFrame f;  
    PJDBC p=new PJDBC();
   // WelcomeScreen ws=new WelcomeScreen();
    
    Pgui() throws Exception
    {    
        f=new JFrame("Disease Information System"); 
       // f.setBackground(Color.LIGHT_GRAY);
        Font font=new Font("",Font.PLAIN,30);
        
        JTextField label1=new JTextField("Disease is....");
        label1.setBounds(150,450,550,50);
        label1.setEditable(false);
        label1.setBackground(Color.orange);
        label1.setFont(font);
        
        JTextField label4=new JTextField("Tablet is....");
        label4.setBounds(800,450,500,50);
        label4.setEditable(false);
        label4.setBackground(Color.orange);
        label4.setFont(font);
        
        JLabel bgd = new JLabel("");
        bgd.setBounds(0,-500,2000,2000);
        bgd.setSize(2000, 2000);
        bgd.setIcon(new ImageIcon("/home/yash/Downloads/Drlogo.jpg"));
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(1200,-300,800,2000);
        lblNewLabel.setIcon(new ImageIcon("/home/yash/Downloads/MaleDoc.png"));
		
        f.add(lblNewLabel);
      
      /*  JTextArea Rmap=new JTextArea("Welcome...\nThis software will tell you the the disease according to the symptoms you entered."
        		+ "\nYou must insert 3 symptoms for getting disease");
        Rmap.setBounds(50,50,1500,150);
        Rmap.setEditable(false);
        Rmap.setFont(font);
        Rmap.setBackground(Color.LIGHT_GRAY);
        */
        
        final JTextField label2=new JTextField("Hospitals near you......");
        label2.setBounds(200,680,650,50);
        label2.setEditable(false);
        label2.setBackground(Color.orange);
        label2.setFont(font);
        //label2.setHorizontalAlignmet(JLabel.CENTER);
        //label2.setSize(700,850);
        
        final JTextField label3=new JTextField("Labs near you......");
        label3.setBounds(200,810,650,50);
        label3.setEditable(false);
        label3.setBackground(Color.orange);
        label3.setFont(font);
        
        JButton b1=new JButton("Check");  
        b1.setBounds(150,350,200,40);
        //b1.setBackground(Color.LIGHT_GRAY);
        b1.setFont(font);
        
        JButton b2=new JButton("Display clinics");
        b2.setBounds(150,620,400,40);
        b2.setFont(font);
        
        JButton b3=new JButton("Display Labs");
        b3.setBounds(600,620,400,40);
        b3.setFont(font);
        
        JButton b4=new JButton("Tablets");
        b4.setBounds(500,350,300,40);
        b4.setFont(font);
        b4.setToolTipText("Coming Soon!!!");
        
        //String col1=p.getCol1();
        String sym1[]={"-Select Symptom-","Weakness","Genral stress","fainting","headache","Aura-visual disturbance","redness of eyes","snezzing ",
        		"nasal headache","mild or severe headache","irregular heartbeat and/or chest pain","loss of appetite and/or vomiting"
        		,"sudden collapse and/or temporary loss of vision","itching and/or burning sensation of scalp",
        		"diabetic coma(Unconsciousness)include polyuria","lump or swelling","Sweaty palms and feet and/or cold hands",
        		"hair loss and/or weight gain","severe or sharp pain in abdomen or back or side part or of body","Sensations of shortness of breath",
        		"end-organ damage",
        		"hydrophobia","runny or stffy nose and/or diarrhoea","red face and ears","bad chronic cough and/or coughing up blood",
        		"depression and/or swelling in the area to the lower left of the front rib cage",
        		"nerve injury or weight loss","pain in back or muscles and/or fever or chills","bloating,nausea and/or cancer related fatigue",
        		"muscle weakness,or severe headache,or reduced sensation of touch",
        		"loss of appetite,or headache","cold sweat,or nausea,or vomiting,or heartburn","vomiting,or fever,or abdominal pain",
        		"Rarely,long-term damage to lymph system",
        		"pain in or arround eye and/or blurred vision","severe weight loss,or shortnessof breath",
        		"headache,or loss of appetite","nausea or vomiting","skin rashes mostly red due to heat",
        		"pain in abdomen ,or electrolyte imbalance","headache,or rash"};        
       final JComboBox cb1 =new JComboBox(sym1);    
     
       /* // JComboBox cb1=new JComboBox();
        String str=null;
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","9597");
		Statement st=conn.createStatement();
		ResultSet col1=st.executeQuery("select symptom1 from Symptoms");
		while(col1.next())
		{
			cb1.addItem(col1.getString(2));
		}
		System.out.println(str);*/
       
        cb1.setBounds(150,100,850,40);    
        cb1.setBackground(Color.WHITE);
        cb1.setToolTipText("Must select 3 symptoms");
        cb1.setFont(font);
        
      	String sym2[]={"-Select symptom-","Pale Skin","Anger","headache similar to those caused during hangover","joint and muscular pain","Chest pain","irritation of eyes","cough with phlegm",
      			"cough with phlegm","painful cough","lightheadedness and/or blurred vision and/or nausea","abdominal pain on right side of belly",
      			"abdominal pain on right side of belly","dry scalp and/or temporary hair loss",
      			"smell of acetone on the patient's breath","shortness of breath/weight gain","Diarrhea and/or nausia",
      			"Slowed metabolism and/or constipation","sweating or nausea or vomiting","Sweating and/or shaking","headaches",
      			"flu like symptoms for three to twelve weeks","dry cough and/or headache","rattling sound in the throat",
      			"chest pains and/or hoarse voice","jaundice and/or significant weight loss","reduced sensation of touch,pins and needles",
      			"skin rashes or scab","pain in abdomenand/or mood swings","mental confusion,or balance disorder","fatigue and/or fever",
      			"anxiety,or abnormal heartbeat","itchiness,or fatigue,orWeight loss","harden and thiken skin due to bacterial infection",
      			"a dark patch in your eye that's getting bigger","loss of muscle,or phlegm,or malaise","diarrhoea,or waekness,or vomiting",
      			"muscles or abdominal pain","rashes as blister,or red lumps","nausea,or vomiting","muscle pain,or joint swelling"
      			};
      	final JComboBox cb2=new JComboBox(sym2);
      	cb2.setBounds(150,180,850,40);
      	cb2.setBackground(Color.WHITE);
      	cb2.setToolTipText("Must select 3 symptoms");
      	cb2.setFont(font);
      	
        String sym3[]={"-Select symptom-","fever and joint pain","severe diarrhoea and dehydration","flushing or itching",
        		"chills,fever and sweating few weeks after being bitten ","high fever,or muscle weakness,skin rash",
        		"chronic cough or with blood and/or chest pain","shadows,flashes of light,or wiggly lines in your vision",
        		"swelling or swollen lymph nodes","yellow tinge to the skin and whites of eyes","shortness of breath,or pain in chest,neck,back"
        		,"itchy,blister-like rash on skin,red spots","blurred vision,personality change,or sleepiness"
        		,"itching,weight loss, or yellow skin and eyes","headache or vomiting and/or malaise",
        		"loss of skin colour or rashes on skin or redness of skin","abdominal pain and/or digestive difficulties",
        		"weight loss or loss of appetite and/or fatigue","sudden collapse and/or loss of consciousness and/or coma",
        		"sore throad and/or fatigue or fever","infection by animal bite","burred vision",
        		"Feeling of choking and/or chest pain","blood in urinr or frequent urination and/or pain may occur during urination",
        		"Dry puffy skin especially on the face","frequent headaches and/or lack of ability to concentrate",
        		"fast heart rate and/or throat tightness","nausea/vomiting and abdominal pain",
        		"dandruff like flaking and white scalp,irritation and/or bleeding",
        		"loss of conciousness","jaundice(yellow eyes and/or skin and/or dark urine)",
        		"inability to eat or drink,burning with urination",
        		"fever with shaking chills and/or sharp chest pain","facial swelling","coughing fits",
        		"watering of eyes","moderate to severe pain on both sides of head and pain may get worse with movement",
        		"sudden high fever and up-down in fever temprature","loss of fluids due to trauma loose stools and/or vomiting",
        		"Rapid breathing","Shortness of breath"};
        final JComboBox cb3=new JComboBox(sym3);
        cb3.setBounds(150,260,850,40);
        cb3.setBackground(Color.WHITE);
        cb3.setToolTipText("Must select 3 symptoms");
        cb3.setFont(font);
        
        String Places[]= {"-Select Places-","Akurdi","Aundh","Baner","Deccan",/*"Hadapsar",*/"Hinjewadi",/*"Katraj/Satra Road",*/"Kothrud","Magarpatta",/*"Narhe/Ambegaon-BK",*/
        		"Nigadi",/*"Pimpri-Chinchwad",*/"Pune Station","Shivaji Nagar","Swargate","Wagholi",/*"Warje/Sihgad"*/};
        final JComboBox cb4=new JComboBox(Places);
        cb4.setBounds(150,550,850,40);
        //cb4.setToolTipText("Must select 3 symptoms");
        cb4.setFont(font);
        cb4.setBackground(Color.WHITE);
        JOptionPane jpane;
        
        f.add(cb1);
        f.add(cb2);
        f.add(cb3);
        f.add(cb4);
        
        f.add(label1);
        f.add(label2);
        f.add(label3);
        f.add(label4);
        //f.add(Rmap);
        f.add(b1);    
        f.add(b2);
        f.add(b3);
        f.add(b4);
        
        f.add(bgd);
        f.setLayout(null);    
        f.setSize(2000,2000);    
        f.setVisible(true);       
        
        b1.addActionListener(new ActionListener() 
        {  
         	public void actionPerformed(ActionEvent e) 
         	{       
         	System.out.println(cb1.getItemAt(cb1.getSelectedIndex())+""+cb2.getItemAt(cb2.getSelectedIndex())+""
         	+cb3.getItemAt(cb3.getSelectedIndex()));
         	String symptom1 = 
         	""+cb1.getItemAt(cb1.getSelectedIndex())+"";
    	 	String symptom2=
    	 	""+cb2.getItemAt(cb2.getSelectedIndex())+"";
    	 	String symptom3=""+cb3.getItemAt(cb3.getSelectedIndex())+"";  
    		
    		try 
    		{
				String Dis=p.getDisease(symptom1,symptom2,symptom3)+"";
				label1.setText(Dis); 
			} catch (Exception e1) 
    		{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		}  
    	}); 
        
        b2.addActionListener(new ActionListener()
        {  
         	public void actionPerformed(ActionEvent e2) 
         	{       
         		String  area=cb4.getItemAt(cb4.getSelectedIndex())+"";
         		System.out.println(cb4.getItemAt(cb4.getSelectedIndex()));
         		
         		try {
					String clinic=p.getPlaces(area);
         			label2.setText(clinic);
         			} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
         		
         	}
        });
    	
        b3.addActionListener(new ActionListener() {
		@Override
			public void actionPerformed(ActionEvent arg0) {
			//System.out.println("Comming soon");
			//label3.setText("comming soon");
				String area=cb4.getItemAt(cb4.getSelectedIndex())+"";
				try {
					String lab=p.getLabs(area);
					label3.setText(lab);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
        
        b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(cb1.getItemAt(cb1.getSelectedIndex())+""+cb2.getItemAt(cb2.getSelectedIndex())+""
			         	+cb3.getItemAt(cb3.getSelectedIndex()));
			         	String symptom1 = 
			         	""+cb1.getItemAt(cb1.getSelectedIndex())+"";
			    	 	String symptom2=
			    	 	""+cb2.getItemAt(cb2.getSelectedIndex())+"";
			    	 	String symptom3=""+cb3.getItemAt(cb3.getSelectedIndex())+"";  
			    		
			    		try 
			    		{
							String tab=p.getMedicine(symptom1,symptom2,symptom3)+"";
							label4.setText(tab); 
						} catch (Exception e1) 
			    		{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
			}
		});
    	//String symptom2=cb2.getItemAt(cb2.getSelectedIndex());
    	//String symptom3=cb3.getItemAt(cb3.getSelectedIndex());    
      	//System.out.println(symptom3);      
        }    
    public static void main(String[] args) 
    {    
    	new WelcomeScreen();
    	//new Pgui();
        
    }    
    
    }    