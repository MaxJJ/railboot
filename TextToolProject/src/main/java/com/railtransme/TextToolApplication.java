package com.railtransme;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
@Lazy
@SpringBootApplication
public class TextToolApplication extends AbstractFxAppSupport{
        @Value("${ui.title}")
      
    private String windowTitle;

    
    @Qualifier("textToolView")
    @Autowired
    private ConfigurationControllers.View view;

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("start is running...");
        stage.setTitle(windowTitle);
        stage.setScene(new Scene(view.getView()));
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.show();
    }

	public static void main(String[] args) {
		launchApp(TextToolApplication.class, args);
	}
}
