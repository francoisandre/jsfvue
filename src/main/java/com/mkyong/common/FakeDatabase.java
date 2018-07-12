package com.mkyong.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeDatabase {
	
	private static Map<Integer, Notification> notifications;
	
	static {
		notifications = new HashMap<Integer, Notification>();
		ajouteNotification(1);
		ajouteNotification(2);
		ajouteNotification(3);
		ajouteNotification(4);
		ajouteNotification(5);
		ajouteNotification(6);
		ajouteNotification(7);
		ajouteNotification(8);
	}

	private static void ajouteNotification(Integer id) {
		Notification notification = new Notification();
		notification.setMessage("Ceci est le message "+ id);
		notification.setUrl("/pipo/url/"+id);
		notification.setId(""+id);
		notifications.put(id, notification);
	}
	
	public static List<Notification> getNotifications() {
		ArrayList<Notification> resultat = new ArrayList<Notification>();
		ArrayList<Integer> cles = new ArrayList<Integer>();
		cles.addAll(notifications.keySet());
		Collections.sort(cles);
		for (Integer cle : cles) {
			resultat.add(notifications.get(cle));
		}
		return resultat;
	}
	
	public static void deleteNotification(Integer id) {
		notifications.remove(id);
	}

}
