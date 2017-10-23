package com.example.ardianza.expandablelistview;

/**
 * Created by ardianza on 20/09/17.
 */

public class ListItem {
    private String contactName;
    private String contactImagUrl;

    public ListItem(String contactName, String contactImagUrl) {
        this.contactName = contactName;
        this.contactImagUrl = contactImagUrl;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactImagUrl() {
        return contactImagUrl;
    }

    public void setContactImagUrl(String contactImagUrl) {
        this.contactImagUrl = contactImagUrl;
    }
}
