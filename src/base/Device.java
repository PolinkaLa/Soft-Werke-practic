package base;

import java.text.SimpleDateFormat;
import java.util.Date;

import enums.Color;
import enums.Mark;
import enums.Type;

/**
 * @author LappoPolina
 * 
 * ����� �������� �������� �� ����������: ���������� �����, �����, ���, ������, ����, ���� ������������, ���������
 * ��� �� ������� �������� ��� ��������� � ��������� ��������� ����� ������
 * ������������� ����� toString() ��� ����, ��� �� �������� ������ �� ���������� � ���� ������,
 * 	��� ����������� ������ �� �����
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
	 * ������������ ��� ������������� ������������ ����������
	 * @param mark ����� ����������
	 * @param type ��� ����������
	 * @param model ������ ���������
	 * @param color ���� ����������
	 * @param cost ��������� ����������
	 * @param dateOfProduce ���� ������������ ���������
	 */
	public Device(Mark mark, Type type, String model, Color color, double cost, Date dateOfProduce ){
		this.mark = mark;
		this.type = type;
		this.model = model;
		this.color = color;
		this.cost = cost;
		this.dateOfProduce = dateOfProduce;
		idDevice = nextUniquelD++;
	}

	/**
	 * �������� ��� ��������� ID ����������
	 * @return int 
	 */
	public int getIdDevice() {
        return idDevice;
    }
	/**
	 * �������� ��� ��������� ����� ����������
	 * @return Mark
	 */
	public Mark getMark() {
		return mark;
	}
	/**
	 * �������� ��� ��������� ������
	 * @return String
	 */
	public String getModel() {
		return model;
	}
	/**
	 * �������� ��� ��������� ���� ���������
	 * @return Type
	 */
	public Type getType() {
		return type;
	}
	/**
	 * �������� ��� ��������� �����
	 * @return Color
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * �������� ��� ��������� ���������
	 * @return double
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * �������� ��� ��������� ���� ������������
	 * @return Date
	 */
	public Date getDateOfProduce() {
		return (Date) dateOfProduce.clone();
	}

	/**
	 * �������� ��� ������� �������� ID ���������� 
	 * @param idDevice ���������� ����� ����������
	 */
	public final void setIdDevice(int idDevice) {
		this.idDevice = idDevice;
	}
	/**
	 * �������� ��� ������� �������� ����� ����������
	 * @param mark ����� ���������
	 */
	public final void setMark(Mark mark) {
		this.mark = mark;
	}
	/**
	 * �������� ��� ������� �������� ������ ���������
	 * @param model ������ ���������
	 */
	public final void setModel(String model) {
		this.model = model;
	}
	/**
	 * �������� ��� ������� �������� ���� ���������
	 * @param type ��� ���������
	 */
	public final void setType(Type type) {
		this.type = type;
	}
	/**
	 * �������� ��� ������� ����� ����������
	 * @param color ���� ���������
	 */
	public final void setColor(Color color) {
		this.color = color;
	}
	/**
	 * �������� ��� ������� ��������� ����������
	 * @param cost ��������� ����������
	 */
	public final void setCost(double cost) {
		this.cost = cost;
	}
	/**
	 * �������� ��� ������� ���� �����������
	 * @param dateOfProduce ���� ������������
	 */
	public final void setDateOfProduce(Date dateOfProduce) {
		this.dateOfProduce = dateOfProduce;
	}

	/**
	 * ���������������� ����� ��� ������ ���������� �� ����������
	 * ��� ������ �� ���������� �������� � ���� ������
	 * @return String 
	 */
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		final SimpleDateFormat formatOfDate = new SimpleDateFormat("dd.MM.yyyy");
		final String Space = " ";
		builder.append(idDevice)
				.append(Space)
				.append(mark)
				.append(Space)
				.append(type)
				.append(Space)
				.append(model)
				.append(Space)
				.append(color)
				.append(Space)
				.append(cost)
				.append(Space)
				.append(formatOfDate.format(dateOfProduce));
		return builder.toString();
	}
}
