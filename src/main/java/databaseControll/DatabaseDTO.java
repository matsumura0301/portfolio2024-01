package databaseControll;

public class DatabaseDTO {
	private int sentenceId;
	private String sentenceName;
	private String sentenceMain;
	private String sentenceLine;
	private String sentenceKind;
	private String sentenceTemp;
	
	public int getSentenceId() {
		return sentenceId;
	}
	public void setSentenceId(int sentenceId) {
		this.sentenceId = sentenceId;
	}
	public String getSentenceName() {
		return sentenceName;
	}
	public void setSentenceName(String sentenceName) {
		this.sentenceName = sentenceName;
	}
	public String getSentenceMain() {
		return sentenceMain;
	}
	public void setSentenceMain(String sentenceMain) {
		this.sentenceMain = sentenceMain;
	}
	public String getSentenceLine() {
		return sentenceLine;
	}
	public void setSentenceLine(String sentenceLine) {
		this.sentenceLine = sentenceLine;
	}
	public String getSentenceKind() {
		return sentenceKind;
	}
	public void setSentenceKind(String sentenceKind) {
		this.sentenceKind = sentenceKind;
	}
	public String getSentenceTemp() {
		return sentenceTemp;
	}
	public void setSentenceTemp(String sentenceTemp) {
		this.sentenceTemp = sentenceTemp;
	}
}
