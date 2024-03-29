import java.util.*;

public class AgentSimulation {

    /***** IMPORTANT *************************************************/
    // feel free to modify the content of the classes and the methods
    // and add new instance variables
    // But do not change the existing instance variables and
    // the signature of the existing methods
    /*****************************************************************/


    public interface ContaminationListener {
        /**
         * Notifies that a new person is contaminated
         * @param p the new contaminated person
         */
        public void contaminated(Person p);
    }


    final static int INCUBATION_DURATION = 1;
    final static int CONTAMINATION_DURATION = 4;

    private int t = 0;

    public final Person [] population;
    public final List<int[]> contacts;

    public AgentSimulation(int populationSize, List<int []> contacts) {
        population = new Person[populationSize];
        for (int i = 0; i < population.length; i++) {
            population[i] = new Person(i,false);
        }
        this.contacts = new LinkedList<>();
        this.contacts.addAll(contacts);
    }

    public void addContaminationListener(ContaminationListener l) {
        // TODO1
    }

    public int currentTime() {
        return t;
    }


    public void simulateOneDay() {
        for (int [] contact: contacts) {
            Person p1 = population[contact[0]];
            Person p2 = population[contact[1]];

            if (p1.isContagious() || p2.isContagious()) {
                p1.contaminateUnlessImmune();
                p2.contaminateUnlessImmune();
            }

        }
        t++;
    }

    public void simulate(int numberOfDays) {
        // simulate all the bubble for a given number of days
        for (int d = 0; d < numberOfDays; d++) {
            simulateOneDay();
        }
    }


    public class Person {

        int endContagious = -1;
        int startContagious = -1;
        public final int id;

        public Person(int id, boolean immune) {
            this.id = id;
            if (immune) {
                endContagious = -2;
            }
        }

        /**
         * Returns the chain of contamination from the origin up to this person (excluded)
         * The chain is empty if the person is not yet contaminated, and should never contain this person.
         * @return the chain of contamination from the origin up to this person
         */
        public List<Person> chainOfContamination() {
            // TODO2
            // Advice: maintain this chain internally similarly to a linked list
            // indeed, you can only be contaminated by one person so you just need
            // to follow the link that you have created
            return null;
        }


        boolean isContaminated() {
            int t = currentTime();
            return t < endContagious;
        }

        boolean isContagious() {
            int t = currentTime();
            return startContagious <= t && t < endContagious;
        }

        boolean isImmune() {
            return endContagious != -1 && !isContaminated();
        }

        /**
         * Return true if the person was not yet imune and not yet contaminated
         */
        public boolean contaminateUnlessImmune() {
            if (!isImmune() & !isContaminated()) {
                startContagious = currentTime() + INCUBATION_DURATION;
                endContagious = currentTime() + CONTAMINATION_DURATION;
                return true;
            }
            return false;
        }
    }
}