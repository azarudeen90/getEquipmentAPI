package com.kone.assignment.equipments.api;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.kone.assignment.equipments.Model.Equipment;

@RestController
@RequestMapping("/equipment")
public class EquipmentsController {
	
	@Autowired
	private Database db;
	
	@RequestMapping(method = RequestMethod.GET, value="/search")
	public @ResponseBody List<Equipment> getAllEquipments(@RequestParam(value="limit", required = false) String limit) throws IOException, ParseException {
		int limitin = 0;
		List<Equipment> allDocs = null;
		if (limit != null) {
			
			try {
			limitin = Integer.parseInt(limit);
			}catch(Throwable t) {
				t.printStackTrace();
			}
		}
			if (limitin > 0) {
				allDocs = db.getAllDocsRequestBuilder().includeDocs(true).limit(limitin).build().getResponse().getDocsAs(Equipment.class);
			}else {
				allDocs = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(Equipment.class);
			}
			return allDocs;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/{_id}")
	public @ResponseBody Equipment getEquipment(@PathVariable String _id) throws IOException {
			Equipment equipment = db.find(Equipment.class, _id);
			return equipment;
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody String add(@RequestBody Equipment equipment) {
			Response response = db.post(equipment);
			String _id = response.getId();
			return _id;
	}
	
	

}
