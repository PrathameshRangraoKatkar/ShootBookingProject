package booking;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class CustomerDetails {
     @Id
     int customer_id;
	String customer_name;
	String email;
	long phone_number;
	int booking_id;
	String created_time;
	String drone_shot_name;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	
	public String getCreated_time() {
		return created_time;
	}
	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
	public String getDrone_shot_name() {
		return drone_shot_name;
	}
	public void setDrone_shot_name(String drone_shot_name) {
		this.drone_shot_name = drone_shot_name;
	}
	
		
}
