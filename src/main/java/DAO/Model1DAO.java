package DAO;

import java.util.concurrent.atomic.AtomicLong;

import interfaces.IModel1;
import models.Model1;

public class Model1DAO implements IModel1{

	private final AtomicLong counter = new AtomicLong();
	
	public Model1 create(String content) {
		Model1 m1 = new Model1(counter.incrementAndGet(), content);
		//validation TODO:use annotations
		if(!m1.isValid()) {
			return m1;
		}
		return null;
	}
	
	public Model1 read(Integer id) {
		//pass to datastore
		if(id == 4) {
			return new Model1(id, "Darshan");
		}
		return null;
	}

	public Model1 update(Model1 m1) {
		//pass to datastore
		if(m1.getId() == 4) {
			return new Model1(m1.getId(), m1.getContent());
		}
		return null;
	}

	public Boolean delete(Integer id) {
		//pass to datastore
		if(id == 4) {
			return true;
		} else if(id > 4) {
			return false;
		}
		return null;
	}

}
