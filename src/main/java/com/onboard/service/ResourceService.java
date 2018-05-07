package com.onboard.service;

import java.util.List;

import com.onboard.model.Resource;

public interface ResourceService {

	Resource findById(long id);
	
	Resource findByEmail(String email);
	
	void saveResource(Resource Resource);
	
	void updateResource(Resource Resource);
	
	void deleteResourceById(long id);
	
	List<Resource> findAllResources();
	
	boolean isResourceExist(Resource Resource);
	
}
