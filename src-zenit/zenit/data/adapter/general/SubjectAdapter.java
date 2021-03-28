package zenit.data.adapter.general;

import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import zenit.data.impl.StandardSubject;


/**
 * Адаптер за предмете према МОНГО бази података. 
 * @author MV
 * @version 1.0
 */
public interface SubjectAdapter {
	public MongoClient getDriver();
	public MongoDatabase getDatabase();
	public MongoCollection<StandardSubject> getTable();
	public List<String> list();
	public List<StandardSubject> get();
	public StandardSubject get(String id);
	public void insert(StandardSubject subject);
	public void delete(String id);
	public void update(String oldId, StandardSubject neoSubject); 
}
