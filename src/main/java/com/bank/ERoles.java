package com.bank;

public enum ERoles {
    ADMIN, MANAGER, CLIENT, DIRECTOR;

    @Override
    public String toString() {
        return "ROLE_" + name();
    }
}
