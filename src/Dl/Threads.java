package Dl;

class Threads implements Runnable {

    public Thread t;
    public String threadName;
    boolean suspended = false;

    Threads(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    public void run() {
         
        System.out.println("Running " + threadName);
        try
        {
            System.out.println("asdsd");
            suspend();
            System.out.println("asdasd");

        } catch (Exception e)
        {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null)
        {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    void suspend() {
        suspended = true;
    }

    synchronized void resume() {
        suspended = false;
        notify();
    }
}

