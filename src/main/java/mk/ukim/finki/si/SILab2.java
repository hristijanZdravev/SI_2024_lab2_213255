package mk.ukim.finki.si;


import java.util.List;


public class SILab2 {
    public static boolean checkCart(List<Item> allItems, int payment){//1
        if (allItems == null){//2
            throw new RuntimeException("allItems list can't be null!");//3
        }

        float sum = 0;//4

        for (int i = 0; i < allItems.size(); i++){//5.1
            Item item = allItems.get(i);//6
            if (item.getName() == null || item.getName().length() == 0){//7
                item.setName("unknown");//8
            }
            if (item.getBarcode() != null){//9
                String allowed = "0123456789";//10
                char chars[] = item.getBarcode().toCharArray();//11
                for (int j = 0; j < item.getBarcode().length(); j++){//12.1
                    char c = item.getBarcode().charAt(j);//13
                    if (allowed.indexOf(c) == -1){//14
                        throw new RuntimeException("Invalid character in item barcode!");//15
                    }
                }//12.3
                if (item.getDiscount() > 0){//16
                    sum += item.getPrice()*item.getDiscount();//17
                }
                else {
                    sum += item.getPrice();//18
                }//19
            }
            else {
                throw new RuntimeException("No barcode!");//20
            }
            if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'){//21
                sum -= 30;//22
            }
        }//5.3
        if (sum <= payment){//23
            return true;//24
        }
        else {
            return false;//25
        }//26
    }//27(END)

    //function for checking multiple condition in the checkCart() function
    public static boolean checkMultipleCondition(int price, float discount, String barcode) {
        if (price > 300 && discount > 0 && barcode.charAt(0) == '0'){
            return true;
        }
        return false;
    }

    }