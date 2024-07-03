package com.inn.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Demo {
    
    public static void main(String[] args) {
        User user1 = new User("name1");
        Map<User, UserPrivateData> cache = new HashMap<>();
        cache.put(user1, new UserPrivateData("1"));
        
        //cache.put(user1, new UserPrivateData("2"));
        user1.name = "pooja123";
        System.out.println(cache.get(user1));
    }
    
    public static class User {
       private String name;
       
       public User(String name) {
           this.name = name;
       }

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(name, other.name);
	}
       
       
    }
    
    public static class UserPrivateData {
    	private String data;

		public UserPrivateData(String data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "data=" + data;
		}
		
	}
}
