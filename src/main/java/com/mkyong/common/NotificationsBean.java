package com.mkyong.common;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.json.JSONArray;
import org.json.JSONObject;

@ManagedBean
@RequestScoped
public class NotificationsBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer currentId;
	
	private String notificationsContent = "";

	public Integer getCurrentId() {
		return currentId;
	}

	public void setCurrentId(Integer currentId) {
		this.currentId = currentId;
	}

	public void deleteCurrent() {
		System.out.println("delete "+getCurrentId());
		FakeDatabase.deleteNotification(getCurrentId());
		refreshNotations();
	}

	public void refreshNotations() {
		System.out.println("refresh");
		List<Notification> notifications = FakeDatabase.getNotifications();
		JSONObject aux = new JSONObject();
        aux.put("hit", notifications.size());
        
        JSONArray aux2 = new JSONArray(notifications);		
        aux.put("notifications", aux2);
        
        setNotificationsContent(aux.toString());
	}

	public String getNotificationsContent() {
		return notificationsContent;
	}

	public void setNotificationsContent(String notificationsContent) {
		this.notificationsContent = notificationsContent;
	}
		
}