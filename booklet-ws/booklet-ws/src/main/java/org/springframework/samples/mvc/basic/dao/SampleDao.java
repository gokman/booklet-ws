package org.springframework.samples.mvc.basic.dao;

import java.util.List;

import org.springframework.samples.mvc.basic.model.Sample;


public interface SampleDao {
        // To Save the sample detail
        public void saveSample ( Sample sample );
       
        // To get list of all samples
        public List<Sample> listSample();
}


