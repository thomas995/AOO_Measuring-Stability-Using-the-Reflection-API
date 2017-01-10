package ie.gmit.sw;


/**
 * @author Thomas
 *
 */
public class MetricsChecker
{

	Test_AffEff TAE = new Test_AffEff(); // new instance of the test class

	// variables
	public int afferentCouplings = Test_AffEff.AffCouplings();
    public int efferentCouplings = Test_AffEff.EffCouplings();
    private String className;

    // getters and setters
    /**
     * @return
     */
    public String getClassName()
    {
        return className;
    }

    /**
     * @param className
     */
    public void setClassName(String className)
    {
        this.className = className;
    }

    /**
     * @return
     */
    public int getAfferentCouplings()
    {

        return afferentCouplings;
    }


    /**
     * @param afferentC
     */
    public void setAfferentCouplings(int afferentC)
    {
        this.afferentCouplings = afferentC;
    }


    /**
     * @return
     */
    public int getEfferentCouplings()
    {
        return efferentCouplings;
    }
    /**
     * @param efferentC
     */
    public void setEfferentCouplings(int efferentC)
    {
        this.efferentCouplings = efferentC;
    }

    /**
     * @return
     */
    public double getStability()
    {
        double stability = 1d; // double is used due to possibility of decimal numbers

        // error handling in case answer is zero or we end up dividing by zero
        try
        {
            if(getEfferentCouplings() > 0)
            {
                // calculate stability using casts to force them to be doubles
                stability = ((double) getEfferentCouplings() / ((double) getAfferentCouplings() + (double) getEfferentCouplings()));
            }
            else
            {
                // stability is equal to zero - STABLE
                stability = 0;
            }
        } catch (Exception e)
        {
            // error handling results in zero being set for stability
            stability = 0;
        }
        return stability;
    }
}