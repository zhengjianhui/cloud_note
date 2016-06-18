package org.tedu.cloudnote.entity;

public class Favors {
    public String getCnFavorsId() {
		return cnFavorsId;
	}

	public void setCnFavorsId(String cnFavorsId) {
		this.cnFavorsId = cnFavorsId;
	}

	private String cnUserId;

    private String cnShareId;
    
    private String cnFavorsId;

    public String getCnUserId() {
        return cnUserId;
    }

    public void setCnUserId(String cnUserId) {
        this.cnUserId = cnUserId == null ? null : cnUserId.trim();
    }

    public String getCnShareId() {
        return cnShareId;
    }

    public void setCnShareId(String cnShareId) {
        this.cnShareId = cnShareId == null ? null : cnShareId.trim();
    }
}