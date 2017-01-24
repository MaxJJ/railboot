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
public class ApplicationViewsAndControllers {
  
     @Bean(name = "editor")
    public View getEditorView() throws IOException {
        return loadView("fxml/r/editor.fxml");
    }
       @Bean
    public MainEditorController getMainEditorController() throws IOException {
        return (MainEditorController) getEditorView().getController();
    }
/*------------------------------------------------------------------------*/
    @Bean(name = "topPaneView")
    public View getTopPaneView() throws IOException {
        return loadView("fxml/topPaneMainView.fxml");
    }
      @Bean(name = "topPaneSelectedItemView")
    public View getTopPaneSelectedItemView() throws IOException {
        return loadView("fxml/selectedViewTopPane.fxml");
    }
    
       @Bean(name = "mainTableView")
    public View getMainTableView() throws IOException {
        return loadView("fxml/mainTable.fxml");
    }
         @Bean(name = "mainEditorView")
    public View getMainEditorView() throws IOException {
        return loadView("fxml/mainEditor.fxml");
    }
    
    
//      @Bean
//    public MainEditorController getMainEditorController() throws IOException {
//        return (MainEditorController) getMainEditorView().getController();
//    }
      @Bean
    public TopPaneController getTopPaneController() throws IOException {
        return (TopPaneController) getTopPaneView().getController();
    }
    
      @Bean
    public MainTableViewController getMainTableController() throws IOException {
        return (MainTableViewController) getMainTableView().getController();
    }
      @Bean
    public SelectedItemTopPaneController getTopPaneSelectedItemController() throws IOException {
        return (SelectedItemTopPaneController) getTopPaneSelectedItemView().getController();
    }
    
    
    @Bean(name = "homeView")
    public View getHomeView() throws IOException {
        return loadView("fxml/homeView.fxml");
    }
    
      @Bean
    public HomeViewController getHomeViewController() throws IOException {
        return (HomeViewController) getHomeView().getController();
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
