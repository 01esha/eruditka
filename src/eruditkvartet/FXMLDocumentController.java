
package eruditkvartet;

import eu.hansolo.enzo.led.Led;
import eu.hansolo.enzo.led.LedBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


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
    
   public KeyCode keyTeam1 =  KeyCode.SHIFT;
   public KeyCode keyTeam2 =  KeyCode.ENTER;   
   public KeyCode keyTeam3 =  KeyCode.ALT;   
   public KeyCode keyTeam4 =  KeyCode.CONTROL; 
   public KeyCode keyReset =  KeyCode.PAGE_UP; 
   
   String sNameTeam1 = "Команда 1";
   String sNameTeam2 = "Команда 2";
   String sNameTeam3 = "Команда 3";
   String sNameTeam4 = "Команда 4";
      
   public boolean btnblock = false;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       loadParams(); 
       
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
              if (event.getCode() == keyTeam1 && !btnblock) {                                                            
                        btnblock = true;                        
                        LedTeam1.setOn(true);                        
                        playsignal("/sound/push.wav");
                        btnCont.setDisable(false);
                } 
                 if (event.getCode() == keyTeam2 && !btnblock) {                                                            
                        btnblock = true;                        
                        LedTeam2.setOn(true);
                        playsignal("/sound/push.wav");       
                        btnCont.setDisable(false);
                }
                  if (event.getCode() == keyTeam3 && !btnblock) {                                                            
                        btnblock = true;                        
                        LedTeam3.setOn(true);
                        playsignal("/sound/push.wav");       
                        btnCont.setDisable(false);
                } 
                 if (event.getCode() == keyTeam4 && !btnblock) {                                                            
                        btnblock = true;                        
                        LedTeam4.setOn(true);                        
                        playsignal("/sound/push.wav");       
                        btnCont.setDisable(false);
                }
                 if (event.getCode() == keyReset && btnblock) {                                                            
                        btnContClick(null);
                }         
            }
    } );   
    }

    
    @FXML 
    protected void btnContClick(ActionEvent event) {
      btnblock = false;
      LedTeam1.setOn(false);   
      LedTeam2.setOn(false);   
      LedTeam3.setOn(false);   
      LedTeam4.setOn(false);
      btnCont.setDisable(true);
     }
   
    @FXML 
    protected void btnPropertyClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("propertyFXML.fxml"));
            Scene scene = new Scene(root);
            Stage secondStage = new Stage(StageStyle.UTILITY);
            secondStage.initModality(Modality.APPLICATION_MODAL); //делаем окном одальным
            secondStage.setTitle("Изменение настроек");
            secondStage.setScene(scene);
            secondStage.showAndWait();
            loadParams();
        } catch (IOException ex) {

        } 
    }
                 
    
    public void loadParams() {
    Properties props = new Properties();
    InputStream is = null; 
    try {
        File f = new File("ek.properties");
        is = new FileInputStream( f );
        }
    catch ( Exception e ) {
        is = null; } 
    try {
        if ( is == null ) {           
            is = getClass().getResourceAsStream("ek.properties");
        } 
        props.load( is );
    }
    catch ( Exception e ) { }
 
    keyTeam1 = KeyCode.getKeyCode(props.getProperty("keyTeam1", "SHIFT"));
    keyTeam2= KeyCode.getKeyCode(props.getProperty("keyTeam2", "ENTER"));   
    keyTeam3= KeyCode.getKeyCode(props.getProperty("keyTeam3", "ALT"));
    keyTeam4= KeyCode.getKeyCode(props.getProperty("keyTeam4", "CTRL"));
    keyReset= KeyCode.getKeyCode(props.getProperty("keyReset", "Page Up"));
    sNameTeam1 = props.getProperty("NameTeam1", "Команда 1");
    sNameTeam2 = props.getProperty("NameTeam2", "Команда 2");
    sNameTeam3 = props.getProperty("NameTeam3", "Команда 3");
    sNameTeam4 = props.getProperty("NameTeam4", "Команда 4");
    lblTeam1.setText(sNameTeam1); 
    lblTeam2.setText(sNameTeam2); 
    lblTeam3.setText(sNameTeam3); 
    lblTeam4.setText(sNameTeam4); 
    }
    
    private void playsignal (String path){
        AudioClip sound = new AudioClip(getClass().getResource(path).toString());
        sound.play();
      }
    
}
