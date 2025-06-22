class SingleDimensionArray {
    int[] arr = new int[5];

    public SingleDimensionArray() {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.MIN_VALUE;
        }
    }

    public void insert(int location, int value) {
        try {
            if (arr[location] == Integer.MIN_VALUE) {
                arr[location] = value;
                System.out.println("Inserted " + value + " at location " + location);
            }else{
                System.out.println("That location already has a value");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Can't insert at that location. Outside of Array");
        }
    }
}