package ie.gmit.sw;

public class AssignAJob 
{
	// private variables
	private static final long serialVersionUID = 1L;
	private String algo;
	private String str1;
	private String str2;
	private String jobNum;
	
	public static long getUid()
	{
		return serialVersionUID;
	}

	// makes AssignAJob a super class
	public AssignAJob()
	{
		super();
	}
	
	// Request method
	public void Req(String String1, String String2, String algo, String jobNum)
	{
		this.str1 = String1;
		this.str2 = String2;
		this.algo = algo;
		this.jobNum = jobNum;

	}
	// getAlgo method
	public String getAlgo() 
	{
		return algo;
	}
	//getAlgo method
	public void setAlgo(String algo)
	{
		this.algo = algo;
	}

	//geString1
	public String getString1() 
	{
		return str1;
	}
	// setString1
	public void setString1(String string1) 
	{
		str1 = string1;
	}
	//getString2
	public String getString2() 
	{
		return str2;
	}

	//setString2
	public void setString2(String string2) 
	{
		str2 = string2;
	}

	//getJobNum
	public String getJobNum() 
	{
		return jobNum;
	}

	//setJobNum
	public void setJobNum(String jobNum) // same as in AlgStrs
	{
		this.jobNum = jobNum;
	}

}