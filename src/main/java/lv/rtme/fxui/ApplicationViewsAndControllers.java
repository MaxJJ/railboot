package lv.rtme.fxui;

import java.io.IOException;
import java.io.InputStream;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javax.annotation.PostConstruct;
import lv.rtme.fxui.controllers.MainEditorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Controllers and Views for MainView
  */
@Configuration
public class ApplicationViewsAndControllers {
  @PostConstruct
     @Bean(name = "editor")
    public View getEditorView() throws IOException {
        return loadView("fxml/r/editor.fxml");
    }
       @Bean
    public MainEditorController getMainEditorController() throws IOException {
        return (MainEditorController) getEditorView().getController();
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
