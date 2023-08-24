package br.com.vithorfjm.projectmanagement.entities.user;

public enum UserRole {
    ADMIN("admin"),

    EMPLOYEE("employee");

    final private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
