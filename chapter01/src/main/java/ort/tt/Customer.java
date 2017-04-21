package ort.tt;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by zangzhonghua on 2017/4/21.
 */
public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        this.rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = this.rentals.elements();
        StringBuilder strBuilder = new StringBuilder("租赁次数：");
        strBuilder.append(this.getName()).append("\n");
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();
            thisAmount = this.getThisAmount(each);
            frequentRenterPoints++;
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDays() > 1) {
                frequentRenterPoints++;
            }
            strBuilder.append("\t").append(each.getMovie().getTitle())
                    .append("/t").append(String.valueOf(thisAmount))
                    .append(" frequent renter points");
            totalAmount += thisAmount;
        }
        strBuilder.append("Amount owed is").append(String.valueOf(totalAmount)).append("\n")
                .append("You earned ").append(String.valueOf(frequentRenterPoints))
                .append(" frequent renter points");

        return strBuilder.toString();
    }

    //计算租金
    private double getThisAmount(Rental each) {
        double thisAmount = 0;
        switch (each.getMovie().getPriceCode()) {
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (each.getDays() > 3) {
                    thisAmount += (each.getDays() - 3) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += each.getDays() * 3;
                break;
            case Movie.REGULAR:
                thisAmount += 2;
                if (each.getDays() > 2) {
                    thisAmount += (each.getDays() - 2) * 1.5;
                }
                break;
        }
        return thisAmount;
    }
}
