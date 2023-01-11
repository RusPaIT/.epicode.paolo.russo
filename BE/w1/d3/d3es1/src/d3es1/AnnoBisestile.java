package d3es1;

public class AnnoBisestile {
	
	public static boolean bisestile(int anno) {
        if (anno % 4 == 0) {
            if (anno % 100 == 0) {
                return anno % 400 == 0;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int anno = 2020;
        System.out.println(bisestile(anno));
    }

}
