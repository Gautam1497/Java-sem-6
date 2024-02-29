import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Video {
    final String title;
    private boolean checkedOut;
    private int rating;

    public Video(String title) {
        this.title = title;
        this.checkedOut = false;
        this.rating = 0;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public int getRating() {
        return rating;
    }

    public void addRating(int rating) {
        this.rating = rating;
    }
}

class VideoStore {
    final List<Video> inventory;

    public VideoStore() {
        this.inventory = new ArrayList<>();
    }

    public void addVideo(String title) {
        inventory.add(new Video(title));
        System.out.println("Video added to inventory: " + title);
    }

    public void checkOutVideo(String title) {
        for (Video video : inventory) {
            if (video.getTitle().equalsIgnoreCase(title) && !video.isCheckedOut()) {
                video.setCheckedOut(true);
                System.out.println("Video checked out: " + title);
                return;
            }
        }
        System.out.println("Video not found in inventory or already checked out: " + title);
    }

    public void returnVideo(String title) {
        for (Video video : inventory) {
            if (video.getTitle().equalsIgnoreCase(title) && video.isCheckedOut()) {
                video.setCheckedOut(false);
                System.out.println("Video returned: " + title);
                return;
            }
        }
        System.out.println("Video not found in inventory or not checked out: " + title);
    }

    public void receiveRating(String title, int rating) {
        for (Video video : inventory) {
            if (video.getTitle().equalsIgnoreCase(title)) {
                video.addRating(rating);
                System.out.println("Rating added to video: " + title);
                return;
            }
        }
        System.out.println("Video not found in inventory: " + title);
    }

    public void listInventory() {
        System.out.println("Inventory:");
        for (Video video : inventory) {
            System.out.println(video.getTitle() + " - Checked Out: " + video.isCheckedOut() + ", Rating: " + video.getRating());
        }
        System.out.println();
    }
}

public class Exp2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VideoStore videoStore = new VideoStore();

        while (true) {
            System.out.println("Video Launcher Menu:");
            System.out.println("1. Add Videos");
            System.out.println("2. Check Out Videos");
            System.out.println("3. Return Videos");
            System.out.println("4. Receive Rating");
            System.out.println("5. List Inventory");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter video title to add to inventory: ");
                    String titleToAdd = scanner.nextLine();
                    videoStore.addVideo(titleToAdd);
                    break;
                case 2:
                    System.out.print("Enter video title to check out: ");
                    String titleToCheckOut = scanner.nextLine();
                    videoStore.checkOutVideo(titleToCheckOut);
                    break;
                case 3:
                    System.out.print("Enter video title to return: ");
                    String titleToReturn = scanner.nextLine();
                    videoStore.returnVideo(titleToReturn);
                    break;
                case 4:
                    System.out.print("Enter video title to receive rating: ");
                    String titleToRate = scanner.nextLine();
                    System.out.print("Enter rating (1-5): ");
                    int rating = scanner.nextInt();
                    videoStore.receiveRating(titleToRate, rating);
                    break;
                case 5:
                    videoStore.listInventory();
                    break;
                case 6:
                    System.out.println("Exiting Video Launcher. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
