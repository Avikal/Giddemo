package media.sigma.getit.model;

public class ListItem {

	private String headline;
	private String reporterName;
	private String date;
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}



	@Override
	public String toString() {
		return "[ headline=" + headline + ", reporter Name=" + reporterName + " , date=" + date + "]";
	}
}
