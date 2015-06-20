package unitn.lifecoach.model;

import java.io.Serializable;

import javax.persistence.*;

import unitn.lifecoach.dao.LifeCoachDao;

import java.util.List;


/**
 * The persistent class for the healthmeasurement database table.
 * 
 */
@Entity
@NamedQuery(name="Healthmeasurement.findAll", query="SELECT h FROM Healthmeasurement h")
public class Healthmeasurement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int healthmeasureDefId;

	private String healthmeasureDefinition;

	private String measuredBy;

	//bi-directional many-to-one association to Healthgoal
	@OneToMany(mappedBy="healthmeasurement")
	private List<Healthgoal> healthgoals;

	//bi-directional many-to-one association to Healthmeasurehistory
	@OneToMany(mappedBy="healthmeasurement")
	private List<Healthmeasurehistory> healthmeasurehistories;

	public Healthmeasurement() {
	}

	public int getHealthmeasureDefId() {
		return this.healthmeasureDefId;
	}

	public void setHealthmeasureDefId(int healthmeasureDefId) {
		this.healthmeasureDefId = healthmeasureDefId;
	}

	public String getHealthmeasureDefinition() {
		return this.healthmeasureDefinition;
	}

	public void setHealthmeasureDefinition(String healthmeasureDefinition) {
		this.healthmeasureDefinition = healthmeasureDefinition;
	}

	public String getMeasuredBy() {
		return this.measuredBy;
	}

	public void setMeasuredBy(String measuredBy) {
		this.measuredBy = measuredBy;
	}

	public List<Healthgoal> getHealthgoals() {
		return this.healthgoals;
	}

	public void setHealthgoals(List<Healthgoal> healthgoals) {
		this.healthgoals = healthgoals;
	}

	public Healthgoal addHealthgoal(Healthgoal healthgoal) {
		getHealthgoals().add(healthgoal);
		healthgoal.setHealthmeasurement(this);

		return healthgoal;
	}

	public Healthgoal removeHealthgoal(Healthgoal healthgoal) {
		getHealthgoals().remove(healthgoal);
		healthgoal.setHealthmeasurement(null);

		return healthgoal;
	}

	public List<Healthmeasurehistory> getHealthmeasurehistories() {
		return this.healthmeasurehistories;
	}

	public void setHealthmeasurehistories(List<Healthmeasurehistory> healthmeasurehistories) {
		this.healthmeasurehistories = healthmeasurehistories;
	}

	public Healthmeasurehistory addHealthmeasurehistory(Healthmeasurehistory healthmeasurehistory) {
		getHealthmeasurehistories().add(healthmeasurehistory);
		healthmeasurehistory.setHealthmeasurement(this);

		return healthmeasurehistory;
	}

	public Healthmeasurehistory removeHealthmeasurehistory(Healthmeasurehistory healthmeasurehistory) {
		getHealthmeasurehistories().remove(healthmeasurehistory);
		healthmeasurehistory.setHealthmeasurement(null);

		return healthmeasurehistory;
	}
	public static List<Healthmeasurement> getAll() {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
	    List<Healthmeasurement> list = em.createNamedQuery("Healthmeasurement.findAll", Healthmeasurement.class).getResultList();
	    LifeCoachDao.instance.closeConnections(em);
	    return list;
	}
	
	public static Healthmeasurement saveHealthmeasurement(Healthmeasurement hm) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(hm);
		tx.commit();
	    LifeCoachDao.instance.closeConnections(em);
	    return hm;
	}
	
	public static Healthmeasurement updateheHealthmeasurement(Healthmeasurement hm) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		hm=em.merge(hm);
		tx.commit();
	    LifeCoachDao.instance.closeConnections(em);
	    return hm;
	}
	
	public static void removedHealthmeasurement(Healthmeasurement hm) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	    hm=em.merge(hm);
	    em.remove(hm);
	    tx.commit();
	    LifeCoachDao.instance.closeConnections(em);
	}
}