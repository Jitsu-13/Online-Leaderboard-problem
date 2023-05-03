import java.util.List;

public class Main {
    public static void main(String[] args) {
        Leaderboard leaderboard=new Leaderboard();
        leaderboard.UPSERT_USER(new User("Nikhil","nikhil@flipkart.com","India"));
        leaderboard.UPSERT_USER(new User("Rahul","rahul@flipkart.com","India"));
        leaderboard.UPSERT_SCORE("rahul@flipkart.com",1);
        leaderboard.UPSERT_SCORE("nikhil@flipkart.com",5);
        leaderboard.UPSERT_USER(new User("Karan","karan@flipkart.com","Argentina"));
        leaderboard.UPSERT_SCORE("karan@flipkart.com",1);

        List<String> top3=leaderboard.GET_TOP(3,null);
        System.out.println("Top 3 users are- "+top3);

        List<String> list=leaderboard.GET_USERS_WITH_SCORE(1);
        System.out.println("Users with score 1 are- "+list);

        List<String> top2=leaderboard.GET_TOP(2,"India");
        System.out.println("Top 2 users from India are- "+top2);

        List<String> search1=leaderboard.SEARCH("Nikhil", null, "India");
        System.out.println(search1);
        List<String> search2=leaderboard.SEARCH(null, null, "India");
        System.out.println(search2);
    }
}
