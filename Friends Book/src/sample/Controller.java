package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

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
    public ListView <Friend> friendsList= new ListView <>();
    public Label lblFirstName;
    public Label lblLastName;
    public Label lblAddress;
    public Label lblAge;
    public Label lblIQScore;
    public Label lblIsTrustworthy;
    public Label lblOtherNotes;
    public Label lblError;
    public Button btnAddFriend;
    public Button btnDeleteFriend;

    //Method to addFriend to friends list
    public void addFriend(ActionEvent actionEvent) {
        //Making sure that all properties of the friend object is filled in (except for "Other Notes" which is optional)
        if(textFirstName.getText().isEmpty() || textLastName.getText().isEmpty()|| textAddress.getText().isEmpty()||textAge.getText().isEmpty() || textIQScore.getText().isEmpty()||!cbxIsTrustworthy.isSelected()&&!cbxIsNotTrustworthy.isSelected()){
            lblError.setText("Please fill required boxes");
        }
        else {
            lblError.setText("");
            //Constructing a friend with given values
            String firstName = textFirstName.getText();
            String lastName = textLastName.getText();
            String Address = textAddress.getText();
            int age = Integer.parseInt(textAge.getText());
            int iqScore = Integer.parseInt(textIQScore.getText());
            boolean isTrust=false;
            if (cbxIsTrustworthy.isSelected()) {
                isTrust = true;
            }
            String otherNotes = textOtherNotes.getText();
            Friend friend = new Friend(firstName, lastName, Address, age, iqScore, isTrust, otherNotes);
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
            friendsList.setDisable(false);
        }
    }

    //Methods to set "Is Trustworthy" checkboxes so that only one checkbox is checked. (Inside addFriend method)
    public void setIsTrustworthy(ActionEvent actionEvent) {
        if (cbxIsTrustworthy.isSelected()) {
            cbxIsNotTrustworthy.setSelected(false);
        }
    }
    public void setIsNotTrustworthy(ActionEvent actionEvent) {
        if(cbxIsNotTrustworthy.isSelected()){
            cbxIsTrustworthy.setSelected(false);
        }
    }

    //Method to display selected friend
    public void displayFriend(MouseEvent mouseEvent) {
        btnDeleteFriend.setDisable(false);
        //Setting Friend object "friend" to the selected friend from list
        Friend friend= friendsList.getSelectionModel().getSelectedItem();
        //Setting labels with the selected friends properties
        lblFirstName.setText(friend.firstName);
        lblLastName.setText(friend.lastName);
        lblAddress.setText(friend.getAddress());
        lblAge.setText(Integer.toString(friend.getAge()));
        lblIQScore.setText(Integer.toString(friend.getIQScore()));
        if(friend.getIsTrustworthy()){
            lblIsTrustworthy.setText("Yes");
        }
        if(!friend.getIsTrustworthy()){
            lblIsTrustworthy.setText("No");
        }
        if(friend.getOtherNotes().isEmpty()){
            lblOtherNotes.setText("n/a");
        }
        else {
            lblOtherNotes.setText(friend.getOtherNotes());
        }
    }

    //Method to remove a friend
    public void deleteFriend(ActionEvent actionEvent) {
        //Setting Friend object "friend: to the selected friend from list
        Friend friend=friendsList.getSelectionModel().getSelectedItem();
        //Removing the selected friend from list
        friendsList.getItems().remove(friend);
        //Setting labels from "displayFriend" method to nothing
        lblFirstName.setText("");
        lblLastName.setText("");
        lblAddress.setText("");
        lblAge.setText("");
        lblIQScore.setText("");
        lblIsTrustworthy.setText("");
        lblOtherNotes.setText("");
        if(friendsList.getItems().isEmpty()){
            friendsList.setDisable(true);
            btnDeleteFriend.setDisable(true);
        }
    }
}

