package org.springframework.samples.mvc.basic.service;

import java.util.List;
import org.springframework.samples.mvc.basic.model.Sample;

public interface SampleService {

        public void addSample(Sample sample);

        public List<Sample> listSample();
        
        public void deleteSample(Long id);
        public void deleteSample2(Sample sample);
}

