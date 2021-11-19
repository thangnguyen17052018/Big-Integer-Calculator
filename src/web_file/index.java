//import java.io.*;
//import java.util.*;
//
//public class Calculator {
//    
//    public static LinkedList substractTwoNumbers(String str1, String str2){
//        LinkedList num1 = new LinkedList();
//        LinkedList num2 = new LinkedList();
//        int len1 = str1.length(), len2 = str2.length();
//        String s1 = str1, s2 = str2;
////        System.out.println("\nSTR1: "+str1);
////        System.out.println("\nSTR2: "+str2);
//        boolean sign = false;
//        if (len1 < len2 || (len1 == len2 && str1.compareTo(str2) < 0)) //Neu first char s1 nho hon s2
//        {
//            s1 = str2;
//            s2 = str1;
//            sign = true;
//        }
//        len1 = s1.length();
//        while (s2.length() != len1) //Them so 0 vao so be hon de bang don vi
//            s2 = "0" + s2;
//        
////        System.out.println("\nSTR1: "+s1);
////        System.out.println("\nSTR2: "+s2);
//        /* Luu tru digits vao danh sach lien ket */            
//        for (int i = len1 - 1; i >= 0; i--)
//        {
//            num1.add(s1.charAt(i) - '0'); //chuyen ve kieu so nguyen
//            //str1.charAt(i) - '0'
//            /* 9 complement of second number */
//            num2.add('9' - s2.charAt(i));
////            System.out.println("\n");
////            System.out.print(str1.charAt(i) - '0');
////            System.out.print('9' - str2.charAt(i));//9 phan bu cua so thu 2
//        }    
//
//        /* Substract the numbers */        
//        LinkedList tmp = new LinkedList();
//        LinkedList ans = new LinkedList();
//
//        int carry = 0;
//        for (int i = 0; i < len1; i++)
//        {
//            int d1 = 0, d2 = 0;            
//            try {
//                d1 = (int)num1.get(i);
//            } 
//            catch(Exception e){}            
//            try {
//                d2 = (int)num2.get(i);
//            } 
//            catch(Exception e){}                        
//            int x = d1 + d2 + carry;
//            tmp.add(x % 10);
//            carry = x / 10;
//        }
//        /* Adding carry and storing in ans list*/
//        for (int i = 0; i < len1; i++)
//        {
//            int x = (int)tmp.get(i) + carry;
//            ans.add(x % 10);
//            carry = x / 10;
//        }    
//        /* Print number */    
////        if (s1.equals(s2))
////            System.out.print("0\n");
////        else
////        {
//
////        }                 
//        if (sign)
//            ans.add(-1);//dau tru tuong trung cho truong S (sign dau cua so)
//        
//        return ans;
//    } 
//    
//    public static LinkedList sumTwoNumbers(String str1, String str2){
//        LinkedList num1 = new LinkedList();
//        LinkedList num2 = new LinkedList();
//        LinkedList tmp = new LinkedList();
//        LinkedList ans = new LinkedList();
//        String s1 = str1;
//        String s2 = str2;
//        /* Store digits in lists */
//        int l1 = s1.length(), l2 = s2.length();        
//        for (int i = l1 - 1; i >= 0; i--)
//            num1.add(s1.charAt(i) - '0');
//        for (int i = l2 - 1; i >= 0; i--)
//            num2.add(s2.charAt(i) - '0');
//        /* Adding digits and storing in ans list */
//        int len = l1 > l2 ? l1 : l2;
//        int carry = 0;
//        for (int i = 0; i < len; i++)
//        {
//            int d1 = 0, d2 = 0;            
//            try {
//                d1 = (int)num1.get(i);
//            } 
//            catch(Exception e){}            
//            try {
//                d2 = (int)num2.get(i);
//            } 
//            catch(Exception e){}                        
//            int x = d1 + d2 + carry;
//            ans.add(x % 10);
//            carry = x / 10;
//        }
//        /* Adding carry */
//        while (carry != 0)
//        {
//            ans.add(carry % 10);
//            carry /= 10;
//        }
//        return ans;
//    }
//    
//    public static void printSubstract(LinkedList result){
//        /* Dont print leading zeroes */
//        int i;
//        int sign = 0;
//        if ((int)result.get(result.size() - 1) == -1){
//            System.out.print("-");
//            sign = 1;
//        }
//        for (i = result.size() - 1 - sign; i >= 0; i--)
//            if ((int)result.get(i) != 0)
//                break;
//        for (; i >= 0; i--)
//            System.out.print(result.get(i));            
//        System.out.println();
//    }
//    
//    public static void printSum(LinkedList result){
//        /* Printing ans list */
//        for (int i = result.size() - 1; i >= 0; i--)
//            System.out.print(result.get(i));
//        System.out.println();     
//    }
//    
//    public static LinkedList multiplyTwoNumbers(String str1, String str2){
//        LinkedList num1 = new LinkedList();
//        LinkedList num2 = new LinkedList();
//        LinkedList tmp = new LinkedList();
//        LinkedList ans = new LinkedList();
//        String s1 = str1;
//        String s2 = str2;
//        int len1 = s1.length(), len2 = s2.length();        
//        
//        /* Xu li truong hop 0 nhan voi 1 so nao do*/
////        if (len1 == 0 || len2 == 0)
////        return 0;
//        
//        /* Store digits in lists */
//        for (int i = len1 - 1; i >= 0; i--)
//            num1.add(s1.charAt(i) - '0');
//        for (int i = len2 - 1; i >= 0; i--)
//            num2.add(s2.charAt(i) - '0');
//        
//        
//        /* Tao 2 index de tim vi tri cua ket qua */
//        int i1 = 0;
//        int i2 = 0;
//        
//        for (int i = 0; i<len1; i++){
//            int carry = 0;
//            int d1 = (int)num1.get(i);
//            //Chuyen vi tri sang trai sau moi lan 
//            //nhan voi 1 chu so cua num2
//            i2 = 0;
//            for (int j = 0; j<len2; j++){
//                int d2 = (int)num2.get(j);
//                //Nhan voi chu so hien tai cua so dau tien va 
//                //them ket qua vao ket qua da luu truoc do
//                Object prevResult = ans.get(i1 + i2);
//                int sum;
//                if (prevResult != null){
//                    sum = d1 * d2 + (int)prevResult + carry;
//                } else {
//                    sum = d1 * d2 + carry;
//                }
//
//                carry = sum / 10;
//                
//                if (prevResult != null)
//                    ans.modifyAtPosition(sum%10, i1 + i2);
//                else
//                    ans.add(sum % 10);
//                
//                i2++;
//            }
//            
//            //luu tru carry cho o ke tiep
//            if (carry > 0)
//                if (ans.get(i1 + i2) != null)
//                    ans.modifyAtPosition((int)ans.get(i1 + i2)+ carry, i1 + i2);
//                else
//                    ans.add(carry);
//        
//            //de chuyen vi tri sang trai
//            //sau moi lan nhan o num1
//            i1++;
//        }
//        // ignore '0's from the right
////        int i = ans.size() - 1;
////        while (i >= 0 && (int)ans.get(i) == 0)
////            ans.remove(ans)
//    return ans;
//    }
//    
//    //reverse ket qua
//    public static LinkedList reverseList(LinkedList list){
//        LinkedList newList = new LinkedList();
//        for (int i = list.size()-1; i >= 0; i--){
//            newList.add(list.get(i));
//        }
//    return newList;
//    }
//    
//    
//    //So sanh so co chu so bang nhau
//    public static int compare(LinkedList str1, LinkedList str2){
//        if (str1.size() < str2.size())
//            return -1;
//        else if (str1.size() > str2.size())
//            return 1;
//            else
//                for (int i = 0; i < str1.size() ; i++){
//                    int num1 = (int)str1.get(i);
//                    int num2 = (int)str2.get(i);
//
//                    if (num1 > num2){
//                        return 1;
//                    }
//                    if (num1 < num2){
//                        return -1;
//                    }
//                }
//        return 0;
//    };
//    
//    public static String toString(LinkedList list){
//        String s = new String();
//        for (int i = 0; i < list.size(); i++){
//            s = s + list.get(i);
//        }
//    return s;
//    }
//    
//    public static int solveQuotient(LinkedList dividend, LinkedList divisor){
//        int result = 1;
//        String s = new String();
//        s = toString(divisor);
//        
//        
//        while (compare(reverseList(multiplyTwoNumbers(s, Integer.toString(result))), dividend) < 0){
//            result++;
//        }
//        if (compare(reverseList(multiplyTwoNumbers(s, Integer.toString(result))), dividend) == 0)
//            return result;
//        else {
//            result--;
//            return result;
//        } 
//    };
//    
//    
//    public static LinkedList divideTwoNumbers(String str1, String str2){
//        LinkedList checkList = new LinkedList();
//        LinkedList num1 = new LinkedList();
//        LinkedList num2 = new LinkedList();
//        LinkedList dividend = new LinkedList();
//        LinkedList ans = new LinkedList();
//        String s1 = str1;
//        String s2 = str2;
//        int len1 = s1.length(), len2 = s2.length();      
//       
//
//        for (int i = 0; i < s1.length(); i++)
//            num1.add(s1.charAt(i) - '0');
//        
//        for (int i = 0; i < s2.length(); i++)
//            num2.add(s2.charAt(i) - '0');
//
//        if (compare(num1, num2) == -1){
//            ans.add(0);
//            return ans;
//        }
//        
//        int i = 0;
//        int quotientTmp;
//        LinkedList remainderTmp = new LinkedList();
//        boolean stop = false;
//        while (((i < len1)||(stop==true))||(checkList.size()<=len1)){
//            if (stop == true) stop = false;
//            if (dividend.size() < num2.size()){
//                if ((i+1) == len1){
//                    if (checkList.size() < len1){
//                        if (dividend.size() != num2.size())
//                            ans.add(0);
//                        dividend.add(str1.charAt(i) - '0');
//                    }
//                    checkList.add(1);
//                    dividend.printList();
//                } else {
//                    if (checkList.size() < len1){
//                        if (dividend.size() != num2.size())
//                            ans.add(0);
//                        dividend.add(str1.charAt(i) - '0');
//                    }
//                    checkList.add(1);
//                    dividend.printList();
//                    i++;
//                }
//            } else {
//                if (dividend.size() == num2.size()){
//                    if (compare(dividend, num2) >= 0){
//                        quotientTmp = solveQuotient(dividend, num2);
//                        ans.add(quotientTmp);
//                        ans.printList();
//                        LinkedList tmpMul = multiplyTwoNumbers(Integer.toString(quotientTmp), toString(num2));
//                        tmpMul = reverseList(tmpMul);
//                        tmpMul.printList();
//                        if (toString(dividend).equals(toString(tmpMul))){
//                            remainderTmp = new LinkedList();
//                            remainderTmp.add(0);
//                        } else {
//                            remainderTmp = substractTwoNumbers(toString(dividend), toString(tmpMul));
//                        }
//                            remainderTmp = reverseList(remainderTmp);
//                            //xu li so 0
//                            int k;
//                            if ((remainderTmp.size() == 1)&&((int)remainderTmp.get(0) == 0)){
//                                k = 0; 
//                            } else {
//                                for (k = 0; k < remainderTmp.size(); k++)
//                                    if ((int)remainderTmp.get(k) != 0)
//                                        break;
//                            }
//                            remainderTmp.printList();
//                        dividend = new LinkedList();
//                        for (int j = k; j < remainderTmp.size(); j++){
//                            dividend.add(remainderTmp.get(j));
//                        }
//                        
//                        if (i < len1)
//                            if ((int)dividend.get(0) == 0)
//                                dividend.modifyAtPosition(str1.charAt(i) - '0', 0);
//                            else
//                                dividend.add(str1.charAt(i) - '0');
//                        checkList.add(1);
//                        i++;
//                            dividend.printList();
//                    } else {
//                        if ((i <= len1)&&(checkList.size() <= len1)){
//                            if (((int)dividend.get(0) == 0)&&(dividend.size() == 1)){
//                                dividend.modifyAtPosition(str1.charAt(i) - '0', 0);
//                            } else {
//                                ans.add(0);
//                                if (i < len1)
//                                    dividend.add(str1.charAt(i) - '0');    
//                            }
//                            checkList.add(1);
//                        }
//                            dividend.printList(); 
//                            if (i == (len1-1))
//                                stop = true;
//                            i++;
//                    }
//                } else {
//                    if (dividend.size() > num2.size()){
//                        quotientTmp = solveQuotient(dividend, num2);
//                        ans.add(quotientTmp);
//                        ans.printList();
//                        LinkedList tmpMul = multiplyTwoNumbers(Integer.toString(quotientTmp), toString(num2));
//                        tmpMul = reverseList(tmpMul);
//                        tmpMul.printList();
//                        if (toString(dividend).equals(toString(tmpMul))){
//                            remainderTmp = new LinkedList();
//                            remainderTmp.add(0);
//                        }
//                        else
//                            remainderTmp = substractTwoNumbers(toString(dividend), toString(tmpMul));
//                        remainderTmp = reverseList(remainderTmp);
//                        remainderTmp.printList();
//                        //xu li so 0
//                        int k;
//                        if ((remainderTmp.size() == 1)&&((int)remainderTmp.get(0) == 0)){
//                                k = 0; 
//                            } else {
//                                for (k = 0; k < remainderTmp.size(); k++)
//                                    if ((int)remainderTmp.get(k) != 0)
//                                        break;
//                            }
//                        remainderTmp.printList();
//                        dividend = new LinkedList();
//                        for (int j = k; j < remainderTmp.size(); j++){
//                            dividend.add(remainderTmp.get(j));
//                        }
//                        if (i < len1)
//                            dividend.add(str1.charAt(i) - '0');
//                        checkList.add(1);
//                        if (i == (len1-1))
//                            stop = true;
//                        i++;
//                        dividend.printList();
//                    }
//                }
//            }
//             
//        }
//        
//        return ans;
//    }
//    
//    public static void main(String[] args)
//    {
//        /* Start with the empty list. */
//        Scanner scan = new Scanner(System.in); 
//        System.out.println("Subtracting Large Numbers Using Linked Lists Test\n");
//        System.out.println("Enter number 1");
//        String str1 = scan.next();
//        System.out.println("Enter number 2");
//        String str2 = scan.next();
//        
//        /* Kiem tra dau cua 2 so */
//        boolean check1 = false;
//        boolean check2 = false;
//        if (str1.charAt(0) == '-'){
//            check1 = true;
//            str1 = str1.substring(0, 0) + str1.substring(1);//xoa ki tu dau la dau "-"
//        }
//        if (str2.charAt(0) == '-'){
//            check2 = true;
//            str2 = str2.substring(0, 0) + str2.substring(1);//xoa ki tu dau la dau "-"
//        }
//        
//        /* Xoa ki tu dau cua so co chu so 0 */
//        while ((str1.charAt(0) == '0')&&(str1.length() > 1)) //tranh truong hop 0 + vơi 1 so nao do
//            str1 = str1.substring(0, 0) + str1.substring(1);
//        while ((str2.charAt(0) == '0')&&(str1.length() > 1))
//            str2 = str2.substring(0, 0) + str2.substring(1);
//        
//        LinkedList ans = new LinkedList();
//        
//        /* SUBSTRACT TWO NUMBERS */
//        System.out.println("Difference: ");
//        if (str1.equals(str2)){
//            System.out.println("0");
//        } else {
//        if ((check1 == true)&&(check2 == true)){
//            ans = substractTwoNumbers(str2, str1);
//            //System.out.println("/n*1*/n");
//            printSubstract(ans);
//        } else if ((check1 == true)&&(check2 == false)){
//                ans = sumTwoNumbers(str1, str2);//dau la -
//                //System.out.println("/n*2*/n");
//                ans.add("-");
//                printSum(ans);
//            } else if ((check1 == false)&&(check2 == true)){
//                    ans = sumTwoNumbers(str1, str2);
//                    //System.out.println("/n*3*/n");
//                    printSubstract(ans);
//                } else {
//                    ans = substractTwoNumbers(str1, str2);  
//                    //System.out.println("/n*4*/n");
//                    printSubstract(ans);
//                }
//           
//        }
//               
//        /* SUM TWO NUMBERS */
//        System.out.println("Sum: ");
//       
//        if ((check1 == true)&&(check2 == true)){
//            ans = sumTwoNumbers(str1, str2);//dau la -
//            //System.out.println("/n*2*/n");
//            ans.add("-");
//            printSum(ans);
//        } else if ((check1 == true)&&(check2 == false)){
//                ans = substractTwoNumbers(str2, str1);
//                //System.out.println("/n*2*/n");
//                printSubstract(ans);
//            } else if ((check1 == false)&&(check2 == true)){
//                    ans = substractTwoNumbers(str1, str2);
//                    //System.out.println("/n*3*/n");
//                    printSubstract(ans);
//                } else {
//                    ans = sumTwoNumbers(str1, str2);  
//                    //System.out.println("/n*4*/n");
//                    printSum(ans);
//                }
//           
//        /* MULTIPLY TWO NUMBERS */
//        System.out.println("Multiply: ");
//        if ((check1 == true)||(check2 == true)){
//            ans = multiplyTwoNumbers(str1, str2);
//            ans.add("-");
//            printSum(ans);
//        } else {
//            ans = multiplyTwoNumbers(str1, str2);
//            printSum(ans);
//        }      
//        /* DIVIDE TWO NUMBERS */
//        LinkedList remainder = new LinkedList();
//        System.out.println("Divide: ");
//        if (str2.equals("0"))
//                System.out.println("Khong the chia cho 0");
//            else if (str1.equals("0"))
//                    System.out.println("0");
//                else if (str1.equals(str2)){
//                    System.out.println(1);
//                    } else {
//                        ans = divideTwoNumbers(str1, str2);
//                        if (((int)ans.get(0) == 0)&&(ans.size() == 1)){
//                            ans.printList();
//                            System.out.println("Remainder: " + str2);
//                        } else {
//                            ans.printList();
//                            String resultDiv = toString(reverseList(multiplyTwoNumbers(str2, toString(ans))));
//                            while ((resultDiv.charAt(0) == '0')&&(resultDiv.length() > 1)) //tranh truong hop 0 + vơi 1 so nao do
//                                resultDiv = resultDiv.substring(0, 0) + resultDiv.substring(1);
//                            if (resultDiv.equals(str1)) remainder.add(0);
//                            else {    
//                                remainder = reverseList(substractTwoNumbers(str1, resultDiv));
//                            }
//                            System.out.println("Remainder: ");
//                            remainder.printList();
//                        }
//                    }
//    }
//}
