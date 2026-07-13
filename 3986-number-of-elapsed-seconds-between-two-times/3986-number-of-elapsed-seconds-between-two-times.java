class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {

        int startHours = Integer.parseInt(startTime.substring(0, 2));
        int startMinutes = Integer.parseInt(startTime.substring(3, 5));
        int startSeconds = Integer.parseInt(startTime.substring(6, 8));

        int endHours = Integer.parseInt(endTime.substring(0, 2));
        int endMinutes = Integer.parseInt(endTime.substring(3, 5));
        int endSeconds = Integer.parseInt(endTime.substring(6, 8));

        int startTotal = startHours * 3600 + startMinutes * 60 + startSeconds;
        int endTotal = endHours * 3600 + endMinutes * 60 + endSeconds;

        return endTotal - startTotal;
    }
}