import com.google.common.base.Supplier;
import org.junit.Test;

public class Lambda {
    public static void main(String[] args) {

        MathOperation substract = (a, b) -> {
            return a - b;
        };

        System.out.println(substract.operation(1, 2));
    }

    interface MathOperation {
        int operation(int a, int b);

    }

}
