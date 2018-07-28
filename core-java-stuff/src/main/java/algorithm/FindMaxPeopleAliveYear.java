package algorithm;


import java.util.*;

class Person{
    int birthYear;
    int deathYear;
    String name;

    public Person(String name, int birthYear, int deathYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("birthYear=").append(birthYear);
        sb.append(", deathYear=").append(deathYear);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

class BirthDeathList{
    Set<Person> births;
    Set<Person> deaths;

    public BirthDeathList(Set<Person> births, Set<Person> deaths) {
        this.births = births;
        this.deaths = deaths;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BirthDeathList{");
        sb.append("births=").append(births);
        sb.append(", deaths=").append(deaths);
        sb.append('}');
        return sb.toString();
    }
}

public class FindMaxPeopleAliveYear {
    static List<Person> getAllPeople(){
        List<Person> list=new ArrayList<>();
        list.add(new Person("p1",1920,1945));
        list.add(new Person("p2",1921,1945));
        list.add(new Person("p3",1945,0));
        list.add(new Person("p4",1950,0));
        list.add(new Person("p5",1946,1999));
        list.add(new Person("p6",1923,1989));
        list.add(new Person("p7",1998,0));
        list.add(new Person("p8",1983,0));
        list.add(new Person("p9",1984,0));
        list.add(new Person("p10",1985,0));
        return list;
    }

    static TreeMap<Integer, BirthDeathList> groupBirthDeathByYear(List<Person> persons){
        TreeMap<Integer, BirthDeathList> groupByYear= new TreeMap<Integer, BirthDeathList>();
        persons.forEach(person -> {
            if(!groupByYear.containsKey(person.birthYear)){
                groupByYear.put(person.birthYear, new BirthDeathList(new HashSet<>(), new HashSet<>()));
            }
            if(person.deathYear !=0 && !groupByYear.containsKey(person.deathYear)){
                groupByYear.put(person.deathYear, new BirthDeathList(new HashSet<>(), new HashSet<>()));
            }

            groupByYear.get(person.birthYear).births.add(person);

            if(person.deathYear!=0){
                groupByYear.get(person.deathYear).deaths.add(person);
            }

        });

        return groupByYear;
    }

    static void addBirths(Set<Person> totalPersons, Set<Person> births){
        totalPersons.addAll(births);
    }

    static void removeDeaths(Set<Person> totalPersons, Set<Person> deaths){
        totalPersons.removeAll(deaths);
    }

    static int findMaxPeopleAliveYear(List<Person> persons){

        TreeMap<Integer, BirthDeathList> groupByYear=groupBirthDeathByYear(persons);

        System.out.println(groupByYear);
        Set<Person> totalPersons=new HashSet<>();
        int maxYear=0;
        int maxCount=0;

        for(Map.Entry<Integer, BirthDeathList> entry: groupByYear.entrySet()){
            int year = entry.getKey();
            System.out.println("year is "+year);
            BirthDeathList birthDeathList=entry.getValue();
            addBirths(totalPersons, birthDeathList.births);
          //  removeDeaths(totalPersons, birthDeathList.deaths);
            if(totalPersons.size() > maxCount){
                maxYear = year;
                maxCount=totalPersons.size();
            }
        }
        System.out.println(maxCount);
        return maxYear;
    }

    public static void main(String[] args) {
        List<Person> persons = getAllPeople();
        int year = findMaxPeopleAliveYear(persons);
        System.out.println(year);
    }



}
