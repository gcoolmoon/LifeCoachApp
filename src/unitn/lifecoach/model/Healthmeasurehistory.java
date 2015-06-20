package unitn.lifecoach.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import unitn.lifecoach.dao.LifeCoachDao;


/**
 * The persistent class for the healthmeasurehistory database table.
 * 
 */
@Entity
@NamedQuery(name="Healthmeasurehistory.findAll", query="SELECT h FROM Healthmeasurehistory h")
public class Healthmeasurehistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String healthmeasureHistoryid;

	private int date;

	private int healthValue;

	private byte isCurrent;

	//bi-directional many-to-one association to Healthmeasurement
	@ManyToOne
	@JoinColumn(name="healthmeasureDefid")
	private Healthmeasurement healthmeasurement;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="personId")
	private Person person;

	public Healthmeasurehistory() {
	}

	public String getHealthmeasureHistoryid() {
		return this.healthmeasureHistoryid;
	}

	public void setHealthmeasureHistoryid(String healthmeasureHistoryid) {
		this.healthmeasureHistoryid = healthmeasureHistoryid;
	}

	public int getDate() {
		return this.date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getHealthValue() {
		return this.healthValue;
	}

	public void setHealthValue(int healthValue) {
		this.healthValue = healthValue;
	}

	public byte getIsCurrent() {
		return this.isCurrent;
	}

	public void setIsCurrent(byte isCurrent) {
		this.isCurrent = isCurrent;
	}

	public Healthmeasurement getHealthmeasurement() {
		return this.healthmeasurement;
	}

	public void setHealthmeasurement(Healthmeasurement healthmeasurement) {
		this.healthmeasurement = healthmeasurement;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	public static List<Healthmeasurehistory> getAll() {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
	    List<Healthmeasurehistory> list = em.createNamedQuery("Healthmeasurehistory.findAll", Healthmeasurehistory.class).getResultList();
	    LifeCoachDao.instance.closeConnections(em);
	    return list;
	}
	
	public static Healthmeasurehistory saveHealthmeasurehistory(Healthmeasurehistory hmh) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(hmh);
		tx.commit();
	    LifeCoachDao.instance.closeConnections(em);
	    return hmh;
	}
	
	public static Healthmeasurehistory updateHealthgoal(Healthmeasurehistory hmh) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		hmh=em.merge(hmh);
		tx.commit();
	    LifeCoachDao.instance.closeConnections(em);
	    return hmh;
	}
	
	public static void removedHealthmeasurehistory(Healthmeasurehistory hmh) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	    hmh=em.merge(hmh);
	    em.remove(hmh);
	    tx.commit();
	    LifeCoachDao.instance.closeConnections(em);
	}
}