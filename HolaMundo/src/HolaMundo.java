//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class HolaMundo {
    public static void main(String[] args) {
        System.out.println("Hoi! =^.^=");

        if(args.length == 1){
            System.out.println("Hoi, " + args[0] + "! =^.^="); //pido disculpas
        }

        for(int i=0; i<args.length; i++){
            System.out.println(args[i]);
        }
    }
}