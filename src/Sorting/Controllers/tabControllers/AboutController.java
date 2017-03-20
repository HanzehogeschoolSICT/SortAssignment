package Sorting.Controllers.tabControllers;

import Sorting.App;
import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import com.sun.javafx.application.HostServicesDelegate;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;

/**
 * Class AboutControllers
 *
 * @author koen
 * @version 0.1 (3/2/17)
 */
public class AboutController {

    @FXML
    public Hyperlink githubLink;

    @FXML
    private void openGithub(){
        HostServicesDelegate hostServices = HostServicesFactory.getInstance(new App());
        hostServices.showDocument("https://github.com/HanzehogeschoolSICT/SortAssignment");
    }
}
