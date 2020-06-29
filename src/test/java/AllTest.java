/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 *
 * @author Samet Burç
 */

import org.junit.Test;

public class AllTest {

    IBatchConverter grayScale=new BatchGrayScale();
    IBatchConverter inversions=new BatchInversions();

    @Test
    public void testGrayScale(){
        grayScale.selectAndConvert();
    }

    @Test
    public void testInversions(){
        inversions.selectAndConvert();
    }
}
