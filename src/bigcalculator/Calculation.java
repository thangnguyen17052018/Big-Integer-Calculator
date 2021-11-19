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
        while ((str1.charAt(0) == '0')&&(str1.length() > 1)) //tranh truong hop 0 + vơi 1 so nao do
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
        while ((str1.charAt(0) == '0')&&(str1.length() > 1)) //tranh truong hop 0 + vơi 1 so nao do
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
        
        /* number1 và number2 lần lượt là copy của 2 danh sách num1 và num2*/
        /* Đảo ngược danh sách để cộng từ trái qua phải */
        number1 = this.num1.reverseList();
        number2 = this.num2.reverseList();
//        number1.printList();
//        number2.printList();
        /* Lưu độ dài 2 danh sách để tìm số có độ dài lớn hơn */
        int len1 = number1.size();
        int len2 = number2.size();
      
        /* Tìm số có độ dài lớn hơn */
        int lenMax = len1 > len2 ? len1 : len2;
        
        /* Thực hiện nối 0 vào danh sách mục đích để 2 danh sách bằng nhau */
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
        
        
        /* Thực hiện cộng */
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
        /* Thêm phần dư, nếu lần cộng cuối có dư thì ta thêm phần dư đó vào */
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
        /* Lưu độ dài 2 danh sách */
        int len1 = this.num1.size();
        int len2 = this.num2.size();
        
        /* Nếu độ dài num1 lớn hơn num2 hoặc (độ dài num1 bằng num2 và num1 < num2) */
        if (len1 < len2 || ((len1 == len2) && (this.num1.toString().compareTo(this.num2.toString()) < 0))) 
        {
            number1 = number1.copyList(this.num2);
            number2 = number2.copyList(this.num1);
            if (this.ans.getSign() == true)
                signCalc = false;
            else
                signCalc = true;//Nếu thực hiện phép trừ số nhỏ cho số lớn thì kết quả sẽ âm nên sẽ mang dấu trừ
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
//        /* Khi trừ hai số num1 và num2, ta phải biết số nào lớn hơn để thực hiện phép trừ. 
//        Ví dụ khi thực hiện phép toán 25 - 50. Xác định 50 lớn hơn 25 nên lấy 50 – 25 = 25, thêm dấu trừ và được kết quả -25 */
//        LinkedList number1 = new LinkedList();
//        LinkedList number2 = new LinkedList();
//
//        /* Lưu độ dài 2 danh sách */
//        int len1 = this.num1.size();
//        int len2 = this.num2.size();
//        
//        /* Nếu độ dài num1 lớn hơn num2 hoặc (độ dài num1 bằng num2 và num1 < num2) */
//        if (len1 < len2 || ((len1 == len2) && (this.num1.toString().compareTo(this.num2.toString()) < 0))) 
//        {
//            number1 = number1.copyList(this.num2);
//            number2 = number2.copyList(this.num1);
//            this.ans.setSign(true);//Nếu thực hiện phép trừ số nhỏ cho số lớn thì kết quả sẽ âm nên sẽ mang dấu trừ
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
//        /* number1 và number2 lần lượt là copy của 2 danh sách num1 và num2*/
//        /* Đảo ngược danh sách để cộng từ trái qua phải */
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
        /* Khi trừ hai số num1 và num2, ta phải biết số nào lớn hơn để thực hiện phép trừ. 
        Ví dụ khi thực hiện phép toán 25 - 50. Xác định 50 lớn hơn 25 nên lấy 50 – 25 = 25, thêm dấu trừ và được kết quả -25 */

        /* Lưu độ dài 2 danh sách */
        int len1 = number1.size();
        int len2 = number2.size();
        LinkedList result = new LinkedList();
        
        /* Nếu độ dài num1 lớn hơn num2 hoặc (độ dài num1 bằng num2 và num1 < num2) */
        if (len1 < len2 || ((len1 == len2) && (number1.toString().compareTo(number2.toString()) < 0))) 
        {
            number1 = number1.copyList(number2);
            number2 = number2.copyList(number1);
            result.setSign(true);//Nếu thực hiện phép trừ số nhỏ cho số lớn thì kết quả sẽ âm nên sẽ mang dấu trừ
        } else {
            number1 = number1.copyList(number1);
            number2 = number2.copyList(number2);
        }
        
        
        int l1 = number1.size();
        int l2 = number2.size();
        
        /* number1 và number2 lần lượt là copy của 2 danh sách num1 và num2*/
        /* Đảo ngược danh sách để cộng từ trái qua phải */
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
        
        
        /* Lưu độ dài 2 danh sách */
        int len1 = this.num1.size();
        int len2 = this.num2.size();   
        
        /* Xu li truong hop 0 nhan voi 1 so nao do*/
//      
        

        /* number1 và number2 lần lượt là copy của 2 danh sách num1 và num2*/
        /* Đảo ngược danh sách để cộng từ trái qua phải */
        number1 = this.num1.reverseList();
        number2 = this.num2.reverseList();
        
        /* Tạo 2 index để tìm vị trí của kết quả danh sách ans */
        int i1 = 0;
        int i2 = 0;
        
        /* Do chuỗi đảo ngược nên ta đi từ trái sang phải (thực tế là phải sang trái của số thứ nhất) */
        for (int i = 0; i<len1; i++){
            int carry = 0;
            int d1 = (int)number1.get(i);
            /* Chuyển vị trí sang trái sau mỗi lần với các chữ số của số thứ 2 (number2) */
            i2 = 0;
            /* Do chuỗi đảo ngược nên ta đi từ trái sang phải (thực tế là phải sang trái của số thứ hai) */
            for (int j = 0; j<len2; j++){
                int d2 = (int)number2.get(j);
                /* Nhân với chữ số hiện tại của số thứ nhất number1 và 
                cộng kết quả với kết quả đã lưu trước đó của danh sách kết quả ans ở vị trí hiện tại */
                Object prevResult = tmpAns.get(i1 + i2);
                int sum = d1 * d2;
                
                if (prevResult != null){
                    sum += (int)prevResult + carry;
                } else {
                    sum += carry;
                }
                /* Ghi nhớ phần nhớ cho lần lặp tiếp theo */
                carry = sum / 10;
                
                /* Lưu trữ kết quả vì không thể cộng với null nên phải kiểm tra xem kết quả trước có null hay không*/
                if (prevResult != null)
                    tmpAns.modifyAtPosition(sum%10, i1 + i2);
                else
                    tmpAns.add(sum % 10);
                
                i2++;
            }
            
            /* Thêm phần dư, nếu lần nhân chữ số cuối có dư thì ta thêm phần dư đó vào (kiểu hạ phần nhớ xuống) */
            if (carry > 0){
                /* Vì không thể cộng với null nên phải kiểm tra xem kết quả tại vị trí của kết quả ans có null hay không */
                if (tmpAns.get(i1 + i2) != null)
                    tmpAns.modifyAtPosition((int)tmpAns.get(i1 + i2)+ carry, i1 + i2);
                else
                    tmpAns.add(carry);
            }    
            
            /* Dịch chuyển sang trái sau mỗi lần thực hiện phép nhân thứ i */
            i1++;
        }
        /* Kiểm tra xem kết quả có là 0 hay không và bỏ qua các số 0 đứng trước số đó tính từ bên phải (vì danh sách đảo ngược) */
        int i = tmpAns.size() - 1;
        while (i >= 0 && (int)tmpAns.get(i) == 0)
            i--;
        /* Nếu kết quả toàn là số 0 nghĩa là 1 trong 2 số có số là số 0 */
        if (i == -1){
            this.ans.add(0);//Kết quả sẽ bằng 0 vì 0 nhân mấy cũng bằng 0
        } else {
            /* Thêm kết quả vào danh sách ans */
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
        
        
        /* Lưu độ dài 2 danh sách */
        int len1 = number1.toString().length();
        int len2 = number2.toString().length();  


        /* number1 và number2 lần lượt là copy của 2 danh sách num1 và num2*/
        /* Đảo ngược danh sách để cộng từ trái qua phải */
        number1 = number1.reverseList();
        number2 = number2.reverseList();
        
        /* Tạo 2 index để tìm vị trí của kết quả danh sách ans */
        int i1 = 0;
        int i2 = 0;
        
        /* Do chuỗi đảo ngược nên ta đi từ trái sang phải (thực tế là phải sang trái của số thứ nhất) */
        for (int i = 0; i<len1; i++){
            int carry = 0;
            int d1 = (int)number1.get(i);
            /* Chuyển vị trí sang trái sau mỗi lần với các chữ số của số thứ 2 (number2) */
            i2 = 0;
            /* Do chuỗi đảo ngược nên ta đi từ trái sang phải (thực tế là phải sang trái của số thứ hai) */
            for (int j = 0; j<len2; j++){
                int d2 = (int)number2.get(j);
                /* Nhân với chữ số hiện tại của số thứ nhất number1 và 
                cộng kết quả với kết quả đã lưu trước đó của danh sách kết quả ans ở vị trí hiện tại */
                Object prevResult = tmpAns.get(i1 + i2);
                int sum = d1 * d2;
                
                if (prevResult != null){
                    sum += (int)prevResult + carry;
                } else {
                    sum += carry;
                }
                /* Ghi nhớ phần nhớ cho lần lặp tiếp theo */
                carry = sum / 10;
                
                /* Lưu trữ kết quả vì không thể cộng với null nên phải kiểm tra xem kết quả trước có null hay không*/
                if (prevResult != null)
                    tmpAns.modifyAtPosition(sum%10, i1 + i2);
                else
                    tmpAns.add(sum % 10);
                
                i2++;
            }
            
            /* Thêm phần dư, nếu lần nhân chữ số cuối có dư thì ta thêm phần dư đó vào (kiểu hạ phần nhớ xuống) */
            if (carry > 0){
                /* Vì không thể cộng với null nên phải kiểm tra xem kết quả tại vị trí của kết quả ans có null hay không */
                if (tmpAns.get(i1 + i2) != null)
                    tmpAns.modifyAtPosition((int)tmpAns.get(i1 + i2)+ carry, i1 + i2);
                else
                    tmpAns.add(carry);
            }    
            
            /* Dịch chuyển sang trái sau mỗi lần thực hiện phép nhân thứ i */
            i1++;
        }
        
        LinkedList ansList = new LinkedList();
        /* Kiểm tra xem kết quả có là 0 hay không và bỏ qua các số 0 đứng trước số đó tính từ bên phải (vì danh sách đảo ngược) */
        int i = tmpAns.size() - 1;
        while (i >= 0 && (int)tmpAns.get(i) == 0)
            i--;
        /* Nếu kết quả toàn là số 0 nghĩa là 1 trong 2 số có số là số 0 */
        if (i == -1){
            ansList.add(0);//Kết quả sẽ bằng 0 vì 0 nhân mấy cũng bằng 0
        } else {
            /* Thêm kết quả vào danh sách ans */
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
    
    //Kết quả chia trả về danh sách là kết quả của số dư. Thương sẽ lưu ở danh sách ans của đối tượng Calculation
    public LinkedList divide(){
        boolean signCalc = this.ans.getSign();
        LinkedList checkList = new LinkedList();
        LinkedList dividend = new LinkedList();//Danh sách để ta lưu dividend tức là số ta chọn để chia với số bị chia ở bước 2
        LinkedList answer = new LinkedList();
        LinkedList remainder =  new LinkedList();
        /* Lưu độ dài 2 danh sách */
        int len1 = this.num1.size(), len2 = this.num2.size();      
       
        /* number1 và number2 lần lượt là copy của 2 danh sách num1 và num2*/
        LinkedList number1 = new LinkedList();
        LinkedList number2 = new LinkedList();
        number1 = number1.copyList(this.num1);
        number2 = number2.copyList(this.num2);
        
        /* Nếu số chia nhỏ hơn số bị chia thì kết quả là 0 và dư là số chia */
        if (compare(number1, number2) == -1){
            this.ans.add(0);//kết quả sẽ là 0
            remainder = remainder.copyList(this.num1);//Dư sẽ là số chia (num1)
            return remainder;
        }
        
        /* Nếu số bị chia bằng 0 thì trả về null vì không thể chia cho 0 */
        if (number2.size() == 1 && (int)number2.get(0) == 0)
            return null;
        
        int i = 0;
        int quotientTmp;
        LinkedList remainderTmp = new LinkedList();//Để lưu phần dư của phép trừ ở bước 4
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
                        LinkedList mulAns = new LinkedList();//Để lưu kết quả nhân ở bước 3
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
                        LinkedList mulAns = new LinkedList();//Để lưu kết quả nhân ở bước 3
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
        
        /* Xóa các số 0 đứng trước kết quả (vì danh sách đảo ngược) */
        answer = answer.reverseList();
        int k = answer.size() - 1;
        while (k >= 0 && (int)answer.get(k) == 0)
            k--;
        
        /* Thêm kết quả vào danh sách ans */
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
