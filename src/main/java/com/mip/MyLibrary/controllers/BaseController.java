package com.mip.MyLibrary.controllers;

import com.mip.MyLibrary.models.User;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BaseController {

    @FXML private TextField email;
    @FXML private TextField nume;
    @FXML private TextField prenume;
    @FXML private TextField id;

    private User user;

    public BaseController() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        nume.setText(user.getNume());
        prenume.setText(user.getPrenume());
        email.setText(user.getEmail());
        id.setText(user.getId());
    }
}
