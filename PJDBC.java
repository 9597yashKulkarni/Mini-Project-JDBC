import java.sql.*;

public class PJDBC 
{
	
	//public static void main(String Arg[]) throws Exception
	public String getDisease(String symptom1,String symptom2,String symptom3) throws Exception
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ProjectM","root","9597");
	//Statement st=con.createStatement();
	
	CallableStatement stmt = null;
	String sql = ("{?=call ak25 (?, ?, ?)}");
	stmt = con.prepareCall(sql);
	String sym1,sym2,sym3;
	//sym1="Weakness";
	//sym2="Pale Skin";
	//sym3="Shortness of breath";
	
	sym1=symptom1;
	sym2=symptom2;
	sym3=symptom3;
	
	stmt.registerOutParameter(1,Types.VARCHAR);
	stmt.setString(2, sym1);
	stmt.setString(3, sym2);
	stmt.setString(4, sym3);
	//ResultSet rs=stmt.executeQuery();
	
	stmt.execute();
	
	System.out.println(stmt.getString(1));
	String dis=stmt.getString(1);
	if(dis==null)
	{
		dis="Enter appropriate symptoms";
	}
	//System.out.println(dis);
	//ResultSet rs=st.executeQuery("select *from Places;");
	//ResultSet rs=null;
	//while(rs.next())
	//{
	//	String d=rs.getString("Dname");
	//	System.out.println(d);
	//}
	
	
	stmt.close();
	con.close();
	return dis; 
	//return rs;
	}
	
	//public String getPlaces(String place) throws Exception
//	public static void main(String args[]) throws Exception
	public String getPlaces(String place) throws Exception
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ProjectM","root","9597");
		
		String clinic;
		//Statement st =conn.createStatement();
		//String str="Aundh";
		//ResultSet rs=st.executeQuery("select *from Places where Area");
		
		//String query="select * from Places where Area = ?";
		PreparedStatement pst=conn.prepareStatement("select * from Places where Area = ?");
		pst.setString(1, place);
		ResultSet rs=pst.executeQuery();
		//while(rs.next())
		rs.next();
		
			System.out.println(rs.getString("Clinic1")+rs.getString("Clinic2")+rs.getString("Lab1")+rs.getString("Lab2"));
			clinic=rs.getString("Clinic1");
		
		//+rs.getString(4)+""+rs.getString(5)+""+rs.getString(6);
		pst.close();
		conn.close();
		return clinic;
	}
	
	public String getLabs(String place) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ProjectM","root","9597");
		String clinic;
		PreparedStatement pst=conn.prepareStatement("select * from Places where Area = ?");
		pst.setString(1, place);
		ResultSet rs=pst.executeQuery();
		rs.next();
		
		System.out.println(rs.getString("Clinic1")+rs.getString("Clinic2")+rs.getString("Lab1")+rs.getString("Lab2"));
		clinic=rs.getString("Lab1");
	
		//+rs.getString(4)+""+rs.getString(5)+""+rs.getString(6);
		pst.close();
		conn.close();
		return clinic;
		
	}
	
	public String getMedicine(String symptom1,String symptom2,String symptom3) throws Exception
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ProjectM","root","9597");
	//Statement st=con.createStatement();
	
	CallableStatement stmt = null;
	String sql = ("{?=call ak211 (?, ?, ?)}");
	stmt = con.prepareCall(sql);
	String sym1,sym2,sym3;
	//sym1="Weakness";
	//sym2="Pale Skin";
	//sym3="Shortness of breath";
	
	sym1=symptom1;
	sym2=symptom2;
	sym3=symptom3;
	
	stmt.registerOutParameter(1,Types.VARCHAR);
	stmt.setString(2, sym1);
	stmt.setString(3, sym2);
	stmt.setString(4, sym3);
	//ResultSet rs=stmt.executeQuery();
	
	stmt.execute();
	
	System.out.println(stmt.getString(1));
	String tab=stmt.getString(1);
	if(tab==null)
	{
		tab="Enter appropriate symptoms";
	}
	//System.out.println(dis);
	//ResultSet rs=st.executeQuery("select *from Places;");
	//ResultSet rs=null;
	//while(rs.next())
	//{
	//	String d=rs.getString("Dname");
	//	System.out.println(d);
	//}
	
	
	stmt.close();
	con.close();
	return tab; 
	//return rs;
	}
	
	
}
