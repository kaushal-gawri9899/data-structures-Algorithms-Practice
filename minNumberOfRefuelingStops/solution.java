/**
 * A car travels from a starting position to a destination which is target miles east of the starting position.
 * Along the way, there are gas stations.  Each station[i] represents a gas station that is station[i][0] miles east of the starting position, and has station[i][1] liters of gas.
 * The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.  It uses 1 liter of gas per 1 mile that it drives.
 * When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.
 * What is the least number of refueling stops the car must make in order to reach its destination?  If it cannot reach the destination, return -1.
 * Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.  If the car reaches the destination with 0 fuel left, it is still considered to have arrived.
 *
 * Input: target = 1, startFuel = 1, stations = []
 * Output: 0
 * Explanation: We can reach the target without refueling. 
 *
 * Input: target = 100, startFuel = 1, stations = [[10,100]]
 * Output: -1
 * Explanation: We can't reach the target (or even the first gas station).
 * 
 * Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
 * Output: 2
 * Explanation: 
 * We start with 10 liters of fuel.
 * We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
 * Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
 * and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
 * We made 2 refueling stops along the way, so we return 2.
 */
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        // /*
        // We need to visit the minimum number of nodes, thus to maintain the order, we
        // can use a priority queue with a custom comparator

        // We need to minimize the distance to be travelled and maximise the fuel that
        // the station can provide. So, we need to maintain a priority queue that
        // maximizes the fuel but if there's another station which provides that much
        // fuel but with less distance, it should be prioritized.

        // A basic bfs approach alonside priority queue could also be used taking
        // stations as our graph and maximise the fuel
        // */

        if (startFuel >= target)
            return 0;

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int totalFuel = startFuel;
        int index = 0;

        int totalStation = 0;
        /*
        
        */
        while (totalFuel < target) {

            while (index < stations.length && stations[index][0] <= totalFuel) {
                pq.offer(stations[index++][1]);
            }

            if (pq.isEmpty())
                return -1;

            totalFuel += pq.poll();
            totalStation++;
        }

        return totalStation;
    }

}