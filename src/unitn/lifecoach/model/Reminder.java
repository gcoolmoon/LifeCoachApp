package unitn.lifecoach.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import unitn.lifecoach.dao.LifeCoachDao;


/**
 * The persistent class for the reminder database table.
 * 
 */
@Entity
@NamedQuery(name="Reminder.findAll", query="SELECT r FROM Reminder r")
public class Reminder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int reminderId;

	private int appointmentDescription;

	private int appointmentType;

	private int date;

	private int time;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="personId")
	private Person person;

	public Reminder() {
	}

	public int getReminderId() {
		return this.reminderId;
	}

	public void setReminderId(int reminderId) {
		this.reminderId = reminderId;
	}

	public int getAppointmentDescription() {
		return this.appointmentDescription;
	}

	public void setAppointmentDescription(int appointmentDescription) {
		this.appointmentDescription = appointmentDescription;
	}

	public int getAppointmentType() {
		return this.appointmentType;
	}

	public void setAppointmentType(int appointmentType) {
		this.appointmentType = appointmentType;
	}

	public int getDate() {
		return this.date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getTime() {
		return this.time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	public static List<Reminder> getAll() {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
	    List<Reminder> list = em.createNamedQuery("Reminder.findAll", Reminder.class).getResultList();
	    LifeCoachDao.instance.closeConnections(em);
	    return list;
	}
	
	public static Reminder saveReminder(Reminder r) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(r);
		tx.commit();
	    LifeCoachDao.instance.closeConnections(em);
	    return r;
	}
	
	public static Reminder updateReminder(Reminder r) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		r=em.merge(r);
		tx.commit();
	    LifeCoachDao.instance.closeConnections(em);
	    return r;
	}
	
	public static void removedReminder(Lifestylemeasuremnt r) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	    r=em.merge(r);
	    em.remove(r);
	    tx.commit();
	    LifeCoachDao.instance.closeConnections(em);
	}
}