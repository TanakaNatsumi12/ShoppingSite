package jo.co.aforce.beans;

import java.time.LocalDateTime;

public class PlayerBean {

	


	    private int id;
	    private String name;
	    private int teamId;
	    private String nationality;
	    private String status;
	    private String position;
	    private LocalDateTime createdAt;
	    private LocalDateTime updatedAt;

	    public PlayerBean() {}

	    public PlayerBean(int id, String name, int teamId, String nationality,
	                  String status, String position,
	                  LocalDateTime createdAt, LocalDateTime updatedAt) {
	        this.id = id;
	        this.name = name;
	        this.teamId = teamId;
	        this.nationality = nationality;
	        this.status = status;
	        this.position = position;
	        this.createdAt = createdAt;
	        this.updatedAt = updatedAt;
	    }

	    public int getId() {
	        return id;
	    }
	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getTeamId() {
	        return teamId;
	    }
	    public void setTeamId(int teamId) {
	        this.teamId = teamId;
	    }

	    public String getNationality() {
	        return nationality;
	    }
	    public void setNationality(String nationality) {
	        this.nationality = nationality;
	    }

	    public String getStatus() {
	        return status;
	    }
	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public String getPosition() {
	        return position;
	    }
	    public void setPosition(String position) {
	        this.position = position;
	    }

	    public LocalDateTime getCreatedAt() {
	        return createdAt;
	    }
	    public void setCreatedAt(LocalDateTime createdAt) {
	        this.createdAt = createdAt;
	    }

	    public LocalDateTime getUpdatedAt() {
	        return updatedAt;
	    }
	    public void setUpdatedAt(LocalDateTime updatedAt) {
	        this.updatedAt = updatedAt;
	    }
	}


