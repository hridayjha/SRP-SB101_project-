package StudentDao;

public interface StudentDao {

	
	abstract void addCourse(int id,String name,int seat,int fees);
	abstract void updateFees(int id,int fees);
	abstract void updateSeat(int id,int seat);
	abstract void dltCor(int id);
	abstract void corDet(int id);
	abstract void allocateStudent(String name,String email,int password,int courseId);
	abstract void viewDet();
	void updateName(int id,String name);
	void updaEmail(int id,String email);
	void updatePassword(int id,int password);
	void updateBatch(int id,int batchId);
	void courseDet();
	
	//abstract void registerStudent(String name,String email, int password, int batchid);
}
