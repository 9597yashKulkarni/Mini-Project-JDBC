import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JoptionPane
{
	JFrame f;
	JoptionPane()
	{
		f=new JFrame();
		JOptionPane.showMessageDialog(f,"Enter appropriate data","Alert",JOptionPane.WARNING_MESSAGE);
	}
}
