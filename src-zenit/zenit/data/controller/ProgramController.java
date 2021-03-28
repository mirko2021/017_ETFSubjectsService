package zenit.data.controller;

import java.util.ArrayList;
import java.util.List;

import zenit.data.adapter.mongo.CommonsEdgesController;
import zenit.data.adapter.mongo.SimpleProgramAdapter;
import zenit.data.impl.StandardProgram;

/**
 * Контролер за студијске програме програме.
 * @author VM
 * @version 1.0
 */
public class ProgramController {
	private List<String> programIds = new ArrayList<>(); 
	private SimpleProgramAdapter programAdapter;
	
	public ProgramController(CommonsEdgesController commonsEdgesController) {
		programAdapter = new SimpleProgramAdapter(commonsEdgesController);
	}
	
	public SimpleProgramAdapter getProgramAdapter() {
		return programAdapter;
	}
	public List<String> getProgramIds() {
		return programIds;
	}
	public void setProgramIds(List<String> programIds) {
		if(programIds==null) programIds = new ArrayList<>();
		this.programIds = programIds;
	}
	
	public void refresh() {
		programIds = programAdapter.list();
	}
	public StandardProgram get(String id) {
		if(!programIds.contains(id)) return null;
		StandardProgram program = programAdapter.get(id);
		if(program==null) programIds.remove(id);
		return program; 
	}
	
	public void remove(String id) {
		if(!programIds.contains(id)) return;
		programIds.remove(id);
		programAdapter.delete(id);
	}
	
	
	public boolean updateId(String oldId, String newId) {
		if(!programIds.contains(oldId)) return false;
		if(programIds.contains(newId)) return false;
		StandardProgram ssOld = programAdapter.get(oldId);
		StandardProgram ssNew = programAdapter.get(newId);
		if(ssOld==null) return false;
		if(ssNew!=null) return false;
		ssNew = ssOld.apply(newId);
		remove(oldId);
		add(ssNew);
		return true;
	}
	
	public boolean updateName(String oldId, String program) {
		if(!programIds.contains(oldId)) return false;
		if(program==null) throw new RuntimeException();
		programAdapter.updateName(oldId, program); 
		return true;
	}
	
	public boolean updateProgram(String oldId, String program) {
		if(!programIds.contains(oldId)) return false;
		if(program==null) throw new RuntimeException();
		programAdapter.updateProgram(oldId, program); 
		return true;
	}
	
	public boolean updateCourse(String oldId, String program) {
		if(!programIds.contains(oldId)) return false;
		if(program==null) throw new RuntimeException();
		programAdapter.updateCourse(oldId, program); 
		return true;
	}
	
	public boolean add(StandardProgram subject) {
		if(programIds.contains(subject.getId())) return false;
		if(programAdapter.get(subject.getId())!=null) return false;
		programAdapter.insert(subject);
		programIds.add(subject.getId());
		return true;
	}
	
	public boolean update(String oldId, StandardProgram neoSubject) {
		if(!programIds.contains(oldId)) return false;
		if(programIds.contains(neoSubject.getId()))
			if(!oldId.contentEquals(neoSubject.getId())) return false;
		StandardProgram ssOld = programAdapter.get(oldId);
		StandardProgram ssNew = programAdapter.get(neoSubject.getId());
		if(ssOld==null) return false;
		if(ssNew!=null) 
			if(!oldId.contentEquals(neoSubject.getId()))
				return false;
		remove(oldId);
		add(neoSubject);
		return true;
	}
}
