class Solution {
    public int dayOfYear(String date) {

        int month = Integer.parseInt(date.substring(5, 7));
        int days = Integer.parseInt(date.substring(8));
        int year = Integer.parseInt(date.substring(0,4));
        int day = 0 ;

        int monthday[] = {31,28,31,30,31,30,31,31,30,31,30,31};

        if((year % 400 == 0)||(year % 4 ==0 && year % 100 != 0)){
            monthday[1] = 29 ;
        }
        for(int i =0;i < month -1 ;i++){
            day += monthday[i];
        }
        day += days;
        return day;
    }
}