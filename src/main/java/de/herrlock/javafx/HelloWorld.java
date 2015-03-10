package de.herrlock.javafx;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import de.herrlock.javafx.helloworld.HelloWorldScene;

public class HelloWorld extends Application {

    public static void main( String[] args ) {
        launch( args );
    }

    @Override
    public void start( Stage stage ) throws IOException {
        stage.setScene( new HelloWorldScene().getScene() );
        stage.sizeToScene();
        stage.show();
    }
}
