import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Samet Burç
 */

public class BatchGrayScale implements IBatchConverter {

    public ImageResource makeGray(ImageResource inImage) {

        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());

        for (Pixel pixel: outImage.pixels()) {

            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());

            int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;

            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
        }
        return outImage;
    }

    @Override
    public void selectAndConvert () {
        List<ImageResource> convertedList=new ArrayList<>();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = makeGray(inImage);
            gray.setFileName("gray-"+f.getName());
            convertedList.add(gray);
        }
        new ImageSaver().doSave(convertedList);
    }


}
