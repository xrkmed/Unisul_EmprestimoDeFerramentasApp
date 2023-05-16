package DAO;

import java.util.ArrayList;

import Model.FriendModel;

public class FriendsDAO {

    //Simulated database
    private final ArrayList<FriendModel> friends = new ArrayList<>();

    //Singleton Class
    private static FriendsDAO instance;

    private FriendsDAO(){

    }

    public static FriendsDAO getInstance(){
        if(instance == null){
            instance = new FriendsDAO();
        }
        return instance;
    }
    

    //Methods
    public void addFriend(FriendModel e) throws IllegalArgumentException{
        if(e.getId() == null){
            e.setId(friends.size() + 1);
        }

        if(getFriend(e.getId()) != null){
            throw new IllegalArgumentException("Friend with id " + e.getId() + " already exists");
        }

        if(getFriend(e.getName()) != null){
            throw new IllegalArgumentException("Friend with name " + e.getName() + " already exists");
        }
        
        this.friends.add(e);
    }

    public void removeFriend(FriendModel e){
        this.friends.remove(e);
    }

    public ArrayList<FriendModel> getFriends(){
        return new ArrayList<>(this.friends);
    }

    public FriendModel getFriend(int id){
        return friends.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public FriendModel getFriend(String nome){
        return friends.stream().filter(e -> e.getName().toLowerCase().equals(nome.toLowerCase())).findFirst().orElse(null);
    }

    public void updateFriend(Integer id, FriendModel reference){
        FriendModel friend = getFriend(id);
        friend.setName(reference.getName());
        friend.setPhone(reference.getPhone());
        friend.updateAddress(reference.getAddress());
    }

    public void logFriends(){
        System.out.println("Friends:");
        friends.forEach(e -> System.out.println(e));
    }
}
