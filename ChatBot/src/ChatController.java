import java.io.File;
import java.io.FileWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class ChatController {
	
	@FXML
	private TextArea log;
	@FXML
	private TextField input;
	
	ChatBot chatbot = new ChatBot();
	
	@FXML
	private void initialize () {
		log.setEditable(false);
		input.setOnAction(this::button);
	}
	
	@FXML
	private void button (ActionEvent event) {
		String inputText = input.getText();
		String date = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		
		if (!inputText.isEmpty()) {
			log.appendText(date+" 🙋 You : "+ inputText + "\n");
			String botAnswer = chatbot.answers(inputText);
			log.appendText(date+ " 🤖 Bot: "+botAnswer+ "\n");
			input.clear();
		} else {
			log.appendText(date+ " 🤖 Bot: please talk to me :("+ "\n");
		}
	}
	
	@FXML
	private void saveLog (ActionEvent event) {
		try {
			String chatLog = log.getText();
			
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Save your log");
			fileChooser.setInitialFileName("chatlog.txt");		
			fileChooser.getExtensionFilters().add(
					new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt")
			);
			
	        Window window = ((Node) event.getSource()).getScene().getWindow();
	        File file = fileChooser.showSaveDialog(window);
	        
	        if(file != null) {
				try (FileWriter writer = new FileWriter(file)) {
					writer.write(chatLog);
				}
	        }
			
		} catch (Exception e) {
			
		}
	}
}
