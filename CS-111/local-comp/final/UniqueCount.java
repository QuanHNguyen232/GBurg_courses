import java.util.Arrays;

public class UniqueCount {
	
	public static int getUniqueCount(int[] data) {
		
        int numCount = 0;
        for (int i = 0; i < data.length; i++) {
            int j = 0;
            for (j = 0; j < i; j++)
                if (data[i] == data[j])
                    break;
            if (i == j)
            	numCount++;
        }
        return numCount;

	}
	
	
	
//	public static void main(String[] args) {
//		int[] data = {1, 2, 3, 2, 1, 4, 4, 20, 3};
//		System.out.println(getUniqueCount(data));
//	}

}
