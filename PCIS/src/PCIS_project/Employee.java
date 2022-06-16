package PCIS_project;

class Employee extends Person {

    private int salary;
    private String position;
    private Employee supervisor;


    Employee(){
        super();
        salary = 0;
        position = "Not yet";
        supervisor= null;
    }
    Employee(String name, int age, int salary, String position){
        super(name, age);
        this.salary = salary;
        this.position = position;
    }
    Employee(String name, int age, String address, int salary, String position){
        super(name, age, address);
        this.salary = salary;
        this.position = position;
    }
    Employee(String name, int age, int salary, String position, Employee supervisor){
        super(name, age);
        this.salary = salary;
        this.position = position;
        this.supervisor = supervisor;
    }
    Employee(String name, int age, String address, int salary, String position,
             Employee supervisor){
        super(name, age, address);
        this.salary = salary;
        this.position = position;
        this.supervisor = supervisor;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }
    public int getSalary(){
        return salary;
    }
    public void setPosition(String position){
        this.position = position;
    }
    public String getPosition(){
        return position;
    }
    public void setSupervisor(Employee supervisor){
        this.supervisor = supervisor;
    }
    public Employee getSupervisor(){
        return supervisor;
    }

    public void info(){
        super.info();
        System.out.println("급여 : " + salary);
        System.out.println("소속 : " + position);
        if(supervisor != null)
            System.out.println("???? : " + supervisor.getName());
    }

}
