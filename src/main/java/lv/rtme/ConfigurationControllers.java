package lv.rtme;

import java.io.IOException;
import java.io.InputStream;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javax.annotation.PostConstruct;
import lv.rtme.fxui.controllers.RailbootMainController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Date: 27.08.15
 * Time: 11:04
 *
 * @author Ruslan Molchanov (ruslanys@gmail.com)
 * @author http://mruslan.com
 */
@Configuration
public class ConfigurationControllers {

    @Bean(name = "railbootMainView")
    public View getMainView() throws IOException {
        return loadView("fxml/r/mainView.fxml");
    }
    
    
    

    /**
     * Именно благодаря этому методу мы добавили контроллер в контекст спринга,
     * и заставили его сделать произвести все необходимые инъекции.
     */
//    @Bean
//    public MainController getMainController() throws IOException {
//        return (MainController) getMainView().getController();
//    }
     @PostConstruct
      @Bean
    public RailbootMainController getMainController() throws IOException {
        return (RailbootMainController) getMainView().getController();
    }
    
    
    

    /**
     * Самый обыкновенный способ использовать FXML загрузчик.
     * Как раз-таки на этом этапе будет создан объект-контроллер,
     * произведены все FXML инъекции и вызван метод инициализации контроллера.
     */
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

    /**
     * Класс - оболочка: контроллер мы обязаны указать в качестве бина,
     * а view - представление, нам предстоит использовать в точке входа {@link Application}.
     */
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
