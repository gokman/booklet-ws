package org.springframework.samples.mvc.basic.dao;

import java.util.List;
import org.springframework.samples.mvc.basic.model.Sample;
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

}
