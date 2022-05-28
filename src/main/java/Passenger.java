import java.util.List;


public class Passenger {
    private int passengerId;
    private boolean survived;
    private int pClass;
    private String name;
    private String sex;
    private int age;
    private int sibSp;
    private int parch;
    private String ticket;
    private double fare;
    private String cabin;
    private char embarked;

    public Passenger(int passengerId, boolean survived, int pClass, String name, String sex, int age, int sibSp,
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
       String[] list = str.split(",");
        this.passengerId = Integer.parseInt(list[0]);
        if (list[1].equals("1"))
            this.survived = true;
        this.pClass = Integer.parseInt(list[2]);
        this.name = list[3] + list[4];
        this.sex = list[5];
        this.age = Integer.parseInt(list[6]);
        this.sibSp = Integer.parseInt(list[7]);
        this.parch = Integer.parseInt(list[8]);
        this.ticket = list[9];
        this.fare = Integer.parseInt(list[10]);
        this.cabin = list[11];
        this.embarked = (list[12].charAt(0));
    }

    public String getFormattedName() {
        int comma = 0; // פסיק
        int dot = 0;
        for (int i = 0; i < this.name.length(); i++) {
            if (this.name.charAt(i) == Constants.COMMA)
                comma = i;
            else if (this.name.charAt(i) == Constants.DOT)
                dot = i;
        }
        String name =  this.name.substring(dot+Constants.LETTER_AFTER_DOT) + " " + this.name.substring(0, comma);
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
