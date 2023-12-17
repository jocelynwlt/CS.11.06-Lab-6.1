import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int challengeOneAnswer = challengeOne("InputOneTwo.txt");
        System.out.println(challengeOneAnswer);
        int challengeTwoAnswer = challengeTwo("InputOneTwo.txt");
        System.out.println(challengeTwoAnswer);
        int challengeThreeAnswer = challengeThree("InputThreeFour.txt");
        System.out.println(challengeThreeAnswer);
        int challengeFourAnswer = challengeFour("InputThreeFour.txt");
        System.out.println(challengeFourAnswer);

        writeFileAllAnswers("AdventureTime.txt",challengeOneAnswer,challengeTwoAnswer,challengeThreeAnswer,challengeFourAnswer);
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int count = 0;
        int[] arr = readFile(fileName);

        int lineCount = countLinesInFile(fileName);
        for(int i = 0; i<arr.length-1; i++){
            if(arr[i]<arr[i+1]){
                count++;
            }
        }
        return count;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int [] arr = readFile(fileName);
        int cnt = 0;

        for(int i=3; i<arr.length; i++){
            int sum1 = arr[i] + arr[i-1] + arr[i-2];
            int sum2 = arr[i-1] + arr[i-2] + arr[i-3];
            if(sum1>sum2){
                cnt++;
            }
        }
        return cnt;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        File file = new File("inputThreeFour.txt");
        Scanner scanner = new Scanner(file);

        int len = countLinesInFile("inputThreeFour.txt");

        String[] arr = new String[len];
        int count = 0;
        while (scanner.hasNextLine()) {
            arr[count] = scanner.next();
        }

        int horizontal = 0;
        int depth = 0;
        for (int i =0; i<len; i++){
            String temp = String.valueOf(arr[i]);
            if(temp.contains("forward")){
                String str = temp.substring(temp.length()-1);
                int hv = Integer.parseInt(str);
                horizontal += hv;
            }
            if(temp.contains("up")){
                String str = temp.substring(temp.length()-1);
                int dvu = Integer.parseInt(str);
                depth += dvu;
            }
            if(temp.contains("down")){
                String str = temp.substring(temp.length()-1);
                int dvd = Integer.parseInt(str);
                depth += dvd;
        }
    }
        return depth*horizontal;

}

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        File file = new File("inputThreeFour.txt");
        Scanner scanner = new Scanner(file);

        int len = 0;
        while (scanner.hasNextLine()) {
            len++;
            scanner.nextLine();
        }
        String[] arr = new String[len];
        int count = 0;
        while (scanner.hasNextLine()) {
            arr[count++] = scanner.next();
        }

        int horizontal = 0;
        int depth = 0;
        int aim = 0;

        for (int i =0; i<len; i++){
            String temp = String.valueOf(arr[i]);
            if(temp.contains("forward")){
                String str = temp.substring(temp.length()-1);
                int hv = Integer.parseInt(str);
                horizontal += hv;
                depth += aim*hv;
            }
            if(temp.contains("up")){
                String str = temp.substring(temp.length()-1);
                int dvu = Integer.parseInt(str);
                aim -= dvu;
            }
            if(temp.contains("down")){
                String str = temp.substring(temp.length()-1);
                int dvd = Integer.parseInt(str);
                aim += dvd;
            }
        }
        return horizontal*depth;

    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}