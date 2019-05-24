package com.chainsys.model;

/**
 * course model
 * @author kart2115
 *
 */
public class Course {
private int id;
private String name;
private int stream_id;
public int getId() {
	return id;
}
public int getStream_id() {
	return stream_id;
}
public void setStream_id(int stream_id) {
	this.stream_id = stream_id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Course [id=" + id + ", name=" + name + ", stream_id=" + stream_id + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + stream_id;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Course other = (Course) obj;
	if (id != other.id)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (stream_id != other.stream_id)
		return false;
	return true;
}




}
