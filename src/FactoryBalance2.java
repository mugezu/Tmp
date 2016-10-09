import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 04.10.2016.
 */
public class FactoryBalance2 extends Factory {
    protected List<Integer> balance2;

    FactoryBalance2(int size) {
        this.size = size;
        potential = new ArrayList<>(size);
        real = new ArrayList<>(size);
        balance = new ArrayList<>(size);
        balance2 = new ArrayList<>(size);
        result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            potential.add(null);
            real.add(null);
            balance.add(null);
            balance2.add(null);
            result.add(null);
        }
    }

    public void showTable() {

        line2();
        System.out.print("\n| Day|");
        for (int j = 0; j < size; j++) {
            System.out.printf("%5d", j + 1);
            System.out.print("|");
        }
        System.out.print("|");

        line2();
        System.out.print("\n|  P |");

        for (int j = 0; j < size; j++) {
            System.out.printf("%5d", getPotential(j));
            System.out.print("|");
        }
        System.out.print("|");

        line2();
        System.out.print("\n|  R |");

        for (int j = 0; j < size; j++) {
            System.out.printf("%5d", getReal(j));
            System.out.print("|");
        }
        System.out.print("|");

        line2();
        System.out.print("\n| B3 |");

        for (int j = 0; j < size; j++) {
            System.out.printf("%5d", getBalance(j));
            System.out.print("|");
        }
        System.out.print("|");

        line2();
        System.out.print("\n| B4 |");

        for (int j = 0; j < size; j++) {
            System.out.printf("%5d", getBalance2(j));
            System.out.print("|");
        }
        System.out.print("|");

        line2();
        System.out.print("\n|  R |");

        for (int j = 0; j < size; j++) {
            System.out.printf("%5.1f", getResult(j));
            System.out.print("|");
        }
        System.out.print("|");

        System.out.print("\n");
        line1();
    }


    public void writeResult(int index) {
        if (index == 0)
            result.set(index, (real.get(index) - plan));
        else result.set(index, (real.get(index) - plan + result.get(index - 1)));
    }

}
