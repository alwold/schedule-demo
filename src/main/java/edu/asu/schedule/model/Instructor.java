package edu.asu.schedule.model;

/**
 *
 * @author alwold
 */
public class Instructor {

	private String nameFormal;
	private String name;
	private String firstName;
	private String lastName;
	private String instrRole;
	private Boolean schedPrintInstr;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getInstrRole() {
		return instrRole;
	}

	public void setInstrRole(String instrRole) {
		this.instrRole = instrRole;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameFormal() {
		return nameFormal;
	}

	public void setNameFormal(String nameFormal) {
		this.nameFormal = nameFormal;
	}

	public Boolean getSchedPrintInstr() {
		return schedPrintInstr;
	}

	public void setSchedPrintInstr(Boolean schedPrintInstr) {
		this.schedPrintInstr = schedPrintInstr;
	}
}
