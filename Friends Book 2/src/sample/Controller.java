package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Controller {
    //Fields
    public TextField textFirstName;
    public TextField textLastName;
    public TextField textAddress;
    public TextField textAge;
    public TextField textIQScore;
    public CheckBox cbxIsTrustworthy;
    public CheckBox cbxIsNotTrustworthy;
    public TextField textOtherNotes;
    public CheckBox cbxBestFriends;
    public CheckBox cbxGoodFriends;
    public CheckBox cbxNormalFriends;
    public Label lblError;
    public Button btnAddFriend;

    public ListView<Friend> friendsList = new ListView<>();
    public Label lblFirstName;
    public Label lblLastName;
    public Label lblAddress;
    public Label lblAge;
    public Label lblIQScore;
    public Label lblIsTrustworthy;
    public Label lblOtherNotes;
    public Label lblTypeOfFriend;
    public Label lblErrorTwo;
    public Button btnDeleteFriend;
    public Button btnSave;

    public ListView<Friend> anyListOfFriends = new ListView<>();
    private ArrayList<Friend> friends = new ArrayList<>();
    public CheckBox cbxAllFriendsTwo;
    public CheckBox cbxBestFriendsTwo;
    public CheckBox cbxGoodFriendsTwo;
    public CheckBox cbxNormalFriendsTwo;
    public Label lblFirstNameTwo;
    public Label lblLastNameTwo;
    public Label lblAddressTwo;
    public Label lblAgeTwo;
    public Label lblIQScoreTwo;
    public Label lblIsTrustworthyTwo;
    public Label lblOtherNotesTwo;
    public Label lblTypeOfFriendTwo;
    public Label lblErrorThree;
    public Button btnLoad;

    //Method to addFriend to all friends list (when friend is not saved yet)
    public void addFriend(ActionEvent actionEvent) {
        //Making sure that all properties of the friend object is filled in (except for "Other Notes" and "Type of Friend" which are optional)
        if (textFirstName.getText().isEmpty() || textLastName.getText().isEmpty() || textAddress.getText().isEmpty() || textAge.getText().isEmpty() || textIQScore.getText().isEmpty() || !cbxIsTrustworthy.isSelected() && !cbxIsNotTrustworthy.isSelected()) {
            lblError.setText("Please fill required boxes");
        } else {
            lblError.setText("");
            //Constructing a friend with given values
            String firstName = textFirstName.getText();
            String lastName = textLastName.getText();
            String Address = textAddress.getText();
            int age = Integer.parseInt(textAge.getText());
            int iqScore = Integer.parseInt(textIQScore.getText());
            boolean isTrustworthy = false;
            if (cbxIsTrustworthy.isSelected()) {
                isTrustworthy = true;
            }
            String otherNotes = textOtherNotes.getText();
            String type = "";
            if (cbxBestFriends.isSelected()) {
                type = "Best Friends";
            } else if (cbxGoodFriends.isSelected()) {
                type = "Good Friends";
            } else if (cbxNormalFriends.isSelected()) {
                type = "Normal Friends";
            }
            Friend friend = new Friend(firstName, lastName, Address, age, iqScore, isTrustworthy, otherNotes, type);
            //Adding item to ListView list
            friendsList.getItems().add(friend);
            //Clearing text fields and checkboxes
            textFirstName.clear();
            textLastName.clear();
            textAddress.clear();
            textAge.clear();
            textIQScore.clear();
            cbxIsTrustworthy.setSelected(false);
            cbxIsNotTrustworthy.setSelected(false);
            textOtherNotes.clear();
            cbxNormalFriends.setSelected(false);
            cbxGoodFriends.setSelected(false);
            cbxBestFriends.setSelected(false);
            friendsList.setDisable(false);
            btnSave.setDisable(false);
        }
    }

    //Methods to set "Is Trustworthy" checkboxes so that only one checkbox is checked. (Inside "addFriend" method)
    public void setIsTrustworthy(ActionEvent actionEvent) {
        cbxIsNotTrustworthy.setSelected(false);
    }

    public void setIsNotTrustworthy(ActionEvent actionEvent) {
        cbxIsTrustworthy.setSelected(false);
    }

    //Methods to set "Type of Friend" checkboxes so that only one checkbox is checked. (inside "addFriend" method)
    public void setBestFriend(ActionEvent actionEvent) {
        cbxNormalFriends.setSelected(false);
        cbxGoodFriends.setSelected(false);
    }

    public void setGoodFriend(ActionEvent actionEvent) {
        cbxBestFriends.setSelected(false);
        cbxNormalFriends.setSelected(false);
    }

    public void setNormalFriend(ActionEvent actionEvent) {
        cbxBestFriends.setSelected(false);
        cbxGoodFriends.setSelected(false);
    }

    //Method to display selected friend (when friend is not saved yet)
    public void displayFriend(MouseEvent mouseEvent) {
        btnDeleteFriend.setDisable(false);
        //Setting Friend object "friend" to the selected friend from list
        Friend friend = friendsList.getSelectionModel().getSelectedItem();
        //Setting labels with the selected friends properties
        lblFirstName.setText(friend.firstName);
        lblLastName.setText(friend.lastName);
        lblAddress.setText(friend.getAddress());
        lblAge.setText(Integer.toString(friend.getAge()));
        lblIQScore.setText(Integer.toString(friend.getIQScore()));
        if (friend.isTrustworthy()) {
            lblIsTrustworthy.setText("Yes");
        } else if (!friend.isTrustworthy()) {
            lblIsTrustworthy.setText("No");
        }
        if (friend.getOtherNotes().isEmpty()) {
            lblOtherNotes.setText("n/a");
        } else {
            lblOtherNotes.setText(friend.getOtherNotes());
        }
        if (friend.getType().equals("Best Friends")) {
            lblTypeOfFriend.setText("Best Friends");
        } else if (friend.getType().equals("Good Friends")) {
            lblTypeOfFriend.setText("Good Friends");
        } else if (friend.getType().equals("Normal Friends")) {
            lblTypeOfFriend.setText("Normal Friends");
        } else {
            lblTypeOfFriend.setText("n/a");
        }
    }

    //Method to remove a friend (when friend is not saved yet)
    public void deleteFriend(ActionEvent actionEvent) {
        //Setting Friend object "friend: to the selected friend from list
        Friend friend = friendsList.getSelectionModel().getSelectedItem();
        //Removing the selected friend from list
        friendsList.getItems().remove(friend);
        //Clearing labels from "displayFriend" method to nothing
        clearLabels(lblFirstName, lblLastName, lblAddress, lblAge, lblIQScore, lblIsTrustworthy, lblOtherNotes, lblTypeOfFriend);
        if (friendsList.getItems().isEmpty()) {
            friendsList.setDisable(true);
            btnDeleteFriend.setDisable(true);
            btnSave.setDisable(true);
        }
    }

    //Method to make clear labels (inside deleteFriend and save method)
    private void clearLabels(Label firstName, Label lastName, Label address, Label age, Label IQScore, Label isTrustworthy, Label otherNotes, Label type) {
        firstName.setText("");
        lastName.setText("");
        address.setText("");
        age.setText("");
        IQScore.setText("");
        isTrustworthy.setText("");
        otherNotes.setText("");
        type.setText("");
    }

    //Method to save "allFriends" list and other lists into txt files
    public void save(ActionEvent actionEvent) throws IOException {
        if (friendsList.getItems().isEmpty()) {
            lblErrorTwo.setText("Please add a friend before saving");
        } else {
            lblErrorTwo.setText("");
            //ObservableList "myList" to hold all the friends on the ListView "friendsList"
            ObservableList<Friend> myList = friendsList.getItems();
            //for loop that goes through "myList" and writes all properties of the friend into all friends and other lists if applicable
            for (Friend f : myList) {
                f.writeToFile("allFriends.txt");
                if (f.getType().equals("Best Friends")) {
                    f.writeToFile("bestFriends.txt");
                } else if (f.getType().equals("Good Friends")) {
                    f.writeToFile("goodFriends.txt");
                } else if (f.getType().equals("Normal Friends")) {
                    f.writeToFile("normalFriends.txt");
                }
            }
            //Clearing items and labels
            friendsList.getItems().clear();
            clearLabels(lblFirstName, lblLastName, lblAddress, lblAge, lblIQScore, lblIsTrustworthy, lblOtherNotes, lblTypeOfFriend);
            friendsList.setDisable(true);
            btnSave.setDisable(true);
            btnDeleteFriend.setDisable(true);
        }
    }

    //Method that loads a selected list
    public void load(ActionEvent actionEvent) throws IOException {
        //Checking if there is no selected friends list to display
        if (!cbxAllFriendsTwo.isSelected() && !cbxBestFriendsTwo.isSelected() && !cbxGoodFriendsTwo.isSelected() && !cbxNormalFriendsTwo.isSelected()) {
            lblErrorThree.setText("Please select a list");
            anyListOfFriends.setDisable(true);
        } else {
            //Making labels and lists all blank
            clearLabels(lblFirstNameTwo, lblLastNameTwo, lblAddressTwo, lblAgeTwo, lblIQScoreTwo, lblIsTrustworthyTwo, lblOtherNotesTwo, lblTypeOfFriendTwo);
            lblErrorThree.setText("");
            anyListOfFriends.getItems().clear();
            friends.clear();
            String list = getSelectedList();
            if (list != null) {
                //Using "createFriends" method from "CreateFriend" class to read the selected txt files and create all the saved friends
                friends = CreateFriend.createFriends(list);
                //Using for loop to add friends to a ListView to display friends
                anyListOfFriends.setDisable(false);
                for (Friend f : friends) {
                    anyListOfFriends.getItems().add(f);
                }
            }
            //Checking if there is no friends in the list
            if(friends.isEmpty()){
                lblErrorThree.setText("There are no friends in this list");
                anyListOfFriends.setDisable(true);
            }
        }
    }

    //Method that returns the selected list. With the different checkboxes, this method allows user to chose which list they wish to load. (inside load method)
    private String getSelectedList() {
        if (cbxAllFriendsTwo.isSelected()) {
            return "allFriends.txt";
        } else if (cbxBestFriendsTwo.isSelected()) {
            return "bestFriends.txt";
        } else if (cbxGoodFriendsTwo.isSelected()) {
            return "goodFriends.txt";
        } else if (cbxNormalFriendsTwo.isSelected()) {
            return "normalFriends.txt";
        } else{
            return null;
        }
    }


    //Methods to set friend type checkboxes so that only one is selected at once (inside load method)
    public void setAllFriendsList(ActionEvent actionEvent) {
        cbxBestFriendsTwo.setSelected(false);
        cbxGoodFriendsTwo.setSelected(false);
        cbxNormalFriendsTwo.setSelected(false);
    }
    public void setBestFriendsList(ActionEvent actionEvent) {
        cbxAllFriendsTwo.setSelected(false);
        cbxGoodFriendsTwo.setSelected(false);
        cbxNormalFriendsTwo.setSelected(false);
    }
    public void setGoodFriendsList(ActionEvent actionEvent) {
        cbxAllFriendsTwo.setSelected(false);
        cbxBestFriendsTwo.setSelected(false);
        cbxNormalFriendsTwo.setSelected(false);
    }
    public void setNormalFriendsList(ActionEvent actionEvent) {
        cbxAllFriendsTwo.setSelected(false);
        cbxGoodFriendsTwo.setSelected(false);
        cbxBestFriendsTwo.setSelected(false);
    }

    //Method to display selected friend (when a file is loaded)
    public void displayFriendTwo(MouseEvent mouseEvent) {
        //Setting Friend object "friend" to the selected friend from list
        Friend friend= anyListOfFriends.getSelectionModel().getSelectedItem();
        //Setting labels with the selected friends properties
        lblFirstNameTwo.setText(friend.firstName);
        lblLastNameTwo.setText(friend.lastName);
        lblAddressTwo.setText(friend.getAddress());
        lblAgeTwo.setText(Integer.toString(friend.getAge()));
        lblIQScoreTwo.setText(Integer.toString(friend.getIQScore()));
        if(friend.isTrustworthy()){
            lblIsTrustworthyTwo.setText("Yes");
        }
        else if(!friend.isTrustworthy()){
            lblIsTrustworthyTwo.setText("No");
        }
        if(friend.getOtherNotes().isEmpty()){
            lblOtherNotesTwo.setText("n/a");
        }
        else {
            lblOtherNotesTwo.setText(friend.getOtherNotes());
        }
        if(friend.getType().equals("Best Friends")){
            lblTypeOfFriendTwo.setText("Best Friends");
        }
        else if(friend.getType().equals("Good Friends")){
            lblTypeOfFriendTwo.setText("Good Friends");
        }
        else if(friend.getType().equals("Normal Friends")){
            lblTypeOfFriendTwo.setText("Normal Friends");
        }
        else{
            lblTypeOfFriendTwo.setText("n/a");
        }
    }
}
