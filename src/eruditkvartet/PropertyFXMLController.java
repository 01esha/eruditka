
package eruditkvartet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;


public class PropertyFXMLController implements Initializable {
@FXML public TextField tfNameTeam1;
@FXML public TextField tfNameTeam2;
@FXML public TextField tfNameTeam3;
@FXML public TextField tfNameTeam4;
@FXML public TextField tfKeyTeam1;
@FXML public TextField tfKeyTeam2;
@FXML public TextField tfKeyTeam3;
@FXML public TextField tfKeyTeam4;
public KeyCode keyTeam1 =  KeyCode.SHIFT;
   public KeyCode keyTeam2 =  KeyCode.ENTER;   
   public KeyCode keyTeam3 =  KeyCode.ALT;   
   public KeyCode keyTeam4 =  KeyCode.SPACE;         
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      loadParams();
        tfKeyTeam1.addEventFilter(KeyEvent.KEY_PRESSED, new javafx.event.EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {            
            tfKeyTeam1.clear();
            tfKeyTeam1.setText(ke.getCode().toString());
            keyTeam1 = ke.getCode();
            }});
        tfKeyTeam2.addEventFilter(KeyEvent.KEY_PRESSED, new javafx.event.EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {            
            tfKeyTeam2.clear();
            tfKeyTeam2.setText(ke.getCode().toString());
            keyTeam2 = ke.getCode();
            }});
        tfKeyTeam3.addEventFilter(KeyEvent.KEY_PRESSED, new javafx.event.EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {            
            tfKeyTeam3.clear();
            tfKeyTeam3.setText(ke.getCode().toString());
            keyTeam3 = ke.getCode();
            }});
        tfKeyTeam4.addEventFilter(KeyEvent.KEY_PRESSED, new javafx.event.EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {            
            tfKeyTeam4.clear();
            tfKeyTeam4.setText(ke.getCode().toString());
            keyTeam4 = ke.getCode();
            }});
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
    tfKeyTeam1.setPromptText(props.getProperty("keyTeam1", "SHIFT")); 
    keyTeam1 = KeyCode.getKeyCode(props.getProperty("keyTeam1", "SHIFT"));
    tfKeyTeam2.setPromptText(props.getProperty("keyTeam2", "ENTER"));
    keyTeam2 = KeyCode.getKeyCode(props.getProperty("keyTeam2", "ENTER"));
    tfKeyTeam3.setPromptText(props.getProperty("keyTeam3", "ALT"));
    keyTeam3 = KeyCode.getKeyCode(props.getProperty("keyTeam3", "ALT"));
    tfKeyTeam4.setPromptText(props.getProperty("keyTeam4", "SPACE"));
    keyTeam4 = KeyCode.getKeyCode(props.getProperty("keyTeam4", "SPACE"));
    
    tfNameTeam1.setText(props.getProperty("NameTeam1", "Команда 1")); 
    tfNameTeam2.setText(props.getProperty("NameTeam2", "Команда 2")); 
    tfNameTeam3.setText(props.getProperty("NameTeam3", "Команда 3")); 
    tfNameTeam4.setText(props.getProperty("NameTeam4", "Команда 4")); 
    }
    
    @FXML 
    protected void btnSaveClick(ActionEvent event) {
       try {
        Properties props = new Properties();
        props.setProperty("NameTeam1", tfNameTeam1.getText());        
        props.setProperty("NameTeam2", tfNameTeam2.getText());        
        props.setProperty("NameTeam3", tfNameTeam3.getText());        
        props.setProperty("NameTeam4", tfNameTeam4.getText());
        props.setProperty("keyTeam1", keyTeam1.getName());        
        props.setProperty("keyTeam2", keyTeam2.getName());        
        props.setProperty("keyTeam3", keyTeam3.getName());        
        props.setProperty("keyTeam4", keyTeam4.getName());        
        File f = new File("ek.properties");
        OutputStream out = new FileOutputStream( f );
        props.store(out, "");
       
        }
    catch (Exception e ) {  
        
        }
     }
    
}
