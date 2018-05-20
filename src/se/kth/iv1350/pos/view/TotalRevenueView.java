package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.model.TotalObserver;

class TotalRevenueView implements TotalObserver{
    private int sumOfTotal;
    /**
     * creates new instance with total set to 0
     */
    public TotalRevenueView() {
        sumOfTotal = 0;
    }
@Override
    public void newTotal(int total) {
        addNewTotal(total);
        printCurrentState();
    }

    private void addNewTotal(int total) {
        sumOfTotal = sumOfTotal + total;
    }

    private void printCurrentState(){
        System.out.println("-------Observer--------");
        System.out.println("Total sold since program started: ");
        System.out.println(sumOfTotal);
        System.out.println("-----------------------");
    }
}
