import java.util.*;
import java.util.stream.Collectors;

public class Leaderboard {
    private Map<String,User> map;

    public Leaderboard(){
        map=new HashMap<>();
    }

    public void UPSERT_USER(User user){
        String email= user.getEmail();
        if(map.containsKey(email)){
            User updateUser=map.get(email);
            updateUser.setName(user.getName());
            updateUser.setCountry(user.getCountry());
        }else{
            map.put(user.getEmail(), user);
        }
        System.out.println(user.getName()+" added to leaderboard");

    }
    public void UPSERT_SCORE(String email,Integer score){
        if(map.containsKey(email)){
            User updateUser=map.get(email);
            updateUser.setScore(score);
            map.put(email,updateUser);
        }

    }
    public List<String> GET_TOP(int k, String country){
        List<User> list=new ArrayList<>();
        for(User user:map.values()) {
            if (country == null || user.getCountry().equals(country)) {
                list.add(user);
            }
        }
//        list.sort(Comparator.comparingInt(User::getScore).reversed());
        list.sort((u1,u2)->u2.getScore()- u1.getScore());
        List<String> result=list.stream().limit(k).map(User::getEmail).collect(Collectors.toList());
        return result;
    }

    public List<String> GET_USERS_WITH_SCORE(Integer score){
        List<String> list=new ArrayList<>();
        for(User user:map.values()){
            if(user.getScore()==score) list.add(user.getEmail());
        }
        return list;
    }
    public List<String> SEARCH(String name, Integer score, String country){
        List<User> list=new ArrayList<>(map.values());
        if(name!=null){
            list=list.stream().filter(i->i.getName()!=null && i.getName().equals(name)).collect(Collectors.toList());
        }if(score!=null){
            list=list.stream().filter(i->i.getScore()==score).collect(Collectors.toList());
        }
        if(country!=null){
            list=list.stream().filter(i->i.getCountry()!=null && i.getCountry()==country).collect(Collectors.toList());
        }

        List<String> result=list.stream().map(User::getEmail).collect(Collectors.toList());

        return result;

    }



}
