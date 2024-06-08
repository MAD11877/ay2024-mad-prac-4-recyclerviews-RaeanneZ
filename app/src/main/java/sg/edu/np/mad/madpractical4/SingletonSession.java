package sg.edu.np.mad.madpractical4;

public class SingletonSession {

    private User user = null;
    private static volatile SingletonSession INSTANCE = null;

    // private constructor to prevent instantiation of the class
    private SingletonSession() {
        user = new User();
    }

    public static SingletonSession getInstance() {
        // Check if the instance is already created
        if(INSTANCE == null) {
            // synchronize the block to ensure only one thread can execute at a time
            synchronized (SingletonSession.class) {
                // check again if the instance is already created
                if (INSTANCE == null) {
                    // create the singleton instance
                    INSTANCE = new SingletonSession();
                }
            }
        }
        // return the singleton instance
        return INSTANCE;
    }

    public void SignUpAccount(int id, String name, String description) {
        user.setId(id);
        user.setName(name);
        user.setDescription(description);
    }
}
