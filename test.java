public class test {
    public static void main(String[] args) {
        try {
            Class.forName("javafx.application.Application");
            System.out.println("✅ JavaFX is available on this system!");
            
            String version = System.getProperty("javafx.runtime.version");
            if (version != null) {
                System.out.println("JavaFX version: " + version);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("❌ JavaFX is NOT found.");
            System.out.println("You need to download the JavaFX SDK.");
        }
    }
}