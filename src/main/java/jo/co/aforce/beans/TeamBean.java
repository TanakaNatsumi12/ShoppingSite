package jo.co.aforce.beans;

public class TeamBean {

	 private int id;
	    private String name;
	    private String conference;

	    public TeamBean() {}

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

	    public String getConference() {
	        return conference;
	    }
	    public void setConference(String conference) {
	        this.conference = conference;
	    }
}
