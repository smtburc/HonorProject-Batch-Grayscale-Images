import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BatchInversions implements IBatchConverter {

    public ImageResource makeInversion(ImageResource inImage) {

        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());

        for (Pixel pixel: outImage.pixels()) {

            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());

            pixel.setRed(255-inPixel.getRed());
            pixel.setGreen(255-inPixel.getGreen());
            pixel.setBlue(255-inPixel.getBlue());
        }
        return outImage;
    }

    @Override
    public void selectAndConvert () {
        List<ImageResource> convertedList=new ArrayList<>();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource inversions = makeInversion(inImage);
            inversions.setFileName("inverted-"+f.getName());
            convertedList.add(inversions);
        }
        new ImageSaver().doSave(convertedList);
    }

}
