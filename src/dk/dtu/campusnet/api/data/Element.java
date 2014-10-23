package dk.dtu.campusnet.api.data;

import java.util.Map;

import com.google.common.collect.Maps;

import dk.dtu.campusnet.api.access.ElementCalendarAccessor;
import dk.dtu.campusnet.api.access.ElementMessageAccessor;
import dk.dtu.campusnet.api.access.ElementParticipantsAccessor;
import dk.dtu.campusnet.api.access.FileAccessor;
import dk.dtu.campusnet.api.access.ICalendarAccessor;
import dk.dtu.campusnet.api.access.IFileAccessor;
import dk.dtu.campusnet.api.access.IMessageAccessor;
import dk.dtu.campusnet.api.access.IParticipantsAccessor;

public class Element {

	private String elementId;
	private String name;
	private String contextName;
	private boolean isArchived;
	private String parentId;
	private int subgroupCount;
	private Map<String, Element> subElements;
	
	protected Element() {
		subElements = Maps.newHashMap();
	}
	
	public static ElementBuilder newBuilder() {
		return new ElementBuilder();
	}
	
	public IFileAccessor getFileAccessor() {
		return new FileAccessor(elementId);
	}
	
	public ICalendarAccessor getCalendarAccessor() {
		return new ElementCalendarAccessor(elementId);
	}
	
	public IMessageAccessor getMessageAccessor() {
		return new ElementMessageAccessor(elementId);
	}
	
	public IParticipantsAccessor getParticipantsAccessor() {
		return new ElementParticipantsAccessor(elementId);
	}
	
	/**
	 * Setter methods are declared protected, so only appropriate
	 * builder classes can touch them.
	 */
	
	protected void setElementId(String elementId) {
		this.elementId = elementId;
	}
	
	protected void setName(String name) {
		this.name = name;
	}
	
	protected void setContextName(String contextName) {
		this.contextName = contextName;
	}
	
	protected void setIsArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}
	
	protected void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	protected void setSubgroupCount(int subgroupCount) {
		this.subgroupCount = subgroupCount;
	}
	
	public void addElement(Element subElement) {
		subElements.put(subElement.getName(), subElement);
	}
	
	public String getElementId() {
		return this.elementId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getContextName() {
		return this.contextName;
	}
	
	public boolean getIsArchived() {
		return this.isArchived;
	}
	
	public String getParentId() {
		return this.parentId;
	}
	
	public int getSubgroupCount() {
		return this.subgroupCount;
	}
	
	public Element getSubElementById(String elementId) {
		return subElements.get(elementId);
	}
	
	public Element getSubElementByName(String elementName) {
		for(Element subElement : subElements.values()) {
			if(subElement.getName().equals(elementName)) 
				return subElement;
		}
		return null;
	}
} 
