package org.zerock.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService {

	private static final Logger logger = LoggerFactory.getLogger(ContentService.class);
	
	@Override
	public void doA() {
		// TODO Auto-generated method stub
		logger.info("doA called............");
		
	}

	@Override
	public void doB() {
		// TODO Auto-generated method stub
		logger.info("doB called............");
	}

	@Override
	public void doC() {
		// TODO Auto-generated method stub
		logger.info("doC called............");
	}

	@Override
	public void doD() {
		// TODO Auto-generated method stub
		logger.info("doD called............");
	}

}
