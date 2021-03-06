/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigcalculator;

import java.io.*;
import java.util.*;

public class Calculation {
    private LinkedList num1;
    private LinkedList num2;
    private LinkedList ans;
    private char operator = '+';
    private LinkedList remainder;
    public Calculation(){
        this.num1 = new LinkedList();
        this.num2 = new LinkedList();
        this.ans = new LinkedList();
        this.remainder = new LinkedList();
        this.operator = '+'; 
    }
    
    public Calculation(Calculation ca){
        this.num1 = ca.num1;
        this.num2 = ca.num2;
        this.ans = ca.ans;
        this.remainder = ca.remainder;
        this.operator = ca.operator; 
    }
    
    public LinkedList getNum1(){
        return this.num1;
    }
    
    public LinkedList getNum2(){
        return this.num2;
    }
    
    public LinkedList getAns(){
        return this.ans;
    }
    
    public LinkedList getRemainder(){
        return this.remainder;
    }
    
    public String getOperator(){
        return String.valueOf(operator);
    }
    
    public void setOperator(char c){
        this.operator = c;
    }
    
    public void readCalc(){
        /* Start with the empty list. */
        Scanner scan = new Scanner(System.in); 
        System.out.println("Enter number 1");
        String str1 = scan.next();
        System.out.println("Enter number 2");
        String str2 = scan.next();
            
        /* Kiem tra dau cua 2 so */
        if (str1.charAt(0) == '-'){
            this.num1.setSign(true);
            str1 = str1.substring(0, 0) + str1.substring(1);//xoa ki tu dau la dau "-"
        }
        if (str2.charAt(0) == '-'){
            this.num2.setSign(true);
            str2 = str2.substring(0, 0) + str2.substring(1);//xoa ki tu dau la dau "-"
        }
        
        /* Xoa ki tu dau cua so co chu so 0 */
        while ((str1.charAt(0) == '0')&&(str1.length() > 1)) //tranh truong hop 0 + v??i 1 so nao do
            str1 = str1.substring(0, 0) + str1.substring(1);
        while ((str2.charAt(0) == '0')&&(str2.length() > 1))
            str2 = str2.substring(0, 0) + str2.substring(1);
        
        /* Store digits in lists */
        int l1 = str1.length(), l2 = str2.length();        
        for (int i = 0; i < l1; i++)
            this.num1.add(str1.charAt(i) - '0');
        for (int i = 0; i < l2; i++)
            this.num2.add(str2.charAt(i) - '0');
    }
    
    public void storeInList(String str1, String str2){
        if (str1.charAt(0) == '-'){
            this.num1.setSign(true);
            str1 = str1.substring(0, 0) + str1.substring(1);//xoa ki tu dau la dau "-"
        }
        if (str2.charAt(0) == '-'){
            this.num2.setSign(true);
            str2 = str2.substring(0, 0) + str2.substring(1);//xoa ki tu dau la dau "-"
        }
        /* Xoa ki tu dau cua so co chu so 0 */
        while ((str1.charAt(0) == '0')&&(str1.length() > 1)) //tranh truong hop 0 + v??i 1 so nao do
            str1 = str1.substring(0, 0) + str1.substring(1);
        while ((str2.charAt(0) == '0')&&(str2.length() > 1))
            str2 = str2.substring(0, 0) + str2.substring(1);
        
        /* Store digits in lists */
        int l1 = str1.length(), l2 = str2.length();        
        for (int i = 0; i < l1; i++)
            this.num1.add(str1.charAt(i) - '0');
        for (int i = 0; i < l2; i++)
            this.num2.add(str2.charAt(i) - '0');
    }
    
    public void readCalc1(String str1, String str2, char operator){           
        /* Kiem tra dau cua 2 so */
//        if (str1.charAt(0) == '-'){
//            this.num1.setSign(true);
//            str1 = str1.substring(0, 0) + str1.substring(1);//xoa ki tu dau la dau "-"
//        }
//        if (str2.charAt(0) == '-'){
//            this.num2.setSign(true);
//            str2 = str2.substring(0, 0) + str2.substring(1);//xoa ki tu dau la dau "-"
//        }
        this.setOperator(operator);
        
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(operator);
        if (operator == '+'){
            if ((str1.charAt(0) == '-')&&(str2.charAt(0) == '-')){
                this.ans.setSign(true);
                this.storeInList(str1, str2);
                this.sum();
            } else if (str1.charAt(0) == '-') {
                this.storeInList(str2, str1);
                this.substract();
            } else if (str2.charAt(0) == '-'){
                this.storeInList(str1, str2);
                this.substract();
            } else {
                this.storeInList(str1, str2);
                this.sum();
            }
        } else if (operator == '-'){
            if ((str1.charAt(0) == '-')&&(str2.charAt(0) == '-')){
                this.storeInList(str2, str1);
                this.substract();
            } else if (str1.charAt(0) == '-') {
                this.ans.setSign(true);
                this.storeInList(str1, str2);
                this.sum();
            } else if (str2.charAt(0) == '-'){
                this.storeInList(str1, str2);
                this.sum();
            } else {
                this.storeInList(str1, str2);
                this.substract();
            }
        } else if (operator == 'x'){
            if ((str1.charAt(0) == '-')||(str2.charAt(0) == '-')){
                this.ans.setSign(true);
                this.storeInList(str1, str2);
                this.multiply();
            } else {
                this.storeInList(str1, str2);
                this.multiply();
            } 
        } else {
            if (((str1.charAt(0) == '-')&&(str2.charAt(0) == '-')) || ((str1.charAt(0) != '-')&&(str2.charAt(0) != '-'))){
                            
                this.storeInList(str1, str2);
                this.remainder = this.divide();
            } else {
                this.storeInList(str1, str2);
                this.remainder = this.divide();
                this.ans.setSign(true);
            } 
        }
        this.ans.printList();
        if (operator == ':')
            this.remainder.printList();
    }
    
    public void sum(){
        boolean signCalc = this.ans.getSign();
        LinkedList number1 = new LinkedList();
        LinkedList number2 = new LinkedList();
        
        /* number1 v?? number2 l???n l?????t l?? copy c???a 2 danh s??ch num1 v?? num2*/
        /* ?????o ng?????c danh s??ch ????? c???ng t??? tr??i qua ph???i */
        number1 = this.num1.reverseList();
        number2 = this.num2.reverseList();
//        number1.printList();
//        number2.printList();
        /* L??u ????? d??i 2 danh s??ch ????? t??m s??? c?? ????? d??i l???n h??n */
        int len1 = number1.size();
        int len2 = number2.size();
      
        /* T??m s??? c?? ????? d??i l???n h??n */
        int lenMax = len1 > len2 ? len1 : len2;
        
        /* Th???c hi???n n???i 0 v??o danh s??ch m???c ????ch ????? 2 danh s??ch b???ng nhau */
        if (lenMax > len1) {
            for (int i = lenMax; i >= len1; i--) {
                number1.add(0);
            }
        }
        if (lenMax > len2) {
            for (int i = lenMax; i >= len2; i--) {
                number2.add(0);
            }
        }
        
        
        /* Th???c hi???n c???ng */
        int carry = 0;
        for (int i = 0; i < lenMax; i++)
        {
            int d1 = 0, d2 = 0;            
            try {
                d1 = (int)number1.get(i);
            } 
            catch(Exception e){}            
            try {
                d2 = (int)number2.get(i);
            } 
            catch(Exception e){}                        
            int x = d1 + d2 + carry;
            this.ans.add(x % 10);
            carry = x / 10;
        }
        /* Th??m ph???n d??, n???u l???n c???ng cu???i c?? d?? th?? ta th??m ph???n d?? ???? v??o */
        while (carry != 0)
        {
            this.ans.add(carry % 10);
            carry /= 10;
        }          
        this.ans = this.ans.reverseList();
        this.ans.setSign(signCalc);
    }
    
    public void substract(){
        LinkedList number1 = new LinkedList();
        LinkedList number2 = new LinkedList();
        boolean signCalc = false;
        /* L??u ????? d??i 2 danh s??ch */
        int len1 = this.num1.size();
        int len2 = this.num2.size();
        
        /* N???u ????? d??i num1 l???n h??n num2 ho???c (????? d??i num1 b???ng num2 v?? num1 < num2) */
        if (len1 < len2 || ((len1 == len2) && (this.num1.toString().compareTo(this.num2.toString()) < 0))) 
        {
            number1 = number1.copyList(this.num2);
            number2 = number2.copyList(this.num1);
            if (this.ans.getSign() == true)
                signCalc = false;
            else
                signCalc = true;//N???u th???c hi???n ph??p tr??? s??? nh??? cho s??? l???n th?? k???t qu??? s??? ??m n??n s??? mang d???u tr???
        } else {
            number1 = number1.copyList(this.num1);
            number2 = number2.copyList(this.num2);
        }
        
        while (number2.size() != number1.size()){
            //Them so 0 vao so be hon de bang don vi
            number2 = number2.addFirst(0);
        }
        number1 = number1.reverseList();
        number2 = number2.reverseList();
//        number1.printList();
//        number2.printList();
        for (int i = 0; i < number2.size(); i++){
            number2.modifyAtPosition(9-(int)number2.get(i), i);
        }
        
        len1 = number1.size();
        len2 = number2.size();
        
        
        /* Substract the numbers */        
        LinkedList tmp = new LinkedList();
        LinkedList tmpAns = new LinkedList();

        int carry = 0;
        for (int i = 0; i < len1; i++)
        {
            int d1 = 0, d2 = 0;            
            try {
                d1 = (int)number1.get(i);
            } 
            catch(Exception e){}            
            try {
                d2 = (int)number2.get(i);
            } 
            catch(Exception e){}                        
            int x = d1 + d2 + carry;
            tmp.add(x % 10);
            carry = x / 10;
        }
        /* Adding carry and storing in ans list*/
        for (int i = 0; i < len1; i++)
        {
            int x = (int)tmp.get(i) + carry;
            tmpAns.add(x % 10);
            carry = x / 10;
        }    
             
        this.ans = ans.copyList(tmpAns).reverseList();
        this.ans.setSign(signCalc);
    }
    
//    public void substract(){
//        boolean signCalc = this.ans.getSign();
//        /* Khi tr??? hai s??? num1 v?? num2, ta ph???i bi???t s??? n??o l???n h??n ????? th???c hi???n ph??p tr???. 
//        V?? d??? khi th???c hi???n ph??p to??n 25 - 50. X??c ?????nh 50 l???n h??n 25 n??n l???y 50 ??? 25 = 25, th??m d???u tr??? v?? ???????c k???t qu??? -25 */
//        LinkedList number1 = new LinkedList();
//        LinkedList number2 = new LinkedList();
//
//        /* L??u ????? d??i 2 danh s??ch */
//        int len1 = this.num1.size();
//        int len2 = this.num2.size();
//        
//        /* N???u ????? d??i num1 l???n h??n num2 ho???c (????? d??i num1 b???ng num2 v?? num1 < num2) */
//        if (len1 < len2 || ((len1 == len2) && (this.num1.toString().compareTo(this.num2.toString()) < 0))) 
//        {
//            number1 = number1.copyList(this.num2);
//            number2 = number2.copyList(this.num1);
//            this.ans.setSign(true);//N???u th???c hi???n ph??p tr??? s??? nh??? cho s??? l???n th?? k???t qu??? s??? ??m n??n s??? mang d???u tr???
//        } else {
//            number1 = number1.copyList(this.num1);
//            number2 = number2.copyList(this.num2);
//        }
//        while (number2.size() != number1.size()) //Them so 0 vao so be hon de bang don vi
//            number2.add(0);
//        number1.printList();
//        number2.printList();
//        int l1 = number1.size();
//        int l2 = number2.size();
//        
//        /* number1 v?? number2 l???n l?????t l?? copy c???a 2 danh s??ch num1 v?? num2*/
//        /* ?????o ng?????c danh s??ch ????? c???ng t??? tr??i qua ph???i */
//        number1 = this.num1.reverseList();
//        number2 = this.num2.reverseList();
//
//        
//        // Run loop till small string length
//        // and subtract digit of str1 to str2
//        int carry = 0;
//        for (int i = 0; i < l2; i++) {
//            // Do school mathematics, compute difference of
//            // current digits
//            int sub = ((int)(number1.get(i)) - (int)(number2.get(i)) - carry);
// 
//            // If subtraction is less then zero
//            // we add then we add 10 into sub and
//            // take carry as 1 for calculating next step
//            if (sub < 0) {
//                sub = sub + 10;
//                carry = 1;
//            }
//            else
//                carry = 0;
// 
//            this.ans.add(sub);
//        }
// 
//        // subtract remaining digits of larger number
//        for (int i = l2; i < l1; i++) {
//            int sub = ((int)number1.get(i) - carry);
// 
//            // if the sub value is -ve, then make it
//            // positive
//            if (sub < 0) {
//                sub = sub + 10;
//                carry = 1;
//            }
//            else
//                carry = 0;
// 
//            this.ans.add(sub);
//        } 
//             
//        this.ans = this.ans.reverseList();
//        this.ans.setSign(signCalc);
//    } 
    
    public static LinkedList substractTwoNumbers(LinkedList number1, LinkedList number2){
        /* Khi tr??? hai s??? num1 v?? num2, ta ph???i bi???t s??? n??o l???n h??n ????? th???c hi???n ph??p tr???. 
        V?? d??? khi th???c hi???n ph??p to??n 25 - 50. X??c ?????nh 50 l???n h??n 25 n??n l???y 50 ??? 25 = 25, th??m d???u tr??? v?? ???????c k???t qu??? -25 */

        /* L??u ????? d??i 2 danh s??ch */
        int len1 = number1.size();
        int len2 = number2.size();
        LinkedList result = new LinkedList();
        
        /* N???u ????? d??i num1 l???n h??n num2 ho???c (????? d??i num1 b???ng num2 v?? num1 < num2) */
        if (len1 < len2 || ((len1 == len2) && (number1.toString().compareTo(number2.toString()) < 0))) 
        {
            number1 = number1.copyList(number2);
            number2 = number2.copyList(number1);
            result.setSign(true);//N???u th???c hi???n ph??p tr??? s??? nh??? cho s??? l???n th?? k???t qu??? s??? ??m n??n s??? mang d???u tr???
        } else {
            number1 = number1.copyList(number1);
            number2 = number2.copyList(number2);
        }
        
        
        int l1 = number1.size();
        int l2 = number2.size();
        
        /* number1 v?? number2 l???n l?????t l?? copy c???a 2 danh s??ch num1 v?? num2*/
        /* ?????o ng?????c danh s??ch ????? c???ng t??? tr??i qua ph???i */
        number1 = number1.reverseList();
        number2 = number2.reverseList();

        
        // Run loop till small string length
        // and subtract digit of str1 to str2
        int carry = 0;
        for (int i = 0; i < l2; i++) {
            // Do school mathematics, compute difference of
            // current digits
            int sub = ((int)(number1.get(i)) - (int)(number2.get(i)) - carry);
 
            // If subtraction is less then zero
            // we add then we add 10 into sub and
            // take carry as 1 for calculating next step
            if (sub < 0) {
                sub = sub + 10;
                carry = 1;
            }
            else
                carry = 0;
 
            result.add(sub);
        }
 
        // subtract remaining digits of larger number
        for (int i = l2; i < l1; i++) {
            int sub = ((int)number1.get(i) - carry);
 
            // if the sub value is -ve, then make it
            // positive
            if (sub < 0) {
                sub = sub + 10;
                carry = 1;
            }
            else
                carry = 0;
 
            result.add(sub);
        } 
             
        result = result.reverseList();
        return result;
    } 
    
    
    public void multiply(){
        boolean signCalc = this.ans.getSign();
        LinkedList number1 = new LinkedList();
        LinkedList number2 = new LinkedList();
        LinkedList tmpAns = new LinkedList();
        
        
        /* L??u ????? d??i 2 danh s??ch */
        int len1 = this.num1.size();
        int len2 = this.num2.size();   
        
        /* Xu li truong hop 0 nhan voi 1 so nao do*/
//      
        

        /* number1 v?? number2 l???n l?????t l?? copy c???a 2 danh s??ch num1 v?? num2*/
        /* ?????o ng?????c danh s??ch ????? c???ng t??? tr??i qua ph???i */
        number1 = this.num1.reverseList();
        number2 = this.num2.reverseList();
        
        /* T???o 2 index ????? t??m v??? tr?? c???a k???t qu??? danh s??ch ans */
        int i1 = 0;
        int i2 = 0;
        
        /* Do chu???i ?????o ng?????c n??n ta ??i t??? tr??i sang ph???i (th???c t??? l?? ph???i sang tr??i c???a s??? th??? nh???t) */
        for (int i = 0; i<len1; i++){
            int carry = 0;
            int d1 = (int)number1.get(i);
            /* Chuy???n v??? tr?? sang tr??i sau m???i l???n v???i c??c ch??? s??? c???a s??? th??? 2 (number2) */
            i2 = 0;
            /* Do chu???i ?????o ng?????c n??n ta ??i t??? tr??i sang ph???i (th???c t??? l?? ph???i sang tr??i c???a s??? th??? hai) */
            for (int j = 0; j<len2; j++){
                int d2 = (int)number2.get(j);
                /* Nh??n v???i ch??? s??? hi???n t???i c???a s??? th??? nh???t number1 v?? 
                c???ng k???t qu??? v???i k???t qu??? ???? l??u tr?????c ???? c???a danh s??ch k???t qu??? ans ??? v??? tr?? hi???n t???i */
                Object prevResult = tmpAns.get(i1 + i2);
                int sum = d1 * d2;
                
                if (prevResult != null){
                    sum += (int)prevResult + carry;
                } else {
                    sum += carry;
                }
                /* Ghi nh??? ph???n nh??? cho l???n l???p ti???p theo */
                carry = sum / 10;
                
                /* L??u tr??? k???t qu??? v?? kh??ng th??? c???ng v???i null n??n ph???i ki???m tra xem k???t qu??? tr?????c c?? null hay kh??ng*/
                if (prevResult != null)
                    tmpAns.modifyAtPosition(sum%10, i1 + i2);
                else
                    tmpAns.add(sum % 10);
                
                i2++;
            }
            
            /* Th??m ph???n d??, n???u l???n nh??n ch??? s??? cu???i c?? d?? th?? ta th??m ph???n d?? ???? v??o (ki???u h??? ph???n nh??? xu???ng) */
            if (carry > 0){
                /* V?? kh??ng th??? c???ng v???i null n??n ph???i ki???m tra xem k???t qu??? t???i v??? tr?? c???a k???t qu??? ans c?? null hay kh??ng */
                if (tmpAns.get(i1 + i2) != null)
                    tmpAns.modifyAtPosition((int)tmpAns.get(i1 + i2)+ carry, i1 + i2);
                else
                    tmpAns.add(carry);
            }    
            
            /* D???ch chuy???n sang tr??i sau m???i l???n th???c hi???n ph??p nh??n th??? i */
            i1++;
        }
        /* Ki???m tra xem k???t qu??? c?? l?? 0 hay kh??ng v?? b??? qua c??c s??? 0 ?????ng tr?????c s??? ???? t??nh t??? b??n ph???i (v?? danh s??ch ?????o ng?????c) */
        int i = tmpAns.size() - 1;
        while (i >= 0 && (int)tmpAns.get(i) == 0)
            i--;
        /* N???u k???t qu??? to??n l?? s??? 0 ngh??a l?? 1 trong 2 s??? c?? s??? l?? s??? 0 */
        if (i == -1){
            this.ans.add(0);//K???t qu??? s??? b???ng 0 v?? 0 nh??n m???y c??ng b???ng 0
        } else {
            /* Th??m k???t qu??? v??o danh s??ch ans */
            int j = 0;
            while (j <= i){
                this.ans.add(tmpAns.get(j));
                j++;
            }
                
        }
        this.ans = this.ans.reverseList();
        this.ans.setSign(signCalc);
    }
    
    
    public static LinkedList multiplyTwoNumbers(LinkedList number1, LinkedList number2){
        LinkedList tmpAns = new LinkedList();
        
        
        /* L??u ????? d??i 2 danh s??ch */
        int len1 = number1.toString().length();
        int len2 = number2.toString().length();  


        /* number1 v?? number2 l???n l?????t l?? copy c???a 2 danh s??ch num1 v?? num2*/
        /* ?????o ng?????c danh s??ch ????? c???ng t??? tr??i qua ph???i */
        number1 = number1.reverseList();
        number2 = number2.reverseList();
        
        /* T???o 2 index ????? t??m v??? tr?? c???a k???t qu??? danh s??ch ans */
        int i1 = 0;
        int i2 = 0;
        
        /* Do chu???i ?????o ng?????c n??n ta ??i t??? tr??i sang ph???i (th???c t??? l?? ph???i sang tr??i c???a s??? th??? nh???t) */
        for (int i = 0; i<len1; i++){
            int carry = 0;
            int d1 = (int)number1.get(i);
            /* Chuy???n v??? tr?? sang tr??i sau m???i l???n v???i c??c ch??? s??? c???a s??? th??? 2 (number2) */
            i2 = 0;
            /* Do chu???i ?????o ng?????c n??n ta ??i t??? tr??i sang ph???i (th???c t??? l?? ph???i sang tr??i c???a s??? th??? hai) */
            for (int j = 0; j<len2; j++){
                int d2 = (int)number2.get(j);
                /* Nh??n v???i ch??? s??? hi???n t???i c???a s??? th??? nh???t number1 v?? 
                c???ng k???t qu??? v???i k???t qu??? ???? l??u tr?????c ???? c???a danh s??ch k???t qu??? ans ??? v??? tr?? hi???n t???i */
                Object prevResult = tmpAns.get(i1 + i2);
                int sum = d1 * d2;
                
                if (prevResult != null){
                    sum += (int)prevResult + carry;
                } else {
                    sum += carry;
                }
                /* Ghi nh??? ph???n nh??? cho l???n l???p ti???p theo */
                carry = sum / 10;
                
                /* L??u tr??? k???t qu??? v?? kh??ng th??? c???ng v???i null n??n ph???i ki???m tra xem k???t qu??? tr?????c c?? null hay kh??ng*/
                if (prevResult != null)
                    tmpAns.modifyAtPosition(sum%10, i1 + i2);
                else
                    tmpAns.add(sum % 10);
                
                i2++;
            }
            
            /* Th??m ph???n d??, n???u l???n nh??n ch??? s??? cu???i c?? d?? th?? ta th??m ph???n d?? ???? v??o (ki???u h??? ph???n nh??? xu???ng) */
            if (carry > 0){
                /* V?? kh??ng th??? c???ng v???i null n??n ph???i ki???m tra xem k???t qu??? t???i v??? tr?? c???a k???t qu??? ans c?? null hay kh??ng */
                if (tmpAns.get(i1 + i2) != null)
                    tmpAns.modifyAtPosition((int)tmpAns.get(i1 + i2)+ carry, i1 + i2);
                else
                    tmpAns.add(carry);
            }    
            
            /* D???ch chuy???n sang tr??i sau m???i l???n th???c hi???n ph??p nh??n th??? i */
            i1++;
        }
        
        LinkedList ansList = new LinkedList();
        /* Ki???m tra xem k???t qu??? c?? l?? 0 hay kh??ng v?? b??? qua c??c s??? 0 ?????ng tr?????c s??? ???? t??nh t??? b??n ph???i (v?? danh s??ch ?????o ng?????c) */
        int i = tmpAns.size() - 1;
        while (i >= 0 && (int)tmpAns.get(i) == 0)
            i--;
        /* N???u k???t qu??? to??n l?? s??? 0 ngh??a l?? 1 trong 2 s??? c?? s??? l?? s??? 0 */
        if (i == -1){
            ansList.add(0);//K???t qu??? s??? b???ng 0 v?? 0 nh??n m???y c??ng b???ng 0
        } else {
            /* Th??m k???t qu??? v??o danh s??ch ans */
            int j = 0;
            while (j <= i){
                ansList.add(tmpAns.get(j));
                j++;
            }
                
        }
        ansList = ansList.reverseList();
    return ansList;
    }
    
    //So sanh so co chu so bang nhau
    public static int compare(LinkedList str1, LinkedList str2){
        str1.printList();
        str2.printList();
        if (str1.size() < str2.size())
            return -1;
        else if (str1.size() > str2.size())
            return 1;
            else
                for (int i = 0; i < str1.size() ; i++){
                    int num2 = (int)str2.get(i);
                    int num1 = (int)str1.get(i);
                    
                    System.out.println(num1 +" - "+ num2);
                    if (num1 > num2){
                        return 1;
                    }
                    if (num1 < num2){
                        return -1;
                    }
                }
        return 0;
    };
    
    public static int getResult(LinkedList result){
        int sum = 0;
        for (int i = 0; i< result.size(); i++){
            sum+= (int)result.get(i);
        }
        return sum;
    } 
    
    public static int solveQuotient(LinkedList dividend, LinkedList divisor){
        LinkedList result = new LinkedList();
        result.add(1);
        int quotient;

        while ((dividend.size() > 1)&&((int)dividend.get(0) == 0)){
                dividend.remove(0);
        }
        
        while (compare(multiplyTwoNumbers(divisor, result), dividend) < 0){
            result.add(1);
            LinkedList tmp = new LinkedList();
            tmp.add(getResult(result));
            result = result.copyList(tmp);
            System.out.println("Result: "+getResult(result));
        }
        quotient = getResult(result);
        
        if (compare(multiplyTwoNumbers(divisor, result), dividend) == 0){
            return quotient;
        }
        else {
            quotient--;
            return quotient;
        } 
    };
    
    //K???t qu??? chia tr??? v??? danh s??ch l?? k???t qu??? c???a s??? d??. Th????ng s??? l??u ??? danh s??ch ans c???a ?????i t?????ng Calculation
    public LinkedList divide(){
        boolean signCalc = this.ans.getSign();
        LinkedList checkList = new LinkedList();
        LinkedList dividend = new LinkedList();//Danh s??ch ????? ta l??u dividend t???c l?? s??? ta ch???n ????? chia v???i s??? b??? chia ??? b?????c 2
        LinkedList answer = new LinkedList();
        LinkedList remainder =  new LinkedList();
        /* L??u ????? d??i 2 danh s??ch */
        int len1 = this.num1.size(), len2 = this.num2.size();      
       
        /* number1 v?? number2 l???n l?????t l?? copy c???a 2 danh s??ch num1 v?? num2*/
        LinkedList number1 = new LinkedList();
        LinkedList number2 = new LinkedList();
        number1 = number1.copyList(this.num1);
        number2 = number2.copyList(this.num2);
        
        /* N???u s??? chia nh??? h??n s??? b??? chia th?? k???t qu??? l?? 0 v?? d?? l?? s??? chia */
        if (compare(number1, number2) == -1){
            this.ans.add(0);//k???t qu??? s??? l?? 0
            remainder = remainder.copyList(this.num1);//D?? s??? l?? s??? chia (num1)
            return remainder;
        }
        
        /* N???u s??? b??? chia b???ng 0 th?? tr??? v??? null v?? kh??ng th??? chia cho 0 */
        if (number2.size() == 1 && (int)number2.get(0) == 0)
            return null;
        
        int i = 0;
        int quotientTmp;
        LinkedList remainderTmp = new LinkedList();//????? l??u ph???n d?? c???a ph??p tr??? ??? b?????c 4
        boolean stop = false;
        while (((i < len1)||(stop==true))||(checkList.size()<=len1)){
            if (stop == true) stop = false;
            if (dividend.size() < number2.size()){
                if ((i+1) == len1){
                    if (checkList.size() < len1){
                        if (dividend.size() != number2.size())
                            answer.add(0);
                        dividend.add(number1.get(i));
                    }
                    checkList.add(1);
                } else {
                    if (checkList.size() < len1){
                        if (dividend.size() != number2.size())
                            answer.add(0);
                        dividend.add(number1.get(i));
                    }
                    checkList.add(1);
                    i++;
                }
            } else {
                if (dividend.size() == number2.size()){
                    if (compare(dividend, number2) >= 0){
                        quotientTmp = solveQuotient(dividend, number2);
                        answer.add(quotientTmp);
                        LinkedList mulAns = new LinkedList();//????? l??u k???t qu??? nh??n ??? b?????c 3
                        mulAns.add(quotientTmp);
                        LinkedList tmpMul = multiplyTwoNumbers(mulAns, number2);
                        if (dividend.toString().equals(tmpMul.toString())){
                            remainderTmp = new LinkedList();
                            remainderTmp.add(0);
                        } else {
                            remainderTmp = substractTwoNumbers(dividend, tmpMul);
                        }
                        //xu li so 0
                        int k;
                        if ((remainderTmp.size() == 1)&&((int)remainderTmp.get(0) == 0)){
                            k = 0; 
                        } else {
                            for (k = 0; k < remainderTmp.size(); k++)
                                if ((int)remainderTmp.get(k) != 0)
                                    break;
                        }
                        dividend = new LinkedList();
                        for (int j = k; j < remainderTmp.size(); j++){
                            dividend.add(remainderTmp.get(j));
                        }
                        
                        if (i < len1)
                            if ((int)dividend.get(0) == 0)
                                dividend.modifyAtPosition(number1.get(i), 0);
                            else
                                dividend.add(number1.get(i));
                        checkList.add(1);
                        i++;
                    } else {
                        if ((i <= len1)&&(checkList.size() <= len1)){
                            if (((int)dividend.get(0) == 0)&&(dividend.size() == 1)){
                                dividend.modifyAtPosition(number1.get(i), 0);
                            } else {
                                answer.add(0);
                                if (i < len1)
                                    dividend.add(number1.get(i));    
                            }
                            checkList.add(1);
                        }
                            if (i == (len1-1))
                                stop = true;
                            i++;
                    }
                } else {
                    if (dividend.size() > number2.size()){
                        quotientTmp = solveQuotient(dividend, number2);
                        answer.add(quotientTmp);
                        LinkedList mulAns = new LinkedList();//????? l??u k???t qu??? nh??n ??? b?????c 3
                        mulAns.add(quotientTmp);
                        LinkedList tmpMul = multiplyTwoNumbers(mulAns, number2);
                        if (dividend.toString().equals(tmpMul.toString())){
                            remainderTmp = new LinkedList();
                            remainderTmp.add(0);
                        }
                        else
                            remainderTmp = substractTwoNumbers(dividend, tmpMul);;
                        //xu li so 0
                        int k;
                        if ((remainderTmp.size() == 1)&&((int)remainderTmp.get(0) == 0)){
                                k = 0; 
                            } else {
                                for (k = 0; k < remainderTmp.size(); k++)
                                    if ((int)remainderTmp.get(k) != 0)
                                        break;
                            }
                        dividend = new LinkedList();
                        /* da sua code 1:54 am 13-11-2021 */
                        if (i < len1){
                            for (int j = k; j < remainderTmp.size(); j++){
                                dividend.add(remainderTmp.get(j));
                            }
                            if (i < len1)
                                dividend.add(number1.get(i));
                        } else {
                            for (int j = k; j < remainderTmp.size(); j++){
                                dividend.add(remainderTmp.get(j));
                            }
                            if (i < len1)
                                dividend.add(number1.get(i));
                        }
                        /* da sua code 1:54 am 13-11-2021 */
                        
//                        if (i < len1){
//                            dividend.add(number1.get(i));
                        checkList.add(1);
                        if (i == (len1-1))
                            stop = true;
                        i++;
                    }
                }
            }
             
        }
        
        /* X??a c??c s??? 0 ?????ng tr?????c k???t qu??? (v?? danh s??ch ?????o ng?????c) */
        answer = answer.reverseList();
        int k = answer.size() - 1;
        while (k >= 0 && (int)answer.get(k) == 0)
            k--;
        
        /* Th??m k???t qu??? v??o danh s??ch ans */
        int j = 0;
        while (j <= k){
            this.ans.add(answer.get(j));
            j++;
        }
                
        
        this.ans = this.ans.reverseList();
        this.ans.setSign(signCalc);
        remainder = remainder.copyList(remainderTmp);
        return remainder;
    }
    
    
    public static void main(String args[]){
        Calculation ca = new Calculation();
        ca.readCalc();
        LinkedList remain = new LinkedList();
        remain = ca.divide();
        ca.ans.printList();        
        remain.printList();
//        LinkedList n2 = new LinkedList();        
//        multiplyTwoNumbers(ca.num1, ca.num2).printList();
//        System.out.println("Size: "+multiplyTwoNumbers(ca.num1, ca.num2).size());
    }
}
