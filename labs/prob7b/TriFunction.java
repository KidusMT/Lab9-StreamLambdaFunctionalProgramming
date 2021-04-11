package labs.prob7b;

/**
 * @author KidusMT
 * Date: 4/9/2021
 * StdID: 612361
 */
@FunctionalInterface
public interface TriFunction<S,T,U,R> {
	R apply(S s, T t, U u);
}
