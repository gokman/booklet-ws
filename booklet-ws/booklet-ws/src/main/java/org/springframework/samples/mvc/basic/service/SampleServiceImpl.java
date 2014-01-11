package org.springframework.samples.mvc.basic.service;

import java.util.List;



import org.springframework.samples.mvc.basic.dao.SampleDao;
import org.springframework.samples.mvc.basic.model.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("sampleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SampleServiceImpl implements SampleService {

        @Autowired
        private SampleDao sampleDao;

        public SampleServiceImpl() {
        }

        @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
        public void addSample(Sample sample) {
                sampleDao.saveSample(sample);
        }

        public List<Sample> listSample() {
                return sampleDao.listSample();
        }

}

