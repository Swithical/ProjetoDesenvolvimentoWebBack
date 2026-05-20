package main.model;

public class GameSession {

    private Long id;
    private String startTime;
    private String endTime;
    private int attempts;
    private int duration;

    public GameSession() {
    }

    public GameSession(Long id, String startTime, String endTime, int attempts, int duration) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.attempts = attempts;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
