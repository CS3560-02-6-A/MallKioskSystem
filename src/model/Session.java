package src.model;
import java.time.LocalDateTime;
public class Session {
	private int sessionID;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	public Session(int sessionID) {setSessionID(sessionID);}
	public Session(int sessionID, LocalDateTime startTime, LocalDateTime endTime) {
		setSessionID(sessionID);
		setStartTime(startTime);
		setEndTime(endTime);
	}
	public Session(int sessionID, boolean startSession) {
		setSessionID(sessionID);
		if (startSession) {
			startTime = LocalDateTime.now();
		}
	}
	public void endSession() {endTime = LocalDateTime.now();}
	public void setSessionID(int sessionID) {this.sessionID = sessionID;}
	public void setStartTime(LocalDateTime startTime) {this.startTime = startTime;}
	public void setEndTime(LocalDateTime endTime) {this.endTime = endTime;}
	public int getSessionID() {return sessionID;}
	public LocalDateTime getStartTime() {return startTime;}
	public LocalDateTime getEndTime() {return endTime;}
}