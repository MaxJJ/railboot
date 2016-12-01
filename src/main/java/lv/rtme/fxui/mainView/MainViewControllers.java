package lv.rtme.fxui.mainView;

import java.io.IOException;
import java.io.InputStream;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Controllers and Views for MainView
  */
@Configuration
public class MainViewControllers {

    @Bean(name = "topPaneView")
    public View getMainView() throws IOException {
        return loadView("fxml/topPaneMainView.fxml");
    }
    
   
 
    
      @Bean
    public TopPaneController getTopPaneController() throws IOException {
        return (TopPaneController) getMainView().getController();
    }
    
    protected View loadView(String url) throws IOException {
        InputStream fxmlStream = null;
        try {
            fxmlStream = getClass().getClassLoader().getResourceAsStream(url);
            FXMLLoader loader = new FXMLLoader();
            
            loader.load(fxmlStream);
            return new View(loader.getRoot(), loader.getController());
        } finally {
            if (fxmlStream != null) {
                fxmlStream.close();
            }
        }
    }

    public class View {
        private Parent view;
        private Object controller;

        public View(Parent view, Object controller) {
            this.view = view;
            this.controller = controller;
        }

        public Parent getView() {
            return view;
        }

        public void setView(Parent view) {
            this.view = view;
        }

        public Object getController() {
            return controller;
        }

        public void setController(Object controller) {
            this.controller = controller;
        }
    }

}
