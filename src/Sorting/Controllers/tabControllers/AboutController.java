package Sorting.Controllers.tabControllers;

import Sorting.App;
import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import com.sun.javafx.application.HostServicesDelegate;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;

/**
 * Created by koen on 3/2/17.
 */
public class AboutController {

    @FXML
    public Hyperlink githubLink;

    public void initialize(){
        System.out.println("About Controller init");
    }

    @FXML
    private void openGithub(){
        HostServicesDelegate hostServices = HostServicesFactory.getInstance(new App());
        hostServices.showDocument("https://github.com/KoenHendriks/SortAssignment");
    }
}
