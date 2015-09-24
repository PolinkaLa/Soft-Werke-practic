package base;

import java.text.SimpleDateFormat;
import java.util.Date;

import enums.Color;
import enums.Mark;
import enums.Type;

/**
 * @author LappoPolina
 * 
 * Класс содержит сведения об устройстве: уникальный номер, марку, тип, модель, цвет, дату производства, стоимость
 * Так же имеются свойства для получения и изменения отдельных полей класса
 * Переопределен метод toString() для того, что бы собирать данные об устройстве в одну строку,
 * 	для дальнейшего вывода на экран
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
	 * Конструкторо для инициализации создаваемого экземпляра
	 * @param mark марка устройства
	 * @param type тип устройства
	 * @param model модель усройства
	 * @param color цвет устройства
	 * @param cost стоимость устройства
	 * @param dateOfProduce дата производства устройсва
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
	 * Свойстов для получения ID устройства
	 * @return int 
	 */
	public int getIdDevice() {
        return idDevice;
    }
	/**
	 * Свойство для получения марки устройства
	 * @return Mark
	 */
	public Mark getMark() {
		return mark;
	}
	/**
	 * Свойство для получения модели
	 * @return String
	 */
	public String getModel() {
		return model;
	}
	/**
	 * Свойство для получение типа устройсва
	 * @return Type
	 */
	public Type getType() {
		return type;
	}
	/**
	 * Свойство для получения цвета
	 * @return Color
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * Свойство для получения стоимости
	 * @return double
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * свойство для получения даты производства
	 * @return Date
	 */
	public Date getDateOfProduce() {
		return (Date) dateOfProduce.clone();
	}

	/**
	 * Свойство для задания значения ID устройства 
	 * @param idDevice уникальный номер устройства
	 */
	public final void setIdDevice(int idDevice) {
		this.idDevice = idDevice;
	}
	/**
	 * Свойство для задания значения марки устройства
	 * @param mark марка устройсва
	 */
	public final void setMark(Mark mark) {
		this.mark = mark;
	}
	/**
	 * Свойство для задания значения модели устройсва
	 * @param model модель устройсва
	 */
	public final void setModel(String model) {
		this.model = model;
	}
	/**
	 * Свойство для задания значения типа устройсва
	 * @param type тип устройсва
	 */
	public final void setType(Type type) {
		this.type = type;
	}
	/**
	 * Свойство для задания цвета устройства
	 * @param color цвет устройста
	 */
	public final void setColor(Color color) {
		this.color = color;
	}
	/**
	 * Свойство для задания стоимости устройства
	 * @param cost стоимость устройства
	 */
	public final void setCost(double cost) {
		this.cost = cost;
	}
	/**
	 * Свойство для задания даты производста
	 * @param dateOfProduce дата производства
	 */
	public final void setDateOfProduce(Date dateOfProduce) {
		this.dateOfProduce = dateOfProduce;
	}

	/**
	 * Переопределяемый метод для вывода информации об устройстве
	 * Все данные об устройстве собирает в одну строку
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
