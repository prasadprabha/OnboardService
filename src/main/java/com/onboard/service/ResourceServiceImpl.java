package com.onboard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onboard.model.Resource;


@Service("resourceService")
@Transactional
public class ResourceServiceImpl implements ResourceService {

	@Override
	public Resource findById(long id) {
		// TODO Auto-generated method stub
		return new Resource("prasad@gmail.com","","","");
	}

	@Override
	public Resource findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveResource(Resource Resource) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateResource(Resource Resource) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteResourceById(long id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Resource> findAllResources() {
		List<Resource> allResources = new ArrayList<Resource>();
		Resource resource = new Resource("prasad@gmail.com","","","");
		allResources.add(resource);
		return allResources;
		
	}

	@Override
	public boolean isResourceExist(Resource Resource) {
		// TODO Auto-generated method stub
		return false;
	}

}
