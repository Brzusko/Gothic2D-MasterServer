public class ServerCounter {
    private boolean isUpdated;
    private int counter;
    private int maxCounter;

    public ServerCounter(int c){
        counter = c;
        maxCounter = c;
        isUpdated = true;
    }

    public void UpdateInfo(){
        synchronized (this){
            isUpdated = true;
        }
    }

    public int Tick(){
            if(isUpdated)
            {
                counter = maxCounter;
                isUpdated = false;
                return counter;
            }

            counter--;
            return counter;

    }
}
