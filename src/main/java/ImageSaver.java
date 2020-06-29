import edu.duke.DirectoryResource;
import edu.duke.ImageResource;

import java.io.File;
import java.util.List;

/**
 * @author Samet Burç
 */

public class ImageSaver {

    public void doSave(List<ImageResource> imageResourceList, String fNameStart) {
        for (ImageResource image : imageResourceList) {
            String fname = image.getFileName();
            String newName = fNameStart + "-" + fname;
            image.setFileName(newName);
            image.draw();
            image.save();
        }
    }

}
