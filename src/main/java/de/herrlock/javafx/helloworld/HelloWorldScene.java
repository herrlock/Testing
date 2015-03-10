package de.herrlock.javafx.helloworld;

import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javax.swing.JOptionPane;

public class HelloWorldScene {

    private final Scene scene;

    public HelloWorldScene() {
        GridPane pane = new GridPane();
        {
            pane.setPadding( new Insets( 16 ) );
            pane.setHgap( 16 );
            pane.setVgap( 8 );
            int y = 0;
            {
                List<String> list = Arrays.asList( "text1", "text2", "text3" );
                for ( String s : list ) {
                    int x = 0;
                    pane.add( new Label( s ), x++ , y );
                    pane.add( new TextField(), x++ , y );
                    y++ ;
                }
            }
        }

        HBox hbox = new HBox( 8 );
        {
            EventHandler<ActionEvent> evtH1 = new EventHandler<ActionEvent>() {
                @Override
                public void handle( @SuppressWarnings( "unused" ) ActionEvent event ) {
                    JOptionPane.showMessageDialog( null, "ok" );
                }
            };
            EventHandler<ActionEvent> evtH2 = new EventHandler<ActionEvent>() {
                @Override
                public void handle( @SuppressWarnings( "unused" ) ActionEvent event ) {
                    JOptionPane.showMessageDialog( null, "cancel" );
                }
            };

            Button b1 = new Button( "button1" );
            b1.setDefaultButton( true );
            b1.setOnAction( evtH1 );
            Button b2 = new Button( "button2" );
            b2.setCancelButton( true );
            b2.setOnAction( evtH2 );
            hbox.getChildren().addAll( b1, b2 );
        }

        Text text = new Text();
        {
            text.setText( "Whatever" );
            text.setFont( Font.font( Font.getDefault().getName(), 30 ) );
        }

        BorderPane parent = new BorderPane();
        parent.setPadding( new Insets( 8, 24, 8, 24 ) );
        parent.setTop( text );
        parent.setCenter( pane );
        parent.setBottom( hbox );
        this.scene = new Scene( parent );
    }
    public Scene getScene() {
        return this.scene;
    }

}
