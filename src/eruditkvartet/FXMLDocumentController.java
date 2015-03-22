/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eruditkvartet;

import eu.hansolo.enzo.common.Section;
import eu.hansolo.enzo.gauge.SimpleGauge;
import eu.hansolo.enzo.gauge.SimpleGaugeBuilder;
import eu.hansolo.enzo.led.Led;
import eu.hansolo.enzo.led.LedBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author olandol
 */
public class FXMLDocumentController implements Initializable {
    
   @FXML public GridPane gridpaneMain;    
   @FXML public Label lblTeam1;
   @FXML public Label lblTeam2;
   @FXML public Label lblTeam3;
   @FXML public Label lblTeam4;
   @FXML public Button btnCont;
         
   public Led LedTeam1;
   public Led LedTeam2;
   public Led LedTeam3;
   public Led LedTeam4;
    
   public KeyCode keyTeam1 =  KeyCode.CONTROL;
   public KeyCode keyTeam2 =  KeyCode.ALT;   
   public KeyCode keyTeam3 =  KeyCode.PAGE_DOWN;   
   public KeyCode keyTeam4 =  KeyCode.PAGE_UP;   
   
   public boolean bredpush = false;
   public boolean bgreenpush = false;
   public boolean btnblock = false;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // loadParams();    
       gridpaneMain.requestFocus();
        LedTeam1 =        LedBuilder.create()
                                   .ledColor(Color.RED)
                                   .frameVisible(true)                                   
                                   .on(false)
                                   .build();
        gridpaneMain.add(LedTeam1,0,1);
       LedTeam2 =        LedBuilder.create()
                                   .ledColor(Color.RED)
                                   .frameVisible(true)                                   
                                   .on(false)
                                   .build();
        gridpaneMain.add(LedTeam2,1,1);
        LedTeam3 =        LedBuilder.create()
                                   .ledColor(Color.RED)
                                   .frameVisible(true)                                   
                                   .on(false)
                                   .build();
        gridpaneMain.add(LedTeam3,2,1);
        LedTeam4 =        LedBuilder.create()
                                   .ledColor(Color.RED)
                                   .frameVisible(true)                                   
                                   .on(false)
                                   .build();
        gridpaneMain.add(LedTeam4,3,1);       
    
    gridpaneMain.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {                
               /* 
                if (event.getCode() == keyTeamRed && !bredpush &&!btnblock) {
                    if (bTimerStart) {
                        playsignal("/sound/push.wav");
                        TimeAccurate();
                        btnblock = true;
                        bredpush = true;
                        redLed.setOn(true);
                        //timer.cancel();
                        AnimTimer.stop();
                        bTimerStart = false;
                        if (!bgreenpush) btnCont.setDisable(false);
                    }
                    else{
                        playsignal("/sound/falsestart.wav");
                        btnblock = true;
                        lblFalseRed.setVisible(true);                        
                        redLed.setBlinking(true);
                        btnCont.setDisable(false);
                        bredpush = true;
                        btnStart.setDisable(true);
                    }
                } else 
                    if (event.getCode() == keyTeamGreen && !bgreenpush &&!btnblock){
                        if (bTimerStart){
                            playsignal("/sound/push.wav");
                            TimeAccurate();
                            btnblock = true;
                            bgreenpush = true;
                            greenLed.setOn(true);
                            //timer.cancel();
                            AnimTimer.stop();
                            bTimerStart = false;
                            if (!bredpush) btnCont.setDisable(false);
                        }
                        else{ 
                            playsignal("/sound/falsestart.wav");
                            btnblock = true;
                            lblFalseGreen.setVisible(true);
                            greenLed.setBlinking(true);                        
                            btnCont.setDisable(false);
                            bgreenpush = true;
                            btnStart.setDisable(true);
                        }
            }
            }*/
            }
    } );   
    }

    
    @FXML 
    protected void btnContClick(ActionEvent event) {
    /*    btnblock = false;
        btnCont.setDisable(true);
        if ( !bredpush | !bgreenpush )
            btnStart.setDisable(false);
        if (bredpush & !lblFalseRed.isVisible()){
            lblFalseRed.setText("Неверный ответ");
            lblFalseRed.setVisible(true);
        }            
        if (bgreenpush & !lblFalseGreen.isVisible()){
            lblFalseGreen.setText("Неверный ответ");
            lblFalseGreen.setVisible(true);
        }        
        if (bredpush)
             redLed.setBlinking(false);
        if (bgreenpush)
            greenLed.setBlinking(false);
        if (bredpush)
             redLed.setOn(false);
        if (bgreenpush)
            greenLed.setOn(false);
        if (dTimeRemain > 0.0)
            controlTimer.setValue(60.0-dTimeRemain);
        if ((lblFalseGreen.isVisible() && lblFalseGreen.getText() =="Фальстарт") )
             //| (lblFalseRed.isVisible()&lblFalseRed.getText()=="Фальстарт"))
            btnStart.setDisable(false);
        else AnimTimerStart();
   */  }
   
    @FXML 
    protected void btnPropertyClick(ActionEvent event) {
        
    }
                 
             
      
    public void saveParamChanges() {
    try {
        Properties props = new Properties();
        props.setProperty("keyTeamGreen", keyTeamGreen.getName());        
        props.setProperty("keyTeamRed",  keyTeamRed.getName());         
       
        File f = new File("brain.properties");
        OutputStream out = new FileOutputStream( f );
        props.store(out, "Коментарий");
        }
    catch (Exception e ) {  
        
        }
    }
    public void loadParams() {
    Properties props = new Properties();
    InputStream is = null; 
    try {
        File f = new File("brain.properties");
        is = new FileInputStream( f );
        }
    catch ( Exception e ) { is = null; }
 
    try {
        if ( is == null ) {           
            is = getClass().getResourceAsStream("brain.properties");
        } 
        props.load( is );
    }
    catch ( Exception e ) { }
 
    keyTeamGreen = KeyCode.getKeyCode (props.getProperty("keyTeamGreen", "Shift"));
    keyTeamRed= KeyCode.getKeyCode(props.getProperty("keyTeamRed", "Ctrl"));   
    }
    
    private void playsignal (String path){        
       /*Media someSound = new Media(getClass().getResource(path).toString());
        MediaPlayer mp = new MediaPlayer(someSound);
        mp.play();*/
        AudioClip sound = new AudioClip(getClass().getResource(path).toString());
        sound.play();
      }
    
}
