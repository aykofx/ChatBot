
public class ChatBot {
	
	public String answers (String inputText) {
		
		String text = inputText.toLowerCase();
		
		if (text.contains("hey")) return "Hey! How are you?";
		if (text.contains("i'm good and you?")) return "I'm good, Thank you for asking :)"; 
		if (text.contains("im good and you?")) return "I'm good, Thank you for asking :)"; 
		if (text.contains("i'm good wbu?")) return "I'm good, Thank you for asking :)"; 
		if (text.contains("im good wbu?")) return "I'm good, Thank you for asking :)"; 
		if (text.contains("how are you?")) return "I'm good, and you?";
		if (text.contains("me too")) return "I'm glad to hear that, what can i help you with?";
		if (text.contains("nothing")) return "Oh okay, then just tell me something about your yourself :)";
		if (text.contains("bye")) return "Goodbye!";
		
		return "Interesting... tell me more.";
	}
	
}
