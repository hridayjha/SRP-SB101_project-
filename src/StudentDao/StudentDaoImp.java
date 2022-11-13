package StudentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utility.DbUtil;

public class StudentDaoImp implements StudentDao{
	
	

	@Override
	public void addCourse(int id, String name, int seat,int fees) {
	
		Connection con= DbUtil.provideConnection();
		
		
		try {
		PreparedStatement ps=	con.prepareStatement("insert into course values(?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, seat);
		ps.setInt(4, fees);
		
	int x=	ps.executeUpdate();
	if(x>0)System.out.println("course inserted succesfully!!");
	
		} catch (SQLException e) {
		System.out.println("Not inserted try again!!!");
		}
		
		
		
		
	}

	@Override
	public void updateFees(int id, int fees) {
		// TODO Auto-generated method stub
		Connection con= DbUtil.provideConnection();
		
		try {
		PreparedStatement ps=	con.prepareStatement(" update course set fees=? where corid=?");
		ps.setInt(1, fees);
		ps.setInt(2, id);
		int x= ps.executeUpdate();
		if(x>0)System.out.println("course fee updated successfully!!");
		else System.out.println("not updated try again!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("not updated try again!!!");
		}
		
	}

	@Override
	public void dltCor(int id) {
		// TODO Auto-generated method stub
Connection con= DbUtil.provideConnection();
		
		try {
		PreparedStatement ps=	con.prepareStatement(" delete from course where corid=?");
	
		ps.setInt(1, id);
		int x= ps.executeUpdate();
		if(x>0)System.out.println("course deleted from trainning session successfully!!");
		else System.out.println("course not deleted try again!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("course not deleted try again!!!");
		}
		
		
		
	}

	@Override
	public void corDet(int id) {
Connection con= DbUtil.provideConnection();
		
		try {
		PreparedStatement ps=	con.prepareStatement("select * from course where corid=?");
	
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs!=null) {
		while(rs.next()) {
			System.out.println("Course id -"+rs.getInt("corid"));
			System.out.println("Batch -"+rs.getString("batch"));
			System.out.println("Course fees -"+rs.getInt("fees"));
			System.out.println("Seat avilablity -"+rs.getInt("seats"));
			System.out.println("===================================");
		}}
		else {
			System.out.println("record not found");
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
			System.out.println("syntex error try again!!!");
		}
		
		
	}

	@Override
	public void allocateStudent(String name, String email, int pass, int corId) {
		Connection con= DbUtil.provideConnection();
		
		try {
			PreparedStatement ps1= con.prepareStatement("select * from course where corid=?");
			ps1.setInt(1, corId);
		ResultSet rs1=	ps1.executeQuery();
		int seat=0;
		if(rs1!=null) {
			while(rs1.next()) {
				seat=rs1.getInt("seats");
			}
			
			if(seat>=1) {
				PreparedStatement ps2= con.prepareStatement("update course set seats=seats-1 where corid=?");
				ps2.setInt(1, corId);
				int x=ps2.executeUpdate();
				if(x>0) {
					System.out.println("Seat allocated sucessfully");
				
				PreparedStatement ps3= con.prepareStatement("insert into students (name, email, pass, batchid) values (?,?,?,?)");
				//ps3.setInt(1, id);
				ps3.setString(1, name);
				ps3.setString(2, email);
				ps3.setInt(3, pass);
				ps3.setInt(4,corId);
				
			int y=	ps3.executeUpdate();
			//System.out.println(ps3.executeUpdate());
			//System.out.println("kgcghghgchghcghghgc");
			//System.out.println(y);
			if(y>0)System.out.println("student added in the bactch sucessfully");
			else System.out.println("student not added please try again");
				
				
			}
			}else System.out.println("seat not allocated try again!!");
		}
		else System.out.println("Course not foound!!!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			//e.printStackTrace();
		}
		
		
	}

	@Override
	public void viewDet() {
Connection con= DbUtil.provideConnection();
		
		try {
		PreparedStatement ps=	con.prepareStatement("select * from students");
	
		
		ResultSet rs = ps.executeQuery();
		if(rs!=null) {
		while(rs.next()) {
			System.out.println("Student roll number - "+rs.getInt("id"));
			System.out.println("Student name - "+rs.getString("name"));
			System.out.println("Student email - "+rs.getString("email"));
			System.out.println("Student password - "+rs.getInt("pass"));
			System.out.println("Course id - "+rs.getInt("batchId"));
			System.out.println("===================================");
		}}
		else {
			System.out.println("record not found");
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
			System.out.println("syntex error try again!!!");
		}
		
		
		
	}

	
	
	@Override
	public void updateSeat(int id, int seat) {
Connection con= DbUtil.provideConnection();
		
		try {
		PreparedStatement ps=	con.prepareStatement(" update course set seats = ? where corid=?");
		ps.setInt(1, seat);
		ps.setInt(2, id);
		int x= ps.executeUpdate();
		if(x>0)System.out.println("course seats updated successfully!!");
		else System.out.println("not updated try again!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			//System.out.println("not updated try again!!!");
		}
		
	}

	@Override
	public void updateName(int id, String name) {
		
Connection con= DbUtil.provideConnection();
		
		try {
		PreparedStatement ps=	con.prepareStatement(" update students set name=? where id=?");
		ps.setString(1, name);
		ps.setInt(2, id);
		int x= ps.executeUpdate();
		if(x>0)System.out.println("name  updated successfully!!");
		else System.out.println("not updated try again!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("not updated try again!!!");
		}
		
		
		
	}

	@Override
	public void updaEmail(int id, String email) {
Connection con= DbUtil.provideConnection();
		
		try {
		PreparedStatement ps=	con.prepareStatement(" update students set email=? where id=?");
		ps.setString(1, email);
		ps.setInt(2, id);
		int x= ps.executeUpdate();
		if(x>0)System.out.println("email updated successfully!!");
		else System.out.println("not updated try again!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("not updated try again!!!");
		}
		
	}

	@Override
	public void updatePassword(int id, int pass) {
		// TODO Auto-generated method stub
Connection con= DbUtil.provideConnection();
		
		try {
		PreparedStatement ps=	con.prepareStatement(" update students set pass=? where id=?");
		ps.setInt(1, pass);
		ps.setInt(2, id);
		int x= ps.executeUpdate();
		if(x>0)System.out.println("password updated successfully!!");
		else System.out.println("not updated try again!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("not updated try again!!!");
		}
		
	}

	@Override
	public void updateBatch(int id, int batchId) {
		// TODO Auto-generated method stub
Connection con= DbUtil.provideConnection();
		
		try {
		PreparedStatement ps=	con.prepareStatement(" update students set batchId=? where id=?");
		ps.setInt(1, batchId);
		ps.setInt(2, id);
		int x= ps.executeUpdate();
		if(x>0)System.out.println("batch  updated successfully!!");
		else System.out.println("not updated try again!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("not updated try again!!!");
		}
		
	}

	@Override
	public void courseDet() {
Connection con= DbUtil.provideConnection();
		
		try {
		PreparedStatement ps=	con.prepareStatement("select * from course ");
	
		//ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs!=null) {
		while(rs.next()) {
			System.out.println("Course id -"+rs.getInt("corid"));
			System.out.println("Batch -"+rs.getString("batch"));
			System.out.println("Course fees -"+rs.getInt("fees"));
			System.out.println("Seat avilablity -"+rs.getInt("seats"));
			System.out.println("===================================");
		}}
		else {
			System.out.println("record not found");
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
			System.out.println("syntex error try again!!!");
		}
		
		
	}

}
