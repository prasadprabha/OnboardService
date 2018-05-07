package com.onboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.onboard.model.Resource;
import com.onboard.service.ResourceService;

@RestController
public class AppRestController {

		
	@Autowired
	ResourceService resourceService;
	
	
	@RequestMapping(value = "/resource/", method = RequestMethod.GET)
	public ResponseEntity<List<Resource>> listAllResources() {
		List<Resource> allResources = resourceService.findAllResources();
		if(allResources.isEmpty()){
			return new ResponseEntity<List<Resource>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Resource>>(allResources, HttpStatus.OK);
	}

	//-------------------Retrieve Single Resource--------------------------------------------------------
	
	@RequestMapping(value = "/resource/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resource> getResource(@PathVariable("id") long id) {
		System.out.println("Fetching Resource with id " + id);
		Resource resource = resourceService.findById(id);
		if (resource == null) {
			System.out.println("Resource with id " + id + " not found");
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Resource>(resource, HttpStatus.OK);
	}

	
	
	//-------------------Create a Resource--------------------------------------------------------
	
	@RequestMapping(value = "/resource/", method = RequestMethod.POST)
	public ResponseEntity<Void> createResource(@RequestBody Resource resource, 	UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Resource " + resource.getFirstName()+" "+ resource.getMiddleName()+ " "+ resource.getLastName());

		if (resourceService.isResourceExist(resource)) {
			System.out.println("A Resource with name " +resource.getFirstName()+" "+ resource.getMiddleName()+ " "+ resource.getLastName() + " already exists");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		resourceService.saveResource(resource);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/resource/{id}").buildAndExpand(resource.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	
	//------------------- Update a Resource --------------------------------------------------------
	
	@RequestMapping(value = "/resource/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Resource> updateResource(@PathVariable("id") long id, @RequestBody Resource resource) {
		System.out.println("Updating Resource " + id);
		
		Resource currentResource = resourceService.findById(id);
		
		if (currentResource==null) {
			System.out.println("Resource with id " + id + " not found");
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}

		resourceService.updateResource(currentResource);
		return new ResponseEntity<Resource>(currentResource, HttpStatus.OK);
	}

	//------------------- Delete a Resource --------------------------------------------------------
	
	@RequestMapping(value = "/resource/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Resource> deleteResource(@PathVariable("id") long id) {
		System.out.println("Fetching & Deleting Resource with id " + id);

		Resource resource = resourceService.findById(id);
		if (resource == null) {
			System.out.println("Unable to delete. Resource with id " + id + " not found");
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}

		resourceService.deleteResourceById(id);
		return new ResponseEntity<Resource>(HttpStatus.NO_CONTENT);
	}

	
	//------------------- Delete All Resource --------------------------------------------------------
	
/*	@RequestMapping(value = "/resource/", method = RequestMethod.DELETE)
	public ResponseEntity<Resource> deleteAllResources() {
		System.out.println("Deleting All Resources");

		resourceService.deleteAllResources();
		return new ResponseEntity<Resource>(HttpStatus.NO_CONTENT);
	}*/

}
