package zenit.data.adapter.mongo;

import zenit.agregator.adapter.mongo.BasicProgramGNAdapter;
import zenit.agregator.adapter.mongo.ProgramSubjectsAdapter;
import zenit.merges.adapter.mongo.SubjectMergeAdapter;
import zenit.merges.controller.SubjectMergesController;

/**
 * Заједничке функционалности, када су у питању реактивности и функционалности
 * за адаптере предмета и студијских програма, као и предмета у алијасу. 
 * @author VM
 * @version 1.0
 */
public class CommonsEdgesController {
	private BasicProgramAdapter programAdapter = new BasicProgramAdapter();
	private BasicSubjectAdapter subjectAdapter = new BasicSubjectAdapter();
	private ProgramSubjectsAdapter programSubjectsAdapter = new ProgramSubjectsAdapter(programAdapter, subjectAdapter);
	private BasicProgramGNAdapter basicProgramGNAAdapter = new BasicProgramGNAdapter(programAdapter);
	private SubjectMergesController subjectMergesController = new SubjectMergesController(new SubjectMergeAdapter(subjectAdapter)); 
	
	public BasicProgramAdapter getProgramAdapter() {
		return programAdapter;
	}
	public BasicSubjectAdapter getSubjectAdapter() {
		return subjectAdapter;
	}
	public ProgramSubjectsAdapter getProgramSubjectsAdapter() {
		return programSubjectsAdapter;
	}
	public BasicProgramGNAdapter getBasicProgramGNAAdapter() {
		return basicProgramGNAAdapter;
	}
	public SubjectMergesController getSubjectMergesController() {
		return subjectMergesController;
	}
	public void setSubjectMergesController(SubjectMergesController subjectMergesController) {
		this.subjectMergesController = subjectMergesController;
	}
}
