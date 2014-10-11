package dk.dtu.campusnet.api.data;

public class ElementBuilder {

	private Element course;
	
	protected ElementBuilder() {
		course = new Element();
	}
	
	public ElementBuilder withElementId(String elementId) {
		course.setElementId(elementId);
		return this;
	}
	
	public ElementBuilder withName(String name) {
		course.setName(name);
		return this;
	}
	
	public ElementBuilder withParentId(String parentId) {
		course.setParentId(parentId);
		return this;
	}
	
	public ElementBuilder withContextName(String contextName) {
		course.setContextName(contextName);
		return this;
	}
	
	public ElementBuilder withSubgroupCount(int subgroupCount) {
		course.setSubgroupCount(subgroupCount);
		return this;
	}
	
	public ElementBuilder withIsArchived(boolean isArchived) {
		course.setIsArchived(isArchived);
		return this;
	}
	
	public Element done() {
		return course;
	}
	
}
