import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 08.09.2016.
 */
public class Factories {
    List<Factory> factories;
    private int quentityFactories;
    private int quentityDays;

    public Factories(int quentityFactories, int quentityDays) {
        this.quentityFactories = quentityFactories;
        this.quentityDays = quentityDays;
        factories = new ArrayList<>(quentityFactories);
        for (int i = 0; i < quentityFactories; i++) {
            if (i != 4)
                factories.add(new Factory(quentityDays));
            else factories.add(new FactoryBalance2(quentityDays));

        }
    }

    public void run(int[][] a) {
        for (int i = 0; i < quentityDays; i++)
            for (int j = 0; j < quentityFactories; j++) {
                if (j <= 1) {
                    factories.get(j).setPotential(i, a[j][i]);
                    factories.get(j).setReal(i, factories.get(j).getPotential(i));
                    factories.get(j).setBalance(i, 0);
                    factories.get(j).writeResult(i);
                } else if (j == 2 || j == 3) {
                    factories.get(j).setPotential(i, a[j][i]);
                    if (i == 0)
                        factories.get(j).setBalance(i, (factories.get(j - 2).getReal(i) - factories.get(j).getPotential(i)));
                    else
                        factories.get(j).setBalance(i, (factories.get(j).getBalance(i - 1) + (factories.get(j - 2).getReal(i) - factories.get(j).getPotential(i))));
                    if (i != 0) {
                        if ((factories.get(j - 2).getReal(i) + factories.get(j).getBalance(i - 1)) >= factories.get(j).getPotential(i))
                            factories.get(j).setReal(i, factories.get(j).getPotential(i));
                        else
                            factories.get(j).setReal(i, (factories.get(j - 2).getReal(i) + factories.get(j).getBalance(i - 1)));
                    } else {
                        if ((factories.get(j - 2).getReal(i)) >= factories.get(j).getPotential(i))
                            factories.get(j).setReal(i, factories.get(j).getPotential(i));
                        else
                            factories.get(j).setReal(i, (factories.get(j - 2).getReal(i) + factories.get(j).getBalance(i)));
                    }
                    factories.get(j).writeResult(i);
                    //  factories.get(j).showTable();
                } else if (j == 4) {
                    int real;
                    //  factories.get(j).showTable();
                    factories.get(j).setPotential(i, a[j][i]);
                    if (i == 0) {
                        if (factories.get(j - 2).getReal(i) < factories.get(j - 1).getReal(i)) {
                            real = factories.get(j - 2).getReal(i);
                        } else {
                            real = factories.get(j - 1).getReal(i);
                        }
                    } else {
                        if (factories.get(j - 2).getReal(i) + factories.get(j).getBalance(i - 1) < factories.get(j - 1).getReal(i) + factories.get(j).getBalance2(i - 1)) {
                            real = factories.get(j - 2).getReal(i) + factories.get(j).getBalance(i - 1);
                        } else {
                            real = factories.get(j - 1).getReal(i) + factories.get(j).getBalance2(i - 1);
                        }
                    }

                    if (real > factories.get(j).getPotential(i))
                        real = factories.get(j).getPotential(i);
                    if (i == 0) {
                        factories.get(j).setBalance(i, (factories.get(j - 2).getReal(i) - real));
                        factories.get(j).setBalance2(i, (factories.get(j - 1).getReal(i) - real));
                    } else {
                        factories.get(j).setBalance(i, (factories.get(j - 2).getReal(i) - real + factories.get(j).getBalance(i - 1)));
                        factories.get(j).setBalance2(i, (factories.get(j - 1).getReal(i) - real + factories.get(j).getBalance2(i - 1)));
                    }
                    factories.get(j).setReal(i, real);
                    factories.get(j).writeResult(i);

                } else if (j == 5) {
                    factories.get(j).setPotential(i, a[j][i]);
                    if (i == 0)
                        factories.get(j).setBalance(i, (factories.get(j - 1).getReal(i) - factories.get(j).getPotential(i)));
                    else
                        factories.get(j).setBalance(i, (factories.get(j).getBalance(i - 1) + (factories.get(j - 1).getReal(i) - factories.get(j).getPotential(i))));
                    if (i != 0) {
                        if ((factories.get(j - 1).getReal(i) + factories.get(j).getBalance(i - 1)) >= factories.get(j).getPotential(i))
                            factories.get(j).setReal(i, factories.get(j).getPotential(i));
                        else
                            factories.get(j).setReal(i, (factories.get(j - 1).getReal(i) + factories.get(j).getBalance(i - 1)));
                    } else {
                        if ((factories.get(j - 1).getReal(i)) >= factories.get(j).getPotential(i))
                            factories.get(j).setReal(i, factories.get(j).getPotential(i));
                        else
                            factories.get(j).setReal(i, (factories.get(j - 1).getReal(i) + factories.get(j).getBalance(i)));
                    }
                    factories.get(j).writeResult(i);
                    //  factories.get(j).showTable();
                }
            }
    }

    /* public void run(){
         Random random=new Random();
         for (int i=0;i<quentityDays;i++)
             for(int j=0;j<quentityFactories;j++) {
             if (j==0) {
                 factories.get(j).setPotential(i, random.nextInt(6) + 1);
                 factories.get(j).setReal(i, factories.get(j).getPotential(i));
                 factories.get(j).setBalance(i, 0);
                 factories.get(j).writeResult(i);
             }
             else{
                 factories.get(j).setPotential(i, random.nextInt(6) + 1);
                 if (i==0)
                 factories.get(j).setBalance(i,( factories.get(j-1).getReal(i)-factories.get(j).getPotential(i)));
                 else
                 factories.get(j).setBalance(i,(factories.get(j).getBalance(i-1)+( factories.get(j-1).getReal(i)-factories.get(j).getPotential(i))));
                if (i!=0) {
                    if ((factories.get(j - 1).getReal(i) + factories.get(j).getBalance(i - 1)) >= factories.get(j).getPotential(i))
                        factories.get(j).setReal(i, factories.get(j).getPotential(i));
                    else
                        factories.get(j).setReal(i, (factories.get(j - 1).getReal(i) + factories.get(j).getBalance(i)));
                }
                else{
                    if ((factories.get(j - 1).getReal(i)) >= factories.get(j).getPotential(i))
                        factories.get(j).setReal(i, factories.get(j).getPotential(i));
                    else
                        factories.get(j).setReal(i, (factories.get(j - 1).getReal(i) + factories.get(j).getBalance(i)));
                }
                 factories.get(j).writeResult(i);
             }
             }
     }*/
    private void line1() {
        System.out.print("|");
        for (int i = 0; i < quentityFactories; i++)
            for (int j = 0; j < quentityDays; j++)
                System.out.print("======");
        for (int i = 0; i < quentityFactories; i++) {
            System.out.print("=");
        }

        System.out.print("====|");
    }

    private void line2() {
        System.out.print("\n|");
        for (int i = 0; i < quentityFactories; i++)
            for (int j = 0; j < quentityDays; j++)
                System.out.print("------");
        for (int i = 0; i < quentityFactories; i++) {
            System.out.print("-");
        }

        System.out.print("----|");
    }


    /*public void showResult(){
        line1();

        System.out.print("\n| № |");
        for (int i=0;i<quentityFactories;i++) {
            for (int j = 0; j < quentityDays; j++)
                if (j == quentityDays / 2) System.out.printf("%6d",i + 1);
                else System.out.print("      ");
            System.out.print("|");
        }
        line2();
        System.out.print("\n| Day|");
        for (int i=0;i<quentityFactories;i++) {
            for (int j = 0; j < quentityDays; j++) {
                System.out.printf("%5d", j+1);
                System.out.print("|");
            }
            System.out.print("|");
        }
        line2();
        System.out.print("\n|  P |");
        for (int i=0;i<quentityFactories;i++) {
            for (int j = 0; j < quentityDays; j++) {
                System.out.printf("%5d", factories.get(i).getPotential(j));
                System.out.print("|");
            }
            System.out.print("|");
        }
        line2();
        System.out.print("\n|  R |");
        for (int i=0;i<quentityFactories;i++) {
            for (int j = 0; j < quentityDays; j++) {
                System.out.printf("%5d", factories.get(i).getReal(j));
                System.out.print("|");
            }
            System.out.print("|");
        }
        line2();
        System.out.print("\n|  B |");
        for (int i=0;i<quentityFactories;i++) {
            for (int j = 0; j < quentityDays; j++) {
                System.out.printf("%5d", factories.get(i).getBalance(j));
                System.out.print("|");
            }
            System.out.print("|");
        }

        line2();
        System.out.print("\n|  R |");
        for (int i=0;i<quentityFactories;i++) {
            for (int j = 0; j < quentityDays; j++) {
                System.out.printf("%5.1f", factories.get(i).getResult(j));
                System.out.print("|");
            }
            System.out.print("|");
        }
        System.out.print("\n");
        line1();
    }*/
    public void showResult() {
        for (int i = 0; i < quentityFactories; i++) {
            System.out.print("\n                                              № " + (i + 1));
            factories.get(i).showTable();
        }
    }

}
