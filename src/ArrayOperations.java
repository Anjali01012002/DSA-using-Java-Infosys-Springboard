import java.util.Scanner;

public class ArrayOperations{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        //Initialize array
        int[] arr={1,2,3,4,5};
        System.out.println("Initial array: ");
        printArray(arr);

        //Insert element
        System.out.print("Enter position to insert: ");
        int insertIndex=sc.nextInt();
        System.out.print("Enter element to insert: ");
        int elementToInsert=sc.nextInt();
        arr=insertElement(arr, insertIndex, elementToInsert);
        System.out.println("Array after insertion: ");
        printArray(arr);

        //Delete element
        System.out.print("Enter position to delete: ");
        int deleteIndex=sc.nextInt();
        arr=deleteElement(arr, deleteIndex);
        System.out.println("Array after deletion: ");
        printArray(arr);

        //Traverse array
        System.out.println("Array traversal: ");
        traverseArray(arr);
        sc.close();
    }

    public static void printArray(int[] array){
        for(int i:array){
            System.out.print(i+ " ");
        }
        System.out.println();
    }

    public static int[] insertElement(int[] array, int index,int element){
        if(index<0 || index>array.length){
            System.out.println("Index out of bounds.");
            return array;
        }
        int[] newArray=new int[array.length+1];
        for(int i=0; i<index;i++){
            newArray[i]=array[i];
        }
        newArray[index]=element;
        for(int i=index;i<array.length;i++){
            newArray[i+1]=array[i];
        }
        return newArray;
    }

    public static int[] deleteElement(int[] array, int index){
        if(index<0||index>=array.length){
            System.out.println("Index out of bounds.");
            return array;
        }
        int[] newArray=new int[array.length-1];
        for(int i=0;i<index;i++){
            newArray[i]=array[i];
        }
        for(int i=index; i<newArray.length;i++){
            newArray[i]=array[i+1];
        }
        return newArray;
    }

    public static void traverseArray(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.println("Element at index "+i+ ": "+array[i]);
        }
    }
}