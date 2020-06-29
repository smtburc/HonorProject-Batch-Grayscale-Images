import edu.duke.DirectoryResource;
import edu.duke.ImageResource;

import java.io.File;
import java.util.List;

/**
 * @author Samet Burç
 */

public class ImageSaver {

    public void doSave(List<ImageResource> imageResourceList) {
        for (ImageResource image : imageResourceList) {
            String fname = image.getFileName();
            image.setFileName(fname);
            image.draw();
            image.save();
        }
    }

}
