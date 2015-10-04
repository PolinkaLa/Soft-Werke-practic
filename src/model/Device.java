package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LappoPolina
 * 
 *         The class contains information about the device: the unique number, mark, type,
 * model, color, date of production, the cost
 * of the same available properties to retrieve and change individual fields 
 * of a class Overridden method toString()
 * in order to collect data about your device in one
 * a string for later display
 */
public class Device {
	private static int nextUniquelD = 1;
	private Mark mark;
	private Type type;
	private String model;
	private Color color;
	private Date dateOfProduce;
	private double cost;
	private int idDevice;

	/**
	 * Constructor to initialize the new created instance
	 * 
	 * @param mark
	 *            mark of device
	 * @param type
	 *            type of device
	 * @param model
	 *            model of device
	 * @param color
	 *            color of device
	 * @param cost
	 *            cost of device
	 * @param dateOfProduce
	 *            date of produce device
	 */
	public Device(Mark mark, Type type, String model, Color color, double cost, Date dateOfProduce) {
		this.mark = mark;
		this.type = type;
		this.model = model;
		this.color = color;
		this.cost = cost;
		this.dateOfProduce = dateOfProduce;
		idDevice = nextUniquelD++;
	}

	public int getIdDevice() {
		return idDevice;
	}

	public Mark getMark() {
		return mark;
	}

	public String getModel() {
		return model;
	}

	public Type getType() {
		return type;
	}

	public Color getColor() {
		return color;
	}

	public Double getCost() {
		return cost;
	}

	public Date getDateOfProduce() {
		return (Date) dateOfProduce.clone();
	}

	public final void setIdDevice(int idDevice) {
		this.idDevice = idDevice;
	}

	public final void setMark(Mark mark) {
		this.mark = mark;
	}

	public final void setModel(String model) {
		this.model = model;
	}

	public final void setType(Type type) {
		this.type = type;
	}

	public final void setColor(Color color) {
		this.color = color;
	}

	public final void setCost(double cost) {
		this.cost = cost;
	}

	public final void setDateOfProduce(Date dateOfProduce) {
		this.dateOfProduce = dateOfProduce;
	}

	/**
	 * Override method to output information about the device
	 * All the data about device collects in one line
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		final SimpleDateFormat formatOfDate = new SimpleDateFormat("dd.MM.yyyy");
		final String Space = " ";
		builder.append(idDevice).append(Space).append(mark).append(Space).append(type).append(Space).append(model)
				.append(Space).append(color).append(Space).append(cost).append(Space)
				.append(formatOfDate.format(dateOfProduce));
		return builder.toString();
	}
}
