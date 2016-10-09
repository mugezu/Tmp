import java.util.ArrayList;
import java.util.List;

public class Factory {
    protected List<Integer> potential;
    protected List<Integer> real;
    protected List<Integer> balance;
    protected List<Double> result;
    protected List<Integer> balance2;
    protected double plan = 3.5;
    protected int size = 0;

    Factory() {
        size = 15;
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

    Factory(int size) {
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
            balance.add(null);
            result.add(null);
        }
    }

    public Integer getPotential(int index) {
        return potential.get(index);
    }

    public void setPotential(int index, Integer date) {
        this.potential.set(index, date);
    }

    public Integer getReal(int index) {
        return real.get(index);
    }

    public void setReal(int index, Integer date) {
        this.real.set(index, date);
    }

    public Integer getBalance(int index) {
        return balance.get(index);
    }

    public void setBalance(int index, Integer date) {
        if (date >= 0)
            this.balance.set(index, date);
        else this.balance.set(index, 0);
    }

    public Integer getBalance2(int index) {
        return balance2.get(index);
    }


    public void setBalance2(int index, Integer date) {
        if (date >= 0)
            this.balance2.set(index, date);
        else this.balance2.set(index, 0);
    }

    public void writeResult(int index) {
        if (index == 0)
            result.set(index, (real.get(index) - plan));
        else result.set(index, (real.get(index) - plan + result.get(index - 1)));
    }

    public Double getResult(int index) {
        return result.get(index);
    }

    protected void line1() {
        System.out.print("|");
        for (int j = 0; j < size; j++)
            System.out.print("======");
        System.out.print("=");
        System.out.print("====|");
    }

    protected void line2() {
        System.out.print("\n|");
        for (int j = 0; j < size; j++)
            System.out.print("------");
        System.out.print("-");
        System.out.print("----|");
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
        System.out.print("\n|  B |");

        for (int j = 0; j < size; j++) {
            System.out.printf("%5d", getBalance(j));
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
}
