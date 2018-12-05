package tudelft.chocolate;

public class ChocolateBags {

    public int calculate(int small, int big, int total) {
        if(big*5 + small < total) {
            return -1;
        }

        int noOfBig = total/5;
        if(noOfBig > big) noOfBig = big;

        int noOfSmall = total - noOfBig*5;
        if(noOfSmall <= small) {
            return noOfSmall;
        }
        return -1;
    }

    public int calculate2(int small, int big, int total) {
        int maxBigBoxes = total / 5;
        int bigBoxesWeCanUse = maxBigBoxes < big ? maxBigBoxes : big;
        total -= (bigBoxesWeCanUse * 5);

        if(small < total)
            return -1;
        return total;

    }

}
