import edu.duke.DirectoryResource;
import edu.duke.ImageResource;

import java.io.File;

/**
 * @author Samet Burç
 */

public class ImageSaver {
    public void doSave() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource image = new ImageResource(f);
            String fname = image.getFileName();
            String newName = "copy-" + fname;
            image.setFileName(newName);
            image.draw();
            image.save();
        }
    }

}
