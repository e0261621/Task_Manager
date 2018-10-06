package tic2002.task;

public class Test {
    public static void main(String[] args) {
//        Task t = new Task("something");
        Todo t = new Todo("something");

        System.out.println(t.getClass().toString().contains("Todo") ? "T" : "D");
//        Scanner in = new Scanner(System.in);
//        String line = in.nextLine();
//
//        int i = line.indexOf("/by");
//
//        System.out.println(i);
//        String line2 = line.substring(i,line.length());
//
//        System.out.println(line.substring(i,line.length()).substring("/by".length()).trim());
//
//        System.out.println(line2.substring("/by".length()).trim());
    }
}
