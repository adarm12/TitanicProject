import java.util.List;


public class Passenger {
    private int passengerId;
    private boolean survived;
    private int pClass;
    private String name;
    private String sex;
    private double age;
    private int sibSp;
    private int parch;
    private String ticket;
    private double fare;
    private String cabin;
    private char embarked;

    public Passenger(int passengerId, boolean survived, int pClass, String name, String sex, double age, int sibSp,
                     int parch, String ticket, int fare, String cabin, char embarked) {
        this.passengerId = passengerId;
        this.survived = survived;
        this.pClass = pClass;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.sibSp = sibSp;
        this.parch = parch;
        this.ticket = ticket;
        this.fare = fare;
        this.cabin = cabin;
        this.embarked = embarked;
    }

    public Passenger(String str) {
        String[] list = str.split(Constants.SPLIT_BY_COMMA);
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(""))
                list[i] = "0";
        }

        this.passengerId = Integer.parseInt(list[Constants.PASSENGER_ID]);
        if (list[Constants.PASSENGER_SURVIVED].equals(Constants.PASSENGER_SURVIVED_1))
            this.survived = true;
        this.pClass = Integer.parseInt(list[Constants.PASSENGER_P_CLASS]);
        // String fullName = list[Constants.PASSENGER_FIRST_NAME] + list[Constants.PASSENGER_LAST_NAME];
        this.name = list[Constants.PASSENGER_FIRST_NAME] + list[Constants.PASSENGER_LAST_NAME];
        this.sex = list[Constants.PASSENGER_SEX];
        this.age = Double.parseDouble(list[Constants.PASSENGER_AGE]);
        this.sibSp = Integer.parseInt(list[Constants.PASSENGER_SIB_SP]);
        this.parch = Integer.parseInt(list[Constants.PASSENGER_PARCH]);
        this.ticket = list[Constants.PASSENGER_TICKET];
        this.fare = Double.parseDouble(list[Constants.PASSENGER_FARE]);
        this.cabin = list[Constants.PASSENGER_CABIN];
        this.embarked = (list[Constants.PASSENGER_EMBARKED].charAt(0));
    }

    public String getFormattedName(String string) {
        int comma = 0; // פסיק
        int dot = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == Constants.COMMA)
                comma = i;
            else if (string.charAt(i) == Constants.DOT)
                dot = i;
        }
        String name = string.substring(dot + Constants.LETTER_AFTER_DOT) + " " + string.substring(0, comma);
        return (name);
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public boolean isSurvived() {
        return survived;
    }

    public void setSurvived(boolean survived) {
        this.survived = survived;
    }

    public int getpClass() {
        return pClass;
    }

    public void setpClass(int pClass) {
        this.pClass = pClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public int getSibSp() {
        return sibSp;
    }

    public void setSibSp(int sibSp) {
        this.sibSp = sibSp;
    }

    public int getParch() {
        return parch;
    }

    public void setParch(int parch) {
        this.parch = parch;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public char getEmbarked() {
        return embarked;
    }

    public void setEmbarked(char embarked) {
        this.embarked = embarked;
    }

    @Override
    public String toString() {
        return "Passenger{ passengerId= " + passengerId +
                ", survived=" + survived +
                ", pClass=" + pClass +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", sibSp=" + sibSp +
                ", parch=" + parch +
                ", ticket='" + ticket + '\'' +
                ", fare=" + fare +
                ", cabin='" + cabin + '\'' +
                ", embarked=" + embarked +
                '}';
    }
}
