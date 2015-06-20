package unitn.lifecoach.model;

import java.io.Serializable;

import javax.persistence.*;

import unitn.lifecoach.dao.LifeCoachDao;

import java.util.List;


/**
 * The persistent class for the lifestylemeasuremnt database table.
 * 
 */
@Entity
@NamedQuery(name="Lifestylemeasuremnt.findAll", query="SELECT l FROM Lifestylemeasuremnt l")
public class Lifestylemeasuremnt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int lifestyleDefid;

	private String lifestyleDefinition;

	private String measuredBy;

	//bi-directional many-to-one association to Dailysuggestion
	@OneToMany(mappedBy="lifestylemeasuremnt")
	private List<Dailysuggestion> dailysuggestions;

	//bi-directional many-to-one association to Lifestylemeasurehistory
	@OneToMany(mappedBy="lifestylemeasuremnt")
	private List<Lifestylemeasurehistory> lifestylemeasurehistories;

	public Lifestylemeasuremnt() {
	}

	public int getLifestyleDefid() {
		return this.lifestyleDefid;
	}

	public void setLifestyleDefid(int lifestyleDefid) {
		this.lifestyleDefid = lifestyleDefid;
	}

	public String getLifestyleDefinition() {
		return this.lifestyleDefinition;
	}

	public void setLifestyleDefinition(String lifestyleDefinition) {
		this.lifestyleDefinition = lifestyleDefinition;
	}

	public String getMeasuredBy() {
		return this.measuredBy;
	}

	public void setMeasuredBy(String measuredBy) {
		this.measuredBy = measuredBy;
	}

	public List<Dailysuggestion> getDailysuggestions() {
		return this.dailysuggestions;
	}

	public void setDailysuggestions(List<Dailysuggestion> dailysuggestions) {
		this.dailysuggestions = dailysuggestions;
	}

	public Dailysuggestion addDailysuggestion(Dailysuggestion dailysuggestion) {
		getDailysuggestions().add(dailysuggestion);
		dailysuggestion.setLifestylemeasuremnt(this);

		return dailysuggestion;
	}

	public Dailysuggestion removeDailysuggestion(Dailysuggestion dailysuggestion) {
		getDailysuggestions().remove(dailysuggestion);
		dailysuggestion.setLifestylemeasuremnt(null);

		return dailysuggestion;
	}

	public List<Lifestylemeasurehistory> getLifestylemeasurehistories() {
		return this.lifestylemeasurehistories;
	}

	public void setLifestylemeasurehistories(List<Lifestylemeasurehistory> lifestylemeasurehistories) {
		this.lifestylemeasurehistories = lifestylemeasurehistories;
	}

	public Lifestylemeasurehistory addLifestylemeasurehistory(Lifestylemeasurehistory lifestylemeasurehistory) {
		getLifestylemeasurehistories().add(lifestylemeasurehistory);
		lifestylemeasurehistory.setLifestylemeasuremnt(this);

		return lifestylemeasurehistory;
	}

	public Lifestylemeasurehistory removeLifestylemeasurehistory(Lifestylemeasurehistory lifestylemeasurehistory) {
		getLifestylemeasurehistories().remove(lifestylemeasurehistory);
		lifestylemeasurehistory.setLifestylemeasuremnt(null);

		return lifestylemeasurehistory;
	}
	public static List<Lifestylemeasuremnt> getAll() {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
	    List<Lifestylemeasuremnt> list = em.createNamedQuery("Lifestylemeasuremnt.findAll", Lifestylemeasuremnt.class).getResultList();
	    LifeCoachDao.instance.closeConnections(em);
	    return list;
	}
	
	public static Lifestylemeasuremnt saveLifestylemeasurehistory(Lifestylemeasuremnt lm) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(lm);
		tx.commit();
	    LifeCoachDao.instance.closeConnections(em);
	    return lm;
	}
	
	public static Lifestylemeasuremnt updateLifestylemeasuremnt(Lifestylemeasuremnt lm) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		lm=em.merge(lm);
		tx.commit();
	    LifeCoachDao.instance.closeConnections(em);
	    return lm;
	}
	
	public static void removedLifestylemeasuremnt(Lifestylemeasuremnt lm) {
		EntityManager em = LifeCoachDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	    lm=em.merge(lm);
	    em.remove(lm);
	    tx.commit();
	    LifeCoachDao.instance.closeConnections(em);
	}
}