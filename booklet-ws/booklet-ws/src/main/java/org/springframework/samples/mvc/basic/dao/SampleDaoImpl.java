package org.springframework.samples.mvc.basic.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.samples.mvc.basic.model.Sample;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("sampleDao")
public class SampleDaoImpl implements SampleDao {


    @Autowired
    private SessionFactory sessionFactory;

	
	@Override
	public void saveSample(Sample sample) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(sample);
	}

	@SuppressWarnings("unchecked")
	public List<Sample> listSample() {
		// TODO Auto-generated method stub
		return (List<Sample>)
				sessionFactory.getCurrentSession().createCriteria(Sample.class).list();

	}

	@Override
	public void deleteSample(Long id) {
		
		//Sample sample=(Sample)sessionFactory.getCurrentSession().load(Sample.class, id);
		//sessionFactory.getCurrentSession().delete(sample);
		Query q = sessionFactory.getCurrentSession().createQuery("delete from Sample where sampleId in (:id) ");
		q.setLong("id", id);
		q.executeUpdate();
		
	}

	@Override
	public void deleteSample2(Sample sample) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(sample);
	}

}
