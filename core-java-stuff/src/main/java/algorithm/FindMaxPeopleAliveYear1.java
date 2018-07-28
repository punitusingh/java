package algorithm;


import java.util.*;


public class FindMaxPeopleAliveYear1 {
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


    //O(P+Y)
    static int findMaxPeopleAliveYear(List<Person> persons){

        int firstBirth = getMinBirth(persons);//O(P)
        int lastBirth = getMaxBirth(persons);//O(P)

        int[] deltas = getYearDeltas(persons, firstBirth, lastBirth); //O(P)
        int peekYearIndex = getMaxDeltaYearIndex(deltas);//O(Y)

        return peekYearIndex+firstBirth;
    }

    private static int getMaxDeltaYearIndex(int[] deltas) {
        int maxDelta = 0;
        int maxDeltaIndex=0;
        int delta=0;
        for(int i=0;i<deltas.length;i++){
            delta += deltas[i];
            if(delta > maxDelta){
                maxDelta=delta;
                maxDeltaIndex=i;
            }
        }

        return maxDeltaIndex;
    }

    private static int[] getYearDeltas(List<Person> persons, int firstBirth, int lastBirth) {
        int[] yearsRange = new int[lastBirth - firstBirth + 1];
        for(Person p: persons){
            addDelta(yearsRange, p.birthYear - firstBirth, 1);
            addDelta(yearsRange, p.deathYear + 1 - firstBirth, -1);
        }
        return yearsRange;
    }

    private static void addDelta(int[] yearsRange, int yearIndex, int delta) {
        if(yearIndex >=0 && yearIndex<yearsRange.length){
            yearsRange[yearIndex] += delta;
        }

    }

    private static int getMaxBirth(List<Person> persons) {
        int maxBirthYr=0;
        for(Person p:persons){
            if(p.birthYear >= maxBirthYr){
                maxBirthYr=p.birthYear;
            }
        }
        return maxBirthYr;
    }

    private static int getMinBirth(List<Person> persons) {
        int minBirthYr=0;
        for(Person p:persons){
            if(minBirthYr==0){
                minBirthYr=p.birthYear;
            }
            if(p.birthYear <= minBirthYr){
                minBirthYr=p.birthYear;
            }
        }
        return minBirthYr;
    }

    public static void main(String[] args) {
        List<Person> persons = getAllPeople();
        int year = findMaxPeopleAliveYear(persons);
        System.out.println(year);
    }



}
