package B3;

public class AlphabetThread extends Thread {
    private SharedResource sharedResource;

    public AlphabetThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        sharedResource.printAlphabet();
    }
}
