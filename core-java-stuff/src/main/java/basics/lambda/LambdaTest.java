package basics.lambda;

import basics.annotation.Test;

import java.util.ArrayList;
import java.util.List;

public class LambdaTest {
    @Test
    public void printPersonsTestWithAnonymouseTester(){
        List<Person> roster=new ArrayList<>();
        Person.printPersons(roster,new CheckPerson() {
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25;
            }
        });
    }

    @Test
    public void printPersonsTestWithLambdaTester(){
        List<Person> roster=new ArrayList<>();
        Person.printPersons(roster,
                p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25
        );
    }

    @Test
    public void printPersonsTestWithPredicate(){
        List<Person> roster=new ArrayList<>();
        Person.printPersonsWithPredicate(roster,
                p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25
        );
    }

    @Test
    public void printPersonsTestWithPredicateAndConsumer(){
        List<Person> roster=new ArrayList<>();
        Person.processPersons(roster,
                p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
                Person::printPerson
        );
    }

    @Test
    public void printPersonsTestWithPredicateConsumerAndFunction(){
        List<Person> roster=new ArrayList<>();
        Person.processPersonsWithFunction(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                Person::getEmailAddress,
                System.out::println
        );

    }

    @Test
    public void printPersonsTestWithPredicateConsumerFunctionAndGenerics(){
        List<Person> roster=new ArrayList<>();
        Person.processElements(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                Person::getEmailAddress,
                System.out::println
        );
    }

    @Test
    public void printPersonsWithAggregateOperations(){
        List<Person> roster=new ArrayList<>();
        roster
                .stream()
                .filter(p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25)
                .map(Person::getEmailAddress)
                .forEach(System.out::println);
    }
}
