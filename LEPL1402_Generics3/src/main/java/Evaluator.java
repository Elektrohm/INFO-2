import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Evaluator {

    public BiFunction<Boolean, Boolean, Boolean> xor_gate() {
        return (a,b)-> a^b;
    }

    public BiFunction<Boolean, Boolean, Boolean> or_gate() {
        return (a,b)->a|b;
    }

    public BiFunction<Boolean, Boolean, Boolean> and_gate() {
        return (a,b)->a&b;
    }

    public Function<Boolean, Boolean> not_gate() {
        return (a)-> a^= true;
    }

    // Should return a map with the results stored in map ( use HashMap )
    // Keys are "SUM", "CarryOut"
    // TODO WARNING : USE HERE ONLY the previously defined method to compute result (as inginious will prevent you to cheat to directly invoke logical operators)
    public Map<String, Boolean> evaluate_circuit(Boolean a, Boolean b, Boolean carry_in) {
        Boolean aXORb = xor_gate().apply(a,b);
        Boolean SUM = xor_gate().apply(aXORb,carry_in);
        Boolean cinANDaxorb = and_gate().apply(carry_in, aXORb);
        Boolean aANDb = and_gate().apply(a,b);
        Boolean CarryOut = or_gate().apply(cinANDaxorb, aANDb);

        Map<String,Boolean> evaluation = new HashMap<String,Boolean>();
        evaluation.put("SUM", SUM);
        evaluation.put("CarryOut", CarryOut);
        return evaluation;
    }

}