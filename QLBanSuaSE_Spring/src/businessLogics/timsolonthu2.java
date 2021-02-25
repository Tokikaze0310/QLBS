package businessLogics;

public class timsolonthu2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 1, 1};
		int max1 = 0;
		int max2 = 0;
		for(int i = 0; i<arr.length;i++)
		{
			if(arr[i] > max1) {
				max1 = arr[i];
			}
			if(max2 < arr[i] && arr[i] < max1)
			{
				max2 = arr[i];
			}
		}
		System.out.print(max2);
		
		//2 vòng for
//		int temp = 0;
//		for(int i = 0; i<arr.length;i++)
//			for(int j = i+1; j<arr.length; j++)
//			{
//				if(arr[i]<arr[j])
//				{
//					temp = arr[i];
//					arr[i] = arr[j];
//					arr[j] = temp;
//				}
//			}
//		System.out.print(arr[1]);
	}
	


}
